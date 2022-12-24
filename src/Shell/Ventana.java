/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Shell;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author red1
 */
public class Ventana extends JPanel {
   
public Ventana() //constructor
    {
        Consola con = new Consola();
    

        Component consola2 = con.consola("Consola"); //Linea 35
        setLayout(new GridLayout(1, 1));//para separar
        add(consola2);//aÃ±adir el componente llamado consola a ventana

    
    }
}
//Fin class Ventana