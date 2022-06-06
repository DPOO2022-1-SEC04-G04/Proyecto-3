package interfaz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogNewPack extends JDialog implements ActionListener
{
	private JLabel lnombre;
	private JTextField tfNombre;
	private JLabel ldescrip;
	private JTextField tfdescrip;
	private JButton bAniadir;
	private Interfaz ventana;
	private JComboBox elPack;
	private JLabel liden;
	private JTextField tfiden;
	private ArrayList<String> losPacks;
	private final static String OK = "OK";
	
	public DialogNewPack(Interfaz ventana1)
	{
		
		this.ventana = ventana1;
		setLayout(null);
		setSize(200, 500);
		setResizable( false );
		
		lnombre = new JLabel();
		lnombre.setText("Ingrese el nombre");
		add(lnombre);
		lnombre.setBounds(10,10,170,30);
		
		tfNombre = new JTextField( 16);
		add(tfNombre);
		tfNombre.setBounds(10,60,170,30);
		
		ldescrip = new JLabel();
		ldescrip.setText("Ingrese la descripcion");
		add(ldescrip);
		ldescrip.setBounds(10,110,170,30);

		tfdescrip = new JTextField( 16);
		add(tfdescrip);
		tfdescrip.setBounds(10,160,170,30);
		
		liden = new JLabel();
		liden.setText("Ingrese el nuevo id");
		add(liden);
		liden.setBounds(10,210,170,30);

		tfiden = new JTextField( 16);
		add(tfiden);
		tfiden.setBounds(10,260,170,30);
		
		this.losPacks = this.ventana.sacarPacks();
		String packks[] = new String[losPacks.size()];
		for(int i = 0; i<losPacks.size(); i++)
		{
			packks[i] = losPacks.get(i);
		}
		elPack = new JComboBox(packks);
		add(elPack);
		elPack.setBounds(20,310,180,30);
		
		bAniadir = new JButton("Aniadir");
		add(bAniadir);
		bAniadir.setActionCommand( OK );
		bAniadir.setBounds(10,360,170,30);
		bAniadir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = bAniadir.getActionCommand();
		
		if(comando.equals(OK))
		{
			String padre = this.losPacks.get(elPack.getSelectedIndex());
			
			this.ventana.aniadirPaquete(tfNombre.getText(),tfdescrip.getText(), padre, tfiden.getText());
			//this.ventana.pasoAHomeProy();
			dispose();
		}
	}

}
