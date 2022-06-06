package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Map;

public class Participante implements Serializable
{
	private String nombre;
	private String correo;
	private ArrayList<Actividad> actividades;
	private ArrayList<Tarea> tareas;
	private Reporte reporte;
	
	public Participante(String nombre, String correo, ArrayList<String> tiposActividad)
	{
		this.nombre = nombre;
		this.correo = correo;
		this.actividades = new ArrayList<Actividad>();
		this.tareas = new ArrayList<Tarea>();
		this.reporte = new Reporte(tiposActividad);
	}
	
	public String getNombre()
	{
		return this.nombre;
	}
	
	public String getCorreo()
	{
		return this.correo;
	}
	
	public void aniadirActividad(Actividad actividad)
	{
		this.actividades.add(actividad);
	}
	
	public void eliminarActividad(Actividad actividad)
	{
		String fechab = actividad.getFechaRealizacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		for (Actividad acti : this.actividades)
		{
			String fechac = acti.getFechaRealizacion().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			
			if (acti.getTitulo().equals(actividad.getTitulo())  && fechac.equals(fechab))
			{
				this.actividades.remove(acti);
			}
		}
	}
	
	public String getReporte()
	{
		for (Actividad laactiv : this.actividades )
		{
			this.reporte.actualizarReporte(laactiv);
		}
		String reporte = "";
		reporte = reporte.concat("\n -----INICIO DEL REPORTE-------");
		reporte = reporte.concat("\n Tiempo total invertido por el participante en TODAS las actividades: ");
		reporte = reporte.concat(String.valueOf(this.reporte.getTiempoTotal()));
		reporte = reporte.concat("\n A continuación se presentan todas las fechas en las que trabajo el participante");
		reporte = reporte.concat("\n con el tiempo que invirtio en cada una de ellas:");
		for (Map.Entry<LocalDate, Integer> pareja : this.reporte.getTiemposDias().entrySet())
		{
			LocalDate llave = pareja.getKey();
			reporte = reporte.concat("\n Fecha: ");
			reporte = reporte.concat(llave.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
			reporte = reporte.concat("------ Tiempo en seg:  ");
			int valor = pareja.getValue();
			reporte = reporte.concat(String.valueOf(valor));
			reporte = reporte.concat("seg");
		}
		reporte = reporte.concat("\n A continuacion vamos a mostrar el promedio trabajado por día:");
		reporte = reporte.concat(String.valueOf(this.reporte.getTiempoPromedioDia()));
		reporte = reporte.concat("\n A continuacion vamos a mostrar los hallazgos de tiempo por tipos:");
		
		for (Map.Entry<String, Integer> pareja : this.reporte.getNumActividadesTipos().entrySet())
		{
			String llave = pareja.getKey();
			int numtipos = pareja.getValue();
			reporte = reporte.concat("\n TIPO: ");
			reporte = reporte.concat(llave.toUpperCase());
			reporte = reporte.concat("\n Cantidad de actividades: ");
			reporte = reporte.concat(String.valueOf(numtipos));
			int tiempoTotall = this.reporte.getTiemposTipos().get(llave);
			reporte = reporte.concat("\n Tiempo invertido en este tipo: ");
			reporte = reporte.concat(String.valueOf(tiempoTotall));
			Double tiempoPromType = this.reporte.getTiemposPromedioTipos().get(llave);
			reporte = reporte.concat("\n Tiempo promedio por actividad en este tipo: ");
			reporte = reporte.concat(String.valueOf(tiempoPromType));
		}
		this.reporte.resetReporte();
		return reporte;
	}

	public void aniadirTarea(Tarea tarea) {
		// TODO Auto-generated method stub
		tareas.add(tarea);
	}

	public ArrayList<Tarea> getTareas() {
		// TODO Auto-generated method stub
		return tareas;
	}
}
