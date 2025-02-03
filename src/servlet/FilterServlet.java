package servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Filter过滤器是JaveEE的规范，也就是接口
 * Filter过滤器它的作用是：拦截请求，过滤响应
 *
 * Filter的生命周期包含几个方法
 *  1、构造器方法
 *  2、init()初始化方法
 *  3、doFilter()过滤方法
 *  4、destroy()销毁方法
 *
 *  注：第1、2步在web工程启动的时候执行
 *      第3步在每次拦截到web.xml配置的拦截路径请求时执行
 *      第4步在停止web工程的时候执行
 *
 * @Author Mr.MC
 **/
public class FilterServlet implements Filter {

    public FilterServlet() {
        System.out.println("Filter的构造器方法");
    }

    /**
     * 初始化方法
     * @param filterConfig Filter过滤器的配置文件类
     **/
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        /*
            Tomcat每次创建Filter的时候，也会同时创建一个FilterConfig类，包含了Filter配置文件的配置信息。

            FilterConfig类的作用是获取filter过滤器的配置内容
                1、获取在filter中配置的filter-name名称
                2、获取在filter中配置的init-param初始化参数
                3、获取ServletContext对象
         */
        System.out.println("Filter的init()方法");

        // 获取在filter中配置的filter-name名称
        System.out.println("filter-name的值是：" + filterConfig.getFilterName());
        // 获取在filter中配置的init-param初始化参数
        System.out.println("初始化参数zookeeper的值是：" + filterConfig.getInitParameter("zookeeper"));
        System.out.println("初始化参数database的值是：" + filterConfig.getInitParameter("database"));
        // 获取ServletContext对象
        System.out.println(filterConfig.getServletContext());
    }

    /**
     * doFilter方法，专门用于拦截请求。可以做权限检查
     * @param servletRequest
     * @param servletResponse
     * @param filterChain
     **/
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("Filter的doFilter()方法");

        HttpServletRequest req = (HttpServletRequest) servletRequest;

        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            System.out.println("当前用户未登录");
        } else {
            /*
                FilterChain.doFilter()方法的作用
                    1、执行下一个Filter过滤器（如果有Filter）
                    2、执行目标资源（如果没有Filter）

                    注：在多个Filter过滤器执行的时候，执行的先后顺序是由web.xml中的配置顺序决定的。

                多个Filter过滤器执行的特点
                    1、所有Filter和目标资源默认都执行在同一个线程中。
                    2、多个Filter共同执行的时候，它们都使用同一个Request对象。
             */
            // 让程序继续往下访问目标资源
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("Filter的destroy()方法");
    }
}
