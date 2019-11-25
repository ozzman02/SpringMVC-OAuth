package lab.spring.io.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebExAppInitializer implements WebApplicationInitializer{

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		XmlWebApplicationContext dispatcherWebContext = new XmlWebApplicationContext();
		dispatcherWebContext.setConfigLocation("/WEB-INF/config/dispatcher-servlet-config.xml");
		
		
		ServletRegistration.Dynamic dispatcherRegistration = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherWebContext));
		dispatcherRegistration.setLoadOnStartup(1);
		dispatcherRegistration.addMapping("/");
		
		XmlWebApplicationContext adminWebContext = new XmlWebApplicationContext();
		adminWebContext.setConfigLocation("/WEB-INF/config/admin-servlet-config.xml");
		
		
		ServletRegistration.Dynamic adminRegistration = servletContext.addServlet("admin_dispatcher", new DispatcherServlet(adminWebContext));
		adminRegistration.setLoadOnStartup(1);
		adminRegistration.addMapping("/admin/*");
		
		XmlWebApplicationContext rootContext  = new XmlWebApplicationContext();
		rootContext.setConfigLocation("/WEB-INF/config/applicationContext.xml");
		servletContext.addListener(new ContextLoaderListener(rootContext));
		
		
		
	}

}
