/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Agerico Reyes
 */
public class LoadGame extends javax.swing.JFrame {

    private static final String driver = "org.apache.derby.jdbc.EmbeddedDriver";
    private static final String dbName = "gameDB";
    private static final String connectionURL = "jdbc:derby:" + dbName + ";create=true";
    private Connection conn;

    private final String createGameTable = "CREATE TABLE GAME "
    + "(ID INT GENERATED ALWAYS AS IDENTITY NOT NULL CONSTRAINT ID_PK PRIMARY KEY,"
    + " NAME VARCHAR(20) NOT NULL,"
    + " DIFFICULTY VARCHAR(20) NOT NULL,"
    + " TIME TIME NOT NULL,"
    + " ISDONE BOOLEAN NOT NULL)";

    
    
    /**
     * Creates new form LoadGame
     */
    public LoadGame() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
 private static boolean isGameTableExist(Connection conn) throws SQLException {
        try {
            Statement stment = conn.createStatement();
            stment.execute("SELECT * FROM GAME");
            stment.close();

        } catch (SQLException e) {
            String sqlExption = e.getSQLState();
            if (sqlExption.equals("42X05")) {
                return false;
            } else if (sqlExption.equals("42X14") || sqlExption.equals("42821")) {
                System.out.println("error in isgametableexist");
                System.out.println("SQLException:\nIncorrect Table Definition.");
                throw e;
            } else {
                e.printStackTrace();
                System.out.println("Unhandled SQLException:\n" + e.getMessage());
                throw e;
            }
        }

        return true;
    }
  

    public void getRecord(String difficulty) {

        try {
            conn = DriverManager.getConnection(connectionURL);
            System.out.println("CONNECTED TO DATABASE: " + dbName);
            Statement stment = conn.createStatement();
            if (!isGameTableExist(conn)) {
                System.out.println("CREATING GAME TABLE...");
                stment.execute(createGameTable);
            }
            stment.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }

        String name = "", time = "";
        try {

            ResultSet rst = null;
            PreparedStatement preStment = conn.prepareStatement("SELECT * FROM game WHERE (DIFFICULTY = ?) AND (ISDONE = ?)");

            String isDone = "false";

            System.out.println("SELECT * FROM game WHERE (DIFFICULTY = ?) AND (ISDONE = ?)");

            preStment.setString(1, difficulty);
            preStment.setString(2, isDone);
            rst = preStment.executeQuery();

            rst.next();
            name = (rst.getString(2));
            time = (rst.getString(4));
           
            //System.out.println(name);
            //System.out.println(time);

        } catch (Exception e) {
            System.out.println("error in get Record");
            e.printStackTrace();
            System.out.println(e.getMessage());
        }
        Sudoku sudokuFrame = new Sudoku(name, difficulty, time);
        sudokuFrame.setVisible(true);
        sudokuFrame.setLocationRelativeTo(null);

        //createGameFrame();
    }
    
    private void closeConnection(Connection conn){
        try {
            conn.close();
            System.out.println("CLOSED CONNECTION");
            if (driver.equals("org.apache.derby.jdbc.EmbeddedDriver")){
                boolean isShutdown = false;
                try {
                    DriverManager.getConnection("jdbc:derby:;shutdown=true");
                }
                catch (SQLException e){
                    if (e.getSQLState().equals("XJ015")){
                        isShutdown = true;
                    }
                }
                if (!(isShutdown)){
                    System.out.println("DATABASE DID NOT SHUTDOWN NORMALLY");
                }
                else {
                    System.out.println("DATABASE SHUTDOWN NORMALLY");
                }
            }
        } catch (Exception e) {
            System.out.println("error in closeConnection");
            JOptionPane.showMessageDialog(rootPane, e.getMessage(), "Exception", JOptionPane.ERROR_MESSAGE);
        }
        

    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        label1 = new java.awt.Label();
        button4 = new java.awt.Button();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        label1.setText("Saved Files");

        button4.setLabel("Back");

        jButton1.setText("Easy Saved Data");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Medium Saved Data");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Hard Saved Data");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(50, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton1)
                .addGap(32, 32, 32)
                .addComponent(jButton2)
                .addGap(31, 31, 31)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        LoadGame loadGame = new LoadGame();
        loadGame.getRecord("EASY");
        this.dispose();
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        // TODO add your handling code here:
        GameMenu gameMenuFrame = new GameMenu();
        gameMenuFrame.setVisible(true);
        gameMenuFrame.setLocationRelativeTo(null);
        
        this.dispose();
    }//GEN-LAST:event_button4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        LoadGame loadGame = new LoadGame();
        loadGame.getRecord("MEDIUM");
        this.dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        LoadGame loadGame = new LoadGame();
        loadGame.getRecord("HARD");
        this.dispose();
    }//GEN-LAST:event_jButton3ActionPerformed

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
            java.util.logging.Logger.getLogger(LoadGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoadGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoadGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoadGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new LoadGame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
