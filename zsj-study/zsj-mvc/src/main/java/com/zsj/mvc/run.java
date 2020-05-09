package com.zsj.mvc;

import com.zsj.mvc.config.Config;
import com.zsj.mvc.config.HelloServlet;
import org.apache.catalina.Context;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.Server;
import org.apache.catalina.Service;
import org.apache.catalina.connector.Connector;
import org.apache.catalina.startup.Tomcat;
import org.apache.tomcat.util.descriptor.web.FilterDef;
import org.apache.tomcat.util.descriptor.web.FilterMap;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;

public class run {

	@Test
	public void main() throws LifecycleException {

		// 创建tomcat应用对象
		Tomcat tomcat = new Tomcat();
		/**
		 * 配置tomcat 访问端口，编码
		 */
		tomcat.setHostname("localhost");//设置主机名

		tomcat.setPort(8080);//设置端口
		tomcat.setBaseDir(".");//tomcat存储自身信息的目录，比如日志等信息，根目录

		String DEFAULT_PROTOCOL = "org.apache.coyote.http11.Http11NioProtocol";
		Connector connector = new Connector(DEFAULT_PROTOCOL);//设置协议，默认就是这个协议connector.setURIEncoding(“UTF-8”);//设置编码
		connector.setPort(8080);//设置端口
		tomcat.getService().addConnector(connector);

		Context ctx = tomcat.addContext("/","/");//网络访问路径

		tomcat.addServlet(ctx,"helloServlet",new HelloServlet()); //配置servlet

		ctx.addServletMappingDecoded("/test","helloServlet");//配置servlet映射路径
		Filter filter = new OncePerRequestFilter() {
			@Override
			protected void doFilterInternal(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, FilterChain filterChain) throws ServletException, IOException {
				System.out.println("filter do something");
				filterChain.doFilter(httpServletRequest, httpServletResponse);
			}
		};
		FilterDef filterDef = new FilterDef();
		filterDef.setFilter(filter);
		filterDef.setFilterName("myFilter");
		filterDef.addInitParameter("userName", "Allen");

		FilterMap filterMap = new FilterMap();
		filterMap.addURLPatternDecoded("/*");
		filterMap.addServletName("*");
		filterMap.setFilterName("myFilter");
		filterMap.setCharset(Charset.forName("UTF-8"));

		ctx.addFilterDef(filterDef);
		ctx.addFilterMap(filterMap);

        //设置appbase目录
		String basePath = System.getProperty("user.dir")+File.separator;
		tomcat.getHost().setAppBase(basePath+"/src/main/webapp/WEB-INF");
		tomcat.addWebapp("","/");

		tomcat.start();//启动tomcat
		tomcat.getServer().await();//维持tomcat服务，否则tomcat一启动就会关闭
	}


	@Test
	public void test() throws LifecycleException {
		Tomcat tomcat = new Tomcat();
		// tomcat.setBaseDir("/temp");
		Server server = tomcat.getServer();
		// server.setPort(8080);
		Service service = tomcat.getService();
		service.setName("Tomcat-embbeded");
		Connector connector = tomcat.getConnector();
		// connector.setPort(8888);
		Context context = tomcat.addContext("", "/");
		tomcat.addServlet("", "test", new HelloServlet());
		context.addServletMappingDecoded("/*", "test");
		server.start();
		server.await();
	}
}
