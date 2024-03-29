package com.domain;

public abstract class Usuario extends Pessoa{
	
	protected String user;
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
	
        public abstract String getFuncao();
        
        public boolean isMedico(){
            return (this instanceof Medico);
        }
        
        public boolean isSecretaria(){
            return (this instanceof Secretaria);
        }

}
