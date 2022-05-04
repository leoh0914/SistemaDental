/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Controlador.ControladorLogin;
import Controlador.ControladorPacientes;
import Frame.Login;
import Frame.Pacientes;
import Modelo.ConsultasBD;

/**
 *
 * @author HP EliteBook 8470p
 */
public class Main {
    public static void main(String[] args) {
        ConsultasBD consultasbd = new ConsultasBD();
        java.util.Date d = new java.util.Date();  
        java.sql.Date date2 = new java.sql.Date(d.getTime());
        //consultasbd.insertarPaciente("alejandra", "alvarado", "martinez", date2, "7121819239", "Las Fuentes", "Mexico", "Atlacomulco");
        //System.out.println(consultasbd.consultarPacientes().toString());
        //consultasbd.modificarPaciente("7121801526", "tlajomulco", "guadalajara", "san francisco", 1);
        //consultasbd.borrarPaciente(1);
        //System.out.println(consultasbd.buscarPorIdPaciente(3).toString()); 
        //consultasbd.insertarEspecialista ("jhovani", "garcia", "mejia", "santiago acutzilapan", "mexico", "atlacomulco", "712189200");
        //System.out.println(consultasbd.consultarEspecialistas().toString());
        //consultasbd.modificarEspecilista("7121801526", "tlajomulco", "guadalajara", "san francisco", 1);
        //consultasbd.borrarEspecialista(1);
        //System.out.println(consultasbd.buscarPorIdEspecialista(1).toString());
        //consultasbd.insertarMedicamento("mnoh876", "naproxeno", "para el dolor", 123456,554.50);
        //System.out.println(consultasbd.consultarMedicamento().toString());
        //consultasbd.modificarMedicamento("quetorolaco", "quita el dolor por un rato", 456, 220.80, "mnoh876");
        //consultasbd.borrarMedicamento("mnoh876");
        //System.out.println(consultasbd.buscarPorIdMedicamento(1).toString());
        //consultasbd.insertarServicio ("bghnoo7", "limpieza", "limpieza general o percial de piezas dentales");
        //System.out.println(consultasbd.consultarServicios().toString());
        //consultasbd.modificarServicios("limpieza", "limpieza general o percial de piezas dentales","bghnoo7");
        //consultasbd.borrarServicios("bghnoo7");
        //System.out.println(consultasbd.buscarPorIdServicio(1).toString());
        //consultasbd.insertarTratamiento("bbbnoo8", "endodoncia", "preservar las piezas dentales dañadas evitando así su pérdida", 654322.61, "bghnoo7");
        //System.out.println(consultasbd.consultarTratamientos().toString());
        //consultasbd.modificarTratamiento( "preservar las piezas dentales dañadas evitando así su pérdida", 654322.61, "bbbnoo8");
        //consultasbd.borrarTratamiento("bbbnoo8");
        //System.out.println(consultasbd.buscarPorIdTratamiento(1).toString());
        //consultasbd.insertarAgenda(date2, "8:00 - 8:30", 2, "matutino");
        //System.out.println(consultasbd.consultarAgenda().toString());
        //consultasbd.modificarAgenda(date2,"8:00 - 8:30", "vespertino", 1);
        //consultasbd.borrarAgenda(1);
        //System.out.println(consultasbd.buscarPorIdAgenda(date2, 2).toString());
        Login l = new Login();
        ControladorLogin cl = new ControladorLogin(l);
        l.setVisible(true);
        Pacientes p = new Pacientes();
        ControladorPacientes cr = new ControladorPacientes(p);
        p.setVisible(true);
        }
}
