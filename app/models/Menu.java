package models;

import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;

import play.db.jpa.*;
import play.data.validation.*;

import play.data.binding.As;

@Entity 
public class Menu extends Model {

    /*@Id
    @Column(unique=true, nullable=false)
    public Long id;
    */
    @Required(message="Debe ingresar el nombre")
    public String name;
    
    @Required @As("dd/MM/yyyy hh:mm")
    public Date created;
    
    @Required @As("dd/MM/yyyy hh:mm")
    public Date updated;

    @Range(min=0, max=10, message="El valor ingresado no es valido (0 a 10) unicamente.")
    public int raiz;

    @Range(min=0, max=10, message="El valor ingresado no es valido (0 a 10) unicamente.")
    public int orden;

    public String accion;

    public String controlador;
	
	public String url;

	public String icon;

   public Menu(String name, int raiz, int orden, String accion, String controlador, String url, String icon) {
        this.name = name;
        this.raiz = raiz;
        this.accion= accion;
        this.controlador = controlador;
        this.created = new Date();
        this.updated = new Date();
        this.icon = icon;
        this.orden = orden;
    }

	
    public static Menu findById(Long id) {
        return find("byId", id).first();
    }
    
    public static List<Menu> getAllOrderedByRaiz() {
        return  Menu.find("order by raiz asc, orden asc").fetch();
    }
    
    
    @Override 
    public String toString(){
    	return name;
    }
	
}
