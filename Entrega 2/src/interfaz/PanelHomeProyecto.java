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

public class PanelHomeProyecto extends JPanel implements ActionListener
{
	private final static String SALIR = "Salir";
	
	private Interfaz ventana;
	private JLabel lnombre;
	private JLabel ldescripcion;
	private JButton bparticipantes;
	private JButton bactividades;
	private JButton bvisualizacion;
	private JButton bsalir;
    
    public PanelHomeProyecto( Interfaz pVentana)
    {
    	ventana = pVentana;
    	setLayout( null );
        setPreferredSize( new Dimension( 400, 800 ) );
        setBackground(new Color(215, 255, 212));
        
        lnombre = new JLabel();
        lnombre.setText("Bienvenidx a "+this.ventana.sacarNombre());
        add(lnombre);
        lnombre.setBounds(10, 10, 300, 50);
        
        ldescripcion = new JLabel();
        ldescripcion.setText(this.ventana.sacarDescripcion());
        add(ldescripcion);
        ldescripcion.setBounds(10, 80, 300, 50);
        
    	bparticipantes = new JButton("Participantes");
    	bparticipantes.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
                ventana.mostrarDialogParti();  
            }  
        });
    	add(bparticipantes);
        bparticipantes.setBounds(10, 400, 100, 50);
        
        bactividades = new JButton("Actividades");
    	bactividades.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
                ventana.pasoAHomeActi();  
            }  
        });
    	add(bactividades);
        bactividades.setBounds(160, 400, 100, 50);
        
        bvisualizacion = new JButton("Visualizacion");
        bvisualizacion.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){
                ventana.pasoAVisualizacion();  
            }  
        });
        add(bvisualizacion);
        bvisualizacion.setBounds(10, 500, 100, 50);
        
        bsalir = new JButton(SALIR);
        bsalir.setActionCommand(SALIR);
        bsalir.addActionListener(this);
        add(bsalir);
        bsalir.setBounds(160, 500, 100, 50);
    }
    
    public void actionPerformed(ActionEvent pEvento)
	{
		String comando = pEvento.getActionCommand();
		if(comando.equals(SALIR))
		{
			System.exit(0);
		}
	}
}
