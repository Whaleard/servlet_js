package test;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Servlet的生命周期
 *      1、执行Servlet构造器方法
 *      2、执行init初始化方法
 *      3、执行service方法
 *      4、执行destroy销毁方法
 *
 * Servlet程序默认是第一次访问时创建，每个Servlet创建时，会创建一个对应的ServletConfig对象。
 */
public class HttpServletTest implements Servlet {

    private transient ServletConfig servletConfig;

    /**
     * 只在第一次访问该Servlet的时候创建Servlet程序会调用
     */
    public HttpServletTest() {

    }

    /**
     * 只在第一次访问该Servlet的时候创建Servlet程序会调用
     */
    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.servletConfig = servletConfig;
        // ServletConfig接口是Servlet程序的配置信息
        // ServletConfig类的三大作用
        // 1、可以获取Servlet程序的别名，也就是web.xml中的servlet-name标签值
        System.out.println("HttpServletTest程序的别名是：" + servletConfig.getServletName());
        // 2、获取初始化参数init-param
        System.out.println("初始化参数username的值是：" + servletConfig.getInitParameter("username"));
        System.out.println("初始化参数password的值是：" + servletConfig.getInitParameter("password"));
        // 3、获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }

    /**
     * 每次访问都会调用
     * @param servletRequest
     * @param servletResponse
     * @throws ServletException
     * @throws IOException
     */
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {

        // HttpServletRequest的实现类才有getMethod()方法
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        // 获取请求方式
        String method = req.getMethod();

        if ("GET".equals(method)) {
            this.doGet();
        } else if ("POST".equals(method)) {
            this.doPost();
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    /**
     * 在web工程停止的时候调用
     */
    @Override
    public void destroy() {

    }

    public void doGet() {
        /*
            ServletContext接口表示Servlet上下文对象，一个web工程只有一个ServletContext对象实例。
            ServletContext对象是一个域对象，是可以像Map一样存取数据的对象，这里的域指的是存取数据的操作范围，范围为整个工程。
            ServletContext在web工程部署启动的时候创建，在web工程停止的时候销毁。
         */
        ServletContext servletContext = this.servletConfig.getServletContext();
        // ServletContext类的四个作用
        // 1、获取web.xml中配置的上下文参数，也就是context-param的值
        String username = servletContext.getInitParameter("username");
        System.out.println("context-param参数username的值是：" + username);
        // 2、获取当前项目的工程路径，格式：/工程路径
        System.out.println("当前工程路径：" + servletContext.getContextPath());
        // 3、获取工程部署后在服务器硬盘上的绝对路径
        /*
            / 被服务器解析地址为：http://ip:port/工程名/ 映射到IDEA代码的web目录
         */
        System.out.println("工程部署的路径是：" + servletContext.getRealPath("/"));
        // 4、像Map一样存取数据
        servletContext.setAttribute("key1", "value1");
        System.out.println("servletContext中获取与数据key1的值是：" + servletContext.getAttribute("key1"));
    }

    public void doPost() {
        // 业务逻辑
    }
}
