package servlet;

import base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends BaseServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) {
        super.doGet(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) {
        System.out.println("Hello Servlet");
        try {
            // resp.sendRedirect("http://www.baidu.com");
            req.setAttribute("tittle", "hello world");
            // getParameter()一般取url后面拼接的参数值或者form表单传递的参数值
            // resp.sendRedirect("http://localhost:8160/learn//hello.jsp");
            req.getRequestDispatcher("/hello.jsp?userName=init").forward(req, resp);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ServletException e) {
            throw new RuntimeException(e);
        }
    }
}
