package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalDate;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;


public class PanelCrearProyecto extends JPanel implements ItemListener
{
	private Interfaz ventana;
	private JLabel lCrear;
	private JLabel lTitulo;
	private JLabel lDescrip;
	private JLabel lNombred;
	private JLabel lCorreod;
	private JLabel lFechai;
	private JLabel lFechaf;
	private JLabel lSlashuno;
	private JLabel lSlashdos;
	private JLabel lSlashTres;
	private JLabel lSlashCuatro;
	private JLabel lTipos;
	private JTextField tfNombred;
	private JTextField tfTitulo;
	private JTextField tfCorreod;
	private JTextField tfDiaini;
	private JTextField tfMesini;
	private JTextField tfAnioini;
	private JTextField tfDiaFin;
	private JTextField tfMesFin;
	private JTextField tfAnioFin;
	private JTextField tfTipos;
	private JTextArea tfDescrip;
	private JCheckBox cbFechaf;
	private JButton bSiguiente;
	private boolean centinela = false;
	
	
	public PanelCrearProyecto( Interfaz pVentana)
    {
    	ventana = pVentana;
    	this.ventana.resetearArray();
        setLayout( null );
        setPreferredSize( new Dimension( 400, 800 ) );
        setBackground(new Color(255, 239, 212));
        
    	lCrear = new JLabel();
    	lCrear.setText("CREAR PROYECTO");
    	add(lCrear);
    	lCrear.setBounds(120, 20, 150, 50);
        
        lTitulo = new JLabel();
        lTitulo.setText("Titulo");
        add(lTitulo);
        lTitulo.setBounds(10, 80, 100, 50);
        
        tfTitulo = new JTextField("Ingrese el titulo", 16);
        add(tfTitulo);
        tfTitulo.setBounds(10, 120, 300, 30);
        
        lDescrip = new JLabel();
        lDescrip.setText("Descripcion");
        add(lDescrip);
        lDescrip.setBounds(10, 140, 100, 50);
        
        tfDescrip = new JTextArea(50, 10);
        JScrollPane scrollBar = new JScrollPane(tfDescrip);
        scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
        scrollBar.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollBar);
        scrollBar.setBounds(10, 180, 300, 60);
        
        lNombred = new JLabel();
        lNombred.setText("Nombre Duenio");
        add(lNombred);
        lNombred.setBounds(10, 250, 100, 50);
        
        tfNombred = new JTextField("Ingrese el nombre", 16);
        add(tfNombred);
        tfNombred.setBounds(10, 290, 150, 30);
        
        lCorreod = new JLabel();
        lCorreod.setText("Correo Duenio");
        add(lCorreod);
        lCorreod.setBounds(210, 250, 100, 50);
        
        tfCorreod = new JTextField("Ingrese el correo", 16);
        add(tfCorreod);
        tfCorreod.setBounds(210, 290, 150, 30);
        
        lFechai = new JLabel();
        lFechai.setText("Fecha Inicial");
        add(lFechai);
        lFechai.setBounds(10, 330, 100, 50);
        
        tfDiaini = new JTextField( 10);
        add(tfDiaini);
        tfDiaini.setBounds(130, 340, 40, 30);
        
        lSlashuno = new JLabel();
        lSlashuno.setText("/");
        add(lSlashuno);
        lSlashuno.setBounds(190, 330, 20, 50);
        
        tfMesini = new JTextField( 10);
        add(tfMesini);
        tfMesini.setBounds(220, 340, 40, 30);
        
        lSlashdos = new JLabel();
        lSlashdos.setText("/");
        add(lSlashdos);
        lSlashdos.setBounds(280, 330, 20, 50);
        
        tfAnioini = new JTextField( 10);
        add(tfAnioini);
        tfAnioini.setBounds(310, 340, 70, 30);
        
        lFechaf = new JLabel();
        lFechaf.setText("Fecha Final");
        add(lFechaf);
        lFechaf.setBounds(10, 410, 100, 50);
        lFechaf.setVisible(false);
        
        tfDiaFin = new JTextField( 10);
        add(tfDiaFin);
        tfDiaFin.setBounds(130, 420, 40, 30);
        tfDiaFin.setVisible(false);
        
        lSlashTres = new JLabel();
        lSlashTres.setText("/");
        add(lSlashTres);
        lSlashTres.setBounds(190, 410, 20, 50);
        lSlashTres.setVisible(false);
        
        tfMesFin = new JTextField( 10);
        add(tfMesFin);
        tfMesFin.setBounds(220, 420, 40, 30);
        tfMesFin.setVisible(false);
        
        lSlashCuatro = new JLabel();
        lSlashCuatro.setText("/");
        add(lSlashCuatro);
        lSlashCuatro.setBounds(280, 410, 20, 50);
        lSlashCuatro.setVisible(false);
        
        tfAnioFin = new JTextField( 10);
        add(tfAnioFin);
        tfAnioFin.setBounds(310, 420, 70, 30);
        tfAnioFin.setVisible(false);
        
        cbFechaf = new JCheckBox("¿Conoce usted la fecha de finalizacion?");
        add(cbFechaf);
        cbFechaf.setBackground(getBackground());
        cbFechaf.setBounds(10, 380, 300, 30);
        cbFechaf.addItemListener(this);
        
        lTipos = new JLabel();
        lTipos.setText("¿Cuantos tipos de actividades habrá?");
        add(lTipos);
        lTipos.setBounds(10, 460, 250, 50);
        
        tfTipos = new JTextField( 10);
        add(tfTipos);
        tfTipos.setBounds(270, 470, 40, 30);
        
        bSiguiente = new JButton("Siguiente");
    	bSiguiente.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		String s = e.getActionCommand();
                if (s.equals("Siguiente")) {
                	int cuantos = Integer.parseInt(tfTipos.getText());
                	ventana.mostrarDialogTipos(cuantos);
                }
            }  
        });
    	add(bSiguiente);
        bSiguiente.setBounds(10, 540, 100, 50);
    }
	
	public void itemStateChanged(ItemEvent e)
    {
        if (e.getSource() == cbFechaf) {
            if (e.getStateChange() == 1)
            {
            	lFechaf.setVisible(true);
            	tfDiaFin.setVisible(true);
            	lSlashTres.setVisible(true);
            	tfMesFin.setVisible(true);
            	lSlashCuatro.setVisible(true);
            	tfAnioFin.setVisible(true);
            	centinela = true;
            }
            else
            {
            	lFechaf.setVisible(false);
            	tfDiaFin.setVisible(false);
            	lSlashTres.setVisible(false);
            	tfMesFin.setVisible(false);
            	lSlashCuatro.setVisible(false);
            	tfAnioFin.setVisible(false);
            	centinela = false;
            }	
        }
    }

	public void cambiarProyecto()
	{
		LocalDate fechainicio = LocalDate.of(Integer.parseInt(tfAnioini.getText()), Integer.parseInt(tfMesini.getText()), Integer.parseInt(tfDiaini.getText()));
    	if(centinela)
    	{
    		LocalDate fechafinal = LocalDate.of(Integer.parseInt(tfAnioFin.getText()), Integer.parseInt(tfMesFin.getText()), Integer.parseInt(tfDiaFin.getText()));
    		ventana.cambiarProyConFin(tfTitulo.getText(),tfDescrip.getText(), tfNombred.getText(),tfCorreod.getText(),fechainicio, fechafinal);
    	}
    	else
    	{
    		ventana.cambiarProySinFin(tfTitulo.getText(),tfDescrip.getText(), tfNombred.getText(),tfCorreod.getText(),fechainicio);
    	}
	}

}
