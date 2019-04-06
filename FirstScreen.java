/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MyGUI;

/**
 *
 * @author hassi
 */
public class FirstScreen extends javax.swing.JFrame {

    /**
     * Creates new form FirstScreen
     */
    public FirstScreen() {
        initComponents();
    }
    boolean isPassenger=false;
    boolean isDriver=false;
    boolean isManager=false;
    String username;
    String password;
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        BusLabel = new javax.swing.JLabel();
        usernameLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        usernameText = new javax.swing.JTextField();
        passengerButton = new javax.swing.JRadioButton();
        driverButton = new javax.swing.JRadioButton();
        mangerButton = new javax.swing.JRadioButton();
        loginButton = new javax.swing.JButton();
        passwordField = new javax.swing.JPasswordField();
        validationLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BusLabel.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        BusLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        BusLabel.setText("Bus Station");

        usernameLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        usernameLabel.setText("username");

        passwordLabel.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        passwordLabel.setText("password");

        usernameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextActionPerformed(evt);
            }
        });

        passengerButton.setText("Passenger");
        passengerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passengerButtonActionPerformed(evt);
            }
        });

        driverButton.setText("Driver");
        driverButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                driverButtonActionPerformed(evt);
            }
        });

        mangerButton.setText("Manager");
        mangerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mangerButtonActionPerformed(evt);
            }
        });

        loginButton.setText("Login ");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        passwordField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(116, 116, 116)
                        .addComponent(BusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(54, 54, 54)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(usernameLabel)
                                    .addComponent(passwordLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(usernameText, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                                    .addComponent(passwordField)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(16, 16, 16)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(validationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(passengerButton)
                                                .addGap(18, 18, 18)
                                                .addComponent(driverButton))
                                            .addComponent(loginButton))
                                        .addGap(18, 18, 18)
                                        .addComponent(mangerButton)))))))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(BusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(usernameLabel)
                    .addComponent(usernameText, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordLabel)
                    .addComponent(passwordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passengerButton)
                    .addComponent(driverButton)
                    .addComponent(mangerButton))
                .addGap(18, 18, 18)
                .addComponent(loginButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addComponent(validationLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextActionPerformed
        username = usernameText.getText();
    }//GEN-LAST:event_usernameTextActionPerformed

    private void passwordFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordFieldActionPerformed
         password = passwordField.getText();
    }//GEN-LAST:event_passwordFieldActionPerformed

    private void passengerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passengerButtonActionPerformed
        isPassenger=true;
        isDriver=false;
        isManager=false;
    }//GEN-LAST:event_passengerButtonActionPerformed

    private void driverButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_driverButtonActionPerformed
        isDriver=true;
        isPassenger=false;
        isManager=false;
    }//GEN-LAST:event_driverButtonActionPerformed

    private void mangerButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mangerButtonActionPerformed
        isManager=true;
        isPassenger=false;
        isDriver=false;
    }//GEN-LAST:event_mangerButtonActionPerformed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        if(isPassenger){
         UserValidation valid = new PassengerValidation();
         if(valid.validation(username, password)){
           validationLabel.setText("passenger");

         }
         else{
             isDriver=false;
             isPassenger=false;
             isManager=false;
           validationLabel.setText("Incorrect username or password!");
         }
        }
        else if(isDriver){
         UserValidation valid = new DriverValidation();
         if(valid.validation(username, password)){
            validationLabel.setText("driver");
         }
         else{
             isDriver=false;
             isPassenger=false;
             isManager=false;
           validationLabel.setText("Incorrect username or password!");
         }
        }
        else if(isManager){
         UserValidation valid = new ManagerValidation();
         if(valid.validation(username, password)){
             
         }
         else{
             isDriver=false;
             isPassenger=false;
             isManager=false;
           validationLabel.setText("Incorrect username or password!");
         }
        }
        else{
          validationLabel.setText("Please select one of the radio buttons!");
        }
        
    }//GEN-LAST:event_loginButtonActionPerformed

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
            java.util.logging.Logger.getLogger(FirstScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FirstScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FirstScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FirstScreen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FirstScreen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BusLabel;
    private javax.swing.JRadioButton driverButton;
    private javax.swing.JButton loginButton;
    private javax.swing.JRadioButton mangerButton;
    private javax.swing.JRadioButton passengerButton;
    private javax.swing.JPasswordField passwordField;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameText;
    private javax.swing.JLabel validationLabel;
    // End of variables declaration//GEN-END:variables
}
