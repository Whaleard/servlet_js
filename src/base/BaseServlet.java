package base;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import domain.Message;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Servlet类的继承体系
 *
 * Interface Servlet
 *      Servlet接口，只负责定义Servlet程序的访问规范
 *
 * Class GenericServlet
 *      GenericServlet类实现了Servlet接口，做了很多实现
 *      持有一个ServletConfig类的引用，并对ServletConfig的使用做了一些实现方法
 *
 * Class HttpServlet
 *      HttpServlet抽象类实现了service()方法，并实现了请求的分发处理
 *      String method = req.getMethod();
 *
 * 自己的业务类
 *      继承HttpServlet并重写doGet()方法和doPost()方法
 *
 * @author Mr MC
 */
public class BaseServlet<T> extends HttpServlet {

    private static final String REQUEST_ENCODING = "UTF-8";

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(req.getInputStream(), REQUEST_ENCODING));
            StringBuffer requestParameter = new StringBuffer();
            String line;
            while((line = br.readLine()) != null) {
                requestParameter.append(line);
            }
            this.doHandler(requestParameter.toString());
            this.invoke(req, resp);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    protected void doHandler(String jsonParameter) {
        System.out.println(jsonParameter);
        Message message = JSON.parseObject(jsonParameter, Message.class);
        System.out.println(message.getHeader().toString());
        System.out.println(message.getUser().toString());
    }

    protected void invoke(HttpServletRequest req, HttpServletResponse resp) {
        resp.setCharacterEncoding("UTF-8");
        // 解决响应中文乱码问题
        resp.setContentType("text/html;charset=UTF-8");

        String action = req.getParameter("action");

        try {
            Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.invoke(this, req, resp);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }
}
