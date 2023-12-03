/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package LoginPanel;

import java.awt.Font;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;


/**
 *
 * @author gauravvraii
 */
public class LoginMainFrame extends javax.swing.JFrame {

    /**
     * Creates new form LoginMainFrame
     */
    public LoginMainFrame() {
        initComponents();
    }

    private String hashPassword(String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
            byte[] hashBytes = messageDigest.digest(password.getBytes());
            return Base64.getEncoder().encodeToString(hashBytes);
        } catch (NoSuchAlgorithmException e) {
            // Handle the exception as needed
            return password;
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        mainPanel = new javax.swing.JPanel();
        titleLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        passwordTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        loginButton = new javax.swing.JButton();
        dontHaveAnAccountLabel = new javax.swing.JLabel();
        registerLabel = new javax.swing.JLabel();
        invalidEmailLabel = new javax.swing.JLabel();
        passwordErrorLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        mainPanel.setBackground(new java.awt.Color(255, 255, 255));

        titleLabel.setBackground(new java.awt.Color(0, 102, 204));
        titleLabel.setFont(new java.awt.Font("Kailasa", 1, 48)); // NOI18N
        titleLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleLabel.setText("CardsConsolidator");

        emailLabel.setFont(new java.awt.Font("Kailasa", 1, 18)); // NOI18N
        emailLabel.setText("Email:");

        passwordLabel.setFont(new java.awt.Font("Kailasa", 1, 18)); // NOI18N
        passwordLabel.setText("Password:");

        passwordTextField.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                passwordTextFieldMousePressed(evt);
            }
        });
        passwordTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                passwordTextFieldKeyPressed(evt);
            }
        });

        emailTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                emailTextFieldKeyTyped(evt);
            }
        });

        loginButton.setBackground(new java.awt.Color(0, 102, 255));
        loginButton.setFont(new java.awt.Font("Kailasa", 1, 18)); // NOI18N
        loginButton.setText("Login");
        loginButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                loginButtonActionPerformed(evt);
            }
        });

        dontHaveAnAccountLabel.setFont(new java.awt.Font("Arial Hebrew Scholar", 0, 14)); // NOI18N
        dontHaveAnAccountLabel.setText("Don't have an account?");

        registerLabel.setFont(new java.awt.Font("Arial Hebrew Scholar", 0, 14)); // NOI18N
        registerLabel.setForeground(new java.awt.Color(0, 102, 255));
        registerLabel.setText("Register");
        registerLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                registerLabelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                registerLabelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                registerLabelMouseExited(evt);
            }
        });

        invalidEmailLabel.setFont(new java.awt.Font("Arial Hebrew Scholar", 1, 14)); // NOI18N
        invalidEmailLabel.setForeground(new java.awt.Color(255, 0, 51));

        passwordErrorLabel.setFont(new java.awt.Font("Arial Hebrew Scholar", 1, 14)); // NOI18N
        passwordErrorLabel.setForeground(new java.awt.Color(255, 51, 51));

        javax.swing.GroupLayout mainPanelLayout = new javax.swing.GroupLayout(mainPanel);
        mainPanel.setLayout(mainPanelLayout);
        mainPanelLayout.setHorizontalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(195, 195, 195)
                        .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(passwordLabel)
                            .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(dontHaveAnAccountLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(registerLabel))
                            .addGroup(mainPanelLayout.createSequentialGroup()
                                .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(55, 55, 55)
                                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(passwordErrorLabel)
                                    .addComponent(invalidEmailLabel)))))
                    .addGroup(mainPanelLayout.createSequentialGroup()
                        .addGap(111, 111, 111)
                        .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 444, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(245, Short.MAX_VALUE))
        );
        mainPanelLayout.setVerticalGroup(
            mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(mainPanelLayout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(titleLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invalidEmailLabel))
                .addGap(18, 18, 18)
                .addComponent(passwordLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(passwordTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(passwordErrorLabel))
                .addGap(30, 30, 30)
                .addComponent(loginButton, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(mainPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dontHaveAnAccountLabel)
                    .addComponent(registerLabel))
                .addContainerGap(174, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(mainPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(48, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailTextFieldKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_emailTextFieldKeyTyped
        // TODO add your handling code here:
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        Pattern pattern = Pattern.compile(emailRegex);
        Matcher matcher = pattern.matcher(emailTextField.getText());

        if (!matcher.matches()) {
            invalidEmailLabel.setText("Invalid Email!");
        } else {
            invalidEmailLabel.setText(null);
        }

    }//GEN-LAST:event_emailTextFieldKeyTyped

    private void passwordTextFieldKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_passwordTextFieldKeyPressed
        // Minimum 8 characters followed by at least one special character, and at least one numeric valu
        
        String passwordRegex = "^(?=.*[0-9])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
        String userEnteredPassword = passwordTextField.getText(); 
        String hashedPassword = hashPassword(userEnteredPassword);
        System.out.println("Hashed Password: " + hashedPassword);
        
        Pattern pattern = Pattern.compile(passwordRegex);
        Matcher matcher = pattern.matcher(passwordTextField.getText());

        if (!matcher.matches()) {
            passwordErrorLabel.setText("Invalid Password!");
        } else {
            passwordErrorLabel.setText(null);    
            
        }
    }//GEN-LAST:event_passwordTextFieldKeyPressed

    private void loginButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_loginButtonActionPerformed
        // TODO add your handling code here:
        String email = emailTextField.getText();
        String password = passwordTextField.getText();
        
        if (email.isEmpty() || password.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill in all required fields", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
            JOptionPane.showMessageDialog(this, "\nEmail: " + email + "\nPassword: " + password, "Successfully Registered", JOptionPane.INFORMATION_MESSAGE);     
        
        JOptionPane.showMessageDialog(null, "Successfully Login", "User Information", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_loginButtonActionPerformed

    private void registerLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerLabelMouseClicked
        // TODO add your handling code here:
        RegistrationMainFrame registrationFrame = new RegistrationMainFrame();
        registrationFrame.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_registerLabelMouseClicked

    private void registerLabelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerLabelMouseEntered
        // TODO add your handling code here:
        Font font = registerLabel.getFont();
        registerLabel.setFont(font.deriveFont(font.getStyle() | Font.CENTER_BASELINE | Font.BOLD));
    }//GEN-LAST:event_registerLabelMouseEntered

    private void registerLabelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_registerLabelMouseExited
        // TODO add your handling code here:
        Font font = registerLabel.getFont();
        registerLabel.setFont(font.deriveFont(Font.PLAIN));
    }//GEN-LAST:event_registerLabelMouseExited

    private void passwordTextFieldMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_passwordTextFieldMousePressed
        // TODO add your handling code here:    
    }//GEN-LAST:event_passwordTextFieldMousePressed

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
            java.util.logging.Logger.getLogger(LoginMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginMainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoginMainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel dontHaveAnAccountLabel;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel invalidEmailLabel;
    private javax.swing.JButton loginButton;
    private javax.swing.JPanel mainPanel;
    private javax.swing.JLabel passwordErrorLabel;
    private javax.swing.JLabel passwordLabel;
    private javax.swing.JTextField passwordTextField;
    private javax.swing.JLabel registerLabel;
    private javax.swing.JLabel titleLabel;
    // End of variables declaration//GEN-END:variables
}
