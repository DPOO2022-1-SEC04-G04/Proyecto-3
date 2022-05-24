package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;



public class PanelInicio extends JPanel
{
	private Interfaz ventana;
	private JButton bnuevo;
	private JButton bcerrar;
	private JButton bcontinuar;
	//private int tamanioint;
	//private int dificultad;
    
    public PanelInicio( Interfaz pVentana)
    {
    	ventana = pVentana;
    	setLayout( null );
        setPreferredSize( new Dimension( 400, 800 ) );
        setBackground(new Color(232, 244, 255));
        
        
    	bnuevo = new JButton("Nuevo");
    	bnuevo.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		//nuevo.setText(String.valueOf(ventana.sacarSelcts()[0]));
        		
                ventana.pasoACrear();  
            }  
        });
    	add(bnuevo);
        bnuevo.setBounds(150, 300, 100, 50);
        bcontinuar = new JButton("Continuar");
    	bcontinuar.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		//nuevo.setText(String.valueOf(ventana.sacarSelcts()[0]));
        		
                ventana.pasoAHomeProy();  
            }  
        });
    	add(bcontinuar);
        bcontinuar.setBounds(150, 400, 100, 50);
        bcerrar = new JButton("Cerrar");
        add(bcerrar);
        bcerrar.setBounds(150, 500, 100, 50);
    }
}
