package interfaz;

import javax.swing.JDialog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogHoraInicio extends JDialog implements ActionListener
{
	private Interfaz ventana;
	private int indexActi;
	
	private final static String OK = "OK";
	private JButton bCambiar;
	private JLabel enunciado;
	private JLabel puntos;
	private JTextField tfHora;
	private JTextField tfMinutos;
	
	
	public DialogHoraInicio(Interfaz interfaz, int selectedIndex) {
		// TODO Auto-generated constructor stub
		this.ventana = interfaz;
		this.indexActi = selectedIndex;
		setLayout(null);
		setSize(400, 800);
		setResizable( false );
		
		enunciado = new JLabel();
        enunciado.setText("Coloque la hora siguiendo el formato");
        add(enunciado);
        enunciado.setBounds(10, 330, 150, 30);
        
        tfHora = new JTextField("13",16);
        add(tfHora);
        tfHora.setBounds(180, 330, 40, 30);
        
        puntos = new JLabel();
        puntos.setText(":");
        add(puntos);
        puntos.setBounds(240, 330, 150, 50);
        
        tfMinutos = new JTextField("59",16);
        add(tfMinutos);
        tfMinutos.setBounds(270, 330, 40, 30);
        
        bCambiar = new JButton("Cambiar");
		add(bCambiar);
		bCambiar.setActionCommand( OK );
		bCambiar.setBounds(10,510,170,30);
		bCambiar.addActionListener(this);
		
		
		
		
	}
	
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = bCambiar.getActionCommand();
		
		if(comando.equals(OK))
		{
			LocalTime horanueva = LocalTime.of(Integer.parseInt(tfHora.getText()), Integer.parseInt(tfMinutos.getText()));
			this.ventana.cambiarHoraInicial(horanueva, indexActi);
			this.ventana.pasoAHomeProy();
			dispose();
		}
	}

}
