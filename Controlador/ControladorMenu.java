/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Frame.Menu;
import Modelo.ConsultasBD;
import Frame.ReservarCitas;
import Frame.Usuarios;
import Frame.Pacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;

/**
 *
 * @author HP EliteBook 8470p
 */
public class ControladorMenu implements ActionListener {

    Menu m = new Menu();
    ConsultasBD consultasbd = new ConsultasBD();

    public ControladorMenu(Menu m) {
        this.m = m;
        etiquetaPaciente(this.m.pac_prin_img);
        etiquetaReservarC(this.m.rc_prin_img);
        etiquetaConsultas(this.m.con_prin_img);
        etiquetaServicios(this.m.ser_prin_img);
        etiquetaTratamientos(this.m.tra_prin_img);
        etiquetaEspecialistas(this.m.esp_prin_img);
        etiquetaExpediente(this.m.expc_prin_img);
        etiquetaUsuarios(this.m.usu_prin_img);
        etiquetaSalir(this.m.salir_prin_img);
    }

    public void etiquetaPaciente(JLabel eti) {
        eti.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Pacientes vr = new Pacientes();
                ControladorPacientes cr = new ControladorPacientes(vr);
                vr.setVisible(true);
            }
        });
    }

    public void etiquetaReservarC(JLabel eti) {
        eti.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                ReservarCitas rc = new ReservarCitas();
                ControladorReservarCitas ca = new ControladorReservarCitas(consultasbd, rc);
                rc.setVisible(true);
            }
        });
    }

    public void etiquetaConsultas(JLabel eti) {
        eti.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                
            }
        });
    }

    public void etiquetaServicios(JLabel eti) {
        eti.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }

    public void etiquetaTratamientos(JLabel eti) {
        eti.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }

    public void etiquetaEspecialistas(JLabel eti) {
        eti.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }

    public void etiquetaExpediente(JLabel eti) {
        eti.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

            }
        });
    }

    public void etiquetaUsuarios(JLabel eti) {
        eti.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Usuarios u = new Usuarios();
                ControladorUsuarios cu = new ControladorUsuarios(u);
                u.setVisible(true);
            }
        });
    }

    public void etiquetaSalir(JLabel eti) {
        eti.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                m.dispose();
            }
        });
    }

//   m.pac_prin_img.addMouseListener(new MouseAdapter()  
//{  
//    public void mouseClicked(MouseEvent e)  
//    {  
//       //point to the frame you want it to go to from here
//       yourFrame = new JFrame("Next JFrame");
//       frame.setVisible(true);
//
//    }  
//}); 
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }
  
}
