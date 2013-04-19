package utils;

import play.Logger;
import play.mvc.Scope.Session;
import controllers.Application;
import controllers.Login;

public class Security {
	
    public static void deny()
    {
    	if (!isLogged())
    		Application.login();
    }
    
    
    public static boolean isLogged()
    {
    	return Session.current().get("usuario")!=null;
    }
    
    
    
    
}
