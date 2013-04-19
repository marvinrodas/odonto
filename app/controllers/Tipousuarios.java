package controllers;

import models.Tipousuario;
import play.mvc.*;
import play.data.*;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.time.DateUtils;
import play.Logger;
import play.data.validation.Required;
import play.data.validation.Valid;


public class Tipousuarios extends Controller {

	public static void index() {
		Date now = new Date();
		List<Tipousuario> tipousuarios = Tipousuario.all().fetch();

		render(tipousuarios, now);
	}

	public static void show(long id) {

		Tipousuario tipousuario = Tipousuario.findById(id);
		Date now = new Date();
		
		render("@form", tipousuario, now);
	}

	public static void create() {
		Date now = new Date();
		
		render("@form", now);
	}

	public static void save(@Valid Tipousuario tipousuario) {
		Date now = new Date();
		if (validation.hasErrors()) {
			flash.error("Favor corregir errores antes de continuar.");
			render("@form", tipousuario, now);
		}

		tipousuario.save();

		flash.success("Tipo de usuario guardado exitosamente.");
		index();
	}

	public static void delete(long id) {
		Tipousuario tipousuario = Tipousuario.findById(id);
		tipousuario.delete();
		flash.success("Tipo de usuario eliminado exitosamente");
		index();
	}
    
}
