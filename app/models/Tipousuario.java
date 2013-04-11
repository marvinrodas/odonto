package models;

import java.util.*;
import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;

import play.db.jpa.*;
import play.data.validation.*;

import play.data.binding.As;


@Entity 
public class Tipousuario extends Model {

	/*
    @Id
    @Column(unique=true, nullable=false)
    public Long id;
	 */
	
    @Required(message="Debe ingresar el nombre")
    public String name;

    @Required @As("dd/MM/yyyy hh:mm")
    public Date created;

    @Required @As("dd/MM/yyyy hh:mm")
    public Date updated;

    public Tipousuario(String name){
    	this.name = name;
    	this.created = new Date();
    	this.updated = new Date();
    }
    
    
    public static Tipousuario findById(Long id) {
        return find("byId", id).first();
    }
    
    @Override
    public String toString(){
    	return name;
    }
    
}
