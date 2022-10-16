

import java.awt.Color;
import java.awt.Font;
import static java.awt.Font.BOLD;
import static java.awt.Font.ITALIC;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.text.StyledEditorKit;

/**
 *
 * @author ccs
 */
public class Text_Animation extends JPanel{

    int x=0;
    int y=100;
    int a=400;
    int b=200;
  
    Text_Animation(){
    	
    	 JFrame jf = new JFrame();
         jf.setSize(500, 500);
         jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         jf.add(this);
         jf.setLocationRelativeTo(null);
         jf.setUndecorated(true);
         jf.setVisible(true);
         Timer timer = new Timer(9550, (ActionListener) new ActionListener(){
             public void actionPerformed(ActionEvent evt) {
                 jf.dispose();
             }
         });
         timer.setRepeats(false);
         timer.start();
    }

     public void paint(Graphics gp)
    {
        super.paint(gp);
        Graphics2D g2d= (Graphics2D) gp;
        g2d.setColor(Color.red);
        g2d.setFont(new Font("BOLD", BOLD, 35));
             
        g2d.drawString("Welcome TO Muet Library ", x, y);
        g2d.drawString("Developed by Zohaib Ahmed", a, b);
//       g2d.drawString("THANKS ", x, 400);
                try {
            Thread.sleep(200);
            x+=20;
            a-=20;
            
            if(x>getWidth())
        {
        
            x=0;
        }
            if(a<0)
        {
        
            a=500;
        }
        repaint();
                      
        } catch (InterruptedException ex) {
            JOptionPane.showMessageDialog(this, ex);
        }
    
        
        
    }
    
    
    
    /**
     * @param args the command line arguments
     */
    
}