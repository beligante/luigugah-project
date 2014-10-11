package com.saei.initialization;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.saei.constants.Constants;
import com.saei.manager.AplicationEng;

public class MyServletContextListener implements ServletContextListener {

	  @Override
	  public void contextDestroyed(ServletContextEvent event) {

	  }

	  @Override
	  public void contextInitialized(ServletContextEvent event) {
		  event.getServletContext().setAttribute(Constants.ENG_KEY, AplicationEng.initialize());
		
		  System.out.println("\n\n\n");
		  
		  String mensagem;
		  mensagem = "***************************************************************************\n"		  
				  	+"*                                                                         *\n"
				  	+"*   ######     ###    ######## ####                  ##         #####     *\n"
				  	+"*  ##    ##   ## ##   ##        ##                 ####        ##   ##    *\n"
				  	+"*  ##        ##   ##  ##        ##                   ##       ##     ##   *\n"
  				    +"*   ######  ##     ## ######    ##     #######       ##       ##     ##   *\n"
				    +"*        ## ######### ##        ##                   ##       ##     ##   *\n"
				    +"*  ##    ## ##     ## ##        ##                   ##   ###  ##   ##    *\n"
				    +"*   ######  ##     ## ######## ####                ###### ###   #####     *\n"
				    +"*                                                                         *\n"
				    +"***************************************************************************\n";
		  System.out.println(mensagem);
		  System.out.println("SYSTEM INITIALIZED WITH SUCCESS!! \\o\\\\o//o/ \n\n\n");
	  }

}