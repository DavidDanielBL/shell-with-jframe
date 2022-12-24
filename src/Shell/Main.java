/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Shell;

import java.awt.BorderLayout;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.plaf.metal.MetalLookAndFeel;

/**
 *
 * @author red1
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       new Main().inicio();
   
    }

   
    public void inicio()
    {
        MetalLookAndFeel.setCurrentTheme(new EstiloHalloween());
        JFrame.setDefaultLookAndFeelDecorated(true);
        JFrame frame = new JFrame("Terminal" + " in " + System.getProperty("os.name"));
        frame.getContentPane().add(new Ventana(), BorderLayout.CENTER);
        frame.setSize(400, 400);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setIconImage (new ImageIcon(getClass().getResource("/Imagenes/carita.gif")).getImage()); 

    
    }
    

}
