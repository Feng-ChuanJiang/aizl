package org.lemonPig.os.assist.logback;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class LogbackConfigListener implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent event) {
		LogbackWebConfigurer.initLogging(event.getServletContext());
	}
	@Override
	public void contextDestroyed(ServletContextEvent event) {
		LogbackWebConfigurer.shutdownLogging(event.getServletContext());
	}

}
