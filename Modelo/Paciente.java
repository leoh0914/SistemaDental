/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Date;

/**
 *
 * @author HP EliteBook 8470p
 */
public class Paciente {
    private int id;
    private String nombre;
    private String apellido_p;
    private String apellido_m;
    private Date fechaDeNacimiento;
    private String direccion;
    private String estado;
    private String celular;
    private String municipio;

    public Paciente(int id, String nombre, String apellido_p, String apellido_m, Date fechaDeNacimiento, String direccion, String estado, String celular, String municipio) {
        this.id = id;
        this.nombre = nombre;
        this.apellido_p = apellido_p;
        this.apellido_m = apellido_m;
        this.fechaDeNacimiento = fechaDeNacimiento;
        this.direccion = direccion;
        this.estado = estado;
        this.celular = celular;
        this.municipio = municipio;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido_p() {
        return apellido_p;
    }

    public String getApellido_m() {
        return apellido_m;
    }

    public Date getFechaDeNacimiento() {
        return fechaDeNacimiento;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getEstado() {
        return estado;
    }

    public String getCelular() {
        return celular;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido_p(String apellido_p) {
        this.apellido_p = apellido_p;
    }

    public void setApellido_m(String apellido_m) {
        this.apellido_m = apellido_m;
    }

    public void setFechaDeNacimiento(Date fechaDeNacimiento) {
        this.fechaDeNacimiento = fechaDeNacimiento;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    @Override
    public String toString() {
        return "Pacientes{" + "id=" + id + ", nombre=" + nombre + ", apellido_p=" + apellido_p + ", apellido_m=" + apellido_m + ", fechaDeNacimiento=" + fechaDeNacimiento + ", direccion=" + direccion + ", estado=" + estado + ", celular=" + celular + ", municipio=" + municipio + '}';
    }

}
