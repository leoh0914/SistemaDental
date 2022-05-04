/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Frame.Pacientes;
import Modelo.ConsultasBD;
import Modelo.Paciente;
import Modelo.Estado;
import Modelo.Municipio;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP EliteBook 8470p
 */
public class ControladorPacientes implements ActionListener {
    ConsultasBD cb = new ConsultasBD();
    Pacientes pcnts = new Pacientes();
    int claveElegida=-1;
    
    public ControladorPacientes(Pacientes pcnts) {
        this.pcnts=pcnts;
        this.pcnts.cmbbx_EstadoPcnt.addItem("----Seleccione el estado----");
        this.pcnts.cmbbx_EstadoPcnt.addActionListener(this);
        this.pcnts.cmbbx_MunicipioPcnt.addItem("--Selecciona el municipio--");
        this.pcnts.btn_AgrPcnt.addActionListener(this);
        this.pcnts.btn_GuarCambPcnt.addActionListener(this);
        this.pcnts.btn_ElimPcnt.addActionListener(this);
        this.pcnts.btn_EditPcnt.addActionListener(this);
	this.pcnts.btn_CancCambPcnt.addActionListener(this);
        llenarComboEstado(this.pcnts.cmbbx_EstadoPcnt);
        llenarTabla(this.pcnts.tabla_Pcnts);
        tablaPacientesEventoKeyReleased(pcnts.tabla_Pcnts);
        tablaPacientesEventoMouseClicked(pcnts.tabla_Pcnts);
    }
    
    public void llenarComboEstado(JComboBox jcb){
    ArrayList<Estado> e = cb.consultarEstado();
    for(int i=0; i< e.size(); i++){
        jcb.addItem(e.get(i));
    }
    }
    
    public void tablaPacientesEventoKeyReleased (JTable tbl)
    {
        tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased ( KeyEvent e)
            {
                if (pcnts.tabla_Pcnts.getSelectedRows().length > 0)
                {
                    int fila = pcnts.tabla_Pcnts.getSelectedRow();
                    // por ultimo, obtengo el valor de la celda
                    claveElegida = Integer.parseInt(String.valueOf(
                            pcnts.tabla_Pcnts.getValueAt(fila,0)));
                }
            }
});
    }
    public void tablaPacientesEventoMouseClicked (JTable tbl)
    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                int fila = pcnts.tabla_Pcnts.getSelectedRow();
                claveElegida = Integer.parseInt(String.valueOf(
                        pcnts.tabla_Pcnts.getValueAt(fila, 0)));
            }
});
    }
    
    public void llenarTabla(JTable tablaH)
    {
        ArrayList<Paciente> listaPaciente = cb.consultarPaciente(); 
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaH.setModel(modeloT);
        modeloT.addColumn("Id");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Fecha Nacimiento");
        modeloT.addColumn("Celular");
        modeloT.addColumn("Direccion");
        modeloT.addColumn("Municipio");
        modeloT.addColumn("Estado");
        
        Object[] columna = new Object [9];
        for (Paciente aux : listaPaciente)
        {
           columna [0] = ""+aux.getId();
           columna [1] = ""+aux.getNombre();
           columna [2] = ""+aux.getApellido_p();
           columna [3] = ""+aux.getApellido_m();
           columna [4] = ""+aux.getFechaDeNacimiento();
           columna [5] = ""+aux.getCelular();
           columna [6] = ""+aux.getDireccion();
           columna [8] = ""+aux.getEstado();
           columna [7] = ""+aux.getMunicipio();
           
           
                 modeloT.addRow(columna); 
        }
    }
    
    public void llenarComboMunicipio(JComboBox jcb, int id){
   ArrayList<Municipio> listaMunicipios = cb.consultarMunicipio(id);
this.pcnts.cmbbx_MunicipioPcnt.addItem("--Selecciona Municipio--");
   for(Municipio aux : listaMunicipios)
   {
       jcb.addItem(aux.getMunicipio());
   }
}
      public boolean verificarCajas(){
            try {
                if(pcnts.txt_Nombres.getText().compareTo("")==0){
                    throw new Exception("Debe poner un nombre");
                }
                if(pcnts.txt_APaterno.getText().compareTo("")==0){
                    throw new Exception ("Debe colocar el apellido paterno");
                }
                if(pcnts.txt_AMaterno.getText().compareTo("")==0){
                    throw new Exception ("Debe colocar el apellido materno");
                }
                if (pcnts.txt_Celular.getText().compareTo("")==0){
                    throw new Exception ("Debe colocar el celular");
                }
                
//                if (vr.fecha_nac_paciente.getDate().compareTo("")==0){
//                    throw new Exception ("Debe poner un costo");
//                }
                if (pcnts.txt_DireccionPcnt.getText().compareTo("")==0){
                    throw new Exception ("Debe poner la direccion");   
                }
                if (pcnts.cmbbx_EstadoPcnt.getSelectedIndex() == 0){
                    throw new Exception ("Debe seleccionar un estado");   
                }
                 if (pcnts.cmbbx_MunicipioPcnt.getSelectedIndex() == 0){
                    throw new Exception ("Debe seleccionar un municipio");   
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                return false;
            }
            
            return true;
        }
     public void limpiarCajas(){
         pcnts.txt_Nombres.setText("");
         pcnts.txt_APaterno.setText("");
         pcnts.txt_AMaterno.setText("");
         pcnts.txt_Celular.setText("");
         pcnts.txt_DireccionPcnt.setText("");
         pcnts.jdate_fechaNacPcnt.setDate(null);
         pcnts.cmbbx_EstadoPcnt.setSelectedIndex(0);
         pcnts.cmbbx_MunicipioPcnt.setSelectedIndex(0);
         
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==pcnts.cmbbx_EstadoPcnt){
            if(pcnts.cmbbx_MunicipioPcnt.getItemCount()>0){
                pcnts.cmbbx_MunicipioPcnt.removeAllItems();
                int indice = pcnts.cmbbx_EstadoPcnt.getSelectedIndex();
            System.out.println("es el indice: "+indice);
            llenarComboMunicipio(pcnts.cmbbx_MunicipioPcnt,indice);
        }
        }
            if (e.getSource() == pcnts.btn_AgrPcnt) {
                if (!verificarCajas()) {
                    return;
                }

                String nombre, apellidoP, apellidoM, celular, direccion, estado, municipio;
                Date fecha;
                nombre = pcnts.txt_Nombres.getText();
                apellidoP = pcnts.txt_APaterno.getText();
                apellidoM = pcnts.txt_AMaterno.getText();
                celular = pcnts.txt_Celular.getText();
                direccion = pcnts.txt_DireccionPcnt.getText();
                fecha = pcnts.jdate_fechaNacPcnt.getDate();
                estado = pcnts.cmbbx_EstadoPcnt.getSelectedItem().toString();
                municipio = pcnts.cmbbx_MunicipioPcnt.getSelectedItem().toString();

                java.sql.Date date2 = new java.sql.Date(fecha.getTime());
                cb.insertarPaciente(nombre, apellidoP, apellidoM, date2, celular, direccion, estado, municipio);
                limpiarCajas();
                llenarTabla(this.pcnts.tabla_Pcnts);
            }
    
        if(e.getSource() == pcnts.btn_EditPcnt){
         if(claveElegida !=-1){
          Paciente paciente = cb.buscarPorIdPaciente(claveElegida);
           this.pcnts.txt_IdPaciente.setText(""+ paciente.getId());
           this.pcnts.txt_Nombres.setText(""+ paciente.getNombre());
           this.pcnts.txt_APaterno.setText(""+ paciente.getApellido_p());
           this.pcnts.txt_AMaterno.setText(""+ paciente.getApellido_m());
           this.pcnts.txt_Celular.setText(""+ paciente.getCelular());
           this.pcnts.txt_DireccionPcnt.setText(""+ paciente.getDireccion());
           this.pcnts.jdate_fechaNacPcnt.setDate(paciente.getFechaDeNacimiento());
           this.pcnts.cmbbx_EstadoPcnt.setSelectedIndex(cb.buscarEstado(paciente.getEstado()));
           llenarComboMunicipio(pcnts.cmbbx_MunicipioPcnt,cb.buscarEstado(paciente.getEstado()));
           System.out.println (cb.buscarEstado(paciente.getEstado()));
           this.pcnts.cmbbx_MunicipioPcnt.setSelectedItem(cb.buscarMunicipio(paciente.getMunicipio()));
        //deshabilitar la caja ID
            this.pcnts.txt_IdPaciente.setEnabled(false);
            this.pcnts.txt_Nombres.setEnabled(false);
            this.pcnts.txt_APaterno.setEnabled(false);
            this.pcnts.txt_AMaterno.setEnabled(false);
            this.pcnts.jdate_fechaNacPcnt.setEnabled(false);
             System.out.println();
             System.out.println();
         }
        
        }
        
        if(e.getSource() == pcnts.btn_ElimPcnt){
          if(claveElegida !=-1){
          Paciente paciente = cb.buscarPorIdPaciente(claveElegida);
          int boton = JOptionPane.showConfirmDialog(null, 
                            "Desea borrar este elemento: "
                            + paciente.toString()+ " ?", "Advertencia", 
                            JOptionPane.YES_NO_OPTION);
          if(boton == JOptionPane.YES_OPTION){
                        cb.borrarPaciente(claveElegida);
                        JOptionPane.showMessageDialog(null, "Registro eliminado");
                        llenarTabla(this.pcnts.tabla_Pcnts);
                    }
          }  
            
        }

        if (e.getSource() == pcnts.btn_GuarCambPcnt) {
            String celular = pcnts.txt_Celular.getText();
            String direccion = pcnts.txt_DireccionPcnt.getText();
            String estado = pcnts.cmbbx_EstadoPcnt.getSelectedItem().toString();
            String municipio = pcnts.cmbbx_MunicipioPcnt.getSelectedItem().toString();
            cb.modificarPaciente(celular, direccion, estado, municipio, claveElegida);
            JOptionPane.showMessageDialog(null, "Se ha registrado el cambio");
            llenarTabla(this.pcnts.tabla_Pcnts);
        }
}
}