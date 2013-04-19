package controllers;

import models.Usuario;
import models.Tipousuario;

import play.Logger;
import play.mvc.*;


public class Login extends Controller {

	public static void tryLogin(Usuario u) {
		// Trata de logearse
		Usuario usuario = Usuario.find("byLoginAndClave", u.login, u.clave).first();
		if (usuario != null) {
			session.put("usuario", usuario.id.toString());
			flash.success("Bienvenido ", usuario.name);
			Application.index();
		}

		// Cria um login para admin
		if (u.login.equals("admin") & u.clave.equals("admin")) {
			Logger.info("%s", u);

//			Atendente a = new Atendente();
//			a.login = "admin";
//			a.senha = "admin";
//			a.nome = "admin";
//			a.matricula = "admin";
//			a.save();

			session.put("usuario","admin");
			flash.success("Bienvenido ", "Admin");
			Application.index();
		}

		flash.error("Login/clave incorrectos.");
		form();
	}

	public static Usuario getLogin() {
		String id = session.get("usuario");

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
		session.remove("usuario");
		//session.clear(); 
		Application.index();
	}

}
