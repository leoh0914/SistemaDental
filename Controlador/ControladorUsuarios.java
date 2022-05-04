/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Frame.Usuarios;
import Modelo.ConsultasBD;
import Modelo.Usuario;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import org.apache.commons.codec.digest.DigestUtils;

/**
 *
 * @author HP EliteBook 8470p
 */
public class ControladorUsuarios implements ActionListener {
Usuarios u = new Usuarios();
ConsultasBD cb = new ConsultasBD();
String rol;
String codigo ="";
    public ControladorUsuarios(Usuarios u) {
        this.u = u;
        this.u.btn_AgrUsr.addActionListener(this);
        this.u.btn_ElimUsr.addActionListener(this);
        this.u.btn_EditUsr.addActionListener(this);
        this.u.btn_GuardarCambUsr.addActionListener(this);
        this.u.btn_CancCambUsr.addActionListener(this);
        this.u.btn_RolAdmin.addActionListener(this);
        this.u.btn_RolAsist.addActionListener(this);
        this.u.btn_RolEspclt.addActionListener(this);
        
        llenarTabla(u.tabla_Usr);
        tablaUsuariosEventoMouseClicked(u.tabla_Usr);
        tablaUsuariosEventoKeyReleased(u.tabla_Usr);
    }
     public void limpiarCajas(){
         u.txt_Usuario.setText("");
         u.txt_Nombres.setText("");
         u.txt_Apellidos.setText("");
         u.txt_Contraseña.setText("");
     }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == u.btn_RolAdmin){
            rol = "Administrador";
        }
        if(e.getSource() == u.btn_RolAsist){
            rol = "Asistente";
        }
        if(e.getSource() == u.btn_RolEspclt){
            rol = "Especialista";
        }
        
            if(e.getSource()== u.btn_AgrUsr){
               String usuario = u.txt_Usuario.getText();
              
               if(cb.buscarPorUser(usuario) == null){
                String nombres = u.txt_Nombres.getText();
               String apellidos = u.txt_Apellidos.getText();
               String pass = u.txt_Contraseña.getText();
               String pass_encrip=DigestUtils.shaHex(pass);
               cb.insertarUsuario(usuario, nombres, apellidos, pass_encrip, rol); 
               llenarTabla(this.u.tabla_Usr);
               limpiarCajas();
               } else {

               JOptionPane.showMessageDialog(null,  "Ese usuario ya existe, favor de intentar con otro", "Error",JOptionPane.ERROR_MESSAGE);
               limpiarCajas();
               }
               
            }
            
            if(e.getSource() == u.btn_EditUsr){
                if(codigo != ""){
              Usuario usuario = cb.buscarPorUser(codigo);
            this.u.txt_Nombres.setText(""+usuario.getNombres());
            this.u.txt_Apellidos.setText(""+usuario.getApellidos());
            rol = usuario.getRol();
            this.u.txt_Usuario.setEnabled(false);
            }
            }
            if(e.getSource() == u.btn_ElimUsr){
                    if(codigo != ""){
          Usuario usuario = cb.buscarPorUser(codigo);
          int boton = JOptionPane.showConfirmDialog(null, 
                            "Desea borrar este elemento: "
                            + usuario.toString()+ " ?", "Advertencia", 
                            JOptionPane.YES_NO_OPTION);
          if(boton == JOptionPane.YES_OPTION){
                        cb.borrarUsuario(codigo);
                        JOptionPane.showMessageDialog(null, "Registro eliminado");
                       llenarTabla(this.u.tabla_Usr);
                    }
          }  
            
            }
            if(e.getSource() == u.btn_GuardarCambUsr){
              String nombres = u.txt_Nombres.getText();
               String apellidos = u.txt_Apellidos.getText();
               String pass = u.txt_Contraseña.getText();
               String pass_encrip=DigestUtils.shaHex(pass);
               cb.modificarUsuario(nombres, apellidos, pass_encrip, rol, codigo); 
               
               llenarTabla(this.u.tabla_Usr);   
            }
            
            if(e.getSource() == u.btn_CancCambUsr){
                          this.u.txt_Usuario.setEnabled(true);
                          limpiarCajas();
            }
            
            
    }
    
        public void llenarTabla(JTable tablaH)
    {
         ArrayList<Usuario> listaUsuarios = cb.consultarUsuarios_Tabla();
        DefaultTableModel modeloT = new DefaultTableModel();
        tablaH.setModel(modeloT);
        modeloT.addColumn("Usuario");
        modeloT.addColumn("Nombres");
        modeloT.addColumn("Apellidos");
        modeloT.addColumn("Rol");
 
        Object[] columna = new Object [4];
        for (Usuario aux : listaUsuarios)
        {
           columna [0] = ""+aux.getUser();
           columna [1] = ""+aux.getNombres();
           columna [2] = ""+aux.getApellidos();
           columna [3] = ""+aux.getRol();
           
                 modeloT.addRow(columna); 
        }
    }
        
                 public void tablaUsuariosEventoKeyReleased (JTable tbl)
    {
        tbl.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased ( KeyEvent e)
            {
                if (u.tabla_Usr.getSelectedRows().length > 0)
                {
                    int fila = u.tabla_Usr.getSelectedRow();
                    // por ultimo, obtengo el valor de la celda
                     codigo = (String) u.tabla_Usr.getValueAt(fila,0);
                }
            }
});
    }
    public void tablaUsuariosEventoMouseClicked (JTable tbl)
    {
        tbl.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(MouseEvent e)
            {
                int fila = u.tabla_Usr.getSelectedRow();
                codigo = (String) u.tabla_Usr.getValueAt(fila,0);
            }
});
    }
}


