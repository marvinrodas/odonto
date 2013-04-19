package controllers;

import play.*;
import play.mvc.*;

import utils.Security;
import java.util.*;

import models.*;


import play.data.validation.Required;
import play.mvc.Before;
import play.mvc.Controller;
import play.mvc.With;

//@With(Secure.class)
public class Application extends Controller {

//    @Before
//    static void setConnectedUser() {
//        if (Security.isConnected()) {
//            renderArgs.put("user", Security.connected());
//        }
//    }
	
    public static void index() {
    	
    	
      	Usuario usuario = Login.getLogin();
    	if (usuario!=null)
    	{
    		
    		/*
    		if (usuario instanceof Atendente)
    			Atendentes.realizaConsulta();
    		
    		
    		if (pessoa instanceof Dentista)
    			Dentistas.showConsultas();
    			*/
    		//List<Menu> menu = Menu.getTodos();
    		//render(menu);
    	}
    	
    	// ira renderizar /application/index.html
    	render();    	
    	
    	
    	
    	
    	//
    	
        //render(menu);
    }
    
    public static void acerca_de(){
    	Date now = new Date();
    	render(now);
    }

    public static void logout(){
    	session.clear();
    	index();
    }
    
    public static void admin(){
    	render();
    }
    
    /**
 	 * Verifica si usuario esta logeado
 	 */
     public static void login(){
     	if (Security.isLogged())
     	{
     		index();
     	}
     	else
     	{
     		Login.form();
     	}
     }
}