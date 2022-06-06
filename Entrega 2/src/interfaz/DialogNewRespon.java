package interfaz;

import javax.swing.JDialog;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogNewRespon extends JDialog implements ActionListener
{
	private Interfaz ventana;
	private String idTarea;
	
	private final static String OK = "OK";
	private JButton bCambiar;
	private JTextField tfHora;
	private JTextField tfMinutos;
	private JLabel lPartis;
	private JComboBox elParti;
	
	
	public DialogNewRespon(Interfaz interfaz, String repartes) {
		// TODO Auto-generated constructor stub
		this.ventana = interfaz;
		this.idTarea = repartes;
		setLayout(null);
		setSize(400, 800);
		setResizable( false );
		
		lPartis = new JLabel();
        lPartis.setText("Escoja el participante");
        add(lPartis);
        lPartis.setBounds(10, 290, 100, 30);
        
        ArrayList<String> losPartis = this.ventana.sacarPartis();
		String partis[] = new String[losPartis.size()];
		for(int i = 0; i<losPartis.size(); i++)
		{
			partis[i] = losPartis.get(i);
		}
		elParti = new JComboBox(partis);
		add(elParti);
		elParti.setBounds(200,290,150,30);
        
        bCambiar = new JButton("Aniadir");
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
			String partesid[] = idTarea.split("-");
			String idDepurado = partesid[0];
			this.ventana.aniadirRespon(elParti.getSelectedIndex(), idDepurado);
			//this.ventana.pasoAHomeProy();
			dispose();
		}
	}

}
