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
import model.ProyectoException;

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
	private PanelMenuVisual panelMenuVisual;
	private PanelAvanceVisual panelAvanceVisual;
	private JScrollPane scroll;
	private HashMap<LocalDate, String> lasfechas;
	
	
	
	public Interfaz() throws ClassNotFoundException, IOException, ProyectoException
	{
		try
		{
			this.proyecto = Proyecto.readIn();
			File archivo = new File("./data/Paque.txt");
			this.proyecto.cargar(archivo);
			this.proyecto.repartirActis();
			this.proyecto.repartirRespons();
			this.tiposArray = this.proyecto.getTiposActividad();
			lasfechas = this.proyecto.sacarFechas();
			
		}
		catch (FileNotFoundException e)
		{
			ArrayList<String> tipos = new ArrayList<String>();
			tipos.add("docu");
			tipos.add("dise");
			this.proyecto = new Proyecto("prueba", "descripcion", "diego", "diego@gmail.com", LocalDate.of(2021, 11, 11), tipos, "Raiz", "DescripRaiz", "1");
			this.tiposArray = new ArrayList<String>();
			lasfechas = new HashMap<LocalDate, String>();
		}
		catch (ProyectoException e)
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
		
		

		
		
		try {
			panelModi = new PanelModifi(this);
			add( panelModi);
			panelModi.setBounds(0, 0, 400, 800);
			panelModi.setVisible(false);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			//JOptionPane.showMessageDialog(null, "NO HAY Actividades, no se va a poder modificar nada ");
		}
		
		
		try {
			panelVisual = new PanelVisualizacion(this, lasfechas);
			scroll = new JScrollPane( );
	        scroll.setHorizontalScrollBarPolicy( JScrollPane.HORIZONTAL_SCROLLBAR_NEVER );
	        scroll.setVerticalScrollBarPolicy( JScrollPane.VERTICAL_SCROLLBAR_ALWAYS );
	        scroll.setBorder( new CompoundBorder( new EmptyBorder( 3, 3, 3, 3 ), new LineBorder( Color.BLACK, 1 ) ) );
			scroll.setViewportView(panelVisual);
			add(scroll);
			scroll.setBounds(0, 0, 390, 790);
			scroll.setVisible(false);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			//JOptionPane.showMessageDialog(null, "NO SE PUDIERON SACAR FECHAS PORQUE NO HAY ACTIVIDADES");
		}
		//add( panelVisual);
		//panelVisual.add(scroll);
		//panelVisual.setBounds(0, 0, 400, 800);
		//panelVisual.setVisible(false);
		
		
		
		
		
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
		if(panelCrearCrono !=null)
		{
			panelCrearCrono.setVisible(false);
		}
		if(panelAvanceVisual !=null)
		{
			panelAvanceVisual.setVisible(false);
		}
		
		if(panelModi != null)
		{
			panelModi.setVisible(false);
		}
		if(panelMenuVisual != null)
		{
			panelMenuVisual.setVisible(false);
		}
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
		if (panelCrearNormal!=null)
		{
			panelCrearNormal.setVisible(false);
		}
		panelCrearProyecto.setVisible(false);
		if(panelCrearCrono!=null)
		{
			panelCrearCrono.setVisible(false);
		}
		
		panelHomeActi.setVisible(false);
		
		if(panelModi != null)
		{
			panelModi.setVisible(false);
		}	
		if(panelMenuVisual != null)
		{
			panelMenuVisual.setVisible(false);
		}
		if(panelAvanceVisual !=null)
		{
			panelAvanceVisual.setVisible(false);
		}
		panelHomeProyecto = new PanelHomeProyecto(this);
		add( panelHomeProyecto);
		panelHomeProyecto.setBounds(0, 0, 400, 800);
		panelHomeProyecto.setVisible(true);
		
	}




	public void cambiarProySinFin(String nombre, String descripcion, String nombreDuenio, String correoDuenio, LocalDate fechaInicio, String nomraiz, String desraiz, String idraiz)
	{
		try {
			this.proyecto = new Proyecto(nombre, descripcion, nombreDuenio, correoDuenio, fechaInicio, this.tiposArray, nomraiz, desraiz,idraiz);
		} catch (IOException | ProyectoException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error Cargando el nuevo proyecto ");
		}
	}
	
	public void cambiarProyConFin(String nombre, String descripcion, String nombreDuenio, String correoDuenio, LocalDate fechaInicio, LocalDate fechaFin, String nomraiz, String desraiz, String idraiz)
	{
		try {
			this.proyecto = new Proyecto(nombre, descripcion, nombreDuenio, correoDuenio, fechaInicio, fechaFin, this.tiposArray,nomraiz, desraiz, idraiz);
		} catch (IOException | ProyectoException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Error Cargando el nuevo proyecto ");
		}
	}




	public void mostrarDialogTipos(int cuantos)
	{
		DialogoTipos dialogoTipos = new DialogoTipos(this,cuantos);
		dialogoTipos.setVisible(true);
	}
	
	public void mostrarDialogNewPack()
	{
		DialogNewPack dialogNewPack = new DialogNewPack(this);
		dialogNewPack.setVisible(true);
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




	public void pasoAHomeActi(String tarea) {
		// TODO Auto-generated method stub
		panelInicio.setVisible(false);
		panelCrearProyecto.setVisible(false);
		if(panelCrearCrono != null)
		{
			panelCrearCrono.setVisible(false);
		}
		panelHomeProyecto.setVisible(false);
		if(panelCrearNormal !=null)
		{
			panelCrearNormal.setVisible(false);
		}
		if(panelMenuVisual != null)
		{
			panelMenuVisual.setVisible(false);
		}
		if(panelAvanceVisual !=null)
		{
			panelAvanceVisual.setVisible(false);
		}
		
		panelHomeActi.setVisible(true);
		panelHomeActi.setTarea(tarea);
		panelHomeProyecto.setVisible(false);
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




	public void pasoACrearActi(String tareaFull) {
		// TODO Auto-generated method stub
		panelInicio.setVisible(false);
		panelCrearProyecto.setVisible(false);
		if(panelCrearCrono != null)
		{
			panelCrearCrono.setVisible(false);
		}
		panelHomeProyecto.setVisible(false);
		panelHomeActi.setVisible(false);
		panelCrearNormal = new PanelCrearNormal(this, tareaFull);
		add( panelCrearNormal);
		panelCrearNormal.setBounds(0, 0, 400, 800);
		if(panelMenuVisual != null)
		{
			panelMenuVisual.setVisible(false);
		}
		if(panelAvanceVisual !=null)
		{
			panelAvanceVisual.setVisible(false);
		}

		
		panelCrearNormal.setVisible(true);
		panelCrearNormal.setTarea(tareaFull);
		
	}




	public void crearActividad(String titulo, String descripcion, String elTipo, int indexParti, String hora, String minuto, String idTarea, String idActi, boolean refinal) {
		// TODO Auto-generated method stub
		Participante autor = this.proyecto.getParticipantes().get(indexParti);
		LocalTime horaFin = LocalTime.now();
		int horaInicio = Integer.parseInt(hora);
		int minutoInicio = Integer.parseInt(minuto);
		LocalTime inicioFormat = LocalTime.of(horaInicio, minutoInicio);
		LocalDate fechainicial = LocalDate.now();
		proyecto.crearActividad(titulo, descripcion, elTipo, autor, fechainicial, inicioFormat, horaFin, idTarea, idActi, refinal);
	}




	public void pasoACrearCrono(String tareaFull) {
		// TODO Auto-generated method stub
		panelInicio.setVisible(false);
		panelCrearProyecto.setVisible(false);
		
		panelHomeProyecto.setVisible(false);
		panelHomeActi.setVisible(false);
		if(panelCrearNormal != null)
		{
			panelCrearNormal.setVisible(false);
		}
		if(panelMenuVisual != null)
		{
			panelMenuVisual.setVisible(false);
		}
		if(panelAvanceVisual !=null)
		{
			panelAvanceVisual.setVisible(false);
		}
		panelCrearCrono = new PanelCrearCrono(this, tareaFull);
		add( panelCrearCrono);
		panelCrearCrono.setBounds(0, 0, 400, 800);
		
		panelCrearCrono.setVisible(true);
		panelCrearCrono.setTarea(tareaFull);
	}




	public void crearActiCrono(String titulo, String descripcion, String eltipo, int indexParti, LocalTime horainicialll, LocalTime horafinal, int duracion, String padre, String nuevo, boolean finaliza) {
		// TODO Auto-generated method stub
		Participante autor = this.proyecto.getParticipantes().get(indexParti);
		LocalDate fechainicial = LocalDate.now();
		proyecto.crearActividad(titulo, descripcion, eltipo, autor, fechainicial, horainicialll, horafinal, duracion, padre, nuevo, finaliza);
	}




	public ArrayList<String> sacarActis() {
		// TODO Auto-generated method stub
		return proyecto.getActividadesString();
	}




	public void mostrarDialogFecha(String repartes) {
		// TODO Auto-generated method stub
		DialogFecha dialogFecha = new DialogFecha(this, repartes);
		dialogFecha.setVisible(true);
	}




	public void cambiarFecha(LocalDate fechaNueva, String idActi) {
		// TODO Auto-generated method stub
		proyecto.modificarFechaActividad(idActi, fechaNueva);
	}




	public void pasoAModificar(String tareaFull) {
		// TODO Auto-generated method stub
		panelInicio.setVisible(false);
		panelCrearProyecto.setVisible(false);
		
		panelHomeProyecto.setVisible(false);
		panelHomeActi.setVisible(false);
		if(panelCrearNormal !=null)
		{
			panelCrearNormal.setVisible(false);
		}
		if(panelCrearCrono !=null)
		{
			panelCrearCrono.setVisible(false);
		}
		if(panelMenuVisual != null)
		{
			panelMenuVisual.setVisible(false);
		}
		if(panelAvanceVisual !=null)
		{
			panelAvanceVisual.setVisible(false);
		}
		
		if(panelModi != null)
		{
			panelModi.setVisible(true);
			panelModi.setTarea(tareaFull);
		}
		else
		{
			try {
				panelModi = new PanelModifi(this, tareaFull);
				add( panelModi);
				panelModi.setBounds(0, 0, 400, 800);
				panelModi.setVisible(true);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}




	public void mostrarDialogHoraIni(String repartes) {
		// TODO Auto-generated method stub
		DialogHoraInicio dialogHoraInicio = new DialogHoraInicio(this, repartes);
		dialogHoraInicio.setVisible(true);
	}




	public void cambiarHoraInicial(LocalTime horanueva, String idActi) {
		// TODO Auto-generated method stub
		proyecto.modificarHoraInicioActividad(idActi, horanueva);
	}




	public void mostrarDialogHoraFin(String repartes) {
		// TODO Auto-generated method stub
		DialogHoraFin dialogHoraFin = new DialogHoraFin(this, repartes);
		dialogHoraFin.setVisible(true);
	}




	public void cambiarHoraFin(LocalTime horanueva, String idActi) {
		proyecto.modificarHoraFinActividad(idActi, horanueva);
	}




	public void mostrarDialogParti(String repartes) {
		// TODO Auto-generated method stub
		DialogCambiParti dialogParti = new DialogCambiParti(this, repartes);
		dialogParti.setVisible(true);
	}




	public void cambiarPartici(int selectedIndex, String idActi) {
		// TODO Auto-generated method stub
		proyecto.modificarParticipanteActividad(idActi, selectedIndex+1);
		
	}




	public void pasoAVisualizacion() {
		lasfechas = proyecto.sacarFechas();
		
		// TODO Auto-generated method stub
		panelInicio.setVisible(false);
		panelCrearProyecto.setVisible(false);
		panelHomeProyecto.setVisible(false);
		panelHomeActi.setVisible(false);
		if(panelCrearNormal !=null)
		{
			panelCrearNormal.setVisible(false);
		}
		if(panelCrearCrono !=null)
		{
			panelCrearCrono.setVisible(false);
		}
		if(panelMenuVisual != null)
		{
			panelMenuVisual.setVisible(false);
		}
		if(panelModi != null)
		{
			panelModi.setVisible(false);
		}
		if(panelAvanceVisual !=null)
		{
			panelAvanceVisual.setVisible(false);
		}
		//panelVisual.setVisible(true);
		scroll.setVisible(true);
		
		
	}




	public void aniadirPaquete(String nombre, String descrip, String idPadre, String idNuevo) {
		// TODO Auto-generated method stub
		String idDepurado = "";
		String partesid[] = idPadre.split("-");
		idDepurado = partesid[0];
		try {
			this.proyecto.aniadirPaquete(nombre, descrip, idDepurado, idNuevo);
		} catch (ProyectoException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERROR aniadiendo paquete");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERROR aniadiendo paquete");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERROR aniadiendo paquete");
		}
	}




	public ArrayList<String> sacarPacks() {
		ArrayList<String> rta = this.proyecto.getPacks();
		return rta;
	}




	public void aniadirTarea(String nombre, String descrip, String idPadre, String idNuevo, String typee) {
		// TODO Auto-generated method stub
		String idDepurado = "";
		String partesid[] = idPadre.split("-");
		idDepurado = partesid[0];
		try {
			this.proyecto.aniadirTarea(nombre, descrip, idDepurado, idNuevo,typee);
		} catch (ProyectoException | IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERROR aniadiendo paquete");
		}
	}




	public void pasoANewTarea() {
		// TODO Auto-generated method stub
		DialogNewTarea dialogNewTarea = new DialogNewTarea(this);
		dialogNewTarea.setVisible(true);
	}




	public void mostrarDialogTarea() {
		// TODO Auto-generated method stub
		DialogTarea dialogTarea = new DialogTarea(this);
		dialogTarea.setVisible(true);
	}




	public ArrayList<String> sacarTareas() {
		// TODO Auto-generated method stub
		return proyecto.sacarTareas();
	}




	public ArrayList<String> sacarActisTarea(String idDepurado) {
		// TODO Auto-generated method stub
		return proyecto.getActiTareaString(idDepurado);
	}




	public void mostrarCambiarFecha(String tareaFull) {
		// TODO Auto-generated method stub
		DialogCambiarFecha dialogCambiarFecha = new DialogCambiarFecha(this, tareaFull);
		dialogCambiarFecha.setVisible(true);
	}




	public void cambiarFechaTarea(LocalDate fechafinal, String idTarea) {
		// TODO Auto-generated method stub
		try {
			proyecto.cambiarFechaTarea(fechafinal, idTarea);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERROR cambiando fecha");
		}
	}




	public void mostrarAddRespon(String tareaFull) {
		// TODO Auto-generated method stub
		DialogNewRespon dialogNewRespon = new DialogNewRespon(this, tareaFull);
		dialogNewRespon.setVisible(true);
	}




	public void aniadirRespon(int selectedIndex, String idTarea) {
		// TODO Auto-generated method stub
		proyecto.aniadirRespon(selectedIndex, idTarea);
	}




	public ArrayList<String> sacarPartisTarea(String tareafull) {
		// TODO Auto-generated method stub
		String partesid[] = tareafull.split("-");
		String idDepurado = partesid[0];
		return proyecto.sacarPartisTarea(idDepurado);
	}




	public void mostrarExcepcion() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "ERROR: NO hay responsables para las actividades \n aniada primero responsables");
	}




	public void mostrarTiempoPlaneado(String tareaFull) {
		// TODO Auto-generated method stub
		DialogCambiarTiempoTarea dialogCambiarTiempoTarea = new DialogCambiarTiempoTarea(this, tareaFull);
		dialogCambiarTiempoTarea.setVisible(true);
	}




	public void aniadirTiempoTarea(String tiempo, String idDepurado) {
		// TODO Auto-generated method stub
		try {
			this.proyecto.cambiarTimeTarea(tiempo, idDepurado);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "ERROR: NO PUDE CAMBIAR EL TIEMPO");
		}
	}




	public void mostrarByePack() {
		// TODO Auto-generated method stub
		DialogByePack dialogByePack = new DialogByePack(this);
		dialogByePack.setVisible(true);
	}




	public void borrarPaquete(String padre) {
		// TODO Auto-generated method stub
		try {
			proyecto.borrarPack(padre);
		} catch (ProyectoException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "NO SE PUEDE BORRAR PAQUETES CON TAREAS CON ACTIVIDADES");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public void mostrarByeTarea() {
		// TODO Auto-generated method stub
		DialogByeTarea dialogByeTarea = new DialogByeTarea(this);
		dialogByeTarea.setVisible(true);
	}




	public void borrarTarea(String idDepurado) {
		// TODO Auto-generated method stub
		try {
			proyecto.borrarTarea(idDepurado);
		} catch (ProyectoException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "NO SE PUEDE BORRAR TAREAS CON ACTIVIDADES");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




	public void pasoAMenuVisual() {
		// TODO Auto-generated method stub
		
		
		panelMenuVisual = new PanelMenuVisual(this);
		add( panelMenuVisual);
		panelMenuVisual.setBounds(0, 0, 400, 800);

		panelInicio.setVisible(false);
		panelCrearProyecto.setVisible(false);
		panelHomeProyecto.setVisible(false);
		panelHomeActi.setVisible(false);
		if(panelCrearNormal !=null)
		{
			panelCrearNormal.setVisible(false);
		}
		if(panelCrearCrono !=null)
		{
			panelCrearCrono.setVisible(false);
		}
		if(panelModi !=null)
		{
			panelModi.setVisible(false);
		}
		if(panelVisual !=null)
		{
			panelVisual.setVisible(false);
		}
		if(panelAvanceVisual !=null)
		{
			panelAvanceVisual.setVisible(false);
		}
		panelMenuVisual.setVisible(true);
	}




	public int[] sacarDatosGenerales() {
		// TODO Auto-generated method stub
		return proyecto.sacarDatos();
	}




	public void pasoAAvance() {
		// TODO Auto-generated method stub
		panelAvanceVisual = new PanelAvanceVisual(this);
		add( panelAvanceVisual);
		panelAvanceVisual.setBounds(0, 0, 400, 800);

		panelInicio.setVisible(false);
		panelCrearProyecto.setVisible(false);
		panelHomeProyecto.setVisible(false);
		panelHomeActi.setVisible(false);
		if(panelCrearNormal !=null)
		{
			panelCrearNormal.setVisible(false);
		}
		if(panelCrearCrono !=null)
		{
			panelCrearCrono.setVisible(false);
		}
		if(panelModi !=null)
		{
			panelModi.setVisible(false);
		}
		if(panelVisual !=null)
		{
			panelVisual.setVisible(false);
		}
		if(panelMenuVisual !=null)
		{
			panelMenuVisual.setVisible(false);
		}
		
		panelAvanceVisual.setVisible(true);
	}




	public ArrayList<Integer> sacarTiemposEstimados() {
		// TODO Auto-generated method stub
		return proyecto.getTiemposEstimados();
	}




	public ArrayList<Integer> sacarTiemposReales() {
		// TODO Auto-generated method stub
		return proyecto.getTiemposReales();
	}




	public int sacarTotalReal() {
		// TODO Auto-generated method stub
		return proyecto.sacarTotalReal();
	}




	public int sacarTotalEstima() {
		// TODO Auto-generated method stub
		return proyecto.sacarTotalEstima();
	}




	public ArrayList<String> sacarTiposEnOrden() {
		// TODO Auto-generated method stub
		return proyecto.sacarTiposEnOrden();
	}
	
}