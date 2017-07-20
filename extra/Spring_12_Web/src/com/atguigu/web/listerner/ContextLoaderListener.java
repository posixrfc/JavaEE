package com.atguigu.web.listerner;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ContextLoaderListener implements ServletContextListener {

	//在Web应用初始化时调用当前方法
    public void contextInitialized(ServletContextEvent sce)  { 
        
    	ServletContext servletContext = sce.getServletContext();
    	
    	//1.从Web应用初始化参数中读取Spring配置文件的路径及文件名
    	String contextConfigLocation = servletContext.getInitParameter("contextConfigLocation");
    	
    	//2.创建IOC容器对象
    	ApplicationContext ioc = new ClassPathXmlApplicationContext(contextConfigLocation);
    	
    	//3.将IOC容器对象保存到ServletContext属性域中
    	servletContext.setAttribute("ioc", ioc);
    }

    public void contextDestroyed(ServletContextEvent sce)  { 
         // TODO Auto-generated method stub
    }
	
}
