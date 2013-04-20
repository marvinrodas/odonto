package controllers;

import play.*;
import play.mvc.*;
import play.data.validation.*;

import utils.Security;

import java.util.*;

import models.*;


//import play.data.validation.Required;
//import play.mvc.Before;
//import play.mvc.Controller;
//import play.mvc.With;

//@With(Secure.class)
public class Application extends Controller {

//    @Before
//    static void setConnectedUser() {
//        Usuario user = connected();
//        if(user != null) {
//            renderArgs.put("user", user);
//        }
//    }	
//
//   static Usuario connected() {
//        if(renderArgs.get("user") != null) {
//            return renderArgs.get("user", Usuario.class);
//        }
//        
//        String usuarioId = session.get("user");
//        if(usuarioId != null) {
//            return Usuario.find("byLogin", login).first();
//        } 
//        return null;
//    }

	
    public static void index() {
    	Usuario usuario = Login.getLogin();
    	if (usuario!=null)
    	{
    		renderArgs.put("user", usuario);
    		
    		/*
    		if (usuario instanceof Atendente)
    			Atendentes.realizaConsulta();
    		
    		
    		if (pessoa instanceof Dentista)
    			Dentistas.showConsultas();
   			*/
    	}
		
    	render();
        
    }
    
    public static void acerca_de(){
    	Date now = new Date();
    	render(now);
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