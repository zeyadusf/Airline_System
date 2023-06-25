/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package gui;

import java.awt.Component;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author hp
 */
public class info extends javax.swing.JFrame {

    DefaultTableModel dtm,dtm2;
    Connection con ;
    Component frame;

    /**
     * Creates new form info
     */
    public info() {
        initComponents();
        this.setLocationRelativeTo(null);
        try {
            con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/airline", "root", "root");
        } catch (SQLException ex) {
            Logger.getLogger(info.class.getName()).log(Level.SEVERE, null, ex);
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        t_info = new javax.swing.JTable();
        btn_search = new javax.swing.JButton();
        tf_landing = new javax.swing.JTextField();
        tf_takeoff = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btn_showAll = new javax.swing.JButton();
        btn_back = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        t_info.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(t_info);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 710, 200));

        btn_search.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_search.setText("Search");
        btn_search.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_searchActionPerformed(evt);
            }
        });
        jPanel1.add(btn_search, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 200, 110, 30));

        tf_landing.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_landingActionPerformed(evt);
            }
        });
        jPanel1.add(tf_landing, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 150, 130, 30));
        jPanel1.add(tf_takeoff, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 90, 130, 30));

        jLabel2.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel2.setText("Landing");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, 80, -1));

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Verdana", 0, 18)); // NOI18N
        jLabel3.setText("TakeOff");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 80, -1));

        btn_showAll.setFont(new java.awt.Font("Verdana", 1, 14)); // NOI18N
        btn_showAll.setText("Show ");
        btn_showAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_showAllActionPerformed(evt);
            }
        });
        jPanel1.add(btn_showAll, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 240, 110, 30));

        btn_back.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/src/images/return-on-investment.png"))); // NOI18N
        btn_back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_backActionPerformed(evt);
            }
        });
        jPanel1.add(btn_back, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 10, -1, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/GUI/src/images/infoCloud.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 750, 530));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_searchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_searchActionPerformed
        // TODO add your handling code here
        if(!tf_takeoff.getText().isEmpty()&&!tf_landing.getText().isEmpty()){
  
      
          
        try {
            dtm=new DefaultTableModel();
            dtm.addColumn("TakeOff");
            dtm.addColumn("Landing");
            dtm.addColumn("Flight Count");
            dtm.addColumn("Seats Count");

            PreparedStatement stat1 = con.prepareStatement("SELECT fl_takeoff ,fl_landing,count(*),sum(fl_seats)  from   flights  WHERE fl_takeoff = '"+tf_takeoff.getText()+"' AND fl_landing ='"+tf_landing.getText()+"';");
            ResultSet rs = stat1.executeQuery(); 
            while(rs.next())
            {
                dtm.addRow(new Object[]{rs.getString(1),rs.getString(2),rs.getInt(3),rs.getInt(4)});
            }
             t_info.setModel(dtm);
            
        } catch (SQLException ex) {
            Logger.getLogger(info.class.getName()).log(Level.SEVERE, null, ex);
        }
        }else{
                JOptionPane.showMessageDialog(frame,
      " Check TakeOff And Landing ",
     "Failed",
      JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_searchActionPerformed

    private void tf_landingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_landingActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_landingActionPerformed

    
    private void btn_showAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_showAllActionPerformed
        // TODO add your handling code here
        try {
        dtm2=new DefaultTableModel();
        dtm2.addColumn("Flight Count");
        dtm2.addColumn("Seats Count");
        dtm2.addColumn("Sold out Tickets ");
        dtm2.addColumn("Unsold Tickets ");
        dtm2.addColumn("Number OF Passengers");
        int Fl_seats=0,Fl_count=0,SoutTicket=0,passenger=0;
       PreparedStatement stat1 =con.prepareStatement("SELECT count(*),sum(fl_seats)  from   flights  ;");
       ResultSet rs1 = stat1.executeQuery();
            while (rs1.next()) {                
                 Fl_count=rs1.getInt(1);
                 Fl_seats=rs1.getInt(2);
            }
        
       PreparedStatement stat2 =con.prepareStatement("select count(*) from tickets ;");
        ResultSet rs2 =stat2.executeQuery();
         while(rs2.next())
         {
             SoutTicket = rs2.getInt(1);
         }
        PreparedStatement stat3 =con.prepareStatement("select count(*) from passengers;");
        ResultSet rs3=stat3.executeQuery();
        while(rs3.next())
        {
            passenger=rs3.getInt(1);
        }
        int Unsold = Fl_seats-SoutTicket;
        
             
        
     //  PreparedStatement stat3 =con.prepareStatement("SELECT SUM(ticket_price) FROM tickets;");
       // ResultSet rs3=stat3.executeQuery();
        //while(rs3.next()){
          //   totalPrice=rs3.getInt(1);

        //}
        dtm2.addRow(new Object[]{Fl_count,Fl_seats,SoutTicket,Unsold,passenger});
        t_info.setModel(dtm2);
            

        } catch (SQLException ex) {
            Logger.getLogger(info.class.getName()).log(Level.SEVERE, null, ex);
        }
        

        
    }//GEN-LAST:event_btn_showAllActionPerformed

    private void btn_backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_backActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new mainWindow().setVisible(true);
    }//GEN-LAST:event_btn_backActionPerformed

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
            java.util.logging.Logger.getLogger(info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(info.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new info().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_back;
    private javax.swing.JButton btn_search;
    private javax.swing.JButton btn_showAll;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable t_info;
    private javax.swing.JTextField tf_landing;
    private javax.swing.JTextField tf_takeoff;
    // End of variables declaration//GEN-END:variables
}