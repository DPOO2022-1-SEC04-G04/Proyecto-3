package model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Tarea extends NodoTrabajo{
	public static final String TIPO = "Tarea";
	private LocalTime tiempoPlaneado;
	private LocalDate fechaPlanFin;
	private LocalDate fechaFin;
	private boolean completada= false;
	private ArrayList<Actividad> actividades;
	private String tipoTarea;
	
	public Tarea(String pIdPadre, String nombre, String descripcion,String tipoTarea)
	{
		super(TIPO,nombre,descripcion,pIdPadre);
		this.actividades = new ArrayList<>();
		this.tipoTarea = tipoTarea;
	}
	public ArrayList<String> getActividades() {
		ArrayList<String> stringActividades = new ArrayList<String>();
		for (Actividad actividad: this.actividades)
		{
			String agregar = actividad.getTitulo() + "  :  " + actividad.getDescripcion() + "  ;  AUTOR: " + actividad.getAutor().getNombre() + "  ;  FECHA: " + actividad.getFechaRealizacion();
			stringActividades.add(agregar);
		}
		return stringActividades;
		
	}
	@Override
	protected NodoTrabajo buscarNodo(String nombre2) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
