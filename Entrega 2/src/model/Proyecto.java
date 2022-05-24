package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
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
	
	public Proyecto(String nombre, String descripcion, String nombreDuenio, String correoDuenio, LocalDate fechaInicio, LocalDate fechaFin, ArrayList<String> tiposss)
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
	}
	
	public Proyecto(String nombre, String descripcion, String nombreDuenio, String correoDuenio, LocalDate fechaInicio, ArrayList<String> tiposss)
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
								LocalDate fechaRealizacion, LocalTime horaInicio, LocalTime horaFin)
	{
		Actividad NuevaA = new Actividad(titulo,descripcion,tipo_seleccionado,autor,fechaRealizacion,horaInicio,horaFin);
		autor.aniadirActividad(NuevaA);
		this.actividades.add(NuevaA);
	}
	
	public void crearActividad(String titulo, String descripcion, String tipo_seleccionado, Participante autor,
			LocalDate fechaRealizacion, LocalTime horaInicio, LocalTime horaFin, int duracion)
	{
		Actividad NuevaA = new Actividad(titulo,descripcion,tipo_seleccionado,autor,fechaRealizacion,horaInicio,horaFin, duracion);
		autor.aniadirActividad(NuevaA);
		this.actividades.add(NuevaA);
	}
	
	public void modificarFechaActividad(int indiceMasUno, LocalDate fechaNueva)
	{
		this.actividades.get(indiceMasUno-1).modificarFecha(fechaNueva);
	}
	
	public void modificarHoraInicioActividad(int indiceMasUno, LocalTime horaNueva)
	{
		this.actividades.get(indiceMasUno-1).modificarHoraInicio(horaNueva);
	}
	
	public void modificarHoraFinActividad(int indiceMasUno, LocalTime horaNueva)
	{
		this.actividades.get(indiceMasUno-1).modificarHoraFin(horaNueva);
	}

	public void modificarParticipanteActividad(int indice, int numAutor)
	{
		Participante newAutor = this.participantes.get(numAutor-1);
		Participante viejo = this.actividades.get(indice-1).getAutor();
		this.actividades.get(indice-1).modificarAutor(newAutor);
		newAutor.aniadirActividad(this.actividades.get(indice-1));
		viejo.eliminarActividad(this.actividades.get(indice-1));
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
}
