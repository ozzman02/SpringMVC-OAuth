package lab.spring.io.security.web.servlets;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.context.support.XmlWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import lab.spring.io.security.config.SecurityContextConfig;
import lab.spring.io.security.config.WebContextConfig;

public class WebAppInitializer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		AnnotationConfigWebApplicationContext dispatcherWebContext = new AnnotationConfigWebApplicationContext();
		dispatcherWebContext.register(WebContextConfig.class);
		
		ServletRegistration.Dynamic dispatcherRegistration = servletContext.addServlet("dispatcher", new DispatcherServlet(dispatcherWebContext));
		dispatcherRegistration.setLoadOnStartup(1);
		dispatcherRegistration.addMapping("/");
		
		AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(SecurityContextConfig.class);
		
		servletContext.addListener(new ContextLoaderListener(rootContext));
	}

}
