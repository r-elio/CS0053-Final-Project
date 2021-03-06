/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author Agerico Reyes
 * @author Mark Egana
 * 
 */
public class LoadGame extends javax.swing.JFrame implements GameDB {
    private Connection conn;
    private boolean notEmpty;

    /**
     * Creates new form LoadGame
     */
    public LoadGame() {
        initComponents();
    }
  

    public boolean getRecord(String difficulty) {
        conn = GameDB.getConnection();
        try {
            Statement stment = conn.createStatement();
            if (!GameDB.isGameTableExist(conn)) {
                stment.execute(GameDB.CREATE_GAME_TABLE);
            }
            stment.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String name = "", time = "";
        try {

            ResultSet rst = null;
            PreparedStatement preStment = conn.prepareStatement("SELECT * FROM game WHERE (DIFFICULTY = ?) AND (ISDONE = ?)");
            
            String isDone = "false";

            preStment.setString(1, difficulty);
            preStment.setString(2, isDone);
            rst = preStment.executeQuery();

            if (rst.next() != false) {
                notEmpty=true;
                
              
                name = (rst.getString(2));
                time = (rst.getString(4));
               this.dispose();
                Sudoku sudokuFrame = new Sudoku(name, difficulty, time);
                sudokuFrame.setVisible(true);
                sudokuFrame.setLocationRelativeTo(null);
            } else {    
                JOptionPane.showMessageDialog(rootPane, "No Saved Files", "NOTICE", JOptionPane.WARNING_MESSAGE);
                notEmpty=false;
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return notEmpty;
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
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

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
        LoadGame loadGame = new LoadGame();
        notEmpty=loadGame.getRecord("EASY");
        
        if(notEmpty){         
             this.dispose();    
            
        }
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        GameMenu gameMenuFrame = new GameMenu();
        gameMenuFrame.setVisible(true);
        gameMenuFrame.setLocationRelativeTo(null);
        
        this.dispose();
    }//GEN-LAST:event_button4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        LoadGame loadGame = new LoadGame();
        notEmpty=loadGame.getRecord("MEDIUM");
        
         if(notEmpty){  
            this.dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        LoadGame loadGame = new LoadGame();
        notEmpty=loadGame.getRecord("HARD");
       
         if(notEmpty){
            this.dispose();
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button4;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
