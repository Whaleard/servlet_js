package listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * ServletContextListener可以监听ServletContext对象的创建和销毁。
 * ServletContext对象在web工程启动的时候创建，在web工程停止的时候销毁。
 * 监听到创建和销毁之后都会分别调用ServletContextListener监听器的方法反馈。
 *
 * @author Mr MC
 */
public class HelloServletContextListener implements ServletContextListener {

    /**
     * 在ServletContext对象创建之后马上调用，做初始化
     * @param servletContextEvent
     */
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被创建了");
    }

    /**
     * 在ServletContext对象销毁之后调用
     * @param servletContextEvent
     */
    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("ServletContext对象被销毁了");
    }
}
