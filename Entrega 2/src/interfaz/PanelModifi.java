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
	private String tareafull;
	
	public PanelModifi (Interfaz pventana) throws Exception
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
        
        String partesid[] = tareafull.split("-");
		String idDepurado = partesid[0];
		ArrayList<String> lasActis = this.ventana.sacarActisTarea(idDepurado);
		if(lasActis ==null)
		{
			throw new Exception("NO HAY ACTIVIDADES PARA MOSTRAR");
		}
		else
		{
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
	        			ventana.mostrarDialogFecha("");
	        		}
	        		else if(queModi.getSelectedIndex()==1)
	        		{
	        			ventana.mostrarDialogHoraIni("");
	        		}
	        		else if(queModi.getSelectedIndex()==2)
	        		{
	        			ventana.mostrarDialogHoraFin("");
	        		}
	        		else if(queModi.getSelectedIndex()==3)
	        		{
	        			ventana.mostrarDialogParti("");
	        		}
	            }  
	        });
			add(cambiar);
			cambiar.setBounds(10, 700, 200, 50);
			
		}
		
		
		
	}

	public PanelModifi(Interfaz interfaz, String tareaFull2) throws Exception {
		// TODO Auto-generated constructor stub
		this.ventana = interfaz;
		setLayout( null );
        setPreferredSize( new Dimension( 400, 800 ) );
        setBackground(Color.YELLOW);
        System.out.println("SI ENTRO");
        lActis = new JLabel();
        lActis.setText("Escoja la actividad");
        add(lActis);
        lActis.setBounds(10, 250, 100, 30);
        
        lModis = new JLabel();
        lModis.setText("Escoja que modificara");
        add(lModis);
        lModis.setBounds(10, 290, 100, 30);
        tareafull = tareaFull2;
        String partesid[] = tareafull.split("-");
		String idDepurado = partesid[0];
		ArrayList<String> lasActis = this.ventana.sacarActisTarea(idDepurado);
		if(lasActis ==null)
		{
			throw new Exception("NO HAY ACTIVIDADES PARA MOSTRAR");
		}
		else
		{
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
	        			String complet = lasActis.get(laActi.getSelectedIndex());
	        			String repartes[] = complet.split(";;");
	        			ventana.mostrarDialogFecha(repartes[4]);
	        		}
	        		else if(queModi.getSelectedIndex()==1)
	        		{
	        			String complet = lasActis.get(laActi.getSelectedIndex());
	        			String repartes[] = complet.split(";;");
	        			ventana.mostrarDialogHoraIni(repartes[4]);
	        		}
	        		else if(queModi.getSelectedIndex()==2)
	        		{
	        			String complet = lasActis.get(laActi.getSelectedIndex());
	        			String repartes[] = complet.split(";;");
	        			ventana.mostrarDialogHoraFin(repartes[4]);
	        		}
	        		else if(queModi.getSelectedIndex()==3)
	        		{
	        			String complet = lasActis.get(laActi.getSelectedIndex());
	        			String repartes[] = complet.split(";;");
	        			ventana.mostrarDialogParti(repartes[4]);
	        		}
	            }  
	        });
			add(cambiar);
			cambiar.setBounds(10, 700, 200, 50);
		}
	}

	public void setTarea(String tareaFull) {
		// TODO Auto-generated method stub
		this.tareafull = tareaFull;
	}

}
