package lab.spring.io.security.web.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		XmlWebApplicationContext dispatcherWebContext = new XmlWebApplicationContext();
		dispatcherWebContext.setConfigLocation("/WEB-INF/dispatcher-servlet.xml");
		
		ServletRegistration.Dynamic dispatcherRegistration = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherWebContext));
		dispatcherRegistration.setLoadOnStartup(1);
		dispatcherRegistration.addMapping("/");
		
		XmlWebApplicationContext rootContext = new XmlWebApplicationContext();
		rootContext.setConfigLocation("/WEB-INF/security-config.xml");
		
		servletContext.addListener(new ContextLoaderListener(rootContext));
	}

}
