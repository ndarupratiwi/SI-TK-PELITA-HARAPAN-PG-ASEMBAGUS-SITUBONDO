package program;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ndaru Pratiwi
 */
public class DaftarAdmin extends javax.swing.JFrame {

    Connection con = null;
    Statement st = null;

    /**
     * Creates new form DaftarAdmin
     */
    public DaftarAdmin(java.awt.Frame parent, boolean modal) {
        initComponents();
    }

    private void hapuslayar() {
        txtIDAdmin.setText("");
        txtNama.setText("");
        txtEmail.setText("");
        txtPasswordAdmin.setText("");
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
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnDaftar = new javax.swing.JButton();
        btnExit = new javax.swing.JButton();
        txtIDAdmin = new javax.swing.JTextField();
        txtNama = new javax.swing.JTextField();
        txtEmail = new javax.swing.JTextField();
        txtPasswordAdmin = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("REGISTRASI ADMIN");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(200, 50, 250, 30);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("ID Admin :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(190, 140, 110, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Nama :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(190, 180, 80, 30);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Email :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(190, 220, 80, 30);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("Password :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(190, 260, 100, 30);

        btnDaftar.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnDaftar.setText("Daftar");
        btnDaftar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDaftarActionPerformed(evt);
            }
        });
        jPanel1.add(btnDaftar);
        btnDaftar.setBounds(330, 320, 81, 31);

        btnExit.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnExit.setText("Exit");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(450, 320, 61, 31);
        jPanel1.add(txtIDAdmin);
        txtIDAdmin.setBounds(300, 140, 230, 30);
        jPanel1.add(txtNama);
        txtNama.setBounds(300, 180, 230, 30);
        jPanel1.add(txtEmail);
        txtEmail.setBounds(300, 220, 230, 30);
        jPanel1.add(txtPasswordAdmin);
        txtPasswordAdmin.setBounds(300, 260, 230, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/program/C.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 657, 491);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 660, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 487, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new LoginAdmin(null, true).setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

    private void btnDaftarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDaftarActionPerformed
        // TODO add your handling code here:
        try {
            if (txtIDAdmin.getText().equals("") || txtNama.getText().equals("") || txtEmail.getText().equals("") || txtPasswordAdmin.getPassword().equals("")) {
                JOptionPane.showMessageDialog(this, "Data Tida Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
                hapuslayar();
            } else {
                Class.forName("com.mysql.jdbc.Driver");

                con = DriverManager.getConnection("jdbc:mysql://localhost/admin", "root", "");
                st = con.createStatement();
                String simpan = "INSERT INTO admin VALUES('" + txtIDAdmin.getText() + "'  ,'" + txtNama.getText() + "' , '" + txtEmail.getText() + "', '" + String.valueOf(txtPasswordAdmin.getPassword()) + "')";
                st = con.createStatement();
                int SA = st.executeUpdate(simpan);
                JOptionPane.showMessageDialog(null, "Registrasi Berhasil");
                this.setVisible(false);
                new LoginAdmin(null, true).setVisible(true);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "This Account isAlready exist / Duplicate Account ", "Pesan", JOptionPane.WARNING_MESSAGE);
            hapuslayar();
        }
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
            java.util.logging.Logger.getLogger(DaftarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DaftarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DaftarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DaftarAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DaftarAdmin dialog = new DaftarAdmin(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnExit;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtEmail;
    private javax.swing.JTextField txtIDAdmin;
    private javax.swing.JTextField txtNama;
    private javax.swing.JPasswordField txtPasswordAdmin;
    // End of variables declaration//GEN-END:variables
}
