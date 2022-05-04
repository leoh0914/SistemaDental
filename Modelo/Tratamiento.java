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
public class Tratamiento {
    private String codigo;
    private String tratam_Name;
    private String descripcion;
    private double costo;
    private String codigo_Servicio;

    public Tratamiento(String codigo, String tratam_Name, String descripcion, double costo, String codigo_Servicio) {
        this.codigo = codigo;
        this.tratam_Name = tratam_Name;
        this.descripcion = descripcion;
        this.costo = costo;
        this.codigo_Servicio = codigo_Servicio;
    }

    public Tratamiento() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getCodigo() {
        return codigo;
    }

    public String getTratam_Name() {
        return tratam_Name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public double getCosto() {
        return costo;
    }

    public String getCodigo_Servicio() {
        return codigo_Servicio;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setTratam_Name(String tratam_Name) {
        this.tratam_Name = tratam_Name;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public void setCodigo_Servicio(String codigo_Servicio) {
        this.codigo_Servicio = codigo_Servicio;
    }

    @Override
    public String toString() {
        return "Tratamientos{" + "codigo=" + codigo + ", tratam_Name=" + tratam_Name + ", descripcion=" + descripcion + ", costo=" + costo + ", codigo_Servicio=" + codigo_Servicio + '}';
    }
    
}
