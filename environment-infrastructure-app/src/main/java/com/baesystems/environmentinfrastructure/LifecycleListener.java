package com.baesystems.environmentinfrastructure;

import java.net.URL;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import com.baesystems.environmentinfrastructure.application.Logger;
import com.baesystems.environmentinfrastructure.loader.aixm.AIXMLoader;
import com.baesystems.environmentinfrastructure.loader.aixm.datasource.AIXMDataSource;

/**
 * Application Lifecycle Listener implementation class Listener
 *
 */
@WebListener
public class LifecycleListener implements ServletContextListener {

	/**
	 * @see ServletContextListener#contextDestroyed(ServletContextEvent)
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		Logger.log("Context destroyed");
	}

	/**
	 * @see ServletContextListener#contextInitialized(ServletContextEvent)
	 */
	@Override
	public void contextInitialized(ServletContextEvent sce) {
		Logger.log("Context initialised");
		URL source = getClass().getClassLoader().getResource("2023_XML_WEF2023-05-18_EXP2023-04-14_CRC_1D03AC5C.xml");		
		Logger.log("Loading " + source);
		new AIXMLoader(new AIXMDataSource(source));
	}

}
