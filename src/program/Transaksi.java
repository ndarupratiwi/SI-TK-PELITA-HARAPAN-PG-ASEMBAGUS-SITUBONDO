package program;

import program.DashboardUser;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Ndaru Pratiwi
 */
public class Transaksi extends javax.swing.JFrame {

    Connection con = null;
    Statement st = null;

    /**
     * Creates new form Transaksi
     */
    public Transaksi(java.awt.Frame parent, boolean modal) {
        initComponents();
         try {
            Class.forName("com.mysql.jdbc.Driver");

            con = DriverManager.getConnection("jdbc:mysql://localhost/transaksi", "root", "");
            st = con.createStatement();
        } catch (Exception ex) {
        }
    }
private void CekTransaksi(){
    try {
            if (txtNoRek.getText().equals("") || txtNamaRek.getText().equals("") || txtTglTransfer.getText().equals("") || txtJumlah.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
                txtNoRek.requestFocus();
                HapusLayar();
            } else {
                st = con.createStatement();
                String sql = ("SELECT * FROM transaksi WHERE NomorRekening  ='" + txtNoRek.getText() + "'AND NamaRekening ='" + txtNamaRek.getText() + "'AND TanggalTransfer ='" + txtTglTransfer.getText()+"'AND Jumlah ='" + txtJumlah.getText() +"' ");
                ResultSet rs = st.executeQuery(sql);
                if(rs.next()) {
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Nomor Rekening Salah Atau Belum Transfer", "Pesan", JOptionPane.ERROR_MESSAGE);
                    HapusLayar();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    
}
    private void HapusLayar() {
        txtNoRek.setText("");
        txtNamaRek.setText("");
        txtTglTransfer.setText("");
        txtJumlah.setText("");
        txtNoRek.setEnabled(true);
        txtNamaRek.setEnabled(true);
        txtTglTransfer.setEnabled(true);
        txtJumlah.setEnabled(true);
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
        txtNoRek = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        btnExit = new javax.swing.JButton();
        btnKonfirmasi = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNamaRek = new javax.swing.JTextField();
        txtTglTransfer = new javax.swing.JTextField();
        txtJumlah = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("TRANSAKSI DAFTAR ULANG");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(130, 40, 337, 29);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Konfirmasi Pembayaran Maksimal 3 Hari Setelah Transfer !!!");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(190, 130, 370, 17);
        jPanel1.add(txtNoRek);
        txtNoRek.setBounds(320, 170, 250, 30);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("No. Rekening :");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(190, 170, 130, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Nama Rekening :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(190, 210, 110, 17);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel6.setText("Tanggal Transfer :");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(190, 250, 120, 17);

        btnExit.setText("Kembali");
        btnExit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExitActionPerformed(evt);
            }
        });
        jPanel1.add(btnExit);
        btnExit.setBounds(490, 330, 80, 30);

        btnKonfirmasi.setText("Konfirmasi Pembayaran");
        btnKonfirmasi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKonfirmasiActionPerformed(evt);
            }
        });
        jPanel1.add(btnKonfirmasi);
        btnKonfirmasi.setBounds(310, 330, 170, 30);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Jumlah :");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(190, 290, 80, 17);
        jPanel1.add(txtNamaRek);
        txtNamaRek.setBounds(320, 210, 250, 30);
        jPanel1.add(txtTglTransfer);
        txtTglTransfer.setBounds(320, 250, 250, 30);
        jPanel1.add(txtJumlah);
        txtJumlah.setBounds(320, 290, 250, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/program/C.jpg"))); // NOI18N
        jPanel1.add(jLabel1);
        jLabel1.setBounds(0, 0, 631, 467);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 633, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 466, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKonfirmasiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKonfirmasiActionPerformed
        // TODO add your handling code here:
        try {
            if (txtNoRek.getText().equals("") || txtNamaRek.getText().equals("") || txtTglTransfer.getText().equals("") || txtJumlah.getText().equals("")) {
                JOptionPane.showMessageDialog(rootPane, "Data Tidak Boleh Kosong", "Pesan", JOptionPane.ERROR_MESSAGE);
                txtNoRek.requestFocus();
                HapusLayar();
            } else {
                st = con.createStatement();
                String sql = ("SELECT * FROM transaksi WHERE NomorRekening  ='" + txtNoRek.getText()+ "'AND NamaRekening ='" + txtNamaRek.getText() + "'AND TanggalTransfer ='" + txtTglTransfer.getText()+"'AND Jumlah ='" + txtJumlah.getText()  +"' ");
                ResultSet rs = st.executeQuery(sql);
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "Transaksi Lunas");
                   
                } else {
                    JOptionPane.showMessageDialog(rootPane, "Nomor Rekening Salah Atau Belum Transfer", "Pesan", JOptionPane.ERROR_MESSAGE);
                    HapusLayar();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }//GEN-LAST:event_btnKonfirmasiActionPerformed

    private void btnExitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExitActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new DashboardUser(null, true).setVisible(true);
    }//GEN-LAST:event_btnExitActionPerformed

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
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Transaksi.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Transaksi dialog = new Transaksi(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btnExit;
    private javax.swing.JButton btnKonfirmasi;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField txtJumlah;
    private javax.swing.JTextField txtNamaRek;
    private javax.swing.JTextField txtNoRek;
    private javax.swing.JTextField txtTglTransfer;
    // End of variables declaration//GEN-END:variables
}
