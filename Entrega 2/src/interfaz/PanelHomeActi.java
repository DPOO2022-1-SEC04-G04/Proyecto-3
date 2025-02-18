package interfaz;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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



public class PanelHomeActi extends JPanel
{
	private Interfaz ventana;
	private JLabel lnombre;
	private JLabel ldescripcion;
	private JButton bnuevanormal;
	private JButton bnuevacrono;
	private JButton bmodificar;
	private JButton bsalir;
	private String idTarea;
	private String tareaFull;
	private JButton bfecha;
	private JButton brespons;
	//private int tamanioint;
	//private int dificultad;
    
    public PanelHomeActi( Interfaz pVentana)
    {
    	ventana = pVentana;
    	setLayout( null );
        setPreferredSize( new Dimension( 400, 800 ) );
        setBackground(Color.PINK);
        
        lnombre = new JLabel();
        lnombre.setText("Bienvenidx a "+this.ventana.sacarNombre());
        add(lnombre);
        lnombre.setBounds(10, 10, 300, 50);
        
        //ldescripcion = new JLabel();
        //ldescripcion.setText(this.ventana.sacarDescripcion());
        //add(ldescripcion);
        //ldescripcion.setBounds(10, 80, 300, 50);
        

        bfecha = new JButton("Cambiar tiempo planeado");
    	bfecha.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		//nuevo.setText(String.valueOf(ventana.sacarSelcts()[0]));
        		
                ventana.mostrarTiempoPlaneado(tareaFull);  
            }  
        });
    	add(bfecha);
        bfecha.setBounds(10, 200, 150, 50);
        
    	bfecha = new JButton("Cambiar fecha fin estimada");
    	bfecha.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		//nuevo.setText(String.valueOf(ventana.sacarSelcts()[0]));
        		
                ventana.mostrarCambiarFecha(tareaFull);  
            }  
        });
    	add(bfecha);
        bfecha.setBounds(10, 300, 150, 50);
        
        brespons = new JButton("Agregar Responsables");
    	brespons.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		//nuevo.setText(String.valueOf(ventana.sacarSelcts()[0]));
        		
                ventana.mostrarAddRespon(tareaFull);  
            }  
        });
    	add(brespons);
        brespons.setBounds(200, 300, 150, 50);
        
        
    	bnuevanormal = new JButton("Crear Actividad Normal");
    	bnuevanormal.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		//nuevo.setText(String.valueOf(ventana.sacarSelcts()[0]));
        		if(ventana.sacarPartisTarea(tareaFull).isEmpty())
        		{
        			ventana.mostrarExcepcion();
        		}
        		else
        		{
        			ventana.pasoACrearActi(tareaFull);
        		}
                  
            }  
        });
    	add(bnuevanormal);
        bnuevanormal.setBounds(10, 400, 150, 50);
        
        bnuevacrono = new JButton("Crear Actividad Cronometrada");
    	bnuevacrono.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		//nuevo.setText(String.valueOf(ventana.sacarSelcts()[0]));
        		
                ventana.pasoACrearCrono(tareaFull);  
            }  
        });
    	add(bnuevacrono);
        bnuevacrono.setBounds(200, 400, 150, 50);
        
        bmodificar = new JButton("Modificar");
        bmodificar.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		//nuevo.setText(String.valueOf(ventana.sacarSelcts()[0]));
        		
                ventana.pasoAModificar(tareaFull);  
            }  
        });
        add(bmodificar);
        bmodificar.setBounds(10, 500, 150, 50);
        
        bsalir = new JButton("Salir");
        add(bsalir);
        bsalir.setBounds(200, 500, 150, 50);
    }

	public void setTarea(String tarea) {
		// TODO Auto-generated method stub
		this.tareaFull = tarea;
		String partesid[] = tarea.split("-");
		String idDepurado = partesid[0];
		this.idTarea = idDepurado;
		lnombre.setText("Bienvenidx a "+tarea);
	}
}
