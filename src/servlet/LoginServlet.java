package servlet;

import base.BaseServlet;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends BaseServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        PrintWriter writer = null;
        BufferedReader reader = null;
        try {
            System.out.println("Login...");

            writer = resp.getWriter();
            // 前端请求内容的类型是application/x-www-form-urlencoded或multipart/form-data，可以用getParameter()方法直接获取
            // String username = req.getParameter("userName");
            // String password = req.getParameter("password");
            // 对于application/json，需要手动读取请求体。
            reader = req.getReader();
            String url = "/error.jsp";
            StringBuffer sb = new StringBuffer();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            User user = JSON.parseObject(sb.toString(), User.class);
            // 此处用户名密码先写死
            if ("init".equals(user.getUserName()) && "123456".equals(user.getPassWord())) {
                // 登录成功
                Cookie cookie = new Cookie("username", user.getUserName());
                cookie.setMaxAge(60* 60 * 24 * 7);
                resp.addCookie(cookie);
                url = "/success.jsp";
            } else {
                // 登录失败

            }
            writer.print(url);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭输入流
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            // 关闭输出流
            if (writer != null) {
                writer.flush();
                writer.close();
            }
        }
    }
}
