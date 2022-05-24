package interfaz;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogoAgregarParticipante extends JDialog implements ActionListener
{
	private JLabel lnombre;
	private JTextField tfNombre;
	private JLabel lcorreo;
	private JTextField tfcorreo;
	private JButton bAniadir;
	private Interfaz ventana;
	private final static String OK = "OK";
	
	public DialogoAgregarParticipante(Interfaz ventana1)
	{
		this.ventana = ventana1;
		setLayout(null);
		setSize(200, 400);
		setResizable( false );
		
		lnombre = new JLabel();
		lnombre.setText("Ingrese el nombre");
		add(lnombre);
		lnombre.setBounds(10,10,170,30);
		
		tfNombre = new JTextField( 16);
		add(tfNombre);
		tfNombre.setBounds(10,60,170,30);
		
		lcorreo = new JLabel();
		lcorreo.setText("Ingrese el correo");
		add(lcorreo);
		lcorreo.setBounds(10,110,170,30);

		tfcorreo = new JTextField( 16);
		add(tfcorreo);
		tfcorreo.setBounds(10,160,170,30);
		
		bAniadir = new JButton("Aniadir");
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
			
			this.ventana.aniadirParticipante(tfNombre.getText(),tfcorreo.getText());
			this.ventana.pasoAHomeProy();
			dispose();
		}
	}

}
