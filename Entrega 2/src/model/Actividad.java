package model;

import java.time.LocalDate;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;

public class Actividad implements Serializable
{
	private String idPropio;
	private String idTarea;
	private boolean finaliza;
	private String titulo;
	private String descripcion;
	private String tipo;
	private Participante autor;
	private LocalDate fechaRealizacion;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private int duracion;
	
	public Actividad(String titulo, String descripcion, String tipo, Participante autor, LocalDate fechaRealizacion,
						LocalTime horaInicio, LocalTime horaFin, String idTarea2, String idActi, boolean refinal)
	{
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.autor = autor;
		this.fechaRealizacion = fechaRealizacion;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		Duration laduracion = Duration.between(horaInicio, horaFin);
		int finalduracion = Math.toIntExact(laduracion.getSeconds());
		this.duracion= finalduracion;
		this.idPropio = idActi;
		this.idTarea = idTarea2;
		this.finaliza = refinal;
	}
	
	//CONSTRUCTOR PARA ACTIVIDADES CRONOMETRADAS
	public Actividad(String titulo, String descripcion, String tipo, Participante autor, LocalDate fechaRealizacion,
			LocalTime horaInicio, LocalTime horaFin, int duracion, String padre, String propio, boolean finali)
	{
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.autor = autor;
		this.fechaRealizacion = fechaRealizacion;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.duracion = duracion;
		this.idPropio = propio;
		this.idTarea = padre;
		this.finaliza = finali;
	}
	
	public String getTitulo()
	{
		return this.titulo;
	}
	
	public String getDescripcion()
	{
		return this.descripcion;
	}
	
	public String getTipo()
	{
		return this.tipo;
	}
	
	public Participante getAutor()
	{
		return this.autor;
	}
	
	public LocalDate getFechaRealizacion()
	{
		return this.fechaRealizacion;
	}
	
	public LocalTime getHoraInicio()
	{
		return this.horaInicio;
	}
	
	public LocalTime getHoraFin()
	{
		return this.horaFin;
	}
	
	public int getDuracion()
	{
		return this.duracion;
	}
	
	public void modificarFecha(LocalDate newFecha)
	{
		this.fechaRealizacion = newFecha;
	}

	public void modificarHoraInicio(LocalTime newHora) 
	{
		this.horaInicio = newHora;
		Duration laduracion = Duration.between(horaInicio, horaFin);
		int finalduracion = Math.toIntExact(laduracion.getSeconds());
		this.duracion= finalduracion;
	}
	
	public void modificarHoraFin(LocalTime newHora) 
	{
		this.horaFin = newHora;
		Duration laduracion = Duration.between(horaInicio, horaFin);
		int finalduracion = Math.toIntExact(laduracion.getSeconds());
		this.duracion= finalduracion;
	}

	public void modificarAutor(Participante newAutor)
	{
		this.autor = newAutor;	
	}

	public String getPadre() {
		// TODO Auto-generated method stub
		return idTarea;
	}

	public String getIdPropio() {
		// TODO Auto-generated method stub
		return idPropio;
	}

	public boolean getFinal() {
		// TODO Auto-generated method stub
		return finaliza;
	}
}
