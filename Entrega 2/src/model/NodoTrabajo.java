package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

//import uniandes.cupi2.almacen.mundo.Producto;

/**
 * Clase abstracta que representa un nodo del árbol del mercado.
 */
public abstract class NodoTrabajo implements Serializable
{

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Tipo del nodo.
     */
    protected String clase;

    /**
     * Identificador del nodo.
     */
    protected String identificador;
    
    /**
     * El nombre del nodo.
     */
    protected String nombre;
    /**
     * La descripcion del nodo.
     */
    protected String descripcion;
    
    

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Crea un nuevo nodo.<br>
     * <b>post: </b> Los atributos identificador y tipo se inicializaron con los valores dados por parámetro.
     * @param pTipo Tipo del nodo. pTipo != null && pTipo != "".
     * @param pIdentificador Identificador del nodo. pIdentificador != null && pIdentificador != "".
     * @param pNombre Nombre del nodo. pNombre != null && pNombre != "".
     */
    public NodoTrabajo( String pClase, String pIdentificador, String pNombre, String descrip )
    {
        clase = pClase;
        identificador = pIdentificador;
        nombre = pNombre;
        descripcion = descrip;
    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna el identificador del nodo.
     * @return Identificador del nodo.
     */
    public String darIdentificador( )
    {
        return identificador;
    }

    /**
     * Retorna el tipo del nodo.
     * @return Tipo del nodo.
     */
    public String darClase( )
    {
        return clase;
    }

    /**
     * Retorna el nombre del nodo.
     * @return Nombre del nodo.
     */
    public String darNombre(){
        return nombre;
    }
    
    /**
     * Busca el nodo con el identificador dado.
     * @param pIdentificador Identificador del nodo. pIdentificador != null && pIdentificador != "".
     * @return NodoAlmacen con el identificador dado o null si no se encontró el nodo.
     */
    public abstract NodoTrabajo buscarNodo( String pIdentificador );

    /**
     * Retorna el valor total de las ventas del nodo.
     * @return Valor ventas del nodo.
     */
    public NodoTrabajo crearNodo( BufferedReader pLector ) throws ProyectoException
    {
        try
        {
            String linea = pLector.readLine( );
            String datos[] = linea.split( ";;;" );
            NodoTrabajo respuesta = null;
            if( datos[ 0 ].equals( Paquete.CLASE ) )
            {
                respuesta = new Paquete( linea, pLector );
            }
            else if( datos[ 0 ].equals( Tarea.CLASE ) )
            {
                respuesta = new Tarea( linea, pLector );
            }
            else
            {
                throw new ProyectoException( datos[ 0 ] + " no es un tipo de nodo valido." );
            }
            return respuesta;

        }
        catch( IOException e )
        {
            throw new ProyectoException( "Error al leer el archivo.\n" + e.getMessage( ) );
        }
    }

    
    public abstract void darActividades( List<Actividad> pActividades );

    /**
     * Retorna una lista con todos los productos de la categoría.<br>
     * <b>pre:</b> La lista de nodos está inicializada.
     * @return Lista con los productos del nodo.
     */
    public List<Actividad> darActividades( )
    {
        List<Actividad> productos = new ArrayList<>( );
        darActividades( productos );
        return productos;
    }
    
    /**
     * Retorna la representación en string de este objeto.<br>
     * @return Nombre del nodo.
     */
    @Override
    public String toString( )
    {
        return nombre;
    }

	public String darDescrip() {
		// TODO Auto-generated method stub
		return descripcion;
	}

	protected abstract String darHijos();

	protected abstract String darTipo();

	protected abstract String darFecha();

	protected abstract String darDuracion();

}
