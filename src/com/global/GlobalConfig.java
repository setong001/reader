package com.global;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.tools.Tools;

import sun.util.logging.resources.logging;

/**
 * 全局监听器
 * 1、容器创建起来后将容器web-inf目录暴露给Tools类
 * @author mizzmiz0659
 *
 */
public class GlobalConfig implements ServletContextListener {


    public GlobalConfig() {
        // TODO Auto-generated constructor stub
    }

    public void contextDestroyed(ServletContextEvent arg0)  { 
         // TODO Auto-generated method stub
    }


    public void contextInitialized(ServletContextEvent arg0)  { 
    	String path = arg0.getServletContext().getRealPath("/WEB-INF");
    	Tools.setWebinfPath(path);
    }
	
}
