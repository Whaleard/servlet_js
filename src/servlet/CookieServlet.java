package servlet;

import base.BaseServlet;
import util.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Cookie是服务器通知客户端保存键值对的一种技术。
 * 客户端有了Cookie后，每次请求都发送给服务器。
 * 每个Cookie的大小不能超过4kb。
 *
 * @author Mr MC
 */
public class CookieServlet extends BaseServlet {

    /**
     * 创建Cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void createCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、创建Cookie对象
        Cookie cookie = new Cookie("key1", "value1");
        // 2、通知客户端保存Cookie
        resp.addCookie(cookie);
        // 3、通过响应头Set-Cookie通知客户端保存Cookie
        // 4、客户端收到响应后，检查set-cookie响应头，如果没有Cookie数据就创建，有就修改

        Cookie cookie1 = new Cookie("key3", "value3");
        resp.addCookie(cookie1);
        resp.getWriter().write("Cookie创建成功");
    }

    /**
     * 获取Cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void getCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、客户端通过请求头Cookie把Cookie信息发送给服务器
        // 2、服务器获取客户端发送过来的Cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie cookie : cookies) {
            // getName()方法返回Cookie的key
            // getValue()方法返回Cookie的value值
            resp.getWriter().write("Cookie[" + cookie.getName() + "=" + cookie.getValue() + "] <br/>");
        }
    }

    /**
     * 更新Cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void updateCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 方案一
        // 1、先创建一个要修改的同名的Cookie对象
        // 2、在构造器中同时赋予新的Cookie值
        Cookie cookie = new Cookie("key1", "newValue1");
        // 3、通知客户端修改
        resp.addCookie(cookie);

        // 方案二
        // 1、先查找到需要修改的Cookie对象
        Cookie cookie1 = CookieUtils.findCookie("key3", req.getCookies());
        if (cookie1 != null) {
            // 2、调用setValue()方法赋予新的Cookie值
            cookie1.setValue("newValue3");
        }
        // 3、调用response.addCookie()通知客户端保存修改
        resp.addCookie(cookie1);
    }

    /**
     * Cookie生命周期
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void defaultLife(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("defaultLife", "defaultLife");
        // 设置Cookie存活时间
        /*
            setMaxAge(int expiry)
                expiry为正数：表示Cookie在指定的秒数后过期
                expiry为负数：表示浏览器一关，Cookie就会被删除（默认值为-1）
                expiry为零：表示马上删除Cookie
         */
        cookie.setMaxAge(-1);
        resp.addCookie(cookie);
    }

    /**
     * 删除Cookie
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void deleteCookie(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、先找到要删除的Cookie对象
        Cookie cookie = CookieUtils.findCookie("key1", req.getCookies());
        if (cookie != null) {
            // 2、调用setMaxAge(0);
            cookie.setMaxAge(0);
        }
        // 调用response.addCookie(cookie);
        resp.addCookie(cookie);

        resp.getWriter().write("key1的Cookie已经被删除");
    }

    /**
     * Cookie路径
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void cookiePath(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookie cookie = new Cookie("path1", "path1");
        // 获取工程路径
        cookie.setPath(req.getContextPath() + "/abc");
        resp.addCookie(cookie);
        resp.getWriter().write("创建了一个带有Path路径的Cookie");
    }
}
