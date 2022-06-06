package interfaz;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JCheckBox;
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
	private String tareafull;
	private JLabel lIden;
	private JTextField tfIden;
	private JCheckBox cbFinal;
	private boolean refinal;
	
	public PanelCrearNormal(Interfaz ventana1, String tareaFull2)
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
        
        lIden = new JLabel();
        lIden.setText("Identificador");
        add(lIden);
        lIden.setBounds(10, 250, 100, 50);
        
        tfIden = new JTextField("Ingrese el id", 16);
        add(tfIden);
        tfIden.setBounds(210, 250, 100, 30);
        
        
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
        
        cbFinal = new JCheckBox("¿Es de finalizacion?");
        add(cbFinal);
        cbFinal.setBackground(getBackground());
        cbFinal.setBounds(10, 380, 300, 30);
        cbFinal.addItemListener(this);
		
		
		enviar = new JButton("enviar");
		enviar.addActionListener(new ActionListener(){  
        	public void actionPerformed(ActionEvent e){ 
        		//nuevo.setText(String.valueOf(ventana.sacarSelcts()[0]));
        		String partesid[] = tareafull.split("-");
        		String idDepurado = partesid[0];
                ventana.crearActividad(tfTitulo.getText(), tfDescrip.getText(), partesid[3], elParti.getSelectedIndex(), tfHora.getText(), tfMinuto.getText(), idDepurado, tfIden.getText(), refinal);
                ventana.pasoAHomeActi(tareafull);
            }  
        });
		add(enviar);
		enviar.setBounds(10, 420, 200, 50);
		
		
		
		
		
		
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
