import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JWindow;
import javax.swing.SwingConstants;

public class SplashScreen{ 
    public static void main(String[] args) {
        new SplashScreen();
    }
    public SplashScreen() {
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
    
    }

}