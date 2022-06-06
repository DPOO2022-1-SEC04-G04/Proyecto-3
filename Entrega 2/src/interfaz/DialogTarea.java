package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogTarea extends JDialog implements ActionListener
{
	private JButton bBorrar;
	private Interfaz ventana;
	private JComboBox elTarea;
	private JLabel lescoger;
	private ArrayList<String> lasTareas;
	private final static String OK = "OK";
	
	public DialogTarea(Interfaz ventana1)
	{
		
		this.ventana = ventana1;
		setLayout(null);
		setSize(200, 500);
		setResizable( false );
		
		lescoger = new JLabel();
		lescoger.setText("Escoger");
		add(lescoger);
		lescoger.setBounds(10,10,170,30);
		this.lasTareas = this.ventana.sacarTareas();
		String taareas[] = new String[lasTareas.size()];
		for(int i = 0; i<lasTareas.size(); i++)
		{
			taareas[i] = lasTareas.get(i);
		}
		elTarea = new JComboBox(taareas);
		add(elTarea);
		elTarea.setBounds(20,310,180,30);
		
		bBorrar = new JButton("Continuar");
		add(bBorrar);
		bBorrar.setActionCommand( OK );
		bBorrar.setBounds(10,360,170,30);
		bBorrar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = bBorrar.getActionCommand();
		if(comando.equals(OK))
		{
			String tarea = this.lasTareas.get(elTarea.getSelectedIndex());
			
			this.ventana.pasoAHomeActi(tarea);
			
			dispose();
		}
	}

}
