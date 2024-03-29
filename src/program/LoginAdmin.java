package program;

import program.DashboardAdmin;
import program.DaftarAdmin;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ndaru Pratiwi
 */
public class LoginAdmin extends javax.swing.JFrame {

    Connection conn = null;
    Statement st = null;

    /**
     * Creates new form LoginAdmin
     */
    public LoginAdmin(java.awt.Frame parent, boolean modal) {
        initComponents();
        try {
            Class.forName("com.mysql.jdbc.Driver");

            conn = DriverManager.getConnection("jdbc:mysql://localhost/admin", "root", "");
            st = conn.createStatement();
        } catch (Exception ex) {
        }
    }

    LoginAdmin(Object object, boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void CekLoginAdmin() {
        try {
            if (txtIDAdmin.getText().equals("") || txtPasswordAdmin.getPassword().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
                txtIDAdmin.requestFocus();
                HapusLayar();
            } else {
                st = conn.createStatement();
                String sql = ("SELECT * FROM admin WHERE Username ='" + txtIDAdmin.getText() + "'AND Password ='" + String.valueOf(txtPasswordAdmin.getPassword()) + "'  ");
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "ID Admin dan Password Salah Atau Akun Belum Terdaftar", "Pesan", JOptionPane.ERROR_MESSAGE);
                    HapusLayar();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void HapusLayar() {
        txtIDAdmin.setText("");
        txtPasswordAdmin.setText("");
        txtIDAdmin.setEnabled(true);
        txtPasswordAdmin.setEnabled(true);
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnLogin = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        btnDaftar = new javax.swing.JButton();
        txtIDAdmin = new javax.swing.JTextField();
        txtPasswordAdmin = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Halaman Login Admin");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(180, 60, 270, 29);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("ID Admin :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(180, 160, 90, 30);

        btnLogin.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });
        jPanel1.add(btnLogin);
        btnLogin.setBounds(290, 270, 100, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Password :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(180, 210, 100, 30);

        btnDaftar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDaftar.setText("Daftar");
        btnDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDaftar);
        btnDaftar.setBounds(410, 270, 100, 40);
        jPanel1.add(txtIDAdmin);
        txtIDAdmin.setBounds(280, 160, 250, 40);
        jPanel1.add(txtPasswordAdmin);
        txtPasswordAdmin.setBounds(280, 210, 250, 40);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/program/C.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 638, 484);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 639, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 484, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLoginActionPerformed
        // TODO add your handling code here:
        try {
            if (txtIDAdmin.getText().equals("") || txtPasswordAdmin.getPassword().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
                txtIDAdmin.requestFocus();
                HapusLayar();
            } else {
                st = conn.createStatement();
                String sql = ("SELECT * FROM admin WHERE IDAdmin ='" + txtIDAdmin.getText() + "'AND Password ='" + String.valueOf(txtPasswordAdmin.getPassword()) + "'  ");
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Login Berhasil");
                    this.setVisible(false);
                    new DashboardAdmin(null, true).setVisible(true);
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "ID Admin dan Password Salah Atau Akun Belum Terdaftar", "Pesan", JOptionPane.ERROR_MESSAGE);
                    HapusLayar();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//GEN-LAST:event_btnLoginActionPerformed

    private void btnDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new DaftarAdmin(null, true).setVisible(true);
    }//GEN-LAST:event_btnDaftarActionPerformed

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
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                LoginAdmin dialog = new LoginAdmin(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void
                            windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDaftar;
    private javax.swing.JButton btnLogin;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtIDAdmin;
    private javax.swing.JPasswordField txtPasswordAdmin;
    // End of variables declaration//GEN-END:variables
}
