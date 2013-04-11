package models;

import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;

import play.db.jpa.*;
import play.data.validation.*;

import play.data.binding.As;

@Entity 
public class MenuTipousuario extends Model {

	/*
    @Id
    @Column(unique=true, nullable=false)
    public Long id;
    */
	
    @Required @As("dd/MM/yyyy hh:mm")
    public Date created;
    
    @Required @As("dd/MM/yyyy hh:mm")
    public Date updated;

    @ManyToOne
	@Required(message="Debe ingresar el tipo de usuario")
    public Tipousuario tipousuario;
    
    @ManyToOne
	@Required(message="Debe ingresar el menu")
    public Menu menu;
	
    public Menu getMenu(Long id) {
		return Menu.findById(id);
	}

    public Tipousuario getTipousuario(Long id) {
		return Tipousuario.findById(id); 
	}


	
	
}
