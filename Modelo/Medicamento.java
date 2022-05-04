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
public class Medicamento {
    private String codigo;
    private String medica_Name;
    private String descripcion;
    private int cant_Ext;
    private double precio_Unit;

    public Medicamento(String codigo, String medica_Name, String descripcion, int cant_Ext, double precio_Unit) {
        this.codigo = codigo;
        this.medica_Name = medica_Name;
        this.descripcion = descripcion;
        this.cant_Ext = cant_Ext;
        this.precio_Unit = precio_Unit;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getMedica_Name() {
        return medica_Name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getCant_Ext() {
        return cant_Ext;
    }

    public double getPrecio_Unit() {
        return precio_Unit;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setMedica_Name(String medica_Name) {
        this.medica_Name = medica_Name;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCant_Ext(int cant_Ext) {
        this.cant_Ext = cant_Ext;
    }

    public void setPrecio_Unit(double precio_Unit) {
        this.precio_Unit = precio_Unit;
    }

    @Override
    public String toString() {
        return "Medicamentos{" + "codigo=" + codigo + ", medica_Name=" + medica_Name + ", descripcion=" + descripcion + ", cant_Ext=" + cant_Ext + ", precio_Unit=" + precio_Unit + '}';
    }
    
}
