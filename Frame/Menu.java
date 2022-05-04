package Frame;

import javax.swing.JOptionPane;

public class Menu extends javax.swing.JFrame {

    /**
     * Creates new form Menu
     */
    public Menu() {
        initComponents();
        this.setLocationRelativeTo(null); //aparece en el cnetro al momento de ejecutarse
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pac_prin_img = new javax.swing.JLabel();
        rc_prin_img = new javax.swing.JLabel();
        con_prin_img = new javax.swing.JLabel();
        ser_prin_img = new javax.swing.JLabel();
        tra_prin_img = new javax.swing.JLabel();
        esp_prin_img = new javax.swing.JLabel();
        usu_prin_img = new javax.swing.JLabel();
        expc_prin_img = new javax.swing.JLabel();
        salir_prin_img = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(950, 600));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(98, 140, 188));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setPreferredSize(new java.awt.Dimension(900, 100));

        pac_prin_img.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        pac_prin_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        pac_prin_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btn_Pacientes.png"))); // NOI18N
        pac_prin_img.setText("Pacientes");
        pac_prin_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        pac_prin_img.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        rc_prin_img.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        rc_prin_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        rc_prin_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btn_ReservarCitas.png"))); // NOI18N
        rc_prin_img.setText("Reservar Citas");
        rc_prin_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        rc_prin_img.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        con_prin_img.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        con_prin_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        con_prin_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btn_Consultas.png"))); // NOI18N
        con_prin_img.setText("Consultas");
        con_prin_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        con_prin_img.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        ser_prin_img.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        ser_prin_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ser_prin_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btn_Servicios.png"))); // NOI18N
        ser_prin_img.setText("Servicios");
        ser_prin_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        ser_prin_img.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        tra_prin_img.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        tra_prin_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        tra_prin_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btn_Tratamientos.png"))); // NOI18N
        tra_prin_img.setText("Tratamientos");
        tra_prin_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        tra_prin_img.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        esp_prin_img.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        esp_prin_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        esp_prin_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btn_Especialistas.png"))); // NOI18N
        esp_prin_img.setText("Especialistas");
        esp_prin_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        esp_prin_img.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        usu_prin_img.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        usu_prin_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        usu_prin_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btn_Usuarios.png"))); // NOI18N
        usu_prin_img.setText("Usuarios");
        usu_prin_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        usu_prin_img.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        expc_prin_img.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        expc_prin_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        expc_prin_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btn_ExpedienteClinico.png"))); // NOI18N
        expc_prin_img.setText("Exp. Clínico");
        expc_prin_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        expc_prin_img.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        salir_prin_img.setFont(new java.awt.Font("Century Gothic", 0, 16)); // NOI18N
        salir_prin_img.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        salir_prin_img.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btn_Salir.png"))); // NOI18N
        salir_prin_img.setText("Salir");
        salir_prin_img.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        salir_prin_img.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(pac_prin_img, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(esp_prin_img, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(rc_prin_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(con_prin_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ser_prin_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tra_prin_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(expc_prin_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(usu_prin_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(salir_prin_img, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(574, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pac_prin_img, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
            .addComponent(esp_prin_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(rc_prin_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(con_prin_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(ser_prin_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(tra_prin_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(expc_prin_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(usu_prin_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(salir_prin_img, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1600, 100));

        jLabel13.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Img_FondoMenu.jpg"))); // NOI18N
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1600, 770));

        jMenuBar1.setBackground(new java.awt.Color(204, 204, 204));
        jMenuBar1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btn_GestionCitas.png"))); // NOI18N
        jMenu1.setText("Gestionar Citas");
        jMenu1.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu1);

        jMenu2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btn_Medicamentos.png"))); // NOI18N
        jMenu2.setText("Medicamentos");
        jMenu2.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N
        jMenuBar1.add(jMenu2);

        jMenu3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btn_Reportes.png"))); // NOI18N
        jMenu3.setText("Reportes");
        jMenu3.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jMenuItem1.setText("Pacientes");
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("Especialistas");
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("Servicios");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem3);

        jMenuItem4.setText("Tratamientos");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuItem5.setText("Medicamentos");
        jMenu3.add(jMenuItem5);

        jMenuBar1.add(jMenu3);

        jMenu4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/Btn_Config.png"))); // NOI18N
        jMenu4.setText("Configuración");
        jMenu4.setFont(new java.awt.Font("Century Gothic", 0, 14)); // NOI18N

        jMenuItem6.setText("Empresa");
        jMenu4.add(jMenuItem6);

        jMenuItem7.setText("Base de Datos");
        jMenu4.add(jMenuItem7);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Menu.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Menu().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JLabel con_prin_img;
    public javax.swing.JLabel esp_prin_img;
    public javax.swing.JLabel expc_prin_img;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JLabel pac_prin_img;
    public javax.swing.JLabel rc_prin_img;
    public javax.swing.JLabel salir_prin_img;
    public javax.swing.JLabel ser_prin_img;
    public javax.swing.JLabel tra_prin_img;
    public javax.swing.JLabel usu_prin_img;
    // End of variables declaration//GEN-END:variables
}
