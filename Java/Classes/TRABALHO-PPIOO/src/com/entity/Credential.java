package com.entity;

public class Credential extends Entity {

	private String user, senha;

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Credential user(String user){this.user = user; return this;}
	public Credential senha(String senha){this.senha = senha; return this;}
	
	@Override
	public boolean equals(Object obj) {
		if(obj.getClass().isInstance(this)){
			Credential toCompare = (Credential) obj;
			return this.user.equalsIgnoreCase(toCompare.user) &&
					this.senha.equalsIgnoreCase(toCompare.senha);
		}
		
		return false;
	}
	
	@Override
	public int compareTo(Entity entidade) {
		if(entidade.getClass().isInstance(this)){
			Credential toCompare = (Credential) entidade;
			
			int userInt = this.user.compareToIgnoreCase(toCompare.user);
			int passInt = this.senha.compareToIgnoreCase(toCompare.senha);
			
			if(userInt == 0 && passInt == 0){ return 0;}
			
			return 1;
		}
		
		return -1;
	}

	public String getAuthKey() {
		return user + "_" + senha;
	}
}
