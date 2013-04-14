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

	/**
	 * Recupera e exibe lista de Procedimentos cadastrados.
	 */
	public static void index() {

		List<Tipousuario> tipousuarios = Tipousuario.all().fetch(); 

		render(tipousuarios);
	}

	/**
	 * Recupera um procedimento através do seu id.
	 * @param id
	 */
	public static void show(long id)
	{

		Tipousuario tipousuario = Tipousuario.findById(id);

		render("@form",tipousuario);
	}

	/**
	 * Exibe o form de cadastro de procedimentos.
	 */
	public static void create()
	{
		render("@form");
	}

	/**
	 * Salva (persiste) o procedimento na base.
	 * @param procedimento
	 */
	public static void save(@Valid Tipousuario tipousuario)
	{
		if (validation.hasErrors())
		{
			flash.error("Favor corregir errores antes de continuar.");
			render("@form", tipousuario);
		}
		
		tipousuario.save();

		flash.success("Tipo de usuario guardado exitosamente.");
		index();
	}

	/**
	 * Exclui o procedimento pelo seu id.
	 * @param id
	 */
	public static void delete(long id)
	{
		Tipousuario tipousuario = Tipousuario.findById(id);
		tipousuario.delete();
		flash.success("Tipo de usuario eliminado exitosamente");
		index();
	}

    
}
