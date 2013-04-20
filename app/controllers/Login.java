package controllers;

import models.Usuario;
import models.Tipousuario;

import play.Logger;
import play.mvc.*;

public class Login extends Controller {

	public static void tryLogin(Usuario u) {
		Usuario usuario = Usuario.find("byLoginAndClave", u.login, u.clave).first();
		if (usuario != null) {
	        session.put("user", usuario.id.toString());
			flash.success("Bienvenido %s", usuario.name);
			Application.index();
		}

		flash.error("Login/clave incorrectos.");
		form();
	}

	public static Usuario getLogin() {
		String id = session.get("user");

		if (id != null) {
			Usuario usuario = Usuario.findById(Long.parseLong(id));
			return usuario;
		}
		return null;
	}

	public static void form() {
		render();
	}

	public static void logout() {
		session.clear(); 
		Application.index();
	}

}
