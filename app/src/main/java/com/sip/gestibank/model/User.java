package com.sip.gestibank.model;

import android.widget.Spinner;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.sip.gestibank.Password;

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
    private String tel;

    @SerializedName("login")
    @Expose
    private String login;

    @SerializedName("motpass")
    @Expose
    private String password;

    @SerializedName("role")
    @Expose
    private String role;

    @SerializedName("status")
    @Expose
    private String status;

    @SerializedName("compte")
    @Expose
    private String compte;

    @SerializedName("matricule")
    @Expose
    private String matricule;

    public User() {
    }

    public User(String nom) {
        this.nom= nom;
    }

    public User(String nom, String prenom, String email, String tel) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.role= "client";
        this.status= "en attente";
    }
    public User(String nom, String prenom, String email, String tel, String compte) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.role= "client";
        this.status= "en attente";
        this.compte= compte;
    }

    public User(String nom, String prenom, String email, String matricule, String password, String status) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.matricule = matricule;
        this.status = "valide"+status;
        this.role="agent";

    }

    public User(String nom, String prenom, String email, String tel, String login, String password, String role, String status) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.tel = tel;
        this.login = login;
        this.password = password;
        this.role= role;
        this.status= status;
    }

    public User(String prenom, String nom, String matricule, String email, String password, String status, String role) {
        this.prenom = prenom;
        this.nom = nom;
        this.email = email;
        this.password = password;
        this.matricule = matricule;
        this.status = "valide";
        this.role = "agent";
    }

    public String getMatricule(){return matricule;}

    public void setMatricule(){this.matricule = matricule; }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString()
    {
        return "Login = "+ this.login + " Nom = "+ this.nom;
    }
}
