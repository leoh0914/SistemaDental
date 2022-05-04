/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Frame.Servicios;
import Modelo.ConsultasBD;
import Modelo.Servicio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP EliteBook 8470p
 */
public class ControladorServicios implements ActionListener {
Servicios s = new Servicios();
ConsultasBD cb = new ConsultasBD();
String codigo ="";
ArrayList<Servicio> listaServicios = cb.consultarServicios();
    public ControladorServicios(Servicios s) {
        this.s=s;
        this.s.btn_AgrServ.addActionListener(this);
        this.s.btn_EditServ.addActionListener(this);
        this.s.btn_ElimServ.addActionListener(this);
        this.s.btn_GuardarCambServ.addActionListener(this);
        this.s.btn_CancCambServ.addActionListener(this);
        
        this.s.btn_BuscServ.addActionListener(this);
        inicializarTabla(s.tabla_Serv);
        tablaServiciosEventoMouseClicked(s.tabla_Serv);
        tablaServiciosEventoKeyReleased(s.tabla_Serv);
        
    }
    
    public void inicializarTabla(JTable tablaH)
    {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaH.setModel(modeloT);
        modeloT.addColumn("Codigo");
        modeloT.addColumn("Nombre servicio");
        modeloT.addColumn("Descripcion");
 
    }
    
     public void llenarTabla(JTable tablaH, ArrayList<Servicio> listaServicios)
    {

        DefaultTableModel modeloT = new DefaultTableModel();
        tablaH.setModel(modeloT);
        modeloT.addColumn("codigo");
        modeloT.addColumn("server_Name");
        modeloT.addColumn("descripcion");

         Object[] columna = new Object [3];
        for (Servicio aux : listaServicios)
        {
           columna [0] = ""+aux.getCodigo();
           columna [1] = ""+aux.getServer_Name();
           columna [2] = ""+aux.getDescripcion();
;
           
                 modeloT.addRow(columna); 
        }
    }
     
         public void limpiarCajas(){
         s.txt_CodServ.setText("");
         s.txt_NomServ.setText("");
         s.txt_DescripServ.setText("");

     }
        public void tablaServiciosEventoKeyReleased (JTable tbl)
    {
        tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased ( KeyEvent e)
            {
                if (s.tabla_Serv.getSelectedRows().length > 0)
                {
                    int fila = s.tabla_Serv.getSelectedRow();

                    codigo = (String) s.tabla_Serv.getValueAt(fila,0);
                }
            }
});
    }
        public void tablaServiciosEventoMouseClicked (JTable tbl)
    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int fila = s.tabla_Serv.getSelectedRow();
 codigo = (String) s.tabla_Serv.getValueAt(fila,0);
            }
});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == s.btn_AgrServ){
            String codigo1,servicio,descripcion;
            codigo1 = s.txt_CodServ.getText();
            servicio = s.txt_NomServ.getText();
            descripcion = s.txt_DescripServ.getText();
                        
            cb.insertarServicio(codigo1, servicio, descripcion);
            limpiarCajas();
                        JOptionPane.showMessageDialog(null, "Se ha agregado el servicio");
            llenarTabla(this.s.tabla_Serv,listaServicios);
            
        }
        if(e.getSource() == s.btn_EditServ){
            Servicio servicio = cb.buscarPorIdServicio(codigo);
            this.s.txt_CodServ.setText(""+servicio.getCodigo());
            this.s.txt_NomServ.setText(""+servicio.getServer_Name());
            this.s.txt_DescripServ.setText(""+servicio.getDescripcion());
            //this.m.txt_CodMedi.setEnabled(false);
        }
        
         if(e.getSource() == s.btn_ElimServ){
       Servicio servicio = cb.buscarPorIdServicio(codigo);
       int boton = JOptionPane.showConfirmDialog(null, 
                            "Desea borrar este elemento: "
                            + servicio.getServer_Name()+ " ?", "Advertencia", 
                            JOptionPane.YES_NO_OPTION);
          if(boton == JOptionPane.YES_OPTION){
                        cb.borrarServicios(codigo);
                        JOptionPane.showMessageDialog(null, "Registro eliminado");
                        llenarTabla(this.s.tabla_Serv, listaServicios);
                    }
        }
         
         if(e.getSource() == s.btn_GuardarCambServ){
            String servicio,descrip;
                      
            servicio =s.txt_NomServ.getText();
            descrip = s.txt_DescripServ.getText();
            cb.modificarServicios(servicio, descrip, codigo);
            JOptionPane.showMessageDialog(null, "Se ha registrado el cambio");
            llenarTabla(this.s.tabla_Serv, listaServicios);
            this.s.txt_CodServ.setEnabled(true);
            limpiarCajas();
            
        }
        
        if(e.getSource() == s.btn_CancCambServ){
            this.s.txt_CodServ.setEnabled(true);
            limpiarCajas();
        }
        
        if(e.getSource() == s.btn_BuscServ)
        {
                int indice =  s.cmbbx_Serv.getSelectedIndex();
                if(indice == 1){
                    String clave = s.txt_ServBuscar.getText();
                   ArrayList<Servicio> serv = cb.consultarServicioCodigo(clave);
                   llenarTabla(this.s.tabla_Serv,serv);
                }else {
                     String clave = s.txt_ServBuscar.getText();
                   ArrayList<Servicio> serv = cb.consultarServicioNombre(clave);
                   llenarTabla(this.s.tabla_Serv,serv); 
                }
    }
    }
}
    
     
