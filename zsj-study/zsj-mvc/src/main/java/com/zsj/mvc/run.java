package com.zsj.mvc;

import com.zsj.mvc.config.HelloServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.WebResourceRoot;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;
import org.apache.catalina.webresources.DirResourceSet;
import org.apache.catalina.webresources.StandardRoot;
import org.junit.Test;

import java.io.File;
import java.io.InputStream;

public class run {

	@Test
	public  void Test() throws LifecycleException {

		// 创建tomcat应用对象
		Tomcat tomcat = new Tomcat();
		/**
		 * 配置tomcat 访问端口，编码
		 */
		tomcat.setHostname("localhost");//设置主机名
		//tomcat.setPort(8080);//设置端口
		Connector connector = tomcat.getConnector();
		connector.setURIEncoding("UTF-8");
		connector.setPort(8080);

        // 是否自动部署
		tomcat.getHost().setAutoDeploy(false);
		// 创建上下文
		StandardContext standardContext = new StandardContext();
		// 设置项目名
		standardContext.setPath("/test");
		// 监听上下文
		standardContext.addLifecycleListener(new Tomcat.FixContextListener());
		// 向tomcat容器对象添加上下文配置     tomcat.getHost().addChild(standardContext);
		// 创建Servlet
		tomcat.addServlet("/test", "helloword", new HelloServlet());
		// Servlet映射
		standardContext.addServletMappingDecoded("/hello", "helloword");

		tomcat.start();//启动tomcat

		tomcat.getServer().await();//维持tomcat服务，否则tomcat一启动就会关闭
	}
}
