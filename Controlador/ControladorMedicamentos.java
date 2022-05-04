/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasBD;
import Modelo.Medicamento;
import Frame.Medicamentos;
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
 * @author HP
 */
public class ControladorMedicamentos  implements ActionListener {
Medicamentos m = new Medicamentos();
ConsultasBD cb = new ConsultasBD();
String codigo ="";
ArrayList<Medicamento> listaMedicamentos = cb.consultarMedicamento();
    public ControladorMedicamentos(Medicamentos m) {
        this.m=m;
        this.m.btn_AgrMedi.addActionListener(this);
        this.m.btn_EditMedi.addActionListener(this);
        this.m.btn_ElimMedi.addActionListener(this);
        this.m.btn_GuardarCambMedi.addActionListener(this);
        this.m.btn_CancCambMedi.addActionListener(this);
        
        this.m.btn_BuscMedi.addActionListener(this);
        inicializarTabla(m.tabla_Medi);
        tablaMedicamentosEventoMouseClicked(m.tabla_Medi);
        tablaMedicamentosEventoKeyReleased(m.tabla_Medi);
        
    }
    public void inicializarTabla(JTable tablaH)
    {
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaH.setModel(modeloT);
        modeloT.addColumn("Codigo");
        modeloT.addColumn("Medicamento");
        modeloT.addColumn("Descripcion");
        modeloT.addColumn("Cantidad existente");
        modeloT.addColumn("Precio");
 
    }

      public void llenarTabla(JTable tablaH, ArrayList<Medicamento> listaMedicamentos)
    {
        
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaH.setModel(modeloT);
        modeloT.addColumn("Codigo");
        modeloT.addColumn("Medicamento");
        modeloT.addColumn("Descripcion");
        modeloT.addColumn("Cantidad existente");
        modeloT.addColumn("Precio");
 
        
        
        Object[] columna = new Object [5];
        for (Medicamento aux : listaMedicamentos)
        {
           columna [0] = ""+aux.getCodigo();
           columna [1] = ""+aux.getMedica_Name();
           columna [2] = ""+aux.getDescripcion();
           columna [3] = ""+aux.getCant_Ext();
           columna [4] = ""+aux.getPrecio_Unit();
           
                 modeloT.addRow(columna); 
        }
    }
      
        public void limpiarCajas(){
         m.txt_CodMedi.setText("");
         m.txt_NomMedi.setText("");
         m.txt_DescripMedi.setText("");
         m.txt_CantMedi.setText("");
         m.txt_PrecioMedi.setText("");
     }
                 public void tablaMedicamentosEventoKeyReleased (JTable tbl)
    {
        tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased ( KeyEvent e)
            {
                if (m.tabla_Medi.getSelectedRows().length > 0)
                {
                    int fila = m.tabla_Medi.getSelectedRow();

                    codigo = (String) m.tabla_Medi.getValueAt(fila,0);
                }
            }
});
    }
    public void tablaMedicamentosEventoMouseClicked (JTable tbl)
    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int fila = m.tabla_Medi.getSelectedRow();
 codigo = (String) m.tabla_Medi.getValueAt(fila,0);
            }
});
    }
        
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == m.btn_AgrMedi){
            String codigo1,medicamento,descripcion;
            int cantidad;
            double precio;
            codigo1 = m.txt_CodMedi.getText();
            medicamento = m.txt_NomMedi.getText();
            descripcion = m.txt_DescripMedi.getText();
            cantidad = Integer.parseInt(m.txt_CantMedi.getText());
            precio = Double.parseDouble(m.txt_CantMedi.getText());
            
            cb.insertarMedicamento(codigo1, medicamento, descripcion, cantidad, precio);
            limpiarCajas();
                        JOptionPane.showMessageDialog(null, "Se ha agregado el medicamento");
            llenarTabla(this.m.tabla_Medi, listaMedicamentos);
            
        }
        if(e.getSource() == m.btn_EditMedi){
            Medicamento medicamento = cb.buscarPorIdMedicamento(codigo);
            this.m.txt_CodMedi.setText(""+medicamento.getCodigo());
            this.m.txt_NomMedi.setText(""+medicamento.getMedica_Name());
            this.m.txt_DescripMedi.setText(""+medicamento.getDescripcion());
            this.m.txt_CantMedi.setText(""+medicamento.getCant_Ext());
            this.m.txt_PrecioMedi.setText(""+medicamento.getPrecio_Unit());
            this.m.txt_CodMedi.setEnabled(false);
        }
        
        if(e.getSource() == m.btn_ElimMedi){
       Medicamento medicamento = cb.buscarPorIdMedicamento(codigo);
       int boton = JOptionPane.showConfirmDialog(null, 
                            "Desea borrar este elemento: "
                            + medicamento.getMedica_Name()+ " ?", "Advertencia", 
                            JOptionPane.YES_NO_OPTION);
          if(boton == JOptionPane.YES_OPTION){
                        cb.borrarMedicamento(codigo);
                        JOptionPane.showMessageDialog(null, "Registro eliminado");
                        llenarTabla(this.m.tabla_Medi,listaMedicamentos );
                    }
        }
        
        if(e.getSource() == m.btn_GuardarCambMedi){
            String medicamento,descrip;
            int cant;
            double precio;
            
            medicamento =m.txt_NomMedi.getText();
            descrip = m.txt_DescripMedi.getText();
            cant = Integer.parseInt(m.txt_CantMedi.getText());
            precio = Double.parseDouble(m.txt_PrecioMedi.getText());
            cb.modificarMedicamento(medicamento, descrip, cant, precio, codigo);
            JOptionPane.showMessageDialog(null, "Se ha registrado el cambio");
            llenarTabla(this.m.tabla_Medi, listaMedicamentos);
            this.m.txt_CodMedi.setEnabled(true);
            limpiarCajas();
            
        }
        
        if(e.getSource() == m.btn_CancCambMedi){
            this.m.txt_CodMedi.setEnabled(true);
            limpiarCajas();
        }
        
         if(e.getSource() == m.btn_BuscMedi)
        {
                int indice =  m.cmbbxMedi.getSelectedIndex();
                if(indice == 1){
                    String clave = m.txt_MedBusc.getText();
                   ArrayList<Medicamento> medi = cb.consultarMedicamentos(clave);
                   llenarTabla(this.m.tabla_Medi,medi);
                }else {
                     String clave = m.txt_MedBusc.getText();
                   ArrayList<Medicamento> medi = cb.consultarMedicamentosNombre(clave);
                   llenarTabla(this.m.tabla_Medi,medi); 
                }
        }
        
    }
    
}
