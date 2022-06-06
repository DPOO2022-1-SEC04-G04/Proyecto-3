package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;


public class Proyecto implements Serializable
{
	private static final long serialVersionUID = 1L;
	private static final String fileName = "./data/Proyecto.dat";
	
	private String nombre;
	private String descripcion;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Participante duenio;
	private ArrayList<Participante> participantes;
	private ArrayList<String> tiposActividad;
	private ArrayList<Actividad> actividades;
	private Paquete packraiz;
	
	public Proyecto(String nombre, String descripcion, String nombreDuenio, String correoDuenio, LocalDate fechaInicio, LocalDate fechaFin, ArrayList<String> tiposss, String nomraiz, String desraiz, String idraiz) throws IOException, ProyectoException
	{
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.tiposActividad = tiposss;
		Participante duenio = new Participante(nombreDuenio, correoDuenio, this.tiposActividad);
		this.duenio = duenio;
		this.participantes = new ArrayList<>();
		this.participantes.add(duenio);
		this.actividades = new ArrayList<>();
		File packinicial = new File("./data/Paque.txt");
		FileWriter fw = new FileWriter(packinicial);
		fw.write(Paquete.CLASE+";;;"+idraiz+";;;"+nomraiz+";;;"+desraiz+";;;0");
		fw.close();
		cargar(new File("./data/Paque.txt"));
		
	}
	
	public Proyecto(String nombre, String descripcion, String nombreDuenio, String correoDuenio, LocalDate fechaInicio, ArrayList<String> tiposss, String nomraiz, String desraiz, String idraiz) throws IOException, ProyectoException
	{
		this.nombre = nombre;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.tiposActividad = tiposss;
		Participante duenio = new Participante(nombreDuenio, correoDuenio, this.tiposActividad);
		this.duenio = duenio;
		this.participantes = new ArrayList<>();
		this.participantes.add(duenio);
		this.actividades = new ArrayList<>();
		File packinicial = new File("./data/Paque.txt");
		FileWriter fw = new FileWriter(packinicial);
		fw.write(Paquete.CLASE+";;;"+idraiz+";;;"+nomraiz+";;;"+desraiz+";;;0");
		fw.close();
		cargar(new File("./data/Paque.txt"));
		
		
	}
	
	public void cargar( File pArchivo ) throws ProyectoException
    {
        try
        {
            BufferedReader in = new BufferedReader( new FileReader( pArchivo ) );
            packraiz = new Paquete( in.readLine( ), in );
        }
        catch( Exception e )
        {
            e.printStackTrace(  );
            throw new ProyectoException( "Error al leer el archivo.\n" + e.getMessage( ) );

        }
    }
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public String getDescripcion()
	{
		return this.descripcion;
	}
	
	public LocalDate getFechaInicio()
	{
		return this.fechaInicio;
	}
	
	public LocalDate getFechaFin()
	{
		return this.fechaFin;
	}
	
	public String getDuenioString()
	{
		return this.duenio.getNombre() + "  :  " + this.duenio.getCorreo();
	}
	
	public ArrayList<Participante> getParticipantes()
	{
		return this.participantes;
	}
	
	public ArrayList<String> getParticipantesString()
	{
		ArrayList<String> stringParticipantes = new ArrayList<String>();
		for (Participante participante: this.participantes)
		{
			String agregar = participante.getNombre() + "  :  " + participante.getCorreo();
			stringParticipantes.add(agregar);
		}
		return stringParticipantes;
	}
	
	public ArrayList<String> getActividadesString()
	{
		ArrayList<String> stringActividades = new ArrayList<String>();
		for (Actividad actividad: this.actividades)
		{
			String agregar = actividad.getTitulo() + "  :  " + actividad.getDescripcion() + "  ;  AUTOR: " + actividad.getAutor().getNombre() + "  ;  FECHA: " + actividad.getFechaRealizacion();
			stringActividades.add(agregar);
		}
		return stringActividades;
	}
		
	public ArrayList<String> getTiposActividad()
	{
		return this.tiposActividad;
	}
	
	public void aniadirParticipante(String nombre, String correo)
	{
		Participante nuevoP = new Participante(nombre,correo,this.tiposActividad);
		this.participantes.add(nuevoP);
	}
	
	public void crearActividad(String titulo, String descripcion, String tipo_seleccionado, Participante autor,
								LocalDate fechaRealizacion, LocalTime horaInicio, LocalTime horaFin, String idTarea, String idActi, boolean refinal)
	{
		Actividad NuevaA = new Actividad(titulo,descripcion,tipo_seleccionado,autor,fechaRealizacion,horaInicio,horaFin, idTarea, idActi, refinal);
		autor.aniadirActividad(NuevaA);
		this.actividades.add(NuevaA);
		this.packraiz.agregarActi(idTarea, NuevaA);
	}
	
	public void crearActividad(String titulo, String descripcion, String tipo_seleccionado, Participante autor,
			LocalDate fechaRealizacion, LocalTime horaInicio, LocalTime horaFin, int duracion, String padre, String nuevo, boolean finaliza)
	{
		Actividad NuevaA = new Actividad(titulo,descripcion,tipo_seleccionado,autor,fechaRealizacion,horaInicio,horaFin, duracion, padre, nuevo, finaliza);
		autor.aniadirActividad(NuevaA);
		this.actividades.add(NuevaA);
	}
	
	public void modificarFechaActividad(String idActi, LocalDate fechaNueva)
	{
		String padre = "";
		for (Actividad acti : actividades)
		{
			if (acti.getIdPropio().equals(idActi))
			{
				acti.modificarFecha(fechaNueva);
				padre = acti.getPadre();
			}
		}
		System.out.println(this.getActiTareaString(padre));
	}
	
	public void modificarHoraInicioActividad(String idActi, LocalTime horaNueva)
	{
		String padre = "";
		for (Actividad acti : actividades)
		{
			if (acti.getIdPropio().equals(idActi))
			{
				acti.modificarHoraInicio(horaNueva);
				padre = acti.getPadre();
			}
		}
	}
	
	public void modificarHoraFinActividad(String idActi, LocalTime horaNueva)
	{
		String padre = "";
		for (Actividad acti : actividades)
		{
			if (acti.getIdPropio().equals(idActi))
			{
				acti.modificarHoraFin(horaNueva);
				padre = acti.getPadre();
			}
		}
	}

	public void modificarParticipanteActividad(String idActi, int numAutor)
	{
		Participante newAutor = this.participantes.get(numAutor-1);
		String padre = "";
		Actividad acti = null;
		for (Actividad actii : actividades)
		{
			if (actii.getIdPropio().equals(idActi))
			{
				acti = actii;
			}
		}
		if(acti !=null)
		{
			Participante viejo = acti.getAutor();
			acti.modificarAutor(newAutor);
			padre = acti.getPadre();
			newAutor.aniadirActividad(acti);
			viejo.eliminarActividad(acti);
		}
		//Participante newAutor = this.participantes.get(numAutor-1);
		
		
	}

	public String getReporteParticipante(int numParticipante)
	{
		return this.participantes.get(numParticipante-1).getReporte();
	}
	
	public HashMap<LocalDate, String> sacarFechas()
	{
		HashMap<LocalDate, String> rta = new HashMap<LocalDate, String>(); 
		for(Actividad acti: actividades)
		{
			if(!rta.containsKey(acti.getFechaRealizacion()))
			{
				rta.put(acti.getFechaRealizacion(), "X");
			}
			else
			{
				String provisional = rta.get(acti.getFechaRealizacion());
				rta.put(acti.getFechaRealizacion(), provisional+"X");
			}
			
			
		}
		System.out.println(rta);
		return rta;
	}
	
	public static Proyecto readIn() throws IOException, ClassNotFoundException {
	      ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName));
	      Proyecto proyecto = (Proyecto) ois.readObject();
	      ois.close();
	      return proyecto;
	  }
	    
	public static void writeOut(Object proyecto) throws IOException {
	      ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName));
	      oos.writeObject(proyecto);
	      oos.close();
	  }

	public void aniadirPaquete(String nombre2, String descrip, String idPadre, String idNuevo) throws ProyectoException, IOException {
		// TODO Auto-generated method stub
		
		this.packraiz.agregarNodo(idPadre, this.packraiz.darClase(), idNuevo, nombre2, descrip, "");
		this.packraiz.rewritefile();
		
	}

	public ArrayList<String> getPacks() {
		// TODO Auto-generated method stub
		ArrayList<String> rta = new ArrayList<String>();
		rta = this.packraiz.darPaquetesString();
		/*
		String meter = "";
		meter = meter.concat(this.packraiz.darIdentificador());
		meter = meter.concat("-");
		meter = meter.concat(this.packraiz.darNombre());
		meter = meter.concat("-");
		meter = meter.concat(this.packraiz.darDescrip());
		rta.add(meter);*/
		
		return rta;
	}

	public void aniadirTarea(String nombre2, String descrip, String idDepurado, String idNuevo, String typee) throws ProyectoException, IOException {
		// TODO Auto-generated method stub
		this.packraiz.agregarNodo(idDepurado, "Tarea", idNuevo, nombre2, descrip, typee);
		this.packraiz.rewritefile();
	}

	public ArrayList<String> sacarTareas() {
		// TODO Auto-generated method stub
		ArrayList<String> rta = new ArrayList<String>();
		rta = this.packraiz.darTareasString();
		return rta;
	}

	public void repartirActis() {
		// TODO Auto-generated method stub
		if (actividades !=null)
		{
			for(Actividad acti: actividades)
			{
				String idPadre = acti.getPadre();
				this.packraiz.agregarActi(idPadre, acti);
			}
		}
		
	}

	public ArrayList<String> getActiTareaString(String idDepurado) {
		// TODO Auto-generated method stub
		ArrayList<Actividad> soloActividades = this.packraiz.darActis(idDepurado);
		ArrayList<String> stringActividades = new ArrayList<String>(); 
		for (Actividad actividad: soloActividades)
		{
			String agregar = actividad.getTitulo() + "  ;;  " + actividad.getDescripcion() + "  ;;  AUTOR: " + actividad.getAutor().getNombre() + "  ;;  FECHA: " + actividad.getFechaRealizacion()+ ";;"+ actividad.getIdPropio();
			stringActividades.add(agregar);
		}
		return stringActividades;
	}

	public void cambiarFechaTarea(LocalDate fechafinal, String idTarea) throws IOException {
		// TODO Auto-generated method stub
		this.packraiz.setFecha(fechafinal, idTarea);
		this.packraiz.rewritefile();
	}

	public void aniadirRespon(int selectedIndex, String idTarea) {
		// TODO Auto-generated method stub
		Participante newAutor = this.participantes.get(selectedIndex);
		this.packraiz.aniadirRespon(newAutor, idTarea);
	}

	public void repartirRespons() {
		// TODO Auto-generated method stub
		for(Participante respon: participantes)
		{
			ArrayList<Tarea> lastareas = respon.getTareas();
			if(lastareas!=null)
			{
				for(Tarea tare: lastareas)
				{
					tare.addResponDos(respon);
				}
			}
		}
	}

	public ArrayList<String> sacarPartisTarea(String idDepurado) {
		// TODO Auto-generated method stub
		return packraiz.getPartisTarea(idDepurado);
	}

	public void cambiarTimeTarea(String tiempo, String idDepurado) throws IOException {
		// TODO Auto-generated method stub
		packraiz.cambiarTimeTarea(tiempo, idDepurado);
		this.packraiz.rewritefile();
	}

	public void borrarPack(String padre) throws ProyectoException, IOException {
		// TODO Auto-generated method stub
		packraiz.borrarPack(padre);
		this.packraiz.rewritefile();
	}

	public void borrarTarea(String idDepurado) throws ProyectoException, IOException {
		// TODO Auto-generated method stub
		packraiz.borrarTarea(idDepurado);
		this.packraiz.rewritefile();
	}

	public int[] sacarDatos() {
		
		return packraiz.sacarDatos();
	}

	public ArrayList<Integer> getTiemposEstimados() {
		// TODO Auto-generated method stub
		return packraiz.sacarTiemposEstimados();
	}

	public ArrayList<Integer> getTiemposReales() {
		// TODO Auto-generated method stub
		return packraiz.sacarTiemposReales();
	}

	public int sacarTotalReal() {
		// TODO Auto-generated method stub
		return packraiz.sacarTiempRealTotal();
	}

	public int sacarTotalEstima() {
		// TODO Auto-generated method stub
		return packraiz.sacarTiempEstimaTotal();
	}

	public ArrayList<String> sacarTiposEnOrden() {
		// TODO Auto-generated method stub
		return packraiz.sacarTiposEnOrden();
	}

	public ArrayList<Integer> sacarTerminPartis() {
		// TODO Auto-generated method stub
		ArrayList<Integer> rta = new ArrayList<Integer>(); 
		for(Participante parti: participantes)
		{
			rta.add(parti.getTerminadas());
		}
		return rta;
	}
	
	public ArrayList<Integer> sacarTodasPartis() {
		// TODO Auto-generated method stub
		ArrayList<Integer> rta = new ArrayList<Integer>(); 
		for(Participante parti: participantes)
		{
			if(parti.getTareas()==null)
			{
				rta.add(0);
			}
			else
			{
				rta.add(parti.getTareas().size());
			}
		}
		return rta;
	}
}
