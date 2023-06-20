
package egyptian.league;

import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;

public class Matches extends javax.swing.JFrame {

    private Connection mycon = null;
    private Statement mystat = null;
    private ResultSet myres = null;
    private DefaultTableModel model;
    
    public void selectional(){
        try {
            mycon = DriverManager.getConnection("jdbc:derby://localhost:1527/Egyption league", "team", "123456");
            mystat = mycon.createStatement();
            myres = mystat.executeQuery("Select * from TEAM.MATCHES");
            MyTable.setModel(DbUtils.resultSetToTableModel(myres));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    public void refreshTable(){
    
        try{
            String query = "Select * from TEAM.MATCHES ";
            PreparedStatement pst = mycon.prepareStatement(query);
            myres = pst.executeQuery();
            //pst.setString(1, Key2Txt.getText());
            //pst.setString(1, String.valueOf(IDTxt.getText()));
            myres = pst.executeQuery();
            MyTable.setModel(DbUtils.resultSetToTableModel(myres));
            pst.close();
            myres.close();
        } catch(SQLException ex){
           ex.printStackTrace();
        }
    }
    
    public Matches() {
        initComponents();
        setLocation(400, 300);

        //displayinfo();
        selectional();
        SetRecordToTable();
    }
    public void SetRecordToTable(){
       try{mycon = DriverManager.getConnection("jdbc:derby://localhost:1527/Egyption league", "team", "123456");
        PreparedStatement pst = mycon.prepareStatement("Select * from TEAM.MATCHES");
        ResultSet res = pst.executeQuery();
        while(res.next()){
            String ID = res.getString("ID");
            String DATE = res.getString("DATE");
            String TEAM1 = res.getString("TEAM1");
            String TEAM2 = res.getString("TEAM2");
            String REFEREE = res.getString("REFEREE");
            String SCORE = res.getString("SCORE");
            String STADUIM_NAME = res.getString("STADUIM_NAME");
            
            Object[] obj = { ID, DATE, TEAM1, TEAM2, REFEREE, SCORE, STADUIM_NAME};
            model = (DefaultTableModel) MyTable.getModel();
            model.addRow(obj);
        }
        
        
        
       } catch(SQLException ex){
          ex.printStackTrace();
       }
    
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IDtxt = new javax.swing.JTextField();
        DATETxt = new javax.swing.JTextField();
        TEAM1Txt = new javax.swing.JTextField();
        TEAM2Txt = new javax.swing.JTextField();
        REFEREETxt = new javax.swing.JTextField();
        SCORETxt = new javax.swing.JTextField();
        STADUIMNAMETxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        backBTN = new javax.swing.JButton();
        key1txt = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        MyTable = new javax.swing.JTable();
        jToggleButton1 = new javax.swing.JToggleButton();
        dateSelectBtn = new com.toedter.calendar.JDateChooser();
        jButton4 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        IDtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                IDtxtActionPerformed(evt);
            }
        });

        DATETxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DATETxtActionPerformed(evt);
            }
        });

        SCORETxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SCORETxtActionPerformed(evt);
            }
        });

        jLabel1.setText("ID");

        jLabel2.setText("Date ");

        jLabel3.setText("First team");

        jLabel4.setText("Second team");

        jLabel5.setText("Reefere");

        jLabel6.setText("Score");

        jLabel7.setText("Stadium Name");

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        backBTN.setText("BACK");
        backBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBTNActionPerformed(evt);
            }
        });

        key1txt.setForeground(new java.awt.Color(153, 153, 153));
        key1txt.setText("Search by Date");
        key1txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                key1txtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                key1txtFocusLost(evt);
            }
        });
        key1txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                key1txtActionPerformed(evt);
            }
        });
        key1txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                key1txtKeyReleased(evt);
            }
        });

        MyTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "ID", "DATE", "TEAM1", "TEAM2", "REFEREE", "SCORE", "STADUIM_NAME"
            }
        ));
        jScrollPane2.setViewportView(MyTable);

        jToggleButton1.setText("Display");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        dateSelectBtn.setDateFormatString("yyyy-M-d");

        jButton4.setText("Select");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(backBTN)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(157, 157, 157)
                                .addComponent(jButton1)
                                .addGap(86, 86, 86)
                                .addComponent(jButton2)
                                .addGap(76, 76, 76)
                                .addComponent(jButton3)
                                .addGap(57, 57, 57)
                                .addComponent(jToggleButton1))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 668, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(48, 48, 48)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(8, 8, 8)
                                .addComponent(dateSelectBtn, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE))
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(IDtxt)
                            .addComponent(TEAM1Txt, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(DATETxt, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 109, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(TEAM2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(REFEREETxt, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(SCORETxt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(STADUIMNAMETxt, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(263, 263, 263)
                .addComponent(key1txt, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(42, 42, 42)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(DATETxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jButton4))
                            .addComponent(jLabel2)
                            .addComponent(dateSelectBtn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(TEAM1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(jLabel4))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(TEAM2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(24, 24, 24)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(REFEREETxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(key1txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(8, 8, 8)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton1)
                            .addComponent(jButton2)
                            .addComponent(jButton3)
                            .addComponent(jToggleButton1))
                        .addGap(18, 18, 18)
                        .addComponent(backBTN))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(SCORETxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(STADUIMNAMETxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))))
                .addContainerGap(64, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SCORETxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SCORETxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_SCORETxtActionPerformed

    private void IDtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_IDtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_IDtxtActionPerformed

    private void DATETxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DATETxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DATETxtActionPerformed

    private void backBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBTNActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MainMenu().setVisible(true);
    }//GEN-LAST:event_backBTNActionPerformed

    //add button
    
    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        //insert();
        
        try{
            String ID = IDtxt.getText();
            String date = DATETxt.getText();
            String team1 = TEAM1Txt.getText();
            String team2 = TEAM2Txt.getText();
            String referee = REFEREETxt.getText();
            String SCORE = SCORETxt.getText();
            String staduim_name = STADUIMNAMETxt.getText();
            PreparedStatement add = mycon.prepareStatement("insert Into TEAM.MATCHES values (?,?,?,?,?,?,?)");
            add.setString(1, ID);
            add.setString(2, date);
            add.setString(3, team1);
            add.setString(4, team2);
            add.setString(5, referee);
            add.setString(6, SCORE);
            add.setString(7, staduim_name);
            int row = add.executeUpdate();
            
            
        } catch(SQLException ex){
           ex.printStackTrace();
        }
        selectional();
        refreshTable();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    //update button
    
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        //update();
        String query ;
        
        
        try
      { 
         String sql = "UPDATE TEAM.MATCHES SET DATE=?, TEAM1=?, TEAM2=?, REFEREE=?, SCORE=?, STADUIM_NAME = ? WHERE ID =?";
        
         PreparedStatement ps = mycon.prepareStatement(sql);
         ps.setString(1,DATETxt.getText());
         ps.setString(2,TEAM1Txt.getText());
         ps.setString(3,TEAM2Txt.getText());
         ps.setString(4, REFEREETxt.getText());
         ps.setInt(5,Integer.parseInt(SCORETxt.getText()));
         ps.setString(6, STADUIMNAMETxt.getText());
         ps.setInt(7,Integer.parseInt(IDtxt.getText()));

         int i=0;
         i = ps.executeUpdate();
         if(i>0)
             {
         //do   something   
             }
     }
     catch(SQLException e)
      {

      e.printStackTrace();
      }
        selectional();
        refreshTable();
        
    }//GEN-LAST:event_jButton2ActionPerformed

    //delete button
    
    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        try {
        String query = "Delete from TEAM.MATCHES where ID ="+IDtxt.getText();
        Statement add = mycon.createStatement();
        add.executeUpdate(query);
        IDtxt.setText("");
        DATETxt.setText("");
        TEAM1Txt.setText("");
        TEAM2Txt.setText("");
        REFEREETxt.setText("");
        SCORETxt.setText("");
        STADUIMNAMETxt.setText("");
         } catch (SQLException ex) {
            // Logger.getLogger(add_uodate_delete.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
        selectional();
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void key1txtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_key1txtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_key1txtActionPerformed

    private void key1txtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_key1txtFocusLost
        if(key1txt.getText().equals("")){
                key1txt.setText("Search by Date");
                key1txt.setForeground(new Color(153,153,153));
            
            }
    }//GEN-LAST:event_key1txtFocusLost

    private void key1txtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_key1txtFocusGained
        if(key1txt.getText().equals("Search by Date")){
                key1txt.setText("");
                key1txt.setForeground(new Color(153,153,153));
            
            }
    }//GEN-LAST:event_key1txtFocusGained

    private void key1txtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_key1txtKeyReleased
        // TODO add your handling code here:
         try{
            String query = "Select * from TEAM.MATCHES where DATE=?";
            PreparedStatement pst = mycon.prepareStatement(query);
            pst.setString(1, key1txt.getText());
            //pst.setString(1, String.valueOf(IDTxt.getText()));
            myres = pst.executeQuery();
            MyTable.setModel(DbUtils.resultSetToTableModel(myres));
            pst.close();
        } catch(SQLException ex){
           ex.printStackTrace();
        }
    }//GEN-LAST:event_key1txtKeyReleased

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        String sql = "Select * From TEAM.MATCHES";
        try{
           PreparedStatement pst = mycon.prepareStatement(sql);
           myres = pst.executeQuery();
           DefaultTableModel model = (DefaultTableModel) MyTable.getModel();
           model.setRowCount(0);
           while(myres.next()){
                model.addRow(new String[] {myres.getString(1),myres.getString(2), myres.getString(3), myres.getString(4), myres.getString(5), myres.getString(6), myres.getString(7)});
           }
        
        } catch(SQLException ex){
           ex.printStackTrace();
        }
        
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        String selectdate = ((JTextField)dateSelectBtn.getDateEditor().getUiComponent()).getText();
        DATETxt.setText(selectdate);
    }//GEN-LAST:event_jButton4ActionPerformed

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
            java.util.logging.Logger.getLogger(Matches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Matches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Matches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Matches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Matches().setVisible(true);
            }
        });
    }
    
    
    /*Connection con = null;
    Statement stat = null;
    ResultSet res = null;
    //DefaultTableModel model;
    
    public void displayinfo(){
        try {
            con = DriverManager.getConnection("jdbc:derby://localhost:1527/Egyption league", "team", "123456");
            stat = con.createStatement();
            res = stat.executeQuery("Select * from TEAM.MATCHES");
            MyTable.setModel(DbUtils.resultSetToTableModel(res));
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
    
    public void insert(){
        
        String query = "INSERT INTO TEAM.MATCHES (ID, \"DATE\", TEAM1, TEAM2, REFEREE, SCORE, STADIUM_NAME) \n" +
"	VALUES (?, ?, ?, ?, ?, ?, ?)";
        try{
        PreparedStatement p = con.prepareStatement(query);
        
        p.setString(1, IDtxt.getText());
        p.setString(2, DATETxt.getText());
        p.setString(3, TEAM1Txt.getText());
        p.setString(4, TEAM2Txt.getText());
        p.setString(5, REFEREETxt.getText());
        p.setString(6, SCORETxt.getText());
        p.setString(7, STADUIMNAMETxt.getText());
        
       int row = p.executeUpdate();
       clear();
        
        }      catch(SQLException e){
            System.err.println("err add");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "can not add this primery key . it is used!");
        }   
                displayinfo();
        
    }
    private void clear(){
        IDtxt.setText("");
        TEAM1Txt.setText("");
        TEAM2Txt.setText("");
        DATETxt.setText("");
        REFEREETxt.setText("");
        SCORETxt.setText("");
        STADUIMNAMETxt.setText("");
    }
    
    private void del(){
        try {
        String query = "Delete from TEAM.MATCHES where ID ="+IDtxt.getText();
        Statement add = mycon.createStatement();
        add.executeUpdate(query);
        IDtxt.setText("");
        DATETxt.setText("");
        TEAM1Txt.setText("");
        TEAM2Txt.setText("");
        REFEREETxt.setText("");
        SCORETxt.setText("");
        STADUIMNAMETxt.setText("");
         } catch (SQLException ex) {
            // Logger.getLogger(add_uodate_delete.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
        selectional();
    }
    
    public void update(){
        String query = "update MATCHES SET SCORE = (?) where ID = ?\n" +
"" ;
                try{
        PreparedStatement p = con.prepareStatement(query);
        

        p.setString(1, SCORETxt.getText());
        p.setString(2, IDtxt.getText());

       int row = p.executeUpdate();
       clear();
        
        }      catch(SQLException e){
            System.err.println("err update");
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "please update score only");
        }   
        
                displayinfo();
        
    }*/
    
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField DATETxt;
    public static javax.swing.JTextField IDtxt;
    public javax.swing.JTable MyTable;
    public static javax.swing.JTextField REFEREETxt;
    public static javax.swing.JTextField SCORETxt;
    public static javax.swing.JTextField STADUIMNAMETxt;
    public static javax.swing.JTextField TEAM1Txt;
    public static javax.swing.JTextField TEAM2Txt;
    private javax.swing.JButton backBTN;
    private com.toedter.calendar.JDateChooser dateSelectBtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JTextField key1txt;
    // End of variables declaration//GEN-END:variables
}
