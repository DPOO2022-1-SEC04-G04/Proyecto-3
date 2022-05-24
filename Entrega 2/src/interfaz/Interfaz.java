package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.UIManager;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import model.Participante;
import model.Proyecto;

//import uniandes.dpoo.taller4.interfaz.InterfazJuego;

import java.io.BufferedReader; 
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets; 
import java.nio.file.Files; 
import java.nio.file.Path; 
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Collection;
import java.util.HashMap;


public class Interfaz extends JFrame
{
	private Proyecto proyecto;
	private ArrayList<String> tiposArray;
	
	private PanelInicio panelInicio;
	private PanelCrearProyecto panelCrearProyecto;
	private PanelHomeProyecto panelHomeProyecto;
	private PanelHomeActi panelHomeActi;
	private PanelCrearNormal panelCrearNormal;
	private PanelCrearCrono panelCrearCrono;
	private PanelModifi panelModi;
	private PanelVisualizacion panelVisual;
	private JScrollPane scroll;
	private HashMap<LocalDate, String> lasfechas;
	
	
	
	public Interfaz() throws ClassNotFoundException, IOException
	{
		try
		{
			this.proyecto = Proyecto.readIn();
			this.tiposArray = this.proyecto.getTiposActividad();
			lasfechas = this.proyecto.sacarFechas();
		}
		catch (FileNotFoundException e)
		{
			this.proyecto = null;
			this.tiposArray = new ArrayList<String>();
			lasfechas = new HashMap<LocalDate, String>();
		}
		setSize( 400, 800 );
		setResizable( false );
        setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		
        panelCrearProyecto = new PanelCrearProyecto(this);
		add( panelCrearProyecto);
		panelCrearProyecto.setBounds(0, 0, 400, 800);
		panelCrearProyecto.setVisible(false);
		
		panelCrearNormal = new PanelCrearNormal(this);
		add( panelCrearNormal);
		panelCrearNormal.setBounds(0, 0, 400, 800);
		panelCrearNormal.setVisible(false);

		panelCrearCrono = new PanelCrearCrono(this);
		add( panelCrearCrono);
		panelCrearCrono.setBounds(0, 0, 400, 800);
		panelCrearCrono.setVisible(false);
		
		panelModi = new PanelModifi(this);
		add( panelModi);
		panelModi.setBounds(0, 0, 400, 800);
		panelModi.setVisible(false);
		
		panelVisual = new PanelVisualizacion(this, lasfechas);
		//add( panelVisual);
		//panelVisual.add(scroll);
		//panelVisual.setBounds(0, 0, 400, 800);
		//panelVisual.setVisible(false);
		
		
		
		scroll = new JScrollPane( );
        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );
		scroll.setViewportView(panelVisual);
		add(scroll);
		scroll.setBounds(0, 0, 390, 790);
		scroll.setVisible(false);
		
		panelHomeActi = new PanelHomeActi(this);
		add( panelHomeActi);
		panelHomeActi.setBounds(0, 0, 400, 800);
		panelHomeActi.setVisible(false);
		
		panelHomeProyecto = new PanelHomeProyecto(this);
		add( panelHomeProyecto);
		panelHomeProyecto.setBounds(0, 0, 400, 800);
		panelHomeProyecto.setVisible(false);
        
        panelInicio = new PanelInicio(this);
		add( panelInicio);
		panelInicio.setBounds(0, 0, 400, 800);
		panelInicio.setVisible(true);
		
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent e)
			{
				if (proyecto != null)
				{
					try {
						Proyecto.writeOut(proyecto);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		
	}
	
	


	public void pasoACrear()
	{
		panelInicio.setVisible(false);
		panelHomeProyecto.setVisible(false);
		panelCrearProyecto.setVisible(true);
		panelCrearCrono.setVisible(false);
		panelModi.setVisible(false);
		
	}
	
	public static void main( String[] pArgs )
    {
        try
        {
            UIManager.setLookAndFeel( UIManager.getCrossPlatformLookAndFeelClassName() );

            Interfaz interfaz = new Interfaz();
            interfaz.setVisible( true );
        }
        catch( Exception e )
        {
            e.printStackTrace( );
        }
    }
	

	public void cambiarArray(String elnuevo)
	{
		this.tiposArray.add(elnuevo);
	}


	public void pasoAHomeProy() 
	{
		panelInicio.setVisible(false);
		panelCrearProyecto.setVisible(false);
		panelCrearCrono.setVisible(false);
		panelHomeActi.setVisible(false);
		panelCrearNormal.setVisible(false);
		panelModi.setVisible(false);
		panelHomeProyecto = new PanelHomeProyecto(this);
		add( panelHomeProyecto);
		panelHomeProyecto.setBounds(0, 0, 400, 800);
		panelHomeProyecto.setVisible(true);
		
	}




	public void cambiarProySinFin(String nombre, String descripcion, String nombreDuenio, String correoDuenio, LocalDate fechaInicio)
	{
		this.proyecto = new Proyecto(nombre, descripcion, nombreDuenio, correoDuenio, fechaInicio, this.tiposArray);
	}
	
	public void cambiarProyConFin(String nombre, String descripcion, String nombreDuenio, String correoDuenio, LocalDate fechaInicio, LocalDate fechaFin)
	{
		this.proyecto = new Proyecto(nombre, descripcion, nombreDuenio, correoDuenio, fechaInicio, fechaFin, this.tiposArray);
	}




	public void mostrarDialogTipos(int cuantos)
	{
		DialogoTipos dialogoTipos = new DialogoTipos(this,cuantos);
		dialogoTipos.setVisible(true);
	}




	public String sacarNombre() {
		// TODO Auto-generated method stub
		
		return this.proyecto.getNombre();
	}
	
	public String sacarDescripcion() {
		// TODO Auto-generated method stub
		
		return this.proyecto.getDescripcion();
	}




	public void resetearArray() {
		// TODO Auto-generated method stub
		tiposArray = new ArrayList<String>();
	}




	public void cambiarProyecto() {
		// TODO Auto-generated method stub
		panelCrearProyecto.cambiarProyecto();
		
	}




	public void aniadirParticipante(String nombre, String correo) {
		// TODO Auto-generated method stub
		proyecto.aniadirParticipante(nombre, correo);
	}




	public void mostrarDialogParti() {
		// TODO Auto-generated method stub
		DialogoAgregarParticipante dialogParti = new DialogoAgregarParticipante(this);
		dialogParti.setVisible(true);
	}




	public void pasoAHomeActi() {
		// TODO Auto-generated method stub
		panelInicio.setVisible(false);
		panelCrearProyecto.setVisible(false);
		panelCrearCrono.setVisible(false);
		panelHomeProyecto.setVisible(false);
		panelCrearNormal.setVisible(false);
		panelHomeActi.setVisible(true);
		//panelHomeProyecto = new PanelHomeProyecto(this);
		
	}




	public ArrayList<String> sacarTipos() {
		// TODO Auto-generated method stub
		return proyecto.getTiposActividad();
	}




	public ArrayList<String> sacarPartis() {
		// TODO Auto-generated method stub
		return proyecto.getParticipantesString();
	}




	public void pasoACrearActi() {
		// TODO Auto-generated method stub
		panelInicio.setVisible(false);
		panelCrearProyecto.setVisible(false);
		panelCrearCrono.setVisible(false);

		panelHomeProyecto.setVisible(false);
		panelHomeActi.setVisible(false);
		panelCrearNormal.setVisible(true);
	}




	public void crearActividad(String titulo, String descripcion, int indexTipo, int indexParti, String hora, String minuto) {
		// TODO Auto-generated method stub
		Participante autor = this.proyecto.getParticipantes().get(indexParti);
		LocalTime horaFin = LocalTime.now();
		int horaInicio = Integer.parseInt(hora);
		int minutoInicio = Integer.parseInt(minuto);
		LocalTime inicioFormat = LocalTime.of(horaInicio, minutoInicio);
		LocalDate fechainicial = LocalDate.now();
		String tipo_seleccionado = this.proyecto.getTiposActividad().get(indexTipo);
		proyecto.crearActividad(titulo, descripcion, tipo_seleccionado, autor, fechainicial, inicioFormat, horaFin);
	}




	public void pasoACrearCrono() {
		// TODO Auto-generated method stub
		panelInicio.setVisible(false);
		panelCrearProyecto.setVisible(false);
		
		panelHomeProyecto.setVisible(false);
		panelHomeActi.setVisible(false);
		panelCrearNormal.setVisible(false);
		
		panelCrearCrono.setVisible(true);
	}




	public void crearActiCrono(String titulo, String descripcion, int indexTipo, int indexParti, LocalTime horainicialll, LocalTime horafinal, int duracion) {
		// TODO Auto-generated method stub
		Participante autor = this.proyecto.getParticipantes().get(indexParti);
		LocalDate fechainicial = LocalDate.now();
		String tipo_seleccionado = this.proyecto.getTiposActividad().get(indexTipo);
		proyecto.crearActividad(titulo, descripcion, tipo_seleccionado, autor, fechainicial, horainicialll, horafinal, duracion);
	}




	public ArrayList<String> sacarActis() {
		// TODO Auto-generated method stub
		return proyecto.getActividadesString();
	}




	public void mostrarDialogFecha(int selectedIndex) {
		// TODO Auto-generated method stub
		DialogFecha dialogFecha = new DialogFecha(this, selectedIndex);
		dialogFecha.setVisible(true);
	}




	public void cambiarFecha(LocalDate fechaNueva, int indexActi) {
		// TODO Auto-generated method stub
		proyecto.modificarFechaActividad(indexActi+1, fechaNueva);
	}




	public void pasoAModificar() {
		// TODO Auto-generated method stub
		panelInicio.setVisible(false);
		panelCrearProyecto.setVisible(false);
		
		panelHomeProyecto.setVisible(false);
		panelHomeActi.setVisible(false);
		panelCrearNormal.setVisible(false);
		
		panelCrearCrono.setVisible(false);
		panelModi.setVisible(true);
	}




	public void mostrarDialogHoraIni(int selectedIndex) {
		// TODO Auto-generated method stub
		DialogHoraInicio dialogHoraInicio = new DialogHoraInicio(this, selectedIndex);
		dialogHoraInicio.setVisible(true);
	}




	public void cambiarHoraInicial(LocalTime horanueva, int indexActi) {
		// TODO Auto-generated method stub
		proyecto.modificarHoraInicioActividad(indexActi+1, horanueva);
	}




	public void mostrarDialogHoraFin(int selectedIndex) {
		// TODO Auto-generated method stub
		DialogHoraFin dialogHoraFin = new DialogHoraFin(this, selectedIndex);
		dialogHoraFin.setVisible(true);
	}




	public void cambiarHoraFin(LocalTime horanueva, int indexActi) {
		proyecto.modificarHoraFinActividad(indexActi+1, horanueva);
	}




	public void mostrarDialogParti(int selectedIndex) {
		// TODO Auto-generated method stub
		DialogCambiParti dialogParti = new DialogCambiParti(this, selectedIndex);
		dialogParti.setVisible(true);
	}




	public void cambiarPartici(int selectedIndex, int indexActi) {
		// TODO Auto-generated method stub
		proyecto.modificarParticipanteActividad(indexActi+1, selectedIndex+1);
		
	}




	public void pasoAVisualizacion() {
		lasfechas = proyecto.sacarFechas();
		
		// TODO Auto-generated method stub
		panelInicio.setVisible(false);
		panelCrearProyecto.setVisible(false);
		panelHomeProyecto.setVisible(false);
		panelHomeActi.setVisible(false);
		panelCrearNormal.setVisible(false);
		panelCrearCrono.setVisible(false);
		panelModi.setVisible(false);
		//panelVisual.setVisible(true);
		scroll.setVisible(true);
		
		
	}
	
}