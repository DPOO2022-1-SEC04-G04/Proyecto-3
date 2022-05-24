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


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

public class PanelModifi extends JPanel
{
	private Interfaz ventana;
	private JLabel lTitulo;
	private JLabel lDescrip;
	private JLabel lActis;
	private JLabel lModis;

	private JComboBox laActi;
	private JComboBox queModi;
	
	private JButton cambiar;
	
	public PanelModifi (Interfaz pventana)
	{
		this.ventana = pventana;
		setLayout( null );
        setPreferredSize( new Dimension( 400, 800 ) );
        setBackground(Color.YELLOW);
        
        lActis = new JLabel();
        lActis.setText("Escoja la actividad");
        add(lActis);
        lActis.setBounds(10, 250, 100, 30);
        
        lModis = new JLabel();
        lModis.setText("Escoja que modificara");
        add(lModis);
        lModis.setBounds(10, 290, 100, 30);
        
		ArrayList<String> lasActis = this.ventana.sacarActis();
		String actiss[] = new String[lasActis.size()];
		for(int i = 0; i<lasActis.size(); i++)
		{
			actiss[i] = lasActis.get(i);
		}
		laActi = new JComboBox(actiss);
		add(laActi);
		laActi.setBounds(200,250,150,30);
		laActi.setSelectedIndex(0);
		
		//ArrayList<String> losPartis = this.ventana.sacarPartis();
		String modiss[] = new String[] {"fecha","Hora inicial","Hora Final", "Participante" };
		queModi = new JComboBox(modiss);
		add(queModi);
		queModi.setBounds(200,290,150,30);
		queModi.setSelectedIndex(0);
		
		cambiar = new JButton("cambiar");
		cambiar.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		//nuevo.setText(String.valueOf(ventana.sacarSelcts()[0]));
        		if(queModi.getSelectedIndex()==0)
        		{
        			ventana.mostrarDialogFecha(laActi.getSelectedIndex());
        		}
        		else if(queModi.getSelectedIndex()==1)
        		{
        			ventana.mostrarDialogHoraIni(laActi.getSelectedIndex());
        		}
        		else if(queModi.getSelectedIndex()==2)
        		{
        			ventana.mostrarDialogHoraFin(laActi.getSelectedIndex());
        		}
        		else if(queModi.getSelectedIndex()==3)
        		{
        			ventana.mostrarDialogParti(laActi.getSelectedIndex());
        		}
            }  
        });
		add(cambiar);
		cambiar.setBounds(10, 700, 200, 50);
		
		
		
	}

}
