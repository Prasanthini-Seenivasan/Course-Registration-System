/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javax.swing;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author SV TECHNOZONE
 */
public class Payment extends javax.swing.JFrame {
Connection conn=null;
ResultSet RS=null;
PreparedStatement PST=null;
Statement stmt = null;

    /**
     * Creates new form Payment
     */
    public Payment() {
        initComponents();
        conn=MysqlConnect.ConnecrDb();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        student = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        mob = new javax.swing.JTextField();
        course = new javax.swing.JComboBox<>();
        payment = new javax.swing.JComboBox<>();
        amount = new javax.swing.JLabel();
        pay = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();

        jLabel7.setText("jLabel7");

        jLabel8.setText("jLabel8");

        jLabel9.setText("jLabel9");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Bradley Hand ITC", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 0, 204));
        jLabel1.setText("PAYMENT");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(150, 40, 100, 24);

        jLabel2.setBackground(new java.awt.Color(0, 0, 0));
        jLabel2.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(153, 0, 153));
        jLabel2.setText("Student Name :");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(30, 103, 130, 18);

        jLabel3.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(153, 0, 153));
        jLabel3.setText("Course Name :");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(30, 180, 120, 18);

        jLabel4.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(153, 0, 153));
        jLabel4.setText("Mode of payment:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(20, 220, 130, 18);
        jPanel1.add(student);
        student.setBounds(173, 100, 144, 30);

        jLabel5.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(153, 0, 153));
        jLabel5.setText("Mobile Number :");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(31, 141, 120, 18);
        jPanel1.add(mob);
        mob.setBounds(173, 138, 144, 30);

        course.setFont(new java.awt.Font("Bradley Hand ITC", 1, 12)); // NOI18N
        course.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "JAVA Full Pack", "VB.Net", "Oracle", "PHP" }));
        course.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                courseActionPerformed(evt);
            }
        });
        jPanel1.add(course);
        course.setBounds(170, 180, 150, 22);

        payment.setFont(new java.awt.Font("Bradley Hand ITC", 1, 12)); // NOI18N
        payment.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Card", "Cheque", "Paytm" }));
        jPanel1.add(payment);
        payment.setBounds(170, 220, 150, 22);

        amount.setText("10000");
        jPanel1.add(amount);
        amount.setBounds(170, 260, 150, 20);

        pay.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        pay.setText("Pay");
        pay.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                payActionPerformed(evt);
            }
        });
        jPanel1.add(pay);
        pay.setBounds(100, 310, 60, 27);

        cancel.setFont(new java.awt.Font("Bradley Hand ITC", 1, 14)); // NOI18N
        cancel.setText("Cancel");
        jPanel1.add(cancel);
        cancel.setBounds(200, 310, 80, 27);

        jLabel6.setIcon(new javax.swing.ImageIcon("F:\\CT Project\\Images\\payment.png")); // NOI18N
        jLabel6.setText("jLabel6");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(0, 0, 400, 350);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void payActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_payActionPerformed
        // TODO add your handling code here:
        try{
            Statement st = conn.createStatement();
            String stud=student.getText();
            String mobile=mob.getText();
            String cout = (String)course.getSelectedItem();
            String paym = (String)payment.getSelectedItem();
            int a=Integer.parseInt(amount.getText());
            
            st.executeUpdate("INSERT INTO admin VALUES('"+stud+"','"+mobile+"','"+cout+"','"+paym+"','"+a+"')");
            String sql="SELECT * FROM amount";
            PST=conn.prepareStatement(sql);
   
            RS=PST.executeQuery();
            int aa=Integer.parseInt(RS.getString("total_amount"));
            int aaa=aa+a;
            st.executeUpdate("INSERT INTO amount VALUES('"+aaa+"')");
            if(RS.next()){
            if(cout == "JAVA Full Pack"){
                String sqlq="SELECT java FROM count";
            PST=conn.prepareStatement(sqlq);
   
            RS=PST.executeQuery();
            int java=Integer.parseInt(RS.getString("java"));
            int javainc=java+1;
            st.executeUpdate("UPDATE count SET java='"+javainc+"'");
            }
            if(cout == "VB.Net"){
                String sqlw="SELECT vb FROM count";
            PST=conn.prepareStatement(sqlw);
   
            RS=PST.executeQuery();
            int vb=Integer.parseInt(RS.getString("vb"));
            int vbinc=vb+1;
            st.executeUpdate("UPDATE count SET vb='"+vbinc+"'");
            }
            if(cout == "Oracle"){
                String sqle="SELECT oracle FROM count";
            PST=conn.prepareStatement(sqle);
   
            RS=PST.executeQuery();
            int orac=Integer.parseInt(RS.getString("oracle"));
            int oracinc=orac+1;
            st.executeUpdate("UPDATE count SET oracle='"+oracinc+"'");
            }
            if(cout == "PHP"){
                String sqlr="SELECT php FROM count";
            PST=conn.prepareStatement(sqlr);
   
            RS=PST.executeQuery();
            int php=Integer.parseInt(RS.getString("php"));
            int phpinc=php+1;
            st.executeUpdate("UPDATE count SET php='"+phpinc+"'");
            }}
            JOptionPane.showMessageDialog(null,"Payment Sucessfull");
            /*String cour=course.getText();
            String paym=payment.getText();
            JAVA Full Pack
VB.Net
Oracle
PHP*/
            
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        
        
    }//GEN-LAST:event_payActionPerformed

    private void courseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_courseActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_courseActionPerformed

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
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Payment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Payment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel amount;
    private javax.swing.JButton cancel;
    private javax.swing.JComboBox<String> course;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTextField mob;
    private javax.swing.JButton pay;
    private javax.swing.JComboBox<String> payment;
    private javax.swing.JTextField student;
    // End of variables declaration//GEN-END:variables
}
