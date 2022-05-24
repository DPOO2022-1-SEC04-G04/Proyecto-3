package model;

import java.time.LocalDate;
import java.io.Serializable;
import java.time.Duration;
import java.time.LocalTime;

public class Actividad implements Serializable
{
	private String titulo;
	private String descripcion;
	private String tipo;
	private Participante autor;
	private LocalDate fechaRealizacion;
	private LocalTime horaInicio;
	private LocalTime horaFin;
	private int duracion;
	
	public Actividad(String titulo, String descripcion, String tipo, Participante autor, LocalDate fechaRealizacion,
						LocalTime horaInicio, LocalTime horaFin)
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
	}
	
	//CONSTRUCTOR PARA ACTIVIDADES CRONOMETRADAS
	public Actividad(String titulo, String descripcion, String tipo, Participante autor, LocalDate fechaRealizacion,
			LocalTime horaInicio, LocalTime horaFin, int duracion)
	{
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.tipo = tipo;
		this.autor = autor;
		this.fechaRealizacion = fechaRealizacion;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.duracion = duracion;
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
}
