package Sonido;

import java.awt.Cursor;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Soundclick {
    //objetos soportados
    private JTextField JTextfield;
    private JLabel jLabel;
    private JComboBox jComboBox;
    private JButton jButton;
    private String Tipo = "";
    private Clip clip;
   
   

    public Soundclick(Object ob1)
    {
        //Eventos del raton
        MouseListener mouseListener = new MouseListener() {

        public void mouseClicked(MouseEvent evt) {
            if( Tipo.equals("JTextField") )
            {
                if( !JTextfield.isEditable() )
                    JTextfield.setEditable(true);
                JTextfield.selectAll();
                daleplay("clic");
            }
            if( Tipo.equals("JComboBox") )            
                daleplay("swing");
            if( Tipo.equals("JButton") )
                daleplay("tada");
            if( Tipo.equals("JLabel") )
                daleplay("chafez");
        }

        public void mouseEntered(MouseEvent evt) {
            if( Tipo.equals("JLabel"))
                daleplay("burro");
            else
                daleplay("water1");
        }

        public void mouseExited(MouseEvent evt) {
            if( Tipo.equals("JTextField") )
            {
                if( JTextfield.isEditable() )
                {
                    JTextfield.setEditable(false);
                    daleplay("bubble");
                }
            }
        }

        public void mousePressed(MouseEvent evt) {}

        public void mouseReleased(MouseEvent evt) {}
    };

    //EVENTOS DE TECLADO
    KeyListener  keyListener = new KeyListener(){

        public void keyTyped(KeyEvent e) {
         if( Tipo.equals("JTextField") )
            {
                if( JTextfield.isEditable() )                
                    daleplay("typetext");
                else
                    daleplay("locked");
            }                
        }

            public void keyPressed(KeyEvent e) {}

            public void keyReleased(KeyEvent e) {}
        };

    //Evento del JCombo cuando se realiza un cambio en un item
    ItemListener Itemlistener = new ItemListener () {
            public void itemStateChanged(ItemEvent e) {
                daleplay("out");
            }
        };

    //Dependiendo del objecto que se añada, se asignan eventos y variables
    if(ob1 instanceof javax.swing.JTextField)
    {
       JTextfield  = (JTextField) ob1;
       JTextfield.addMouseListener(mouseListener);
       JTextfield.addKeyListener(keyListener);
       JTextfield.setEditable(false);
       JTextfield.setCursor(Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ));
       this.Tipo = "JTextField";
    }
    else if(ob1 instanceof javax.swing.JLabel)
    {
        jLabel = (JLabel) ob1;
        jLabel.addMouseListener(mouseListener);
        jLabel.setCursor(Cursor.getPredefinedCursor( Cursor.HAND_CURSOR ));
        this.Tipo = "JLabel";
    }
    else if(ob1 instanceof javax.swing.JComboBox)
    {
        jComboBox = ((JComboBox) ob1);
        this.Tipo = "JComboBox";
        jComboBox.addMouseListener(mouseListener);
        jComboBox.addItemListener(Itemlistener);
    }
    else if(ob1 instanceof javax.swing.JButton)
    {
        this.Tipo = "JButton";
        this.jButton = (JButton) ob1;
        this.jButton.addMouseListener(mouseListener);
    }

    }
    //metodo que reproduce un sonido del paquete WAV
    public void daleplay(String value)
    {        
       try
       {
   clip=AudioSystem.getClip();
   clip.open(AudioSystem.getAudioInputStream( getClass().getResourceAsStream( value +".wav" ) ) );
   //clip.open...( path +  value +".wav" ) ) );
   clip.start();
       }catch(Exception ex){
        }
    }

}

