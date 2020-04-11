package com.zsj.mvc;

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

		String webappDirLocation = "src/main/webapp/WEB-INF";
		String absolutePath = new File(
				webappDirLocation).getAbsolutePath();
		System.out.println(absolutePath);

		Tomcat tomcat = new Tomcat();//创建tomcat实例，用来启动tomcat
		tomcat.setHostname("localhost");//设置主机名
		//tomcat.setPort(8080);//设置端口
		Connector connector = tomcat.getConnector();
		connector.setPort(8080);
		tomcat.setBaseDir(".");//tomcat存储自身信息的目录，比如日志等信息，根目录

		StandardContext ctx = (StandardContext) tomcat.addWebapp("/", new File(
				webappDirLocation).getAbsolutePath());

		/*
		 * true时：相关classes | jar 修改时，会重新加载资源，不过资源消耗很大
		 * autoDeploy 与这个很相似，tomcat自带的热部署不是特别可靠，效率也不高。生产环境不建议开启。
		 */
		ctx.setReloadable(false);

		// 上下文监听器
		ctx.addLifecycleListener(new AprLifecycleListener());

	/*	File additionWebInfClasses = new File("target/classes");
		WebResourceRoot resources = new StandardRoot(ctx);
		resources.addPreResources(new DirResourceSet(resources,
				"/WEB-INF/classes", additionWebInfClasses.getAbsolutePath(),
				"/"));*/
		// 注册servlet
		//tomcat.addServlet("/access", "demoServlet", new DemoServlet());
		// servlet mapping
		//ctx.addServletMappingDecoded("/demo.do", "demoServlet");

		tomcat.start();//启动tomcat

		tomcat.getServer().await();//维持tomcat服务，否则tomcat一启动就会关闭
	}
}
