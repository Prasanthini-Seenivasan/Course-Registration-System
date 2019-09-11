package javax.swing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
public class JavaPay extends javax.swing.JFrame {
Connection conn=null;
ResultSet RS=null;
PreparedStatement PST=null;
Statement stmt = null;

    
    public JavaPay() {
        initComponents();
        conn=MysqlConnect.ConnecrDb();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        student = new javax.swing.JTextField();
        mob = new javax.swing.JTextField();
        payment = new javax.swing.JComboBox<>();
        pay = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);
        getContentPane().add(student);
        student.setBounds(170, 110, 144, 30);

        mob.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mobActionPerformed(evt);
            }
        });
        getContentPane().add(mob);
        mob.setBounds(170, 170, 144, 30);

        payment.setFont(new java.awt.Font("Bradley Hand ITC", 1, 12)); // NOI18N
        payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Card", "Cheque", "Paytm" }));
        payment.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                paymentActionPerformed(evt);
            }
        });
        getContentPane().add(payment);
        payment.setBounds(180, 240, 144, 22);

        pay.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        pay.setText("Pay");
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });
        getContentPane().add(pay);
        pay.setBounds(101, 320, 60, 27);

        cancel.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        cancel.setText("Cancel");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        getContentPane().add(cancel);
        cancel.setBounds(190, 320, 80, 27);

        jLabel1.setFont(new java.awt.Font("Bradley Hand ITC", 1, 18)); // NOI18N
        jLabel1.setText("JAVA PAYMENT");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(120, 40, 153, 24);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 0, 51));
        jLabel2.setText("Student Name :");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(31, 111, 130, 18);

        jLabel5.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(204, 0, 51));
        jLabel5.setText("Mobile Number :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(31, 173, 120, 18);

        jLabel4.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(204, 0, 51));
        jLabel4.setText("Mode of payment:");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(31, 238, 130, 18);

        jLabel3.setIcon(new javax.swing.ImageIcon("F:\\CT Project\\Images\\payment.png")); // NOI18N
        jLabel3.setText("jLabel3");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 400, 380);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        // TODO add your handling code here:
        try{
            Statement st = conn.createStatement();
            String stud=student.getText();
            String mobile=mob.getText();
            String paym = (String)payment.getSelectedItem();
            
            String sqlq="SELECT mobile FROM signup WHERE username='"+stud+"' and mobile='"+mobile+"'";
            PST=conn.prepareStatement(sqlq);
            RS=PST.executeQuery();
            RS.beforeFirst();
            if(RS.next()){
            st.executeUpdate("INSERT INTO admin VALUES('"+stud+"','"+mobile+"','JAVA','"+paym+"','12,000')");
            String sql="SELECT * FROM amount";
            PST=conn.prepareStatement(sql);

            RS=PST.executeQuery();
            RS.beforeFirst();
            while(RS.next()){
            int newAmount =Integer.parseInt(RS.getString("total_amount"))+12000;
            st.executeUpdate("UPDATE amount SET total_amount='"+newAmount+"'");
                
            }
            String sqll="SELECT java FROM count";
            PST=conn.prepareStatement(sqll);
            RS=PST.executeQuery();
            RS.beforeFirst();
            while(RS.next()){
            int newCount = Integer.parseInt(RS.getString("java"))+1;
            st.executeUpdate("UPDATE count SET java='"+newCount+"'");
            }
            
            JOptionPane.showMessageDialog(null,"Payment Sucessfull");
            
        Final h=new Final();
        h.setVisible(true);
        JavaPay p=new JavaPay();
        p.setVisible(false);
        dispose();
            
                /*String cour=course.getText();
                String paym=payment.getText();
                JAVA Full Pack
                VB.Net
                Oracle
                PHP*/

            }else{
                 JOptionPane.showMessageDialog(null,"Sorry Mobile number is WRONG!!");
            }}
            catch(Exception e){
                JOptionPane.showMessageDialog(null,e);
            }

    }//GEN-LAST:event_payActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        Home h=new Home();
        h.setVisible(true);
        JavaPay p=new JavaPay();
        p.setVisible(false);
        dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void mobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mobActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_mobActionPerformed

    private void paymentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_paymentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_paymentActionPerformed

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
            java.util.logging.Logger.getLogger(JavaPay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JavaPay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JavaPay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JavaPay.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JavaPay().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField mob;
    private javax.swing.JButton pay;
    private javax.swing.JComboBox<String> payment;
    private javax.swing.JTextField student;
    // End of variables declaration//GEN-END:variables
}
