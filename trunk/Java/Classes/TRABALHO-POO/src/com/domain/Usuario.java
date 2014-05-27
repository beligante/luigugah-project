package com.domain;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Table;

@javax.persistence.Entity
@Table(name = "usuario")
@MappedSuperclass
public abstract class Usuario extends Pessoa{
	
        @Column(name="user")
	protected String user;
	
        @Column(name="password")
        protected String password;
	
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	

}
