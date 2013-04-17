package controllers;

import java.util.List;

//import models.Tipousuario;
import models.*;
import play.data.validation.Valid;
import play.mvc.*;

import play.data.*;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import play.Logger;
import play.data.validation.Required;
import play.data.validation.Valid;


public class Usuarios extends Controller {

	public static void index() {

		List<Usuario> usuarios = Usuario.all().fetch();
		
		render(usuarios);
	}

	public static void show(long id) {
		Usuario usuario = Usuario.findById(id);
		Date now = new Date();
	
		render("@form", usuario, now);
	}

	public static void create() {
		List<Tipousuario> tipousuarios = Tipousuario.all().fetch();
		Date now = new Date();
		
		render("@form", tipousuarios, now);
	}

	public static void save(@Valid Usuario usuario) {
		/*
		//--check if login exists
		if( Usuario.find("byLogin", usuario.login).first() != null)
		{
			System.out.println("Ya existe");
			validation.addError(usuario.login, "login ya existe " + usuario.login);
		}
		*/
		
		if (validation.hasErrors()) {
			flash.error("Favor corregir errores antes de continuar." );
			Date now = new Date();
			List<Tipousuario> tipousuarios = Tipousuario.all().fetch();

			render("@form", usuario, tipousuarios, now);
		}
		
		
		usuario.save();

		flash.success("Usuario guardado exitosamente.");
		index();
	}

	public static void delete(long id) {
		Usuario usuario = Usuario.findById(id);
		usuario.delete();
		flash.success("Usuario eliminado exitosamente");
		index();
	}


}
