package model;

import java.util.*;


public class Paquete extends NodoTrabajo {
	
	public final static String TIPO = "Paquete";
	private List<NodoTrabajo> nodosHijos;
	
	public Paquete (String nombre, String descripcion, String idPadre)
	{
		super(TIPO,nombre,descripcion,idPadre);
		nodosHijos = new ArrayList<>();
		
	}
	public void agregarNodo(String pIdPadre, String nombre, String descripcion, String tipo) throws Exception
	{
		NodoTrabajo nuevo = tipo.equals(Paquete.TIPO) ? new Paquete(nombre,descripcion,pIdPadre): new Tarea(pIdPadre,nombre,descripcion,tipo);
		agregarNodo(pIdPadre, nuevo);	
	}
	public boolean agregarNodo(String pIdPadre, NodoTrabajo nodoAgregar) throws Exception
	{
		if (buscarNodo(nodoAgregar.nombre) != null)
		{
			throw new Exception("Ya existe un nodo con el nombre " + nodoAgregar.nombre);
		}
		boolean resultado = false;
		if(idPadre.equals(pIdPadre))
		{
			resultado = nodosHijos.add(nodoAgregar);
		}
		else
		{
			for(int i = 0; i < nodosHijos.size() && !resultado; i++)
			{
				NodoTrabajo nodo = nodosHijos.get(i);
				if (nodo.getTipo().equals(Paquete.TIPO))
				{
					resultado = ((Paquete) nodo).agregarNodo(pIdPadre, nodoAgregar);
				}
			}
			
		}	
		return resultado;
	}
	private boolean tieneHijo( String pIdNodo )
    {
        boolean respuesta = false;
        for( int i = 0; i < nodosHijos.size( ) && !respuesta; i++ )
        {
            NodoTrabajo nodo = nodosHijos.get( i );
            respuesta = nodo.getIdentificador().equals( pIdNodo );
        }
        return respuesta;
    }
	public Paquete buscarPadre(String pNombre)
	{
		Paquete padre = tieneHijo(pNombre) ? this: null;
		
		
		return null;
	}
	@Override
	public NodoTrabajo buscarNodo(String Nombre)
	{
		NodoTrabajo  respuesta = null;
		for(int i = 0; i < nodosHijos.size() && respuesta == null; i++)
		{
			if(Nombre.equals(nombre))
			{
				respuesta = this;
			}
			else
			{
				respuesta = nodosHijos.get(i).buscarNodo(Nombre);
			}
			
			
		}
		return respuesta;
	}
	@Override
	public ArrayList<String> getActividades() {
		return null;
	}
	
	
	
	

}
