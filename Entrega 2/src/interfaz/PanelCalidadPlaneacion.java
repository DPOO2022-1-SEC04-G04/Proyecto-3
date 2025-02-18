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
		//g2d.fillRect(10, 480, 330, 130 );
		g2d.drawString("Bienvenidx a "+this.ventana.sacarNombre(), 10, 10);
		g2d.drawString("TERCERA VISUALIZACION: ", 10, 30);
		g2d.drawString("TIEMPO REAL DE LAS TAREAS VS ESTIMADO:"	
		+ String.valueOf(tiemporeal)+"/"+String.valueOf(tiempoestima), 10, 50);
		g2d.drawString("Real ", 50, 70);
		g2d.drawString("Estimado ", 170, 70);
		g2d.drawString("ANALISIS DE TIPOS ", 20, 440);
		for (int i =0; i<tipos.size(); i++)
		{
			g2d.drawString(tipos.get(i)+"||tiempo real:"+String.valueOf(reales.get(i))
			+"||tiempo estimado:"+String.valueOf(estimas.get(i)), 20, (450+(i*10)));
			
		}
		//double numero = ((double)terminadas/tareas)*300;
		//int num = (int)numero;
		g2d.setColor(new Color(121, 250, 234));
		if(tiemporeal>tiempoestima)
		{
			g2d.fillRect(50, 80, 70, 280 );
			double numer = ((double)tiempoestima/tiemporeal)*280;
			int numo = (int)numer;
			g2d.setColor(new Color(43, 63, 174));
			g2d.fillRect(170, 80, 70, numo );
		}
		else
		{
			g2d.fillRect(170, 80, 70, 280 );
			double numer = ((double)tiemporeal/tiempoestima)*280;
			int numo = (int)numer;
			g2d.setColor(new Color(43, 63, 174));
			g2d.fillRect(50, 80, 70, numo );
		}	
		//g2d.fillRect(20, 90, num, 100 );
		double numeroo = ((double)tiempoEnds/tiempototal)*300;
		
		g2d.setColor(new Color(121, 250, 234));
		//g2d.fillRect(20, 290, numo, 100 );
	}
}