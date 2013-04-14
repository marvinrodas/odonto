package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;


import play.data.validation.Required;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

@With(Secure.class)
public class Application extends Controller {

    @Before
    static void setConnectedUser() {
        if (Security.isConnected()) {
            renderArgs.put("user", Security.connected());
        }
    }
	
    public static void index() {
    	
    	List<Menu> menu = Menu.getTodos();
    	
        render(menu);
    }
    
    public static void acerca_de(){
    	render();
    }

    public static void logout(){
    	session.clear();
    	index();
    }
}