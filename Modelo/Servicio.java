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
public class Servicio {
    private String codigo;
    private String server_Name;
    private String descripcion;

    public Servicio(String codigo, String server_Name, String descripcion) {
        this.codigo = codigo;
        this.server_Name = server_Name;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getServer_Name() {
        return server_Name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setServer_Name(String server_Name) {
        this.server_Name = server_Name;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Servicios{" + "codigo=" + codigo + ", server_Name=" + server_Name + ", descripcion=" + descripcion + '}';
    }
    
}
