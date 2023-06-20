package egyptian.league ;

import com.sun.imageio.plugins.png.RowFilter;
import java.awt.Color;
import java.awt.event.InputEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import net.proteanit.sql.DbUtils;

public class Teams extends javax.swing.JFrame {
    private Connection mycon = null;
    private Statement mystat = null;
    private ResultSet myres = null;
    private ResultSet myres2 = null;
    private DefaultTableModel model;
    
    public Teams() {
        initComponents();
        setLocation(400, 300);
        selectional();
        SetRecordToTable();
    }
    
    public void display_by_points(){
        
        by_point = new JMenuItem("by points",'p');
        by_point.setAccelerator(KeyStroke.getKeyStroke('P' ,InputEvent.CTRL_DOWN_MASK));
        try{ 
        myres = mystat.executeQuery("Select * from TEAM.TEAM ORDER by points desc");
            Mytable.setModel(DbUtils.resultSetToTableModel(myres));
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("error in points");
        }
    }
    
    public void display_by_goals(){
        
        by_goals = new JMenuItem("by goals",'g');
        by_goals.setAccelerator(KeyStroke.getKeyStroke('G' ,InputEvent.CTRL_DOWN_MASK));
        try{ 
        myres = mystat.executeQuery("Select * from TEAM.TEAM ORDER by TOTAL_SCORE desc");
            Mytable.setModel(DbUtils.resultSetToTableModel(myres));
        
        } catch (SQLException ex) {
            ex.printStackTrace();
            System.err.println("error in goals");
        }
    }
    
    
    public void selectional(){
        try {
            mycon = DriverManager.getConnection("jdbc:derby://localhost:1527/Egyption league", "team", "123456");
            mystat = mycon.createStatement();
            myres = mystat.executeQuery("Select * from TEAM.TEAM");
            Mytable.setModel(DbUtils.resultSetToTableModel(myres));
        
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    
    }
    public void refreshTable(){
    
        try{
            String query = "Select * from TEAM.TEAM ";
            PreparedStatement pst = mycon.prepareStatement(query);
            myres = pst.executeQuery();
            //pst.setString(1, Key2Txt.getText());
            //pst.setString(1, String.valueOf(IDTxt.getText()));
            myres = pst.executeQuery();
            Mytable.setModel(DbUtils.resultSetToTableModel(myres));
            pst.close();
            myres.close();
        } catch(SQLException ex){
           ex.printStackTrace();
        }
    }
    public void SetRecordToTable(){
       try{mycon = DriverManager.getConnection("jdbc:derby://localhost:1527/Egyption league", "team", "123456");
        PreparedStatement pst = mycon.prepareStatement("Select * from TEAM.TEAM");
        ResultSet res = pst.executeQuery();
        while(res.next()){
            String name = res.getString("T_NMAE");
            String ID = res.getString("ID");
            String PLAYERS = res.getString("PLAYERS");
            String CAPTIAN = res.getString("CAPTIAN");
            String MATCHES = res.getString("MATCHES");
            String TOTAL_SCORE = res.getString("TOTAL_SCORE");
            
            Object[] obj = {name, ID, PLAYERS, CAPTIAN, MATCHES, TOTAL_SCORE};
            model = (DefaultTableModel) Mytable.getModel();
            model.addRow(obj);
        }
        
        
        
       } catch(SQLException ex){
          ex.printStackTrace();
       }
    
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        Mytable = new javax.swing.JTable();
        T_NAMETxt = new javax.swing.JTextField();
        IDTxt = new javax.swing.JTextField();
        PLAYERSTxt = new javax.swing.JTextField();
        CAPTIANTxt = new javax.swing.JTextField();
        MATCHESTxt = new javax.swing.JTextField();
        TOTAL_SCORETxt = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        Key1Txt = new javax.swing.JTextField();
        Key2Txt = new javax.swing.JTextField();
        backBTN = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        pointstxt = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        Key1Txt1 = new javax.swing.JTextField();
        Key1Txt3 = new javax.swing.JTextField();
        jMenuBar2 = new javax.swing.JMenuBar();
        displaymenu = new javax.swing.JMenu();
        by_point = new javax.swing.JMenuItem();
        by_goals = new javax.swing.JMenuItem();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        jMenu1.setText("File");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Edit");
        jMenuBar1.add(jMenu2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Add");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Display");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Update");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Mytable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null}
            },
            new String [] {
                "T_NAME", "ID", "PLAYERS", "CAPTIAN", "MATCHES", "TOTAL_SCORE", "Points"
            }
        ));
        jScrollPane2.setViewportView(Mytable);
        if (Mytable.getColumnModel().getColumnCount() > 0) {
            Mytable.getColumnModel().getColumn(0).setResizable(false);
            Mytable.getColumnModel().getColumn(0).setHeaderValue("T_NAME");
            Mytable.getColumnModel().getColumn(1).setResizable(false);
            Mytable.getColumnModel().getColumn(1).setHeaderValue("ID");
            Mytable.getColumnModel().getColumn(2).setResizable(false);
            Mytable.getColumnModel().getColumn(2).setHeaderValue("PLAYERS");
            Mytable.getColumnModel().getColumn(3).setResizable(false);
            Mytable.getColumnModel().getColumn(3).setHeaderValue("CAPTIAN");
            Mytable.getColumnModel().getColumn(4).setResizable(false);
            Mytable.getColumnModel().getColumn(4).setHeaderValue("MATCHES");
            Mytable.getColumnModel().getColumn(5).setHeaderValue("TOTAL_SCORE");
            Mytable.getColumnModel().getColumn(6).setResizable(false);
            Mytable.getColumnModel().getColumn(6).setHeaderValue("Points");
        }

        T_NAMETxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                T_NAMETxtActionPerformed(evt);
            }
        });

        jLabel1.setText("T_NAME");

        jLabel2.setText("ID");

        jLabel3.setText("PLAYERS");

        jLabel4.setText("CAPTIAN");

        jLabel5.setText("MATCHES");

        jLabel6.setText("TOTAL_SCORE");

        Key1Txt.setForeground(new java.awt.Color(153, 153, 153));
        Key1Txt.setText("Search by Team Name");
        Key1Txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Key1TxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Key1TxtFocusLost(evt);
            }
        });
        Key1Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Key1TxtActionPerformed(evt);
            }
        });
        Key1Txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Key1TxtKeyReleased(evt);
            }
        });

        Key2Txt.setForeground(new java.awt.Color(153, 153, 153));
        Key2Txt.setText("Search by ID");
        Key2Txt.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Key2TxtFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Key2TxtFocusLost(evt);
            }
        });
        Key2Txt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Key2TxtActionPerformed(evt);
            }
        });
        Key2Txt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Key2TxtKeyReleased(evt);
            }
        });

        backBTN.setText("BACK");
        backBTN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBTNActionPerformed(evt);
            }
        });

        jLabel7.setText("Points");

        jToggleButton1.setText("Delete");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        Key1Txt1.setForeground(new java.awt.Color(153, 153, 153));
        Key1Txt1.setText("Display Team Players By Team Name");
        Key1Txt1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Key1Txt1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Key1Txt1FocusLost(evt);
            }
        });
        Key1Txt1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Key1Txt1ActionPerformed(evt);
            }
        });
        Key1Txt1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Key1Txt1KeyReleased(evt);
            }
        });

        Key1Txt3.setForeground(new java.awt.Color(153, 153, 153));
        Key1Txt3.setText("Display Team Matches");
        Key1Txt3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                Key1Txt3FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                Key1Txt3FocusLost(evt);
            }
        });
        Key1Txt3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Key1Txt3ActionPerformed(evt);
            }
        });
        Key1Txt3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                Key1Txt3KeyReleased(evt);
            }
        });

        displaymenu.setText("Display");

        by_point.setText("by points");
        by_point.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                by_pointActionPerformed(evt);
            }
        });
        displaymenu.add(by_point);

        by_goals.setText("by goals");
        by_goals.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                by_goalsActionPerformed(evt);
            }
        });
        displaymenu.add(by_goals);

        jMenuBar2.add(displaymenu);

        setJMenuBar(jMenuBar2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(97, 97, 97)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Key1Txt1, javax.swing.GroupLayout.PREFERRED_SIZE, 254, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Key1Txt3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Key1Txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Key2Txt, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jButton3)
                                .addGap(34, 34, 34)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(32, 32, 32)
                                .addComponent(jToggleButton1)
                                .addGap(27, 27, 27)
                                .addComponent(jButton2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(backBTN)
                                .addGap(277, 277, 277))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jLabel5)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(T_NAMETxt, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(IDTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(PLAYERSTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(CAPTIANTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(MATCHESTxt, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(TOTAL_SCORETxt, javax.swing.GroupLayout.DEFAULT_SIZE, 132, Short.MAX_VALUE)
                    .addComponent(pointstxt))
                .addGap(61, 61, 61))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(T_NAMETxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(23, 23, 23)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(IDTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Key1Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Key1Txt1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Key2Txt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Key1Txt3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton3)
                            .addComponent(jButton1)
                            .addComponent(jToggleButton1)
                            .addComponent(jButton2))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(backBTN)
                        .addGap(34, 34, 34))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(PLAYERSTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CAPTIANTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(MATCHESTxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6)
                            .addComponent(TOTAL_SCORETxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pointstxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(134, 134, 134))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed

        String query;
        
        try
      { 
         String sql = "UPDATE TEAM.TEAM SET T_NAME=?, PLAYERS=?, CAPTIAN=?, MATCHES=?, TOTAL_SCORE=?, points = ? WHERE ID =?";
        
         PreparedStatement ps = mycon.prepareStatement(sql);
         ps.setString(1,T_NAMETxt.getText());
         ps.setInt(2,Integer.parseInt(PLAYERSTxt.getText()));
         ps.setString(3,CAPTIANTxt.getText());
         ps.setInt(4,Integer.parseInt(MATCHESTxt.getText()));
         ps.setInt(5,Integer.parseInt(TOTAL_SCORETxt.getText()));
         ps.setInt(6, Integer.parseInt(pointstxt.getText()));
         ps.setInt(7,Integer.parseInt(IDTxt.getText()));
         

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
      
        
        
        /*if (!IDTxt.getText().equals("")  && !MATCHESTxt.getText().equals("")){
            
            query = "UPDATE TEAM SET  MATCHES = ? WHERE ID  = ?";
            try {
                ps = mycon.prepareStatement(query);
                ps.setString(1, MATCHESTxt.getText());
                ps.setString(2, IDTxt.getText());
                int row = ps.executeUpdate();
                
            } catch (SQLException ex) {
               // Logger.getLogger(Teams.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("matches update err");
                ex.printStackTrace();
            }
            }
            else if (!IDTxt.getText().equals("")  && !TOTAL_SCORETxt.getText().equals("")){
                 
                 query = "UPDATE TEAM SET  TOTAL_SCORE = ? WHERE ID  = ?";
            try {
                ps = mycon.prepareStatement(query);
                ps.setString(1, TOTAL_SCORETxt.getText());
                ps.setString(2, IDTxt.getText());
                int row = ps.executeUpdate();
                
            } catch (SQLException ex) {
               // Logger.getLogger(Teams.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("score update err");
                ex.printStackTrace();
            }
                    
                    
               }
        
            else if (!IDTxt.getText().equals("")  && !pointstxt.getText().equals("")){
                
                query = "UPDATE TEAM SET  POINTS = ? WHERE ID  = ?";
            try {
                ps = mycon.prepareStatement(query);
                ps.setString(1, pointstxt.getText());
                ps.setString(2, IDTxt.getText());
                int row = ps.executeUpdate();
                
            } catch (SQLException ex) {
               // Logger.getLogger(Teams.class.getName()).log(Level.SEVERE, null, ex);
                System.err.println("points update err");
                ex.printStackTrace();
            }
                */
                
            
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        try{
            String T_NAME = T_NAMETxt.getText();
            String ID = IDTxt.getText();
            String PLAYERS = PLAYERSTxt.getText();
            String CAPTIAN = CAPTIANTxt.getText();
            String MATCHES = MATCHESTxt.getText();
            String TOTAL_SCORE = TOTAL_SCORETxt.getText();
            PreparedStatement add = mycon.prepareStatement("insert Into TEAM.TEAM values (?,?,?,?,?,?,?)");
            add.setString(1, T_NAME);
            add.setString(2, ID);
            add.setString(3, PLAYERS);
            add.setString(4, CAPTIAN);
            add.setString(5, MATCHES);
            add.setString(6, TOTAL_SCORE);
            add.setString(7, pointstxt.getText());
            int row = add.executeUpdate();
            
            
        } catch(SQLException ex){
           ex.printStackTrace();
        }
        selectional();
        refreshTable();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void T_NAMETxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_T_NAMETxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_T_NAMETxtActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        
        String sql = "Select * From TEAM.TEAM";
        try{
           PreparedStatement pst = mycon.prepareStatement(sql);
           myres = pst.executeQuery();
           DefaultTableModel model = (DefaultTableModel) Mytable.getModel();
           model.setRowCount(0);
           while(myres.next()){
                model.addRow(new String[] {myres.getString(1),myres.getString(2), myres.getString(3), myres.getString(4), myres.getString(5), myres.getString(6), myres.getString(7)});
           
           }
        
        } catch(SQLException ex){
           ex.printStackTrace();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    
    
    private void Key1TxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Key1TxtKeyReleased
        // TODO add your handling code here:
        
        try{
            String query = "Select * from TEAM.TEAM where T_NAME=?";
            PreparedStatement pst = mycon.prepareStatement(query);
            pst.setString(1, Key1Txt.getText());
            //pst.setString(1, String.valueOf(IDTxt.getText()));
            myres = pst.executeQuery();
            Mytable.setModel(DbUtils.resultSetToTableModel(myres));
            pst.close();
            
        } catch(SQLException ex){
           ex.printStackTrace();
        }
        
    }//GEN-LAST:event_Key1TxtKeyReleased

    private void Key1TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Key1TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Key1TxtActionPerformed

    private void Key1TxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Key1TxtFocusGained
        
        if(Key1Txt.getText().equals("Search by Team Name")){
                Key1Txt.setText("");
                Key1Txt.setForeground(new Color(153,153,153));
            
            }
    }//GEN-LAST:event_Key1TxtFocusGained

    private void Key1TxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Key1TxtFocusLost
        
        if(Key1Txt.getText().equals("")){
                Key1Txt.setText("Search by Team Name");
                Key1Txt.setForeground(new Color(153,153,153));
            
            }
    }//GEN-LAST:event_Key1TxtFocusLost

    private void Key2TxtFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Key2TxtFocusGained
        
        if(Key2Txt.getText().equals("Search by ID")){
                Key2Txt.setText("");
                Key2Txt.setForeground(new Color(153,153,153));
            
            }
    }//GEN-LAST:event_Key2TxtFocusGained

    private void Key2TxtFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Key2TxtFocusLost
        
        if(Key2Txt.getText().equals("")){
                Key2Txt.setText("Search by ID");
                Key2Txt.setForeground(new Color(153,153,153));
            
            }
    }//GEN-LAST:event_Key2TxtFocusLost

    private void Key2TxtKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Key2TxtKeyReleased
        try{
            String query = "Select * from TEAM.TEAM where ID=?";
            PreparedStatement pst = mycon.prepareStatement(query);
            
            pst.setString(1, Key2Txt.getText());
            //pst.setString(1, String.valueOf(IDTxt.getText()));
            myres = pst.executeQuery();
            Mytable.setModel(DbUtils.resultSetToTableModel(myres));
            pst.close();
        } catch(SQLException ex){
           ex.printStackTrace();
        }
    }//GEN-LAST:event_Key2TxtKeyReleased

    private void backBTNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBTNActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        new MainMenu().setVisible(true);
    }//GEN-LAST:event_backBTNActionPerformed

    private void by_pointActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_by_pointActionPerformed
        // TODO add your handling code here:
        display_by_points();
    }//GEN-LAST:event_by_pointActionPerformed

    private void by_goalsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_by_goalsActionPerformed
        // TODO add your handling code here:
        display_by_goals();
    }//GEN-LAST:event_by_goalsActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        // TODO add your handling code here:
        try {
        String query = "Delete from TEAM.TEAM where ID ="+IDTxt.getText();
        Statement add = mycon.createStatement();
        add.executeUpdate(query);
        T_NAMETxt.setText("");
        IDTxt.setText("");
        PLAYERSTxt.setText("");
        CAPTIANTxt.setText("");
        MATCHESTxt.setText("");
        TOTAL_SCORETxt.setText("");
        pointstxt.setText("");
         } catch (SQLException ex) {
            // Logger.getLogger(add_uodate_delete.class.getName()).log(Level.SEVERE, null, ex);
             ex.printStackTrace();
         }
        selectional();
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    private void Key1Txt1FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Key1Txt1FocusGained
        // TODO add your handling code here:
        if(Key1Txt1.getText().equals("Display Team Players By Team Name")){
                Key1Txt1.setText("");
                Key1Txt1.setForeground(new Color(153,153,153));
            
            }
    }//GEN-LAST:event_Key1Txt1FocusGained

    private void Key1Txt1FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Key1Txt1FocusLost
        // TODO add your handling code here:
        
        if(Key1Txt1.getText().equals("")){
                Key1Txt1.setText("Display Team Players By Team Name");
                Key1Txt1.setForeground(new Color(153,153,153));
            
            }
    }//GEN-LAST:event_Key1Txt1FocusLost

    private void Key1Txt1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Key1Txt1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Key1Txt1ActionPerformed

    private void Key1Txt1KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Key1Txt1KeyReleased

        try{
            String query = "Select * from TEAM.PLAYER where TEAM=?";
            PreparedStatement pst = mycon.prepareStatement(query);
            
            pst.setString(1, Key1Txt1.getText());
            //pst.setString(1, String.valueOf(IDTxt.getText()));
            myres = pst.executeQuery();
            Mytable.setModel(DbUtils.resultSetToTableModel(myres));
            pst.close();
        } catch(SQLException ex){
           ex.printStackTrace();
        }
        
        
    }//GEN-LAST:event_Key1Txt1KeyReleased

    private void Key2TxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Key2TxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Key2TxtActionPerformed

    private void Key1Txt3FocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Key1Txt3FocusGained
        // TODO add your handling code here:
        if(Key1Txt3.getText().equals("Display Team Matches")){
                Key1Txt3.setText("");
                Key1Txt3.setForeground(new Color(153,153,153));
            
            }
    }//GEN-LAST:event_Key1Txt3FocusGained

    private void Key1Txt3FocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_Key1Txt3FocusLost
        // TODO add your handling code here:
        if(Key1Txt3.getText().equals("")){
                Key1Txt3.setText("Display Team Matches");
                Key1Txt3.setForeground(new Color(153,153,153));
            
            }
    }//GEN-LAST:event_Key1Txt3FocusLost

    private void Key1Txt3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Key1Txt3ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_Key1Txt3ActionPerformed

    private void Key1Txt3KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_Key1Txt3KeyReleased
        try{
            String query = "Select * from TEAM.MATCHES where TEAM1=?";
            PreparedStatement pst = mycon.prepareStatement(query);
            pst.setString(1, Key1Txt3.getText());
            //pst.setString(1, String.valueOf(IDTxt.getText()));
            myres = pst.executeQuery();
            Mytable.setModel(DbUtils.resultSetToTableModel(myres));
            pst.close();
        } catch(SQLException ex){
           ex.printStackTrace();
        }
    }//GEN-LAST:event_Key1Txt3KeyReleased

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
            java.util.logging.Logger.getLogger(Teams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Teams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Teams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Teams.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Teams().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTextField CAPTIANTxt;
    public static javax.swing.JTextField IDTxt;
    private javax.swing.JTextField Key1Txt;
    private javax.swing.JTextField Key1Txt1;
    private javax.swing.JTextField Key1Txt3;
    private javax.swing.JTextField Key2Txt;
    public static javax.swing.JTextField MATCHESTxt;
    public javax.swing.JTable Mytable;
    public static javax.swing.JTextField PLAYERSTxt;
    public static javax.swing.JTextField TOTAL_SCORETxt;
    public static javax.swing.JTextField T_NAMETxt;
    private javax.swing.JButton backBTN;
    private javax.swing.JMenuItem by_goals;
    private javax.swing.JMenuItem by_point;
    private javax.swing.JMenu displaymenu;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuBar jMenuBar2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    public static javax.swing.JTextField pointstxt;
    // End of variables declaration//GEN-END:variables
}
