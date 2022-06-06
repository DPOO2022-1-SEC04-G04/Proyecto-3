package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;

import javax.swing.JPanel;

import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;


public class PanelCrearCrono extends JPanel  implements ItemListener 
{	
	private Interfaz ventana;
	private JLabel lTitulo;
	private JLabel lDescrip;
	private JLabel lTipos;
	private JLabel lPartis;
	private JLabel ltimer;
	private JLabel lmin;
	private JLabel lsec;
	private JLabel lpun;
	
	private JTextField tfTitulo;
	private JTextArea tfDescrip;
	private JComboBox elTipo;
	private JComboBox elParti;
	private JButton enviar;
	private JButton iniciar;
	private JButton continuar;
	private JButton pausar;
	private JButton parar;
	private LocalTime horafinal;
	private LocalTime horainicio;
	private int duracion;
	
	private Timer timer = null;
	private int contadormin;
	private int contadorsec;
	
	private String tareafull;
	private JCheckBox cbFinal;
	private boolean refinal;
	private JLabel lIden;
	private JTextField tfIden;
	
	public PanelCrearCrono(Interfaz ventana1, String tareaFull2) 
	{
		this.ventana = ventana1;
		setLayout( null );
        setPreferredSize( new Dimension( 400, 800 ) );
        setBackground(Color.YELLOW);
        
        this.tareafull = tareaFull2;

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
        add(tfDescrip);
        tfDescrip.setBounds(10, 180, 300, 60);
        
        
        
        lPartis = new JLabel();
        lPartis.setText("Escoja el participante");
        add(lPartis);
        lPartis.setBounds(10, 290, 100, 30);
        
		
		ArrayList<String> losPartis = this.ventana.sacarPartisTarea(tareafull);
		String partis[] = new String[losPartis.size()];
		for(int i = 0; i<losPartis.size(); i++)
		{
			partis[i] = losPartis.get(i);
		}
		elParti = new JComboBox(partis);
		add(elParti);
		elParti.setBounds(200,290,150,30);
		
		ltimer = new JLabel();
        ltimer.setText("Mire el cronometro");
        add(ltimer);
        ltimer.setBounds(10, 340, 100, 30);
        //TODA LA PARTE DE CODIGO DE CRONOMETRO LA COPIAMOS DE STACKOVERFLOW
        //Y LA ADAPTAMOS
        contadorsec = 0;
        contadormin = 0;

        timer = new Timer(1000, new ActionListener(){      // Timer 4 seconds
            public void actionPerformed(ActionEvent e) {
            	contadorsec+=1;
            	if(contadorsec>59)
            	{
            		contadorsec=0;
            		contadormin+=1;
            	}
            	remove(lmin);
            	lmin = new JLabel();
            	if (contadormin<10)
            	{
            		lmin.setText("0"+String.valueOf(contadormin));
            	}
            	else
            	{
            		lmin.setText(String.valueOf(contadormin));
            	}
    	        add(lmin);
    	        lmin.setBounds(120, 340, 100, 30);
    	        
    	        lpun = new JLabel();
    	        lpun.setText(":");
    	        add(lpun);
    	        lpun.setBounds(140, 340, 100, 30);
    	        
    	        remove(lsec);
    	        lsec = new JLabel();
    	        if (contadorsec<10)
            	{
            		lsec.setText("0"+String.valueOf(contadorsec));
            	}
            	else
            	{
            		lsec.setText(String.valueOf(contadorsec));
            	}
    	        add(lsec);
    	        lsec.setBounds(150, 340, 100, 30);
            }
        });
        
        iniciar = new JButton("iniciar");
        iniciar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	horainicio = LocalTime.now();
            	lmin = new JLabel();
    	        lmin.setText("00");
    	        add(lmin);
    	        lmin.setBounds(120, 340, 100, 30);
    	        
    	        lpun = new JLabel();
    	        lpun.setText(":");
    	        add(lpun);
    	        lpun.setBounds(140, 340, 100, 30);
    	        
    	        lsec = new JLabel();
    	        lsec.setText("00");
    	        add(lsec);
    	        lsec.setBounds(150, 340, 100, 30);
                timer.start();              // start timer
            }
        });

		add(iniciar);
		iniciar.setBounds(10, 500, 120, 50);
		
		
		continuar = new JButton("continuar");
        continuar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	timer.start();// start timer
            }
        });

		add(continuar);
		continuar.setBounds(10, 500, 120, 50);
		continuar.setVisible(false);
		
		pausar = new JButton("pausar");
        pausar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	timer.stop();
            	iniciar.setVisible(false);
            	continuar.setVisible(true);// start timer
            }
        });

		add(pausar);
		pausar.setBounds(150, 500, 120, 50);
		
		parar = new JButton("parar");
        parar.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
            	timer.stop();
            	iniciar.setVisible(false);
            	continuar.setVisible(false);
            	pausar.setVisible(false);
            	horafinal = LocalTime.now();
            	duracion = (60*contadormin)+contadorsec;// start timer
            }
        });

		add(parar);
		parar.setBounds(300, 500, 120, 50);
			        
		cbFinal = new JCheckBox("¿Es de finalizacion?");
        add(cbFinal);
        cbFinal.setBackground(getBackground());
        cbFinal.setBounds(10,250, 300, 30);
        cbFinal.addItemListener(this);
        
        lIden = new JLabel();
        lIden.setText("Identificador");
        add(lIden);
        lIden.setBounds(10, 580, 100, 50);
        
        tfIden = new JTextField("Ingrese el id", 16);
        add(tfIden);
        tfIden.setBounds(210, 580, 100, 30);
        
		enviar = new JButton("enviar");
		enviar.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		//nuevo.setText(String.valueOf(ventana.sacarSelcts()[0]));
        		String partesid[] = tareafull.split("-");
        		String idDepurado = partesid[0];
                ventana.crearActiCrono(tfTitulo.getText(), tfDescrip.getText(), partesid[3], elParti.getSelectedIndex(), horainicio, horafinal, duracion , idDepurado, tfIden.getText(), refinal);
                ventana.pasoAHomeActi(tareafull);
            }  
        });
		add(enviar);
		enviar.setBounds(10, 700, 200, 50);
		
		
		
		
		
	}
	
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == cbFinal) {
            if (e.getStateChange() == 1)
            {
            	refinal = true;
            }
            else
            {
            	refinal = false;
            }	
        }
	}

	public void setTarea(String tareaFull) {
		// TODO Auto-generated method stub
		this.tareafull = tareaFull;
	}
}
