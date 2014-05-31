package com.domain;

public class Credencial {

    private String user;
    private String password;

    public Credencial(String user, String password) {
        this.user = user;
        this.password = password;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }

    public boolean equals(Credencial credencial) {
        if (credencial != null) {
            return (this.user.equals(credencial.getUser()) && this.password.equals(credencial.getPassword()));
        }
        return false;
    }

}
