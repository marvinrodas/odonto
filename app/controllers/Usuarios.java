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

		render("@form", usuario);
	}

	public static void create() {
		render("@form");
	}

	public static void save(@Valid Usuario usuario) {
		if (validation.hasErrors()) {
			flash.error("Favor corregir errores antes de continuar.");
			render("@form", usuario);
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