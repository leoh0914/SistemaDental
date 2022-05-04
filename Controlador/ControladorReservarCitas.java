/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

/**
 *
 * @author HP EliteBook 8470p
 */

import Modelo.ConsultasBD;
import Modelo.Paciente;
import Frame.ReservarCitas;
import Frame.TablaPacientes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

/**
 *
 * @author HP
 */
public class ControladorReservarCitas implements ActionListener{
ConsultasBD cb = new ConsultasBD();
ReservarCitas rc = new ReservarCitas();
String horario = "";
String turno ="";

    public ControladorReservarCitas(ConsultasBD cb,ReservarCitas rc ) {
        this.cb = cb;
        this.rc = rc;
        this.rc.btnBuscarP_Agenda.addActionListener(this);
        this.rc.radio_8_Mat.setEnabled(false);
        this.rc.radio_830_Mat.setEnabled(false);
        this.rc.radio_9_Mat.setEnabled(false);
        this.rc.radio_930_Mat.setEnabled(false);
        this.rc.radio_10_Mat.setEnabled(false);
        this.rc.radio_1030_Mat.setEnabled(false);
        this.rc.radio_11_Mat.setEnabled(false);
        this.rc.radio_1130_Mat.setEnabled(false);
        this.rc.radio_12_Ves.setEnabled(false);
        this.rc.radio_1230_Ves.setEnabled(false);
        this.rc.radio_13_Ves.setEnabled(false);
        this.rc.radio_1330_Ves.setEnabled(false);
        this.rc.radio_14_Ves.setEnabled(false);
        this.rc.radio_1430_Ves.setEnabled(false);
        this.rc.radio_15_Ves.setEnabled(false);
        this.rc.radio_1530_Ves.setEnabled(false);
        this.rc.radio_16_Ves.setEnabled(false);
        this.rc.radio_1630_Ves.setEnabled(false);
        this.rc.radio_17_Ves.setEnabled(false);
        this.rc.radio_1730_Ves.setEnabled(false);
        this.rc.radio_18_Ves.setEnabled(false);
        this.rc.radio_1830_Ves.setEnabled(false);
        this.rc.radio_19_Ves.setEnabled(false);
        this.rc.radio_1930_Ves.setEnabled(false);
        this.rc.radio_20_Ves.setEnabled(false);
        this.rc.radio_2030_Ves.setEnabled(false);
//       
        this.rc.btnVerDisponible.addActionListener(this);
        this.rc.txt_Cita.setEditable(false);
        this.rc.txt_NombrePcnt.setEditable(false);
        this.rc.txt_celular.setEditable(false);
        this.rc.txt_Edad.setEditable(false);
        this.rc.txt_IdPcntCita.setEditable(false);
        this.rc.btn_AgregarCita.addActionListener(this);
        this.rc.fecha_Elegida.setEnabled(false);
        this.rc.btnVerDisponible.setEnabled(false);
        this.rc.btnBuscarP_Agenda.setEnabled(false);
        this.rc.btn_CancelarCita.setEnabled(false);
        this.rc.btn_GuardarCita.setEnabled(false);
        this.rc.btn_CancelarCita.addActionListener(this);
        this.rc.btn_GuardarCita.addActionListener(this);
        
    }
    
    public void reprogramarCita(Paciente p, int idCita) throws SQLException{
        this.rc.fecha_Elegida.setEnabled(true);
        this.rc.btn_CancelarCita.setEnabled(true);
        this.rc.btn_GuardarCita.setEnabled(true);
        this.rc.btnVerDisponible.setEnabled(true);
        rc.txt_IdPcntCita.setText(""+p.getId());
        rc.txt_NombrePcnt.setText(p.getNombre()+" "+p.getApellido_p()+" "+p.getApellido_m());
        rc.txt_celular.setText(p.getCelular());
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
// Aqui usamos la instancia formatter para darle el formato a la fecha. Es importante ver que el resultado es un string.
            String fechaTexto = formatter.format(p.getFechaDeNacimiento());
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate fechaNac = LocalDate.parse(fechaTexto, fmt);
            LocalDate ahora = LocalDate.now();

            Period periodo = Period.between(fechaNac, ahora);
            int edad = periodo.getYears();
            int cita = cb.obtenerIdCita()-1;
        rc.txt_Edad.setText(""+edad);
        rc.txt_Cita.setText(""+idCita);        
    }

public void habilitarBoton (String d1, String d2, Date date,JRadioButton rb) throws ParseException{
            Date fecha = rc.fecha_Elegida.getDate();
            java.sql.Date date2 = new java.sql.Date(fecha.getTime());
            DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                Date  actual = new SimpleDateFormat("HH:mm").parse(dateFormat.format(date).trim());
                Date inicial= new SimpleDateFormat("HH:mm").parse(d1.trim());
                Date final1 = new SimpleDateFormat("HH:mm").parse(d2.trim());  
                Date intermedio= new SimpleDateFormat("HH:mm").parse("15:00".trim());
   
                if(actual.after(inicial) && actual.before(final1)){
                    if(actual.before(intermedio)){
                        turno = "Matutino";
                    } else {
                        turno = "Vespertino";
                        System.out.println(turno);
                    }                          
              horario = rb.getText();
             System.out.println(horario);
          if(cb.buscarPorFechaAgendaBoton(date2, horario, turno) == null){
              rb.setEnabled(true);
          }
}                
                
}

public void checarDisponibilidad (Date date2, JRadioButton rb, String turno) throws ParseException{
            Date intermedio= new SimpleDateFormat("HH:mm").parse("15:00".trim());
            Date actual= new SimpleDateFormat("HH:mm").parse("08:00".trim());
              horario = rb.getText();
             System.out.println(horario);
          if(cb.buscarPorFechaAgendaBoton((java.sql.Date) date2, horario, turno) == null){
              rb.setEnabled(true);
          } 
}

 public void limpiarCajas(){
         rc.txt_Cita.setText("");
         rc.txt_NombrePcnt.setText("");
         rc.txt_celular.setText("");
         rc.txt_Edad.setText("");
         rc.txt_IdPcntCita.setText("");
         rc.fecha_Elegida.setEnabled(false);
        rc.btnVerDisponible.setEnabled(false);
        rc.btnBuscarP_Agenda.setEnabled(false);
        rc.btn_CancelarCita.setEnabled(false);
        rc.btn_GuardarCita.setEnabled(false);
        rc.btn_AgregarCita.setEnabled(true);
        rc.radio_8_Mat.setSelected(false);
        rc.radio_830_Mat.setSelected(false);
        rc.radio_9_Mat.setSelected(false);
        rc.radio_930_Mat.setSelected(false);
        rc.radio_10_Mat.setSelected(false);
        rc.radio_1030_Mat.setSelected(false);
        rc.radio_11_Mat.setSelected(false);
        rc.radio_1130_Mat.setSelected(false);
        rc.radio_12_Ves.setSelected(false);
        rc.radio_1230_Ves.setSelected(false);
        rc.radio_13_Ves.setSelected(false);
        rc.radio_1330_Ves.setSelected(false);
                    
     rc.radio_15_Ves.setSelected(false);
     rc.radio_1530_Ves.setSelected(false);
     rc.radio_16_Ves.setSelected(false);
     rc.radio_1630_Ves.setSelected(false);
     rc.radio_17_Ves.setSelected(false);
     rc.radio_1730_Ves.setSelected(false);
     rc.radio_18_Ves.setSelected(false);
     rc.radio_1830_Ves.setSelected(false);
     rc.radio_19_Ves.setSelected(false);
     rc.radio_1930_Ves.setSelected(false);
     rc.radio_20_Ves.setSelected(false);
     rc.radio_2030_Ves.setSelected(false);
     
        rc.radio_8_Mat.setEnabled(false);
        rc.radio_830_Mat.setEnabled(false);
        rc.radio_9_Mat.setEnabled(false);
        rc.radio_930_Mat.setEnabled(false);
        rc.radio_10_Mat.setEnabled(false);
        rc.radio_1030_Mat.setEnabled(false);
        rc.radio_11_Mat.setEnabled(false);
        rc.radio_1130_Mat.setEnabled(false);
        rc.radio_12_Ves.setEnabled(false);
        rc.radio_1230_Ves.setEnabled(false);
        rc.radio_13_Ves.setEnabled(false);
        rc.radio_1330_Ves.setEnabled(false);
        rc.radio_15_Ves.setEnabled(false);
        rc.radio_1530_Ves.setEnabled(false);
        rc.radio_16_Ves.setEnabled(false);
        rc.radio_1630_Ves.setEnabled(false);
        rc.radio_17_Ves.setEnabled(false);
        rc.radio_1730_Ves.setEnabled(false);
        rc.radio_18_Ves.setEnabled(false);
        rc.radio_1830_Ves.setEnabled(false);
        rc.radio_19_Ves.setEnabled(false);
        rc.radio_1930_Ves.setEnabled(false);
        rc.radio_20_Ves.setEnabled(false);
        rc.radio_2030_Ves.setEnabled(false);
        rc.fecha_Elegida.setDate(null);
//         vr.fecha_nac_paciente.setDate(null);
//         vr.cbx_estado.setSelectedIndex(0);
//         vr.cbx_municipio.setSelectedIndex(0);
         
     }
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource() == rc.btnBuscarP_Agenda){
            TablaPacientes tp = new TablaPacientes();
            ControladorTablaPaciente ctp = new ControladorTablaPaciente(tp,rc);
            tp.setVisible(true);
        }
      if(e.getSource() == rc.btnVerDisponible){
            Date fecha = rc.fecha_Elegida.getDate();
             java.sql.Date date2 = new java.sql.Date(fecha.getTime());
              java.util.Date d = new java.util.Date();  
                java.sql.Date date3 = new java.sql.Date(d.getTime());

             if(date2.toString().equals(date3.toString())){
                try {
                    System.out.println("son fechas iguales");
                    DateFormat dateFormat = new SimpleDateFormat("HH:mm");
                    Date date = new Date();
                    String dInicial = null, dFinal = null;
                    Date actual;
                    Date inicial;
                    Date final1;
                    dInicial ="08:00";
                    dFinal="08:30";
                    habilitarBoton(dInicial,dFinal,date,rc.radio_8_Mat);
                    habilitarBoton("08:30","09:00",date,rc.radio_830_Mat);
                    habilitarBoton("09:00","09:30",date,rc.radio_9_Mat);
                    habilitarBoton("09:30","10:00",date,rc.radio_930_Mat);
                    habilitarBoton("10:00","10:30",date,rc.radio_10_Mat);
                    habilitarBoton("10:30","11:00",date,rc.radio_1030_Mat);
                    habilitarBoton("11:00","11:30",date,rc.radio_11_Mat);
                    habilitarBoton("11:30","12:00",date,rc.radio_1130_Mat);
                    habilitarBoton("12:00","12:30",date,rc.radio_12_Ves);
                    habilitarBoton("12:30","13:00",date,rc.radio_1230_Ves);
                    habilitarBoton("13:00","13:30",date,rc.radio_13_Ves);
                    habilitarBoton("13:30","14:00",date,rc.radio_1330_Ves);
                    habilitarBoton("14:30","14:30",date,rc.radio_1330_Ves);
                    habilitarBoton("14:30","15:00",date,rc.radio_1330_Ves);
                    habilitarBoton("15:00","15:30",date,rc.radio_15_Ves);
                    habilitarBoton("15:30","16:00",date,rc.radio_1530_Ves);
                    habilitarBoton("16:00","16:30",date,rc.radio_16_Ves);
                    habilitarBoton("16:30","17:00",date,rc.radio_1630_Ves);
                    habilitarBoton("17:00","17:30",date,rc.radio_17_Ves);
                    habilitarBoton("17:30","18:00",date,rc.radio_1730_Ves);
                    habilitarBoton("18:00","18:30",date,rc.radio_18_Ves);
                    habilitarBoton("18:30","19:00",date,rc.radio_1830_Ves);
                    habilitarBoton("19:00","19:30",date,rc.radio_19_Ves);
                    habilitarBoton("19:30","20:00",date,rc.radio_1930_Ves);
                    habilitarBoton("20:00","20:30",date,rc.radio_20_Ves);
                    habilitarBoton("20:30","21:00",date,rc.radio_2030_Ves);
                    
                    
                } catch (ParseException ex) {
                    Logger.getLogger(ControladorReservarCitas.class.getName()).log(Level.SEVERE, null, ex);
                }
                
     

             } else   if(date2.before(date3)){
                 JOptionPane.showMessageDialog(null, "No se puede registrar una cita en esa fecha ya que ya paso, por favor elige otra fecha", "Advertencia", JOptionPane.WARNING_MESSAGE);
             }  
             
             else {
                 try {
              turno = "Matutino";
               checarDisponibilidad(date2,rc.radio_8_Mat,turno);
                    checarDisponibilidad(date2,rc.radio_830_Mat,turno);
                    checarDisponibilidad(date2,rc.radio_9_Mat,turno);
                    checarDisponibilidad(date2,rc.radio_930_Mat,turno);
                    checarDisponibilidad(date2,rc.radio_10_Mat,turno);
                    checarDisponibilidad(date2,rc.radio_1030_Mat,turno);
                    checarDisponibilidad(date2,rc.radio_11_Mat,turno);
                    checarDisponibilidad(date2,rc.radio_1130_Mat,turno);
                    checarDisponibilidad(date2,rc.radio_12_Ves,turno);
                    checarDisponibilidad(date2,rc.radio_1230_Ves,turno);
                    checarDisponibilidad(date2,rc.radio_13_Ves,turno);
                    checarDisponibilidad(date2,rc.radio_1330_Ves,turno);
                    
                    turno= "Verpertino";
                    checarDisponibilidad(date2,rc.radio_15_Ves, turno);
                    checarDisponibilidad(date2,rc.radio_1530_Ves, turno);
                    checarDisponibilidad(date2,rc.radio_16_Ves, turno);
                    checarDisponibilidad(date2,rc.radio_1630_Ves, turno);
                    checarDisponibilidad(date2,rc.radio_17_Ves, turno);
                    checarDisponibilidad(date2,rc.radio_1730_Ves, turno);
                    checarDisponibilidad(date2,rc.radio_18_Ves, turno);
                    checarDisponibilidad(date2,rc.radio_1830_Ves, turno);
                    checarDisponibilidad(date2,rc.radio_19_Ves, turno);
                    checarDisponibilidad(date2,rc.radio_1930_Ves, turno);
                    checarDisponibilidad(date2,rc.radio_20_Ves, turno);
                    checarDisponibilidad(date2 ,rc.radio_2030_Ves, turno);
                    
                    } catch (ParseException ex) {
                    Logger.getLogger(ControladorReservarCitas.class.getName()).log(Level.SEVERE, null, ex);
                }
        }
      }  

      if(e.getSource() == rc.btn_AgregarCita){
            try {
                rc.txt_Cita.setText(""+cb.obtenerIdCita());
                rc.fecha_Elegida.setEnabled(true);
                rc.btnVerDisponible.setEnabled(true);
                rc.btnBuscarP_Agenda.setEnabled(true);
                rc.btn_CancelarCita.setEnabled(true);
                rc.btn_GuardarCita.setEnabled(true);
                rc.btn_AgregarCita.setEnabled(false);
                
                
            } catch (SQLException ex) {
                Logger.getLogger(ControladorReservarCitas.class.getName()).log(Level.SEVERE, null, ex);
            }
                  
      }
      if(e.getSource() == rc.btn_GuardarCita){
          Date fecha = rc.fecha_Elegida.getDate();
           java.sql.Date fecha1 = new java.sql.Date(fecha.getTime());
          int idP = Integer.parseInt(rc.txt_IdPcntCita.getText());
          int idCita = Integer.parseInt(rc.txt_Cita.getText());
          if(cb.buscarPorIdAg(idCita) == null){
            cb.insertarAgenda(fecha1, horario, idP, turno); 
          //mensaje de que se guardo bien
            JOptionPane.showMessageDialog(null, "Se ha registrado exitosamente la cita en la agenda", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            limpiarCajas();
          }
          else{
            System.out.println("actualizacion");
        cb.modificarAgenda(fecha1, horario, turno, idCita);
            JOptionPane.showMessageDialog(null, "Se ha reprogramado la cita " + idCita + " en la agenda", "Informacion", JOptionPane.INFORMATION_MESSAGE);
                }
          
      }
      if(e.getSource() == rc.btn_CancelarCita){
          limpiarCajas();
      }
    }
}

//if(actual.after(inicial) && actual.before(final1)){
//                    
//                } else {
//                    dInicial ="08:30";
//                dFinal="09:00";
//                actual = new SimpleDateFormat("HH:mm").parse(dateFormat.format(date).trim());
//                  inicial= new SimpleDateFormat("HH:mm").parse(dInicial.trim());
//                final1 = new SimpleDateFormat("HH:mm").parse(dFinal.trim());
//                    if(actual.after(inicial) && actual.before(final1)){
//                                    turno = "Matutino";
//              horario = rc.radio_10_Mat.getText();
//             System.out.println(horario);
//          if(cb.buscarPorFechaAgendaBoton(date2, horario, turno) == null){
//              rc.radio_10_Mat.setEnabled(true);
//          } 
//                    }
//                }