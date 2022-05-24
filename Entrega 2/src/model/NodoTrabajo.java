package model;

import java.util.*;

public abstract class NodoTrabajo {
	protected String tipo;
	protected String nombre;
	protected String descripcion;
	protected String idPadre;
	public NodoTrabajo (String ptipo, String pnombre, String pdescripcion,String pIdPadre)
	{
		tipo = ptipo;
		nombre = pnombre;
		descripcion = pdescripcion;
		idPadre = pIdPadre;
		
	}
	public String getIdentificador( )
    {
        return idPadre;
    }

    /**
     * Retorna el tipo del nodo.
     * @return Tipo del nodo.
     */
    public String getTipo( )
    {
        return tipo;
    }

    /**
     * Retorna el nombre del nodo.
     * @return Nombre del nodo.
     */
    public String getNombre(){
        return nombre;
    }
    public abstract ArrayList<String> getActividades();
	protected abstract NodoTrabajo buscarNodo(String nombre2);
}
