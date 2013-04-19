package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;
import play.data.binding.As;
import play.data.validation.*;

@Entity 
public class Usuario extends Model {
    
	@Required(message = "Debe ingresar el nombre")
	public String name;

	@Required
	@As("dd/MM/yyyy HH:mm:ss")
	public Date created;

	@Required
	@As("dd/MM/yyyy HH:mm:ss")
	public Date updated;

	@Required(message = "Debe ingresar el login")
	@Column(unique=true ) 
	public String login;

	@Required(message = "Debe ingresar la clave")
	public String clave;

	// @Required(message="Debe ingresar el email")
	public String email;

	@ManyToOne
	@Required(message = "Debe ingresar el tipo de usuario")
	public Tipousuario tipousuario;
	
	public Tipousuario getTipoUsuario(Long id){
		return Tipousuario.findById(id);
	}


	// constructor
	public Usuario(String name, String login, String password, String email,
			Tipousuario tipoUsuario) {
		this.name = name;
		this.login = login;
		this.clave = password;
		this.email = email;
		this.created = new Date();
		this.updated = new Date();
		this.tipousuario = tipoUsuario;
	}


	// public static List<Usuario> getTodos() {
	// return Usuario.all().fetch();
	// }

	
	
	
	 public static boolean findByLogin(String login) {
		 
		 Usuario usuario = Usuario.find("byLogin", login).first(); 
		 
		 
		if (usuario != null) 
			return true;
		
		return false;

	 }

	// public static Usuario authenticate(String usuario, String clave) {
	// return find.where()
	// .eq("login", usuario)
	// .eq("password", clave)
	// .findUnique();
	// }
}