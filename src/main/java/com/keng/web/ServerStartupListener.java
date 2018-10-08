package com.keng.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * FileName: ServerStartupListener
 *
 * @author: keng
 * Date:     2018/10/7 22:56
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
public class ServerStartupListener implements ServletContextListener {
    public void contextInitialized(ServletContextEvent sce) {
        // 把web应用的名称保存到application中
        //获取application
        ServletContext application = sce.getServletContext();
        //获取应用路径
        String path = application.getContextPath();
        application.setAttribute("APP_PATH", path);
    }

    public void contextDestroyed(ServletContextEvent sce) {

    }
}
