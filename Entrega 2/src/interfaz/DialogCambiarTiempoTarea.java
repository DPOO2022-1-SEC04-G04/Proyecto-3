package interfaz;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogCambiarTiempoTarea extends JDialog implements ActionListener
{
	private JLabel ltiempo;
	private JTextField tfTiempo;
	private JLabel lcorreo;
	private JTextField tfcorreo;
	private JButton bAniadir;
	private Interfaz ventana;
	private final static String OK = "OK";
	private String tareafull;
	
	public DialogCambiarTiempoTarea(Interfaz ventana1, String tareafulll)
	{
		this.ventana = ventana1;
		setLayout(null);
		setSize(200, 400);
		setResizable( false );
		this.tareafull = tareafulll;
		ltiempo = new JLabel();
		ltiempo.setText("Ingrese el tiempo planeado en horas");
		add(ltiempo);
		ltiempo.setBounds(10,10,170,30);
		
		tfTiempo = new JTextField( 16);
		add(tfTiempo);
		tfTiempo.setBounds(10,60,170,30);
		

		
		bAniadir = new JButton("Cambiar");
		add(bAniadir);
		bAniadir.setActionCommand( OK );
		bAniadir.setBounds(10,210,170,30);
		bAniadir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = bAniadir.getActionCommand();
		
		if(comando.equals(OK))
		{
			String idDepurado = "";
			String partesid[] = tareafull.split("-");
			idDepurado = partesid[0];
			this.ventana.aniadirTiempoTarea(tfTiempo.getText(),idDepurado);
			//this.ventana.pasoAHomeProy();
			dispose();
		}
	}

}

