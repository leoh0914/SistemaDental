/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author HP EliteBook 8470p
 */
public class Usuario {
    private String user;
    private String nombres;
    private String apellidos;
    private String contrasena;
    private String rol;

    public Usuario(String user, String nombres, String apellidos, String rol) {
        this.user = user;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.rol = rol;
    }

    
    public Usuario(String user, String nombres, String apellidos, String contrasena, String rol) {
        this.user = user;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.contrasena = contrasena;
        this.rol = rol;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "user=" + user + ", nombres=" + nombres + ", apellidos=" + apellidos + ", contrasena=" + contrasena + ", rol=" + rol + '}';
    }
    
    
}

