package interfaz;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class DialogoTipos extends JDialog implements ActionListener
{
	private final static String OK = "OK";
	private String siguienteS = "Siguiente";
	
	private Interfaz ventana;
	private int tipos;
	private int contador;
	//private ArrayList<String> tiposArray;
	private JLabel lIngrese;
	private JTextField eltipo;
	private JButton siguiente;
	
	public DialogoTipos(Interfaz ventana1, int tipos1)
	{
		this.ventana = ventana1;
		this.tipos = tipos1;
		this.contador = 1;
		//this.tiposArray = new ArrayList<String>();
		setLayout(new GridLayout(1,3));
		setSize(500,100);
		lIngrese = new JLabel();
		lIngrese.setText("Ingrese el tipo");
		add(lIngrese);
		eltipo = new JTextField( 16);
		add(eltipo);
		siguiente = new JButton(siguienteS);
		add(siguiente);
		if(tipos1<2)
		{
			siguiente.setActionCommand( OK );
		}
		else
		{
			siguiente.setActionCommand( siguienteS );
		}
        siguiente.addActionListener( this );
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = siguiente.getActionCommand();
		if(this.tipos>this.contador+1)
		{
			this.ventana.cambiarArray(eltipo.getText());
			eltipo.setText("");
			contador+=1;
		}
		else if(this.tipos>this.contador)
		{
			this.ventana.cambiarArray(eltipo.getText());
			eltipo.setText("");
			siguiente.setActionCommand( OK );
			contador+=1;
		}
		else if(comando.equals(OK))
		{
			contador+=1;
			this.ventana.cambiarArray(eltipo.getText());
			eltipo.setText("");
			this.ventana.cambiarProyecto();
			this.ventana.pasoAHomeProy();
			dispose();
		}
		
	}

}
