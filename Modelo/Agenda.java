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
public class Agenda {
    private int id_Cita;
    private Date fecha;
    private String hora;
    private int id_Paciente;
    private String turno;

    public Agenda(int id_Cita, Date fecha, String hora, int id_Paciente, String turno) {
        this.id_Cita = id_Cita;
        this.fecha = fecha;
        this.hora = hora;
        this.id_Paciente = id_Paciente;
        this.turno = turno;
    }

    public int getId_Cita() {
        return id_Cita;
    }

    public int getId_Paciente() {
        return id_Paciente;
    }

    public Date getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getTurno() {
        return turno;
    }

    public void setId_Cita(int id_Cita) {
        this.id_Cita = id_Cita;
    }

    public void setId_Paciente(int id_Paciente) {
        this.id_Paciente = id_Paciente;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setTurno(String turno) {
        this.turno = turno;
    }

    @Override
    public String toString() {
        return "Agenda{" + "id_Cita=" + id_Cita + ", id_Paciente=" + id_Paciente + ", fecha=" + fecha + ", hora=" + hora + ", turno=" + turno + '}';
    }

}
