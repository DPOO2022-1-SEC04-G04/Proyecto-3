package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelAvanceVisual extends JPanel {
	
	private Interfaz ventana;
	//{terminadas, tareas, tiempoEnds, tiempototal}
	private int terminadas;
	private int tareas;
	private int tiempoEnds;
	private int tiempototal;
	private JLabel cantidades;
	private JLabel tiempos;

	public PanelAvanceVisual(Interfaz pventana)
	{
		ventana = pventana;
        setPreferredSize( new Dimension( 400, 800) );
        setBackground(new Color(121, 250, 234));
        Toolkit t=Toolkit.getDefaultToolkit();
        int numeros[] = ventana.sacarDatosGenerales();
        terminadas = numeros[0];
        tareas  = numeros[1];
        tiempoEnds = numeros[2];
        tiempototal  = numeros[3];
        cantidades = new JLabel();
        cantidades.setText("Bienvenidx a "+this.ventana.sacarNombre()
        					+ "PRIMERA VISUALIZACION: NUMERO DE TAREAS COMPLETADAS VS TOTALES:"
        					+ String.valueOf(terminadas)+"/"+String.valueOf(tareas));
        add(cantidades);
        cantidades.setBounds(10, 10, 300, 50);
        
        tiempos = new JLabel();
        tiempos.setText("\n SEGUNDA VISUALIZACION: TIEMPOS PLANEADOS DE TAREAS COMPLETADAS VS TOTALES:"
				+ String.valueOf(tiempoEnds)+"/"+String.valueOf(tiempototal));
        add(tiempos);
        tiempos.setBounds(10, 210, 300, 50);
        
        
        
        

	}
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(250, 156, 121));
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillRect(10, 80, 330, 130 );
		g2d.fillRect(10, 280, 330, 130 );
		g2d.drawString("Bienvenidx a "+this.ventana.sacarNombre(), 10, 10);
		g2d.drawString("PRIMERA VISUALIZACION: ", 10, 30);
		g2d.drawString("NUMERO DE TAREAS COMPLETADAS VS TOTALES:"	
		+ String.valueOf(terminadas)+"/"+String.valueOf(tareas), 10, 50);

		g2d.drawString("SEGUNDA VISUALIZACION: ", 10, 240);
		g2d.drawString("TIEMPO DE TAREAS COMPLETADAS VS TOTALES:"	
		+ String.valueOf(tiempoEnds)+"/"+String.valueOf(tiempototal), 10, 260);
		double numero = ((double)terminadas/tareas)*300;
		int num = (int)numero;
		g2d.setColor(new Color(121, 250, 234));
		g2d.fillRect(20, 90, num, 100 );
		double numeroo = ((double)tiempoEnds/tiempototal)*300;
		int numo = (int)numeroo;
		g2d.setColor(new Color(121, 250, 234));
		g2d.fillRect(20, 290, numo, 100 );
	}
}