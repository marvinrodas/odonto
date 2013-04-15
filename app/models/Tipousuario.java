package models;

import play.*;
import play.data.validation.Required;
import play.db.jpa.*;

import javax.persistence.*;
import java.util.*;

import play.data.binding.As;


@Entity 
public class Tipousuario extends Model {

    @Required(message="Debe ingresar el nombre")
    public String name;

    @Required 
    @As("dd/MM/yyyy HH:mm:ss")
    public Date created;

    @Required 
    @As("dd/MM/yyyy HH:mm:ss")
    public Date updated;

    //public Tipousuario(String name){
    //	this.name = name;
    	//this.created = new Date();
    	//this.updated = new Date();
    //}
    
    @Override
    public String toString(){
    	return name;
    }
    
}
