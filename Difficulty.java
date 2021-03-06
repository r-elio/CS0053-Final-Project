import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Agerico Reyes
 * @author Rajan Elio
 * 
 */
public class Difficulty extends javax.swing.JFrame implements GameDB {

    private Connection conn;
    private String playerName;
    private String title;

    /**
     * Creates new form Difficulty
     */
    public Difficulty(String title, String playerName) {
        this.playerName = playerName;
        this.title = title;
        initComponents();
    }

    public Difficulty(String title){
        this.title = title;
        initComponents();
    }

    /*
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        setTitle(title);

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

        button1 = new java.awt.Button();
        button2 = new java.awt.Button();
        button3 = new java.awt.Button();
        label1 = new java.awt.Label();
        button4 = new java.awt.Button();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        button1.setLabel("Easy");
        
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setLabel("Medium");

        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button3.setLabel("Hard");

        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        label1.setText("Difficulty");

        button4.setLabel("Back");

        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(100, 100, 100)
                        .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(75, 75, 75)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(button2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(button3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(86, 86, 86)
                        .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(77, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(label1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(button4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(44, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        if (title.equals("New Game")){
            if (isSaveDataExists("EASY")){
                int response = JOptionPane.showConfirmDialog(rootPane, "There is existing save data. Would you like to overwrite it?", "Existing Save Data", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (response == JOptionPane.YES_OPTION){
                    deleteSaveData("EASY");
                    createSudokuFrame("EASY");
                }
            }
            else {
                createSudokuFrame("EASY");
            }
        }
        else if (title.equals("Rankings")){
            createRankingsFrame("EASY");
        }
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        if (title.equals("New Game")){
            if (isSaveDataExists("MEDIUM")){
                int response = JOptionPane.showConfirmDialog(rootPane, "There is existing save data. Would you like to overwrite it?", "Existing Save Data", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (response == JOptionPane.YES_OPTION){
                    deleteSaveData("MEDIUM");
                    createSudokuFrame("MEDIUM");
                }
            }
            else {
                createSudokuFrame("MEDIUM");
            }
        }
        else if (title.equals("Rankings")){
            createRankingsFrame("MEDIUM");
        }
    }//GEN-LAST:event_button2ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed
        if (title.equals("New Game")){
            if (isSaveDataExists("HARD")){
                int response = JOptionPane.showConfirmDialog(rootPane, "There is existing save data. Would you like to overwrite it?", "Existing Save Data", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
                if (response == JOptionPane.YES_OPTION){
                    deleteSaveData("HARD");
                    createSudokuFrame("HARD");
                }
            }
            else {
                createSudokuFrame("HARD");
            }
        }
        else if (title.equals("Rankings")){
            createRankingsFrame("HARD");
        }
    }//GEN-LAST:event_button3ActionPerformed

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        if (title.equals("New Game")){
            createPlayerNameFrame();
        }
        else if (title.equals("Rankings")){
            createGameFrame();
        }
        
    }//GEN-LAST:event_button4ActionPerformed

    private boolean isSaveDataExists(String difficulty){
        boolean isResult = true;
        try {
            PreparedStatement preStment = conn.prepareStatement("SELECT * FROM GAME WHERE DIFFICULTY = ? AND ISDONE = ?");
            preStment.setString(1, difficulty);
            preStment.setString(2, "false");
            ResultSet rSet = preStment.executeQuery();

            if (!rSet.next()){
                isResult = false;
            }

            rSet.close();
            preStment.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return isResult;
    }

    private void deleteSaveData(String difficulty){
        try {
            PreparedStatement preStment = conn.prepareStatement("DELETE FROM GAME WHERE DIFFICULTY = ? AND ISDONE = ?");
            preStment.setString(1, difficulty);
            preStment.setString(2, "false");
            preStment.executeUpdate();

            File saveFile = new File(difficulty + ".save");
            saveFile.delete();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createPlayerNameFrame(){
        PlayerName playerNameFrame = new PlayerName(playerName);
        playerNameFrame.setVisible(true);
        playerNameFrame.setLocationRelativeTo(null);
        this.dispose();
    }

    private void createSudokuFrame(String difficulty){
        Sudoku sudokuFrame = new Sudoku(playerName, difficulty, "00:00:00");
        sudokuFrame.setVisible(true);
        sudokuFrame.setLocationRelativeTo(null);
        this.dispose();
    }

    private void createRankingsFrame(String difficulty){
        Rankings rankingsFrame = new Rankings(difficulty);
        rankingsFrame.setVisible(true);
        rankingsFrame.setLocationRelativeTo(null);
        this.dispose();
    }

    private void createGameFrame(){
        GameMenu gameMenuFrame = new GameMenu();
        gameMenuFrame.setVisible(true);
        gameMenuFrame.setLocationRelativeTo(null);
        dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private java.awt.Button button1;
    private java.awt.Button button2;
    private java.awt.Button button3;
    private java.awt.Button button4;
    private java.awt.Label label1;
    // End of variables declaration//GEN-END:variables
}
