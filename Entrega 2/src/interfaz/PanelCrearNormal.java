package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelCrearNormal extends JPanel implements ItemListener {
	
	
	private Interfaz ventana;
	private JLabel lTitulo;
	private JLabel lDescrip;
	private JLabel lTipos;
	private JLabel lPartis;
	private JLabel lHora;
	private JLabel lpuntos;
	private JTextField tfTitulo;
	private JTextField tfHora;
	private JTextField tfMinuto;
	private JTextArea tfDescrip;
	private JComboBox elTipo;
	private JComboBox elParti;
	private JButton enviar;
	
	public PanelCrearNormal(Interfaz ventana1)
	{
		this.ventana = ventana1;
		setLayout( null );
        setPreferredSize( new Dimension( 400, 800 ) );
        setBackground(Color.YELLOW);

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
        
        lTipos = new JLabel();
        lTipos.setText("Escoja el tipo");
        add(lTipos);
        lTipos.setBounds(10, 250, 100, 30);
        
        lPartis = new JLabel();
        lPartis.setText("Escoja el participante");
        add(lPartis);
        lPartis.setBounds(10, 290, 100, 30);
        
		ArrayList<String> losTipos = this.ventana.sacarTipos();
		String tiposs[] = new String[losTipos.size()];
		for(int i = 0; i<losTipos.size(); i++)
		{
			tiposs[i] = losTipos.get(i);
		}
		elTipo = new JComboBox(tiposs);
		add(elTipo);
		elTipo.setBounds(200,250,150,30);
		ArrayList<String> losPartis = this.ventana.sacarPartis();
		String partis[] = new String[losPartis.size()];
		for(int i = 0; i<losPartis.size(); i++)
		{
			partis[i] = losPartis.get(i);
		}
		elParti = new JComboBox(partis);
		add(elParti);
		elParti.setBounds(200,290,150,30);
		
		lHora = new JLabel();
        lHora.setText("Coloque la hora siguiendo el formato");
        add(lHora);
        lHora.setBounds(10, 330, 150, 30);
        
        tfHora = new JTextField("13",16);
        add(tfHora);
        tfHora.setBounds(180, 330, 40, 30);
        
        lpuntos = new JLabel();
        lpuntos.setText(":");
        add(lpuntos);
        lpuntos.setBounds(240, 330, 150, 50);
        
        tfMinuto = new JTextField("59",16);
        add(tfMinuto);
        tfMinuto.setBounds(270, 330, 40, 30);
        
		
		
		enviar = new JButton("enviar");
		enviar.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		//nuevo.setText(String.valueOf(ventana.sacarSelcts()[0]));
        		
                ventana.crearActividad(tfTitulo.getText(), tfDescrip.getText(), elTipo.getSelectedIndex(), elParti.getSelectedIndex(), tfHora.getText(), tfMinuto.getText());
                ventana.pasoAHomeActi();
            }  
        });
		add(enviar);
		enviar.setBounds(10, 380, 200, 50);
		
		
		
		
		
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
