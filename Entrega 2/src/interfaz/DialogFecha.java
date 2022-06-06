package interfaz;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DialogFecha extends JDialog implements ActionListener
{
	private JLabel lfechai;
	private JLabel lslashuno;
	private JLabel lslashdos;
	
	private JTextField tfDia;
	private JTextField tfMes;
	private JTextField tfAnio;
	
	private String idActi;
	
	
	private JButton bCambiar;
	private Interfaz ventana;
	private final static String OK = "OK";
	
	public DialogFecha(Interfaz ventana1, String repartes)
	{
		this.ventana = ventana1;
		this.idActi = repartes;
		setLayout(null);
		setSize(400, 800);
		setResizable( false );
		
		lfechai = new JLabel();
        lfechai.setText("Fecha Inicial");
        add(lfechai);
        lfechai.setBounds(10, 330, 100, 50);
        
        tfDia = new JTextField( 10);
        add(tfDia);
        tfDia.setBounds(130, 340, 40, 30);
        
        lslashuno = new JLabel();
        lslashuno.setText("/");
        add(lslashuno);
        lslashuno.setBounds(190, 330, 20, 50);
        
        tfMes = new JTextField( 10);
        add(tfMes);
        tfMes.setBounds(220, 340, 40, 30);
        
        lslashdos = new JLabel();
        lslashdos.setText("/");
        add(lslashdos);
        lslashdos.setBounds(280, 330, 20, 50);
        
        tfAnio = new JTextField( 10);
        add(tfAnio);
        tfAnio.setBounds(310, 340, 70, 30);
        
		
		bCambiar = new JButton("Cambiar");
		add(bCambiar);
		bCambiar.setActionCommand( OK );
		bCambiar.setBounds(10,510,170,30);
		bCambiar.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = bCambiar.getActionCommand();
		
		if(comando.equals(OK))
		{
			LocalDate fechafinal = LocalDate.of(Integer.parseInt(tfAnio.getText()), Integer.parseInt(tfMes.getText()), Integer.parseInt(tfDia.getText()));
			this.ventana.cambiarFecha(fechafinal, idActi);
			this.ventana.pasoAHomeProy();
			dispose();
		}
	}

}