package interfaz;



import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogNewTarea extends JDialog implements ActionListener
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
	private ArrayList<String> losTipos;
	private JComboBox elTipo;
	private final static String OK = "OK";
	
	public DialogNewTarea(Interfaz ventana1)
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
		
		this.losTipos = this.ventana.sacarTipos();
		String tiposs[] = new String[losTipos.size()];
		for(int i = 0; i<losTipos.size(); i++)
		{
			tiposs[i] = losTipos.get(i);
		}
		elTipo = new JComboBox(tiposs);
		add(elTipo);
		elTipo.setBounds(20,350,150,30);
		
		bAniadir = new JButton("Aniadir");
		add(bAniadir);
		bAniadir.setActionCommand( OK );
		bAniadir.setBounds(10,400,170,30);
		bAniadir.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = bAniadir.getActionCommand();
		
		if(comando.equals(OK))
		{
			String padre = this.losPacks.get(elPack.getSelectedIndex());
			String typee = this.losTipos.get(elTipo.getSelectedIndex());
			this.ventana.aniadirTarea(tfNombre.getText(),tfdescrip.getText(), padre, tfiden.getText(), typee);
			//this.ventana.pasoAHomeProy();
			dispose();
		}
	}

}
