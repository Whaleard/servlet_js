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

/**
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
}
