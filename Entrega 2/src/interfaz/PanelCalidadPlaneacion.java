package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelCalidadPlaneacion extends JPanel {
	
	private Interfaz ventana;
	//{terminadas, tareas, tiempoEnds, tiempototal}
	private int terminadas;
	private int tareas;
	private int tiempoEnds;
	private int tiempototal;
	private JLabel cantidades;
	private JLabel tiempos;
	private ArrayList<Integer> estimas;
	private ArrayList<Integer> reales;
	private ArrayList<String> tipos;
	private int tiemporeal;
	private int tiempoestima;

	public PanelCalidadPlaneacion(Interfaz pventana)
	{
		ventana = pventana;
        setPreferredSize( new Dimension( 400, 800) );
        setBackground(new Color(121, 250, 234));
        Toolkit t=Toolkit.getDefaultToolkit();
        estimas = ventana.sacarTiemposEstimados();

        reales = ventana.sacarTiemposReales();
        
        tipos = ventana.sacarTiposEnOrden();
        
        tiemporeal = ventana.sacarTotalReal();
        tiempoestima = ventana.sacarTotalEstima();
        
               

	}
	public void paint(Graphics g)
	{
		Graphics2D g2d = (Graphics2D) g;
		g2d.setColor(new Color(250, 156, 121));
		g2d.fillRect(0, 0, getWidth(), getHeight());
		g2d.setColor(new Color(255, 255, 255));
		g2d.fillRect(10, 80, 300, 300 );
		g2d.setColor(new Color(0, 0, 0));
		g2d.fillRect(10, 280, 330, 130 );
		g2d.drawString("Bienvenidx a "+this.ventana.sacarNombre(), 10, 10);
		g2d.drawString("PRIMERA VISUALIZACION: ", 10, 30);
		g2d.drawString("TIEMPO REAL DE LAS TAREAS VS ESTIMADO:"	
		+ String.valueOf(tiemporeal)+"/"+String.valueOf(tiempoestima), 10, 50);

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