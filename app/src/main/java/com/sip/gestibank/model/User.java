package com.sip.gestibank.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("nom")
    @Expose
    private String nom;

    @SerializedName("prenom")
    @Expose
    private String prenom;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("tel")
    @Expose
    private int tel;

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("motpass")
    @Expose
    private String motpass;

    @SerializedName("role")
    @Expose
    private String role;

    @SerializedName("status")
    @Expose
    private String status;

    public User() {
    }

    public User(String nom) {
        this.nom= nom;
    }

    public User(String nom, String prenom, String email, int tel, String login, String motpass, String role, String status) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.login = login;
        this.motpass = motpass;
        this.role= role;
        this.status= status;

    }

    public String getLogin() {
        return login;
    }

    public void setId(String login) {
        this.login= login;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString()
    {
        return "Login = "+ this.login + " Nom = "+ this.nom;
    }
}
