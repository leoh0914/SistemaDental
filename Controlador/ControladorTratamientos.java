/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Frame.Tratamientos;
import Modelo.ConsultasBD;
import Modelo.Tratamiento;
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
public class ControladorTratamientos implements ActionListener {
Tratamientos t = new Tratamientos();
ConsultasBD cb = new ConsultasBD();
String codigo ="";
ArrayList<Tratamiento> listaTratamientos = cb.consultarTratamientos();
    public ControladorTratamientos(Tratamientos t) {
        this.t=t;
        this.t.btn_AgrTrat.addActionListener(this);
        this.t.btn_EditTrat.addActionListener(this);
        this.t.btn_ElimTrat.addActionListener(this);
        this.t.btn_GuardarCambTrat.addActionListener(this);
        this.t.btn_CancCambTrat.addActionListener(this);
        
        this.t.btn_BuscTrat.addActionListener(this);
        inicializarTabla(t.tabla_Trat);
        tablaTratamientosEventoMouseClicked(t.tabla_Trat);
        tablaTratamientosEventoKeyReleased(t.tabla_Trat);
        
    }
    
        

       public void inicializarTabla(JTable tablaH)
    {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaH.setModel(modeloT);
        modeloT.addColumn("Codigo");
        modeloT.addColumn("Nombre tratamiento");
        modeloT.addColumn("Descripcion");
        modeloT.addColumn("Costo");
        modeloT.addColumn("Servicio");
 
    }
    
    public void llenarTabla(JTable tablaH, ArrayList<Tratamiento> listaTratamientos)
    {

        DefaultTableModel modeloT = new DefaultTableModel();
        tablaH.setModel(modeloT);
        modeloT.addColumn("codigo");
        modeloT.addColumn("tratam_Name");
        modeloT.addColumn("descripcion");
        modeloT.addColumn("costo");
        modeloT.addColumn("servicio");

         Object[] columna = new Object [5];
        for (Tratamiento aux : listaTratamientos)
        {
           columna [0] = ""+aux.getCodigo();
           columna [1] = ""+aux.getTratam_Name();
           columna [2] = ""+aux.getDescripcion();
           columna [3] = ""+aux.getCosto();
           columna [4] = ""+aux.getCodigo_Servicio();

           
                 modeloT.addRow(columna); 
        }
    }
        public void limpiarCajas(){
         t.txt_CodTrat.setText("");
         t.txt_CostoTrat.setText("");
         t.cmbbx_ServTrat.setSelectedIndex(0);
         t.txt_NomTrat.setText("");
         t.txt_DescripTrat.setText("");

     }
        public void tablaTratamientosEventoKeyReleased (JTable tbl)
    {
        tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased ( KeyEvent e)
            {
                if (t.tabla_Trat.getSelectedRows().length > 0)
                {
                    int fila = t.tabla_Trat.getSelectedRow();

                    codigo = (String) t.tabla_Trat.getValueAt(fila,0);
                }
            }
});
    }
        public void tablaTratamientosEventoMouseClicked (JTable tbl)
    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int fila = t.tabla_Trat.getSelectedRow();
 codigo = (String) t.tabla_Trat.getValueAt(fila,0);
            }
});
    }
        

    @Override
    public void actionPerformed(ActionEvent e) {
       if(e.getSource() == t.btn_AgrTrat){
            String codigo1,tratamiento,descripcion, servicio;
            double costo;
            codigo1 = t.txt_CodTrat.getText();
            tratamiento = t.txt_NomTrat.getText();
            servicio = t.cmbbx_ServTrat.getSelectedItem().toString();
            descripcion = t.txt_DescripTrat.getText();
            costo = Double.parseDouble(t.txt_CostoTrat.getText());
            
            cb.insertarTratamiento(codigo1, tratamiento, descripcion,  costo, servicio);
            limpiarCajas();
                        JOptionPane.showMessageDialog(null, "Se ha agregado el tratamiento");
            llenarTabla(this.t.tabla_Trat, listaTratamientos);
            
        }
       if(e.getSource() == t.btn_EditTrat){
            Tratamiento tratamiento = cb.buscarPorIdTratamiento(codigo);
            this.t.txt_CodTrat.setText(""+tratamiento.getCodigo());
            this.t.txt_NomTrat.setText(""+tratamiento.getTratam_Name());
            this.t.txt_DescripTrat.setText(""+tratamiento.getDescripcion());
            //this.t.cmbbx_ServTrat.(""+medicamento.getPrecio_Unit());
            this.t.txt_CodTrat.setEnabled(false);
        }
       if(e.getSource() == t.btn_ElimTrat){
       Tratamiento tratamiento = cb.buscarPorIdTratamiento(codigo);
       int boton = JOptionPane.showConfirmDialog(null, 
                            "Desea borrar este elemento: "
                            + tratamiento.getTratam_Name()+ " ?", "Advertencia", 
                            JOptionPane.YES_NO_OPTION);
          if(boton == JOptionPane.YES_OPTION){
                        cb.borrarTratamiento(codigo);
                        JOptionPane.showMessageDialog(null, "Registro eliminado");
                        llenarTabla(this.t.tabla_Trat, listaTratamientos);
                    }
        }
       
        if(e.getSource() == t.btn_GuardarCambTrat){
            String tratamiento,descrip, servicio;
            double costo;
            //servicio = cmbbx_ServTrat.get
            tratamiento =t.txt_NomTrat.getText();
            descrip = t.txt_DescripTrat.getText();
            costo = Double.parseDouble(t.txt_CostoTrat.getText());
            cb.modificarTratamiento( descrip, costo, codigo);
            JOptionPane.showMessageDialog(null, "Se ha registrado el cambio");
            llenarTabla(this.t.tabla_Trat, listaTratamientos);
            this.t.txt_CodTrat.setEnabled(true);
            limpiarCajas();
            
        }
        
        if(e.getSource() == t.btn_CancCambTrat){
            this.t.txt_CodTrat.setEnabled(true);
            limpiarCajas();
        }
        
           if(e.getSource() == t.btn_BuscTrat)
        {
                int indice =  t.cmbbx_Trat.getSelectedIndex();
                if(indice == 1){
                    String clave = t.txt_TratBuscar.getText();
                   ArrayList<Tratamiento> trata = cb.consultarTratamientoCodigo(clave);
                   llenarTabla(this.t.tabla_Trat,trata);
                }else {
                     String clave = t.txt_TratBuscar.getText();
                   ArrayList<Tratamiento> trata = cb.consultarTratamientosNombre(clave);
                   llenarTabla(this.t.tabla_Trat,trata); 
                }
        }
        
    }
}