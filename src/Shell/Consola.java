/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Shell;

/**
 *
 * @author red1
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author red1
 */
public class Consola {

    public JTextField ruta,  comando;     //agregamos un campo texto
    public JLabel prompt;
    public JTextArea pantalla,  texto3; //agregar una are de texto admite mas texto
    public JPanel p1,  p2,  p3; //creamos 2 paneles 
    public JButton btOK,  btQuitar,  btSalir; //creamos 3 botones
    int i = 0, j = 4;
    public String texto1Inicio;//cadena para el texto de inicio
    public Color B,  F1,  F2,  F3; //colores 
    public int orden; //valor entero orden
    public final static String newline = "\n";
    public boolean band = false,  flag = false,  flog = false,  bande = false,  bander = false;
    char a = ' ', letra = '1';
    int codigo, k = 0, MAX = 0;
    char[] directorio;
    String[] Registro;
    String[] Directorios;
    String texto;
    String temp, h, anterior, unid = "", unidad, temp2, temp3, temp5 = "", dire = "c:", direc = "\\";

    public Component consola(String text) {
        Registro = new String[5];
        Directorios = new String[100];
        directorio = new char[100];
        B = new Color(40, 40, 40);
        F1 = Color.green;
        p1 = new JPanel(new BorderLayout()); // panel Principal
        p2 = new JPanel(new GridLayout(3, 1)); // panel para 3 botones en BorderLayout.SOUTH
        p3 = new JPanel(new GridLayout(1, 1));
        ruta = new JTextField(40);
        ruta.setToolTipText("RUTA ACTUAL");
        comando = new JTextField(40);
        comando.setToolTipText("Enter your command");
        pantalla = new JTextArea(10, 10);
        pantalla.setToolTipText("The result is displayed");
        btOK = new JButton("ENTER");
        btOK.setToolTipText("Ingresar Comando");
        btOK.addActionListener(new prueba());
        btQuitar = new JButton("CLEAN");
        btQuitar.setToolTipText("Reiniciar todo");
        btQuitar.addActionListener(new limpiarPantalla());
        btSalir = new JButton("EXIT");
        btSalir.setToolTipText("Salir de shell");
        btSalir.addActionListener(new cerrarVentana());
        p2.add(btOK);
        p2.add(btQuitar);
        p2.add(btSalir);
        p3.setBackground(Color.ORANGE);
        ruta.setBackground(Color.BLACK);
        ruta.setForeground(Color.GREEN);
        System.setProperty("user.dir", dire + direc);//cambiar de ruta
        ruta.setText(System.getProperty("user.dir"));
        ruta.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        ruta.setEditable(false);
        p3.add(ruta);
        comando.setBackground(Color.WHITE);
        comando.setForeground(Color.BLACK);

        pantalla.setEditable(true);
        pantalla.setFont(new java.awt.Font("Arial", Font.PLAIN, 12));
        pantalla.setBackground(B);
        pantalla.setForeground(F1);
        pantalla.append("");
        pantalla.setEditable(false);
        JScrollPane pScroll = new JScrollPane(pantalla, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
        p1.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        p1.add(p2, BorderLayout.SOUTH);
        p1.add(p3, BorderLayout.NORTH);
        p1.add(pScroll, BorderLayout.CENTER);
        prompt = new JLabel();

        prompt.setBounds(5, -15, 50, 50);
        prompt.setText("#");
        comando.setMargin(new Insets(0, 10, 0, 0));
        comando.add(prompt);

        comando.addKeyListener(new KeyAdapter() {

            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                   
                    if (band == true) {
                        j = 4;
                        comando.setText(Registro[j]);
                        j--;
                        if (j < 0) {
                            j = 4;
                        }
                        band = false;
                    } else {
                        comando.setText(Registro[j]);
                        j--;
                        if (j < 0) {
                            j = 4;
                        }

                    }
                }
            }
        });
        p3.add(comando);

        return p1;
    }

    public class limpiarPantalla implements ActionListener {

        public void actionPerformed(ActionEvent evt) {

            System.setProperty("user.dir", "c:\\");
            ruta.setText(System.getProperty("user.dir"));
            pantalla.setText("");
            comando.setText("");
        }
    }

    public JTextField getRuta() {
        return ruta;
    }

    public void setRuta(JTextField ruta) {
        this.ruta = ruta;
    }

    public class cerrarVentana implements ActionListener {

        public void actionPerformed(ActionEvent evt) {
            System.exit(0);
        }
    }

    public class prueba implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                bander = false;
                flag = false;
                bande = false;
                pantalla.append(newline);
                texto = comando.getText();
                Registro[0] = Registro[1];
                Registro[1] = Registro[2];
                Registro[2] = Registro[3];
                Registro[3] = Registro[4];
                Registro[4] = texto;
                band = true;
                texto = comando.getText();
                if (texto.compareToIgnoreCase("") == 0) {
                    pantalla.setText("Enter something");
                } else {
                    letra = texto.toCharArray()[0];

                    codigo = (int) letra;
                    if (codigo >= 97 && codigo <= 122 && texto.toCharArray()[1] == ':') {
                        unidad = letra + ":";
                        unid = unidad + "\\";

                 


                        System.setProperty("user.dir", unidad + "\\ ");
                        ruta.setText(System.getProperty("user.dir"));
                        pantalla.setText("Se cambio de unidad");
                        bande = true;
                        temp5 = "";
                        unidad = "";
                        k = 0;

                    }
                    if (texto.toCharArray()[0] == 'c' && texto.toCharArray()[1] == 'd' && texto.toCharArray()[2] == '.' && texto.toCharArray()[3] == '.') {

                        if (k == 0) {
                            System.setProperty("user.dir", unid);
                            ruta.setText(System.getProperty("user.dir"));
                            
                        } else {
                            flog = true;
                            System.setProperty("user.dir", Directorios[k - 1]);
                           

                            ruta.setText(System.getProperty("user.dir"));
                            k--;



                        }


                    }




                    if (texto.toCharArray()[0] == 'c' && texto.toCharArray()[1] == 'd' && texto.toCharArray()[2] == ' ') {
                        try {
                            bander = true;
                            direc = "";
                            anterior = System.getProperty("user.dir");
                            Directorios[k] = anterior;
                            
                            k++;
                            
                          
                            for (i = 3; i < texto.length(); i++) {
                                a = texto.toCharArray()[i];
                                temp5 = temp5 + a;
                            }

                            temp5 = temp5 + '\\';
                            directorio[0] = '\\';
                            direc = direc + directorio[0]; 

                            for (int i = 0; i < temp5.length(); i++) {
                                directorio[i + 1] = temp5.toCharArray()[i];
                                direc = direc + directorio[i + 1];
                            }
                            System.setProperty("user.dir", unid + direc);//cambiar de ruta
                            ruta.setText(System.getProperty("user.dir"));

                            run("cmd", "/c", texto);



                        } catch (IOException ex) {
                            Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    } else {
                        run("cmd", "/c", texto);
                        k = 0;
                    }
                    if (flag == false && bande == false && flog == false) {
                        
                        direc = "";
                        pantalla.setText("Ingresa algo valido");
                        comando.setText("");
                        System.setProperty("user.dir", anterior);
                        ruta.setText(System.getProperty("user.dir"));
                    } else {
                        if (flag == true && bander == true) {
                           
                            pantalla.setText("Se cambio de directorio con exito");
                            flag = false;
                            bander = false;
                            comando.setText("");
                        }

                    }
                }
            } catch (IOException ex) {
                Logger.getLogger(Consola.class.getName()).log(Level.SEVERE, null, ex);
            }



        }
    }

    public void run(String... command) throws IOException {
        try {
            ProcessBuilder pb = new ProcessBuilder(command);
            pb.redirectErrorStream(true);
            pb.directory(new File(System.getProperty("user.dir")));
            Process p = pb.start();
            InputStream is = p.getInputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String aux = br.readLine();
            if (aux == null) {
                band = false;
            }

            while (aux != null) {
                pantalla.append(aux + newline);
                pantalla.setCaretPosition(pantalla.getDocument().getLength());
                aux = br.readLine();
                flag = true;
            }

            pantalla.append(newline);
            pantalla.append("***********************************");
            comando.setText("");

            is.close();
            p.destroy();

        } catch (IOException e) {

        }
    }
    }



