package com.PruebasSaberPro.app.Entidades;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Role {
    
    @Id
    private String id;
    private String role;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
	
}
