package servlet;

import base.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Session是一个接口（HttpSession）。
 * Session是会话，用来维护一个客户端和服务器之间关联的一种技术。
 * 每个客户端都有自己的一个Session会话。
 * Session会话经常用来保存用户登录之后的信息。
 *
 * @author Mr MC
 */
public class SessionServlet extends BaseServlet {

    public void createOrGetSession(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建和获取Session会话对象
        HttpSession session = req.getSession();
        // 判断当前Session会话是否是新创建出来的
        boolean isNew = session.isNew();
        // 获取Session会话的唯一标识id
        String id = session.getId();

        resp.getWriter().write("得到的Session，它的id是：" + id + " <br/> ");
        resp.getWriter().write("这个Session是否是新创建的：" + isNew + " <br/> ");
    }

    /**
     * 往session域中保存数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void setAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().setAttribute("key1", "value1");
        resp.getWriter().write("已经往Session中保存了数据");
    }

    /**
     * 获取session域中的数据
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void getAttribute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Object attribute = req.getSession().getAttribute("key1");
        resp.getWriter().write("从Session中获取出key1的数据是：" + attribute);
    }

    /**
     * 获取Session的默认超时时长，默认超时时长为30分钟
     * 在Tomcat服务器的配置文件web.xml中默认有以下的配置
     *      <session-config>
     *          <session-timeout>30</session-timeout>
     *      </session-config>
     *  该配置表示配置了当前Tomcat服务器下所有的Session超时配置默认时长为30分钟。
     *  如果希望web工程默认的Session超时时长为其他时长，可以在项目的web.xml配置文件中做以上相同的配置，就可以修改web工程所有Session的默认超时时长。
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void defaultLifeTime(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取Session的超时时长
        int maxInactiveInterval = req.getSession().getMaxInactiveInterval();

        resp.getWriter().write("Session的默认超时时长为：" + maxInactiveInterval + "秒");
    }

    /**
     * 自定义Session的超时时长（以秒为单位），超过指定的时长，Session就会被销毁
     *  public int setMaxInactiveInterval(int interval)
     *      值为正数的时候，设定Session的超时时长
     *      值为负数的时候，表示永不超时
     *
     * Session超时时长指的是客户端两次请求的最大间隔时长
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    public void setLifeTime(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 先获取Session对象
        HttpSession session = req.getSession();
        // 设置当前Session超时时长为3秒
        session.setMaxInactiveInterval(3);

        resp.getWriter().write("当前Session已经设置为" + session.getMaxInactiveInterval() + "秒超时");
    }
}
