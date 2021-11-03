/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto_1;

import java.awt.Color;
import javax.swing.JOptionPane;

/**
 * Ventana para añadir un nuevo restaurante a la plataforma Samancito Delivery
 * @author Alex
 */
public class AddRestaurant extends javax.swing.JFrame {

    /**
     * Creates new form AddRestaurant
     */
    private DataUpload uploadWindow;
    private RestNode restaurant;
    private FoodList menu;
    
    public AddRestaurant() {
        this.uploadWindow = null;
        this.restaurant = null;
        this.menu = null;
        initComponents();
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    }
    
    public AddRestaurant(DataUpload uploadWindow) {
        this.uploadWindow = uploadWindow;
        this.restaurant = null;
        this.menu = null;
        initComponents();
        Functions f = new Functions();
        int id = this.uploadWindow.getInfo().getClients().getSize() + 
                this.uploadWindow.getInfo().getRestaurants().getSize();
        this.jTextPane1.setText(
                f.changeRoadIntString(id, this.uploadWindow.getInfo().getClients()));
        this.jTextField8.setText(
                f.changeRoadIntString(id, this.uploadWindow.getInfo().getClients()));
        this.jTextField10.setText(
                f.changeRoadIntString(id, this.uploadWindow.getInfo().getClients()));
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
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
        jLabel8 = new javax.swing.JLabel();
        jLabel22 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel12 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jTextField8 = new javax.swing.JTextField();
        jTextField9 = new javax.swing.JTextField();
        jTextField10 = new javax.swing.JTextField();
        jTextField11 = new javax.swing.JTextField();
        jTextField12 = new javax.swing.JTextField();
        jTextField13 = new javax.swing.JTextField();
        jPanel8 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jButton12 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Nuevos Local:");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, -1));

        jLabel22.setText("ID #");
        jPanel1.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 80, -1, -1));

        jTextPane1.setEditable(false);
        jScrollPane3.setViewportView(jTextPane1);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 70, 34, 29));

        jLabel12.setText("Ingrese el nombre del plato:");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 230, -1, -1));

        jTextField4.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField4KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField4, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 220, 130, 30));

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setText("Finalizar");
        jButton1.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                jButton1AncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton1MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton1MouseExited(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 380, 100, 30));

        jLabel13.setText("Ingrese el nombre:");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 130, -1, -1));

        jTextField5.setHorizontalAlignment(javax.swing.JTextField.LEFT);
        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField5KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, 190, 30));

        jTextArea2.setEditable(false);
        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane2.setViewportView(jTextArea2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 310, 100));

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setText("Aceptar");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton2MouseExited(evt);
            }
        });
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 170, 100, 30));

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setText("Agregar");
        jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton3MouseExited(evt);
            }
        });
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 260, 100, 30));

        jLabel14.setText("Restaurante y sus platos:");
        jPanel1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 300, -1, -1));

        jLabel18.setText("Ruta #1 (lo llevaba hasta su locacion):");
        jPanel1.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, -1, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        jLabel11.setText("Rutas");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 60, -1, -1));

        jLabel20.setText("Salida:");
        jPanel1.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 290, -1, -1));

        jLabel23.setText("Llegada:");
        jPanel1.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, -1, -1));

        jLabel24.setText("Distancia:");
        jPanel1.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 340, -1, -1));

        jLabel17.setText("Ruta #2 (lo lleva de su locacion a otro lugar):");
        jPanel1.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 240, -1, -1));

        jLabel21.setText("Salida:");
        jPanel1.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 130, -1, -1));

        jLabel25.setText("Llegada:");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 130, -1, -1));

        jLabel26.setText("Distancia:");
        jPanel1.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 190, -1, -1));

        jTextField8.setEditable(false);
        jTextField8.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextField8, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 280, 40, 30));

        jTextField9.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField9ActionPerformed(evt);
            }
        });
        jTextField9.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField9KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField9, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 40, 30));

        jTextField10.setEditable(false);
        jTextField10.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jPanel1.add(jTextField10, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 120, 40, 30));

        jTextField11.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField11.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField11KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 180, 40, 30));

        jTextField12.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField12.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField12KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, 40, 30));

        jTextField13.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        jTextField13.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextField13KeyTyped(evt);
            }
        });
        jPanel1.add(jTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 280, 40, 30));

        jPanel8.setBackground(new java.awt.Color(255, 153, 0));
        jPanel8.setBorder(javax.swing.BorderFactory.createMatteBorder(3, 3, 3, 3, new java.awt.Color(0, 0, 0)));

        jLabel28.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel28.setText("Añadir un nuevo local!");

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(206, Short.MAX_VALUE)
                .addComponent(jLabel28)
                .addGap(203, 203, 203))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel28)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel1.add(jPanel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 50));

        jButton12.setBackground(new java.awt.Color(255, 255, 255));
        jButton12.setText("Ver IDs");
        jButton12.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jButton12MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jButton12MouseExited(evt);
            }
        });
        jButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton12ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton12, new org.netbeans.lib.awtextra.AbsoluteConstraints(570, 380, -1, 30));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 680, 440));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextField4KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c) && !Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField4KeyTyped

    private void jTextField5KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isAlphabetic(c) && !Character.isDigit(c)){
            evt.consume();
        }
    }//GEN-LAST:event_jTextField5KeyTyped

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (this.jTextField5.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un nombre "
                    + "para el local");
        }else{
            if (this.restaurant == null){
                RestNode newRest = new RestNode();
                this.restaurant = newRest;
                String restName = this.jTextField5.getText();
                this.restaurant.setRestName(restName);
                this.restaurant.setMenu(new FoodList());
                this.restaurant.setRestId(this.jTextPane1.getText());
                this.jTextArea2.setText(this.restaurant.restToString());
            }else{
                JOptionPane.showMessageDialog(rootPane, "Ya tiene un registro"
                        + " en proceso");
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if (this.jTextField4.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Debe ingresar un nombre "
                    + "para el plato");
        }else{
            this.restaurant.getMenu().addLast(
                    new FoodNode(this.jTextField4.getText()));
            this.jTextArea2.setText(this.restaurant.restToString());
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.jTextField5.getText().isEmpty() || this.jTextField4.getText().isEmpty() || this.jTextArea2.getText().isEmpty() || this.jTextField9.getText().isEmpty() || this.jTextField10.getText().isEmpty() || this.jTextField8.getText().isEmpty() || this.jTextField11.getText().isEmpty() || this.jTextField12.getText().isEmpty() || this.jTextField13.getText().isEmpty()){
            JOptionPane.showMessageDialog(rootPane, "Debe completar todos los "
                    + "campos vacíos");
        }else{
            String route1en = this.jTextField9.getText();
            String route1ex = this.jTextField10.getText();
            int route1w = Integer.parseInt(this.jTextField11.getText());
            String route2en = this.jTextField8.getText();
            String route2ex = this.jTextField13.getText();
            int route2w = Integer.parseInt(this.jTextField12.getText());
            if (this.uploadWindow.getInfo().getRoutes().searchEntrance(route1en)
                    && this.uploadWindow.getInfo().getRoutes().searchExit(route2ex)){
                if (route1w > 50 || route1w < 0 || route2w > 50 || route2w < 0){
                    JOptionPane.showMessageDialog(rootPane, "Por los momentos no "
                            + "realizamos envios a lugares tan lejanos");
                }else{
                    if (!route1en.equals(route1ex) && !route2en.equals(route2ex)){
                        if (this.restaurant != null){
                            this.uploadWindow.getInfo().getRestaurants().addLast(this.restaurant);
                            RouteNode newRoute1 = new RouteNode(route1en, 
                            route1ex, route1w);
                            RouteNode newRoute2 = new RouteNode(route2en, 
                                    route2ex, route2w);
                            this.uploadWindow.getInfo().getRoutes().addLast(newRoute1);
                            this.uploadWindow.getInfo().getRoutes().addLast(newRoute2);
                            JOptionPane.showMessageDialog(rootPane, "Registro "
                                    + "exitoso");
                            Functions f = new Functions();
                            f.writeTXT(this.uploadWindow.getInfo().getRestaurants(), 
                                    this.uploadWindow.getInfo().getClients(), 
                                    this.uploadWindow.getInfo().getOrders(), 
                                    this.uploadWindow.getInfo().getRoutes(), 
                                    this.uploadWindow.getInfo().getPathTXT());
                            this.setVisible(false);
                            this.dispose();
                        }else{
                            JOptionPane.showMessageDialog(rootPane, "Debe "
                                    + "proporcionar los datos del local y "
                                    + "sus rutas para finalizar el resgitro");
                        }
                    }else{
                        JOptionPane.showMessageDialog(rootPane, "Las entradas y "
                                + "salidas de las rutas no deben ser iguales");
                    }
                }
            }else{
                JOptionPane.showMessageDialog(rootPane, "Las rutas ingresadas no "
                        + "son validas");
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jTextField9KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField9KeyTyped
        char c = evt.getKeyChar();
        if (Character.isAlphabetic(c)){
            if (Character.isLowerCase(c)){
                evt.consume();
            }else if (this.jTextField9.getText().length() == 1){
                evt.consume();
            }
        }else{
            if (this.jTextField9.getText().length() == 2){
                evt.consume();
            }
        }
    }//GEN-LAST:event_jTextField9KeyTyped

    private void jTextField13KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField13KeyTyped
        char c = evt.getKeyChar();
        if (Character.isAlphabetic(c)){
            if (Character.isLowerCase(c)){
                evt.consume();
            }else if (this.jTextField13.getText().length() == 1){
                evt.consume();
            }
        }else{
            if (this.jTextField13.getText().length() == 2){
                evt.consume();
            }
        }
    }//GEN-LAST:event_jTextField13KeyTyped

    private void jTextField11KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField11KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)){
            evt.consume();
        }else{
            if (this.jTextField11.getText().length() == 2){
                evt.consume();
            }
        }
    }//GEN-LAST:event_jTextField11KeyTyped

    private void jTextField12KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField12KeyTyped
        char c = evt.getKeyChar();
        if (!Character.isDigit(c)){
            evt.consume();
        }else{
            if (this.jTextField12.getText().length() == 2){
                evt.consume();
            }
        }
    }//GEN-LAST:event_jTextField12KeyTyped

    private void jTextField9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField9ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField9ActionPerformed

    private void jButton1MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseEntered
        this.jButton1.setBackground(new Color(255,153,51));
    }//GEN-LAST:event_jButton1MouseEntered

    private void jButton1MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseExited
        this.jButton1.setBackground(Color.white);
    }//GEN-LAST:event_jButton1MouseExited

    private void jButton2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseEntered
        this.jButton2.setBackground(new Color(255,153,51));
    }//GEN-LAST:event_jButton2MouseEntered

    private void jButton2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseExited
        this.jButton2.setBackground(Color.white);
    }//GEN-LAST:event_jButton2MouseExited

    private void jButton3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseEntered
        this.jButton3.setBackground(new Color(255,153,51));
    }//GEN-LAST:event_jButton3MouseEntered

    private void jButton3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton3MouseExited
        this.jButton3.setBackground(Color.white);
    }//GEN-LAST:event_jButton3MouseExited

    private void jButton12MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseEntered
        this.jButton12.setBackground(new Color(255,153,51));
    }//GEN-LAST:event_jButton12MouseEntered

    private void jButton12MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton12MouseExited
        this.jButton12.setBackground(Color.white);
    }//GEN-LAST:event_jButton12MouseExited

    private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
        GetRoutes routesWindow = new GetRoutes(this.uploadWindow);
        routesWindow.setLocationRelativeTo(null);
        routesWindow.setVisible(true);
    }//GEN-LAST:event_jButton12ActionPerformed

    private void jButton1AncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_jButton1AncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1AncestorAdded

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
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AddRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AddRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AddRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AddRestaurant.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AddRestaurant().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton12;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JTextField jTextField10;
    private javax.swing.JTextField jTextField11;
    private javax.swing.JTextField jTextField12;
    private javax.swing.JTextField jTextField13;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField8;
    private javax.swing.JTextField jTextField9;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables
}
