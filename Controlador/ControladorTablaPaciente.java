/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.ConsultasBD;
import Modelo.Paciente;
import Frame.ReservarCitas;
import Frame.TablaPacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author HP
 */
public class ControladorTablaPaciente implements ActionListener{
    TablaPacientes tp = new TablaPacientes();
    ConsultasBD cb = new ConsultasBD();
    ReservarCitas rc = new ReservarCitas();
    int claveElegida=-1;

    public ControladorTablaPaciente(TablaPacientes tp, ReservarCitas rc) {
        this.tp = tp;
        this.rc = rc;
        llenarTabla(this.tp.tabla_PcntsEmergente);
        tp.Btn_PcntsElegir.addActionListener(this);
        tp.Btn_PcntsCancel.addActionListener(this);
       tablaHuespedesEventoKeyReleased(this.tp.tabla_PcntsEmergente);
     tablaHuespedesEventoMouseClicked(this.tp.tabla_PcntsEmergente);
    }
         public void llenarTabla(JTable tablaH)
    {
         ArrayList<Paciente> listaPacientes = cb.consultarPaciente();
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaH.setModel(modeloT);
        modeloT.addColumn("Id");
        modeloT.addColumn("Nombre");
        modeloT.addColumn("Apellido Paterno");
        modeloT.addColumn("Apellido Materno");
        modeloT.addColumn("Fecha Nacimiento");
        modeloT.addColumn("Domicilio");
        modeloT.addColumn("Estado");
        modeloT.addColumn("Municipio");
        modeloT.addColumn("Telefono");
 
        
        
        Object[] columna = new Object [9];
        for (Paciente aux : listaPacientes)
        {
           columna [0] = ""+aux.getId();
           columna [1] = ""+aux.getNombre();
           columna [2] = ""+aux.getApellido_p();
           columna [3] = ""+aux.getApellido_m();
           columna [4] = ""+aux.getFechaDeNacimiento();
           columna [5] = ""+aux.getCelular();
           columna [6] = ""+aux.getDireccion();
           columna [7] = ""+aux.getMunicipio();
           columna [8] = ""+aux.getEstado();
           
                 modeloT.addRow(columna); 
        } 
    }
         
              
         public void tablaHuespedesEventoKeyReleased (JTable tbl)
    {
        tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased ( KeyEvent e)
            {
                if (tp.tabla_PcntsEmergente.getSelectedRows().length > 0)
                {
                    int fila = tp.tabla_PcntsEmergente.getSelectedRow();
                    // por ultimo, obtengo el valor de la celda
                    claveElegida = Integer.parseInt(String.valueOf(
                            tp.tabla_PcntsEmergente.getValueAt(fila,0)));
                }
            }
});
    }
    public void tablaHuespedesEventoMouseClicked (JTable tbl)
    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e)
            {
                int fila =tp.tabla_PcntsEmergente.getSelectedRow();
                claveElegida = Integer.parseInt(String.valueOf(
                        tp.tabla_PcntsEmergente.getValueAt(fila, 0)));
            }
});
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(tp.Btn_PcntsElegir == e.getSource()){
            Paciente paciente = cb.buscarPorIdPaciente(claveElegida);
            
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
// Aqui usamos la instancia formatter para darle el formato a la fecha. Es importante ver que el resultado es un string.
            String fechaTexto = formatter.format(paciente.getFechaDeNacimiento());
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNac = LocalDate.parse(fechaTexto, fmt);
            LocalDate ahora = LocalDate.now();

            Period periodo = Period.between(fechaNac, ahora);
            int edad = periodo.getYears();
            String nombreCompleto = paciente.getNombre() + " " + paciente.getApellido_p()+ " " + paciente.getApellido_m();
            String telefono = paciente.getCelular();
            rc.txt_NombrePcnt.setText(nombreCompleto);
            rc.txt_IdPcntCita.setText(claveElegida+ "");
            rc.txt_Edad.setText(edad+"");
            rc.txt_celular.setText(telefono);
            tp.dispose();
            
             
        }
        if(tp.Btn_PcntsCancel == e.getSource()){
            tp.dispose();
            
        }
    }
}
