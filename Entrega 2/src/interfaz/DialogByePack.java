package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogByePack extends JDialog implements ActionListener
{
	private JButton bBorrar;
	private Interfaz ventana;
	private JComboBox elPack;
	private JLabel lescoger;
	private ArrayList<String> losPacks;
	private final static String OK = "OK";
	
	public DialogByePack(Interfaz ventana1)
	{
		
		this.ventana = ventana1;
		setLayout(null);
		setSize(200, 500);
		setResizable( false );
		
		lescoger = new JLabel();
		lescoger.setText("Escoger");
		add(lescoger);
		lescoger.setBounds(10,10,170,30);
		this.losPacks = this.ventana.sacarPacks();
		String packks[] = new String[losPacks.size()];
		for(int i = 0; i<losPacks.size(); i++)
		{
			packks[i] = losPacks.get(i);
		}
		elPack = new JComboBox(packks);
		add(elPack);
		elPack.setBounds(20,310,180,30);
		
		bBorrar = new JButton("Eliminar");
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
			String padre = this.losPacks.get(elPack.getSelectedIndex());
			String idDepurado = "";
			String partesid[] = padre.split("-");
			idDepurado = partesid[0];
			this.ventana.borrarPaquete(idDepurado);
			//this.ventana.pasoAHomeProy();
			dispose();
		}
	}

}
