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
import Frame.Menu;
import Modelo.ConsultasBD;
import Frame.Login;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import org.apache.commons.codec.digest.DigestUtils;

public class ControladorLogin implements ActionListener{
    Login l = new Login();
    ConsultasBD consultasbd = new ConsultasBD();

    public ControladorLogin(Login login) {
        this.l = login;
        this.l.btn_ingreso.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.l.btn_ingreso){
            String usuario = this.l.txt_usuario.getText();
            String pass = this.l.txt_pass.getText();
            String pass_encrip=DigestUtils.shaHex(pass);
            
            if(consultasbd.comprobarUsuario(usuario,pass_encrip) == null){
            JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto","Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                Menu m = new Menu();
                ControladorMenu cm = new ControladorMenu(m);
                m.setVisible(true);
            }
        }
    }
}


