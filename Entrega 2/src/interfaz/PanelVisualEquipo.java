package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class PanelVisualEquipo extends JPanel {
	
	private Interfaz ventana;
	private int numFinDuenio;
	private int numIncDuenio;
	private ArrayList<Integer> sinfin;
	private ArrayList<Integer> confin;
	private ArrayList<String> partis;
	private int tiemporeal;
	private int tiempoestima;

	public PanelVisualEquipo(Interfaz pventana)
	{
		ventana = pventana;
        setPreferredSize( new Dimension( 400, 800) );
        setBackground(new Color(121, 250, 234));
        Toolkit t=Toolkit.getDefaultToolkit();
        confin = ventana.sacarTerminPartis();

        sinfin = ventana.sacarSinFinPartis();
        
        partis = ventana.sacarPartis();
        
        numFinDuenio = confin.get(0);
        numIncDuenio = sinfin.get(0);
        
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
		g2d.drawString("CUARTA VISUALIZACION: ", 10, 30);
		g2d.drawString("ANALSIS DEL DUENIO:", 10, 50);
		g2d.drawString("Totales ", 50, 70);
		g2d.drawString("Completadas ", 170, 70);
		g2d.drawString("ANALISIS DE TODOS LOS PARTICIPANTES ", 20, 440);
		for (int i =0; i<partis.size(); i++)
		{
			g2d.drawString(partis.get(i), 20, (450+(i*20)));
			g2d.drawString("||tareas terminadas:"+String.valueOf(confin.get(i))+"||tareas totales:"
						+String.valueOf(sinfin.get(i)), 20, (460+(i*20)));
			//"||tiempo real:"+String.valueOf(sinfin.get(i))+"||tiempo estimado:"+String.valueOf(confin.get(i))
		}
		//double numero = ((double)terminadas/tareas)*300;
		//int num = (int)numero;
		g2d.setColor(new Color(121, 250, 234));
		if(numIncDuenio>numFinDuenio)
		{
			g2d.fillRect(50, 80, 70, 280 );
			double numer = ((double)numFinDuenio/numIncDuenio)*280;
			int numo = (int)numer;
			g2d.setColor(new Color(43, 63, 174));
			g2d.fillRect(170, 80, 70, numo );
		}
		else
		{
			g2d.fillRect(170, 80, 70, 280 );
			double numer = ((double)numIncDuenio/numFinDuenio)*280;
			int numo = (int)numer;
			g2d.setColor(new Color(43, 63, 174));
			g2d.fillRect(50, 80, 70, numo );
		}	
		//g2d.fillRect(20, 90, num, 100 );
		//double numeroo = ((double)tiempoEnds/tiempototal)*300;
		
		g2d.setColor(new Color(121, 250, 234));
		//g2d.fillRect(20, 290, numo, 100 );
	}
}