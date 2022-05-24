package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class Reporte implements Serializable
{
	private int tiempoTotal;
	private int tiempoPromedioDia;
	private ArrayList<LocalDate> fechas;
	private HashMap <String, Integer> tiemposTipos;
	private HashMap <LocalDate, Integer> tiemposDias;
	private HashMap <String, Integer> numActividadesTipos;
	private HashMap <String, Double> tiemposPromedioTipos;
	
	public Reporte(ArrayList<String> tiposActividad)
	{
		this.tiempoTotal = 0;
		this.tiempoPromedioDia = 0;
		this.tiemposTipos = new HashMap <String, Integer> ();
		this.tiemposDias = new HashMap <LocalDate, Integer> ();
		String agregar = "";
		this.numActividadesTipos = new HashMap <String, Integer> ();
		this.tiemposPromedioTipos = new HashMap <String, Double> ();
		for(int i = 0;i<tiposActividad.size();i++)
		{
			agregar = tiposActividad.get(i);
			tiemposTipos.put(agregar, 0);
			numActividadesTipos.put(agregar, 0);
			tiemposPromedioTipos.put(agregar, 0.0);
		}
	}
	
	public  void resetReporte()
	{
		this.tiempoTotal = 0;
		this.tiempoPromedioDia = 0;
		for (Map.Entry<String, Integer> pareja : this.tiemposTipos.entrySet())
		{
			tiemposTipos.put(pareja.getKey(), 0);
			numActividadesTipos.put(pareja.getKey(), 0);
		}
		for (Map.Entry<String, Double> pareja : this.tiemposPromedioTipos.entrySet())
		{
			tiemposPromedioTipos.put(pareja.getKey(), 0.0);
		}
		this.tiemposDias = new HashMap <LocalDate, Integer>();
	}
	
	public int getTiempoTotal()
	{
		return tiempoTotal;
	}
	
	public int getTiempoPromedioDia()
	{
		return tiempoPromedioDia;
	}
	
	public ArrayList<LocalDate> getFechas()
	{
		return fechas;
	}
	
	public HashMap<String, Integer> getTiemposTipos()
	{
		return tiemposTipos;
	}
	
	public HashMap<LocalDate, Integer> getTiemposDias()
	{
		return tiemposDias;
	}
	
	public HashMap<String, Integer> getNumActividadesTipos()
	{
		return numActividadesTipos;
	}
	
	public HashMap<String, Double> getTiemposPromedioTipos()
	{
		return tiemposPromedioTipos;
	}
	
	public void actualizarReporte(Actividad laactividad)
	{
		calcularTiempoTotal(laactividad);
		calcularTiempoTipo(laactividad);
		calcularNumActividadesTipo(laactividad);
		calcularTiemposPromedioTipos(laactividad);
		calcularTiempoDia(laactividad);
		calcularTiempoPromedioDia();
	}
	
	private void calcularTiempoTotal(Actividad laactividad)
	{
		this.tiempoTotal+=laactividad.getDuracion();
	}
	
	private void calcularTiempoTipo(Actividad laactividad)
	{
		int viejo = this.tiemposTipos.get(laactividad.getTipo());
		this.tiemposTipos.put(laactividad.getTipo(), viejo+laactividad.getDuracion());	
	}
	
	private void calcularNumActividadesTipo(Actividad laactividad)
	{
		int viejo = this.numActividadesTipos.get(laactividad.getTipo());
		this.numActividadesTipos.put(laactividad.getTipo(), viejo+1);	
	}
	
	private void calcularTiemposPromedioTipos(Actividad laactividad)
	{
		int divisor = this.tiemposTipos.get(laactividad.getTipo());
		int dividendo = this.numActividadesTipos.get(laactividad.getTipo());
		Double nuevovalor = (double)divisor/(double)dividendo;
		this.tiemposPromedioTipos.put(laactividad.getTipo(), nuevovalor);
	}
	
	private void calcularTiempoDia(Actividad laactividad)
	{
		boolean existe = this.tiemposDias.containsKey(laactividad.getFechaRealizacion());
		if(existe)
		{
			int viejo = this.tiemposDias.get(laactividad.getFechaRealizacion());
			this.tiemposDias.put(laactividad.getFechaRealizacion(), viejo + laactividad.getDuracion());
		}
		else
		{
			this.tiemposDias.put(laactividad.getFechaRealizacion(),laactividad.getDuracion());
		}
	}
	
	private void calcularTiempoPromedioDia()
	{
		int acumuvalores = 0;
		for (Map.Entry<LocalDate, Integer> pareja : tiemposDias.entrySet())
		{
			int valor = pareja.getValue();
			acumuvalores +=valor;
		}
		this.tiempoPromedioDia = acumuvalores/this.tiemposDias.size();
	}
}
