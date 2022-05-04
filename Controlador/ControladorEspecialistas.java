/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Frame.Especialistas;
import Modelo.ConsultasBD;
import Modelo.Especialista;
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
public class ControladorEspecialistas implements ActionListener {
    ConsultasBD cb = new ConsultasBD();
    Especialistas espclts = new Especialistas();
    int claveElegida=-1;
    
    public ControladorEspecialistas(Especialistas espclts) {
        this.espclts=espclts;
        this.espclts.cmbbx_EstadoEspclt.addItem("----Seleccione el estado----");
        this.espclts.cmbbx_EstadoEspclt.addActionListener(this);
        this.espclts.cmbbx_MunicipioEspclt.addItem("--Selecciona--");
        this.espclts.btn_AgrEspclt.addActionListener(this);
        this.espclts.btn_GuarCambEspclt.addActionListener(this);
        this.espclts.btn_ElimEspclt.addActionListener(this);
        this.espclts.btn_EditEspclt.addActionListener(this);
	this.espclts.btn_CancCambEspclt.addActionListener(this);
        llenarComboEstado(this.espclts.cmbbx_EstadoEspclt);
        llenarTabla(this.espclts.tabla_Espclts);
        tablaEspecialistasEventoKeyReleased(espclts.tabla_Espclts);
        tablaEspecialistasEventoMouseClicked(espclts.tabla_Espclts);
    }
    
    public void llenarComboEstado(JComboBox jcb){
    ArrayList<Estado> e = cb.consultarEstado();
    for(int i=0; i< e.size(); i++){
        jcb.addItem(e.get(i));
    }
    }    
    
    public void tablaEspecialistasEventoKeyReleased (JTable tbl)
    {
        tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased ( KeyEvent e)
            {
                if (espclts.tabla_Espclts.getSelectedRows().length > 0)
                {
                    int fila = espclts.tabla_Espclts.getSelectedRow();
                    // por ultimo, obtengo el valor de la celda
                    claveElegida = Integer.parseInt(String.valueOf(
                            espclts.tabla_Espclts.getValueAt(fila,0)));
                }
            }
});
    }
    public void tablaEspecialistasEventoMouseClicked (JTable tbl)
    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                int fila = espclts.tabla_Espclts.getSelectedRow();
                claveElegida = Integer.parseInt(String.valueOf(
                        espclts.tabla_Espclts.getValueAt(fila, 0)));
            }
});
    }
    
    public void llenarTabla(JTable tablaH)
    {
        ArrayList<Especialista> listaEspecialista = cb.consultarEspecialista(); 
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaH.setModel(modeloT);
        modeloT.addColumn("Id");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Celular");
        modeloT.addColumn("Direccion");
        modeloT.addColumn("Estado");
        modeloT.addColumn("Municipio");
        
        Object[] columna = new Object [8];
        for (Especialista aux : listaEspecialista)
        {
           columna [0] = ""+aux.getId();
           columna [1] = ""+aux.getNombre();
           columna [2] = ""+aux.getApellido_p();
           columna [3] = ""+aux.getApellido_m();
           columna [4] = ""+aux.getCelular();
           columna [5] = ""+aux.getDireccion();
           columna [6] = ""+aux.getEstado();
           columna [7] = ""+aux.getMunicipio();
           
           
                 modeloT.addRow(columna); 
        }
    }
    
    public void llenarComboMunicipio(JComboBox jcb, int id) {
        ArrayList<Municipio> listaMunicipios = cb.consultarMunicipio(id);
        this.espclts.cmbbx_MunicipioEspclt.addItem("--Selecciona Municipio--");
        for (Municipio aux : listaMunicipios) {
            jcb.addItem(aux.getMunicipio());
        }
    }
     public boolean verificarCajas(){
            try {
                if(espclts.txt_NombresEspclt.getText().compareTo("")==0){
                    throw new Exception("Debe poner un nombre");
                }
                if(espclts.txt_APaternoEspclt.getText().compareTo("")==0){
                    throw new Exception ("Debe colocar el apellido paterno");
                }
                if(espclts.txt_AMaternoEspclt.getText().compareTo("")==0){
                    throw new Exception ("Debe colocar el apellido materno");
                }
                if (espclts.txt_CelularEspclt.getText().compareTo("")==0){
                    throw new Exception ("Debe colocar el celular");
                }
                
//                if (vr.fecha_nac_paciente.getDate().compareTo("")==0){
//                    throw new Exception ("Debe poner un costo");
//                }
                if (espclts.txt_DireccionEspclt.getText().compareTo("")==0){
                    throw new Exception ("Debe poner la direccion");   
                }
                if (espclts.cmbbx_EstadoEspclt.getSelectedIndex() == 0){
                    throw new Exception ("Debe seleccionar un estado");   
                }
                 if (espclts.cmbbx_MunicipioEspclt.getSelectedIndex() == 0){
                    throw new Exception ("Debe seleccionar un municipio");   
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                return false;
            }
            
            return true;
        }
    public void limpiarCajas(){
        espclts.txt_NombresEspclt.setText("");
        espclts.txt_APaternoEspclt.setText("");
        espclts.txt_AMaternoEspclt.setText("");
        espclts.txt_CelularEspclt.setText("");
        espclts.txt_DireccionEspclt.setText("");
        espclts.jdate_fechaNacEspclt.setDate(null);
        espclts.cmbbx_EstadoEspclt.setSelectedIndex(0);
        espclts.cmbbx_MunicipioEspclt.setSelectedIndex(0);
         
     }
     @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==espclts.cmbbx_EstadoEspclt){
            if(espclts.cmbbx_MunicipioEspclt.getItemCount()>0){
                espclts.cmbbx_MunicipioEspclt.removeAllItems();
                int indice = espclts.cmbbx_EstadoEspclt.getSelectedIndex();
            System.out.println("es el indice: "+indice);
            llenarComboMunicipio(espclts.cmbbx_MunicipioEspclt,indice);
        }
        }
            if (e.getSource() == espclts.btn_AgrEspclt) {
                if (!verificarCajas()) {
                    return;
                }
                String nombre, apellidoP, apellidoM, celular, direccion, estado, municipio;
                Date fecha;
                nombre = espclts.txt_NombresEspclt.getText();
                apellidoP = espclts.txt_APaternoEspclt.getText();
                apellidoM = espclts.txt_AMaternoEspclt.getText();
                celular = espclts.txt_CelularEspclt.getText();
                direccion = espclts.txt_DireccionEspclt.getText();
                fecha = espclts.jdate_fechaNacEspclt.getDate();
                estado = espclts.cmbbx_EstadoEspclt.getSelectedItem().toString();
                municipio = espclts.cmbbx_MunicipioEspclt.getSelectedItem().toString();

                java.sql.Date date2 = new java.sql.Date(fecha.getTime());
                cb.insertarEspecialista (nombre, apellidoP, apellidoM, date2, celular, direccion, estado, municipio);
                limpiarCajas();
                llenarTabla(this.espclts.tabla_Espclts);
            }
            
        if(e.getSource() == espclts.btn_EditEspclt){
        if(claveElegida !=-1){
          Especialista especialista = cb.buscarPorIdEspecialista(claveElegida);
           this.espclts.txt_IdEspclt.setText(""+ especialista.getId());
           this.espclts.txt_NombresEspclt.setText(""+ especialista.getNombre());
           this.espclts.txt_APaternoEspclt.setText(""+ especialista.getApellido_p());
           this.espclts.txt_AMaternoEspclt.setText(""+ especialista.getApellido_m());
           this.espclts.txt_CelularEspclt.setText(""+ especialista.getCelular());
           this.espclts.txt_DireccionEspclt.setText(""+ especialista.getDireccion());
           this.espclts.cmbbx_EstadoEspclt.setSelectedIndex(cb.buscarEstado(especialista.getEstado()));
           llenarComboMunicipio(espclts.cmbbx_MunicipioEspclt,cb.buscarEstado(especialista.getEstado()));
           System.out.println (cb.buscarEstado(especialista.getEstado()));
           this.espclts.cmbbx_MunicipioEspclt.setSelectedItem(cb.buscarMunicipio(especialista.getMunicipio()));
        //deshabilitar la caja ID
            this.espclts.txt_IdEspclt.setEnabled(false);
            this.espclts.txt_NombresEspclt.setEnabled(false);
            this.espclts.txt_APaternoEspclt.setEnabled(false);
            this.espclts.txt_AMaternoEspclt.setEnabled(false);
            this.espclts.jdate_fechaNacEspclt.setEnabled(false);
             System.out.println();
             System.out.println();
         }
        
        }
        
        if(e.getSource() == espclts.btn_ElimEspclt){
          if(claveElegida !=-1){
          Especialista especialista = cb.buscarPorIdEspecialista(claveElegida);
          int boton = JOptionPane.showConfirmDialog(null, 
                            "Desea borrar este elemento: "
                            + especialista.toString()+ " ?", "Advertencia", 
                            JOptionPane.YES_NO_OPTION);
          if(boton == JOptionPane.YES_OPTION){
                        cb.borrarEspecialista(claveElegida);
                        JOptionPane.showMessageDialog(null, "Registro eliminado");
                        llenarTabla(this.espclts.tabla_Espclts);
                    }
          }  
            
        }

        if (e.getSource() == espclts.btn_GuarCambEspclt) {
            String celular = espclts.txt_CelularEspclt.getText();
            String direccion = espclts.txt_DireccionEspclt.getText();
            String estado = espclts.cmbbx_EstadoEspclt.getSelectedItem().toString();
            String municipio = espclts.cmbbx_MunicipioEspclt.getSelectedItem().toString();
            cb.modificarEspecialista(celular, direccion, estado, municipio, claveElegida);
            JOptionPane.showMessageDialog(null, "Se ha registrado el cambio");
            llenarTabla(this.espclts.tabla_Espclts);
        }
}
}
