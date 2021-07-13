import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class SplashScreen{ 
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Difficulty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Difficulty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Difficulty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Difficulty.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        new SplashScreen();
    }
    public SplashScreen() {

        Music music = Music.getInstance();

        JWindow window = new JWindow();
        window.getContentPane().add(new JLabel("", new ImageIcon(getClass().getResource("logo.png")), 0), SwingConstants.CENTER);
        window.setBounds(500, 150, 300, 200);
        window.setSize(500,500);
        window.setVisible(true);
        window.setLocationRelativeTo(null);
        
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        window.setVisible(false);
        window.dispose();
        GameMenu gm = new GameMenu();
        gm.setVisible(true);
        gm.setLocationRelativeTo(null);
    
        try{
            music.play();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

}