package interfaz;

import javax.swing.JDialog;

import java.awt.Component;
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

public class DialogCambiarFecha extends JDialog implements ActionListener
{
	private Interfaz ventana;
	private String idTarea;
	
	private final static String OK = "OK";
	private JButton bCambiar;
	private JComboBox elParti;
	private JLabel lFechaf;
	private JTextField tfDiaFin;
	private JLabel lSlashTres;
	private JTextField tfMesFin;
	private JLabel lSlashCuatro;
	private JTextField tfAnioFin;
	
	
	public DialogCambiarFecha(Interfaz interfaz, String repartes) {
		// TODO Auto-generated constructor stub
		this.ventana = interfaz;
		this.idTarea = repartes;
		setLayout(null);
		setSize(400, 800);
		setResizable( false );
		
		lFechaf = new JLabel();
        lFechaf.setText("Fecha Final");
        add(lFechaf);
        lFechaf.setBounds(10, 410, 100, 50);
        
        tfDiaFin = new JTextField( 10);
        add(tfDiaFin);
        tfDiaFin.setBounds(130, 420, 40, 30);
        
        
        lSlashTres = new JLabel();
        lSlashTres.setText("/");
        add(lSlashTres);
        lSlashTres.setBounds(190, 410, 20, 50);
        
        
        tfMesFin = new JTextField( 10);
        add(tfMesFin);
        tfMesFin.setBounds(220, 420, 40, 30);
        
        
        lSlashCuatro = new JLabel();
        lSlashCuatro.setText("/");
        add(lSlashCuatro);
        lSlashCuatro.setBounds(280, 410, 20, 50);
        
        
        tfAnioFin = new JTextField( 10);
        add(tfAnioFin);
        tfAnioFin.setBounds(310, 420, 70, 30);
        
        
        
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
			LocalDate fechafinal = LocalDate.of(Integer.parseInt(tfAnioFin.getText()), Integer.parseInt(tfMesFin.getText()), Integer.parseInt(tfDiaFin.getText()));
			this.ventana.cambiarFechaTarea(fechafinal, idTarea);
			dispose();
		}
	}

}
