package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


public class Paquete extends NodoTrabajo implements Serializable
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Representa el tipo del nodo categoría.-8188336236976093552
     */
	private static final long serialVersionUID = 1L;
    public final static String CLASE = "Paquete";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Lista con los nodos hijos de la categoría.
     */
    private List<NodoTrabajo> nodosHijos;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva categoría sin nodosHijos.<br>
     * <b>post: </b> Se inicializaron los atributos de la clase padre con los valores dados por parámetro y el tipo respectivo. Se inicializó la lista de nodosHijos como una lista
     * vacía.
     * @param pIdentificador Identificador único de la marca. pIdentificador != null && pIdentificador != "".
     * @param pNombre Nombre de la categoría. pNombre != null && pNombre != "".
     */
    public Paquete( String pIdentificador, String pNombre, String descri )
    {
        super( CLASE, pIdentificador, pNombre, descri );
        nodosHijos = new ArrayList<>( );
    }

    /**
     * Construye una nueva categoría a partir de la línea con la información general y el lector para la información adicional.<br>
     * <b>post:</b> Se inicializaron los atributos de la clase padre con el identificador que viene en la línea y el tipo respectivo. Se cargaron los nodosHijos de la categoría de
     * la información contenida en el lector.
     * @param pLinea Línea que contiene la información general de la marca. pLinea != null && pLinea != "" && pLinea.startsWith(TIPO).
     * @param pLector Lector para acceder a la información de los productos.
     * @throws AlmacenException Si ocurren errores al leer la información de los productos.
     */
    public Paquete( String pLinea, BufferedReader pLector ) throws ProyectoException
    {
        super( CLASE, pLinea.split( ";;;" )[ 1 ], pLinea.split( ";;;" )[ 2 ], pLinea.split( ";;;" )[ 3 ] );
        nodosHijos = new ArrayList<>( );
        try
        {
            String datos[] = pLinea.split( ";;;" );
            int numHijos = Integer.parseInt( datos[ 4 ] );
            while( numHijos-- > 0 )
            {
                agregarNodo( identificador, crearNodo( pLector ) );
            }
        }
        catch( Exception e )
        {
            throw new ProyectoException( "Error al leer el paquetePOPO:\n" + e.getMessage( ) );
        }

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    /**
     * Retorna la lista de los nodosHijos hijos.
     * @return Lista de nodosHijos.
     */
    public List<NodoTrabajo> darNodos( )
    {
        return nodosHijos;
    }
    
    public ArrayList<String> darPaquetesString()
    {
    	ArrayList<String> rta = new ArrayList<String>();
    	//List<NodoTrabajo> paRevision = this.darNodos();
    	System.out.println("ENTRA A LA FUNCION");
    	System.out.println(this.darPreorden());
    	List<NodoTrabajo> parecorrer = this.darPreorden();
    	for(NodoTrabajo nodo : parecorrer)
    	{
    		System.out.println("ENTRA EL FOR");
    		if(nodo.darClase().equals( Paquete.CLASE ))
    		{
    			String meter = "";
    			meter = meter.concat(nodo.darIdentificador());
    			meter = meter.concat("-");
    			meter = meter.concat(nodo.darNombre());
    			meter = meter.concat("-");
    			meter = meter.concat(nodo.darDescrip());
    			rta.add(meter);
    			System.out.println(meter);
    			
    		}
    	}
    	return rta;
    }

    /**
     * Indica si esta categoría tiene como hijo el nodo con el identificador dado.<br>
     * <b>pre: </b> La lista de nodosHijos está inicializada.<br>
     * @param pIdNodo Identificador del nodo. pIdNodo != null && pIdNodo != "".
     * @return True si esta categoría tiene un hijo con el identificador dado, False en caso contrario.
     */
    private boolean tieneHijo( String pIdNodo )
    {
        boolean respuesta = false;
        for( int i = 0; i < nodosHijos.size( ) && !respuesta; i++ )
        {
            NodoTrabajo nodo = nodosHijos.get( i );
            respuesta = nodo.darIdentificador( ).equals( pIdNodo );
        }
        return respuesta;
    }

    /**
     * Retorna la categoría padre del nodo con identificador dado.<br>
     * <b>pre: </b> La lista de nodosHijos está inicializada y existe un nodo con el identificador dado.<br>
     * @param pIdNodo Identificador del nodo. pIdNodo != null && pIdNodo != "".
     * @return Padre del nodo dado.
     */
    public Paquete buscarPadre( String pIdNodo )
    {
        Paquete respuesta = tieneHijo( pIdNodo ) ? this : null;
        for( int i = 0; i < nodosHijos.size( ) && respuesta == null; i++ )
        {
            NodoTrabajo actual = nodosHijos.get( i );
            if( actual.darClase( ).equals( Paquete.CLASE ) )
            {
                respuesta = ( ( Paquete )actual ).buscarPadre( pIdNodo );
            }

        }
        return respuesta;
    }

    /**
     * Busca el nodo con el identificador dado.
     * @param pIdentificador Identificador del nodo. pIdentificador != null && pIdentificador != "".
     * @return NodoAlmacen con el identificador dado o null si no se encontró el nodo.
     */
    @Override
    public NodoTrabajo buscarNodo( String pIdentificador )
    {
        NodoTrabajo respuesta = null;
        if( pIdentificador.equals( identificador ) )
        {
            respuesta = this;
        }
        else
        {
            for( int i = 0; i < nodosHijos.size( ) && respuesta == null; i++ )
            {
                respuesta = nodosHijos.get( i ).buscarNodo( pIdentificador );
            }
        }
        return respuesta;
    }

    /**
     * Agrega un nuevo nodo del tipo dado a la lista.<br>
     * <b>pre: </b> La lista de nodosHijos está inicializada.<br>
     * <b>post: </b> Se agregó un nuevo nodo a la lista con los valores dados.
     * @param pIdPadre Identificador único del padre del nodo. pIdPadre != null && pIdPadre != "".
     * @param pTipo Tipo del nodo. pTipo != null && pTipo != "".
     * @param pIdentificador Identificador del nodo. pIdentificador != null && pIdentificador != "".
     * @param pNombre Nombre del nodo. pNombre != null && pNombre != "".
     * @param tipo 
     * @throws AlmacenException Si ya existe un nodo en el subárbol con ese identificador.
     */
    public void agregarNodo( String pIdPadre, String pClase, String pIdentificador, String pNombre, String pDescr, String tipo ) throws ProyectoException
    {
        NodoTrabajo nuevo = pClase.equals( Paquete.CLASE ) ? new Paquete( pIdentificador, pNombre, pDescr ) : new Tarea( pIdentificador, pNombre, pDescr, tipo );
        boolean rta = agregarNodo( pIdPadre, nuevo );
        System.out.println(rta);
    }

    /**
     * Agrega un nuevo nodo a la lista.<br>
     * <b>pre: </b> La lista de nodosHijos está inicializada.<br>
     * <b>post: </b> Se agregó el nuevo nodo a la lista.
     * @param pIdPadre Identificador único del padre del nodo. pIdPadre != null && pIdPadre != "".
     * @param pNodo NodoAlmacen que se va a agregar. pNodo != null.
     * @return True si agregó el nodo, False en caso contrario.
     * @throws AlmacenException Si ya existe un nodo en el subárbol con ese identificador.
     */
    public boolean agregarNodo( String pIdPadre, NodoTrabajo pNodo ) throws ProyectoException
    {
        if( buscarNodo( pNodo.identificador ) != null )
        {
            throw new ProyectoException( "Ya existe un nodo en el árbol con el identificador " + pNodo.identificador );
        }
        boolean respuesta = false;
        if( identificador.equals( pIdPadre ) )
        {
            respuesta = nodosHijos.add( pNodo );
        }
        else
        {
            for( int i = 0; i < nodosHijos.size( ) && !respuesta; i++ )
            {
                NodoTrabajo actual = nodosHijos.get( i );
                if( actual instanceof Paquete )
                {
                    respuesta = ( ( Paquete )actual ).agregarNodo( pIdPadre, pNodo );
                }
            }
        }
        return respuesta;
    }

    /**
     * Elimina el nodo con el identificador dado.<br>
     * <b>pre: </b>La lista de nodosHijos está inicializada. Existe un nodo con el identificador dado en el subárbol.<br>
     * <b>post: </b> Se eliminó el nodo con toda su información y su subárbol asociado.
     * @param pIdentificador Identificador del nodo. pIdentificador != null && pIdentificador != "".
     * @return NodoAlmacen eliminado.
     */
    public NodoTrabajo eliminarNodo( String pIdentificador )
    {
        NodoTrabajo respuesta = null;
        for( int i = 0; i < nodosHijos.size( ) && respuesta == null; i++ )
        {
            NodoTrabajo actual = nodosHijos.get( i );
            if( actual.identificador.equals( pIdentificador ) )
            {
                respuesta = nodosHijos.remove( i );
            }
            else if( actual instanceof Paquete )
            {
                respuesta = ( ( Paquete )actual ).eliminarNodo( pIdentificador );
            }
        }

        return respuesta;
    }

    /**
     * Busca el producto con el código dado.
     * @param pCodigo Código del producto. pCodigo != null && pCodigo != "".
     * @return El producto buscado o null si no existe.
     */
    public Actividad buscarActividad( String pCodigo )
    {
        Actividad respuesta = null;
        for( int i = 0; i < nodosHijos.size( ) && respuesta == null; i++ )
        {
            NodoTrabajo actual = nodosHijos.get( i );
            if( actual instanceof Tarea )
            {
                respuesta = ( ( Tarea )actual ).buscarActividad( pCodigo );
            }
            else
            {
                respuesta = ( ( Paquete )actual ).buscarActividad( pCodigo );
            }
        }

        return respuesta;

    }

    /**
     * Agrega a la lista acumulada todos los productos del nodo.<br>
     * <b>pre:</b> La lista de nodosHijos está inicializada.
     * @param pProductos Lista acumulada con los productos. pProductos != null.
     */
    @Override
    public void darActividades( List<Actividad> pActividades )
    {
        for( NodoTrabajo nodoTrab : nodosHijos )
        {
            nodoTrab.darActividades( pActividades );
        }
    }

    /**
     * Retorna una lista con todas las marcas que tiene la categoría y su subárbol.<br>
     * <b>pre:</b> La lista de nodosHijos está inicializada.<br>
     * @return Lista con todas las marcas de la categoría y su subárbol.
     * 
     */
    public List<Tarea> darTareas( )
    {
        List<Tarea> respuesta = new ArrayList<>( );
        for( NodoTrabajo nodo : nodosHijos )
        {
            if( nodo instanceof Paquete )
            {
                respuesta.addAll( ( ( Paquete )nodo ).darTareas( ) );
            }
            else
            {
                respuesta.add( ( Tarea )nodo );
            }
        }
        return respuesta;

    }
    
    public void rewritefile() throws IOException
    {
    	List<NodoTrabajo> pameter = darPreorden();
    	File packinicial = new File("./data/Paque.txt");
		FileWriter fw = new FileWriter(packinicial);
		PrintWriter pw = new PrintWriter(fw);
    	for(NodoTrabajo nodo : pameter)
    	{
    		pw.write( nodo.darClase()+";;;"+nodo.darIdentificador()+";;;"+nodo.darNombre()+";;;"+nodo.darDescrip()+";;;"+nodo.darHijos());
    		if(nodo.darClase().equals("Tarea"))
    		{
    			pw.write(";;;"+nodo.darTipo()+";;;"+nodo.darFecha()+";;;"+nodo.darDuracion()+"\n");
    		}
    		else
    		{
    			pw.write("\n");
    		}
    	}
    	pw.close();
    }

	public List<NodoTrabajo> darPreorden() {
		// TODO Auto-generated method stub
		
		List<NodoTrabajo> respuesta = new ArrayList<>( );
        respuesta.add( this );
        for( NodoTrabajo nodo : nodosHijos )
        {
            if( nodo instanceof Paquete )
            {
                respuesta.addAll( ( ( Paquete )nodo ).darPreorden( ) );
            }
            else
            {
                respuesta.add( nodo );
            }
        }
        return respuesta;
	}

	@Override
	protected String darHijos() {
		// TODO Auto-generated method stub
		int numero = nodosHijos.size();
		String strnum = String.valueOf(numero);
		return strnum;
		
	}

	@Override
	protected String darTipo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String darFecha() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String darDuracion() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<String> darTareasString() {
		// TODO Auto-generated method stub
		ArrayList<String> rta = new ArrayList<String>();
		List<Tarea> respuesta = darTareas();
		for (Tarea nodo : respuesta)
		{
			String meter = "";
			meter = meter.concat(nodo.darIdentificador());
			meter = meter.concat("-");
			meter = meter.concat(nodo.darNombre());
			meter = meter.concat("-");
			meter = meter.concat(nodo.darDescrip());
			meter = meter.concat("-");
			meter = meter.concat(nodo.darTipo());
			rta.add(meter);
			System.out.println(meter);
		}
		return rta;
	}

	public void agregarActi(String idTarea, Actividad nuevaA) {
		// TODO Auto-generated method stub
		Tarea latarea = (Tarea) buscarNodo(idTarea);
		latarea.agregarActividad(nuevaA);
	}

	public ArrayList<Actividad> darActis(String idDepurado) {
		// TODO Auto-generated method stub
		Tarea latarea = (Tarea) buscarNodo(idDepurado);
		return latarea.sacarActividades();
	}

	public void setFecha(LocalDate fechafinal, String idTarea) {
		// TODO Auto-generated method stub
		String partesid[] = idTarea.split("-");
		String idDepurado = partesid[0];
		Tarea latarea = (Tarea) buscarNodo(idDepurado);
		latarea.setFecha(fechafinal);
		
	}

	public void aniadirRespon(Participante newAutor, String idTarea) {
		// TODO Auto-generated method stub
		Tarea latarea = (Tarea) buscarNodo(idTarea);
		latarea.addRespon(newAutor);
	}

	public ArrayList<String> getPartisTarea(String idDepurado) {
		// TODO Auto-generated method stub
		Tarea latarea = (Tarea) buscarNodo(idDepurado);
		ArrayList<String> respons = latarea.getResponString();
		return respons;
	}

	public void cambiarTimeTarea(String tiempo, String idDepurado) {
		// TODO Auto-generated method stub
		Tarea latarea = (Tarea) buscarNodo(idDepurado);
		latarea.setTiempo(tiempo);
	}

	public void borrarPack(String padre) throws ProyectoException {
		// TODO Auto-generated method stub
		Paquete elpack = (Paquete) buscarNodo(padre);
		List<Tarea> lalista = elpack.darTareas();
		for(Tarea latarea: lalista)
		{
			if(latarea.sacarActividades()!=null)
			{
				if(!latarea.sacarActividades().isEmpty())
				{
					throw new ProyectoException("NO SE PUEDE BORRAR PAQUETES CON TAREAS CON ACTIVIDADES");
				}
			}
			
		}
		eliminarNodo(padre);
	}

	public void borrarTarea(String idDepurado) throws ProyectoException {
		// TODO Auto-generated method stub
		Tarea latarea = (Tarea) buscarNodo(idDepurado);
		if(latarea.sacarActividades()!=null)
		{
			if(!latarea.sacarActividades().isEmpty())
			{
				throw new ProyectoException("NO SE PUEDE BORRAR PAQUETES CON TAREAS CON ACTIVIDADES");
			}
		}
		eliminarNodo(idDepurado);
	}

	public int[] sacarDatos() {
		// TODO Auto-generated method stub
		List<Tarea> tareass = this.darTareas();
		int tiempoEnds = 0;
		int tareas = 0;
		int terminadas = 0;
		int tiempototal = 0;
		if(tareass!=null)
		{
			for(Tarea latarea: tareass)
			{
				tareas+=1;
				boolean term = latarea.getFin();
				if (term)
				{
					terminadas+=1;
					tiempoEnds+=latarea.getTiempo();
				}
				tiempototal += latarea.getTiempo();
			}
		}
		int datos[] = new int[] {terminadas, tareas, tiempoEnds, tiempototal};
		
		return datos;
	}

	public ArrayList<Integer> sacarTiemposEstimados() {
		// TODO Auto-generated method stub
		List<Tarea> tareass = this.darTareas();
		ArrayList<String> tipos = new ArrayList<String>();
		ArrayList<Integer> reales = new ArrayList<Integer>();
		int realtotal = 0;
		ArrayList<Integer> estimas = new ArrayList<Integer>();
		int estimatotal = 0;
		//estimas.add(0);
		//tipos.add("todo!!!!!!");
		if(tareass!=null)
		{
			for(Tarea latarea: tareass)
			{
				int indice = -1;
				String typee= latarea.getTipo();
				for(int i =0; i<tipos.size();i++ )
				{
					if(typee.equals(tipos.get(i)))
					{
						indice = i;
					}
				}
				estimatotal += latarea.getTiempo();
				realtotal += latarea.getReal();
				if(indice>-1)
				{
					String elti = tipos.get(indice);
					int retime = reales.get(indice);
					int eltime = estimas.get(indice);
					tipos.remove(indice);
					reales.remove(indice);
					estimas.remove(indice);
					eltime+= latarea.getTiempo();
					retime += latarea.getReal();
					tipos.add(elti);
					reales.add(retime);
					estimas.add(eltime);
				}
				else
				{
					int retime = latarea.getReal();
					int eltime = latarea.getTiempo();
					tipos.add(typee);
					reales.add(retime);
					estimas.add(eltime);
				}
				
			}
		}
		return estimas;
	}
	
	public ArrayList<Integer> sacarTiemposReales() {
		// TODO Auto-generated method stub
		List<Tarea> tareass = this.darTareas();
		ArrayList<String> tipos = new ArrayList<String>();
		ArrayList<Integer> reales = new ArrayList<Integer>();
		int realtotal = 0;
		ArrayList<Integer> estimas = new ArrayList<Integer>();
		int estimatotal = 0;
		//estimas.add(0);
		//tipos.add("todo!!!!!!");
		if(tareass!=null)
		{
			for(Tarea latarea: tareass)
			{
				int indice = -1;
				String typee= latarea.getTipo();
				for(int i =0; i<tipos.size();i++ )
				{
					if(typee.equals(tipos.get(i)))
					{
						indice = i;
					}
				}
				estimatotal += latarea.getTiempo();
				realtotal += latarea.getReal();
				if(indice>-1)
				{
					String elti = tipos.get(indice);
					int retime = reales.get(indice);
					int eltime = estimas.get(indice);
					tipos.remove(indice);
					reales.remove(indice);
					estimas.remove(indice);
					eltime+= latarea.getTiempo();
					retime += latarea.getReal();
					tipos.add(elti);
					reales.add(retime);
					estimas.add(eltime);
				}
				else
				{
					int retime = latarea.getReal();
					int eltime = latarea.getTiempo();
					tipos.add(typee);
					reales.add(retime);
					estimas.add(eltime);
				}
				
			}
		}
		return reales;
	}
	
	public int sacarTiempRealTotal() {
		// TODO Auto-generated method stub
		List<Tarea> tareass = this.darTareas();
		ArrayList<String> tipos = new ArrayList<String>();
		ArrayList<Integer> reales = new ArrayList<Integer>();
		int realtotal = 0;
		ArrayList<Integer> estimas = new ArrayList<Integer>();
		int estimatotal = 0;
		//estimas.add(0);
		//tipos.add("todo!!!!!!");
		if(tareass!=null)
		{
			for(Tarea latarea: tareass)
			{
				int indice = -1;
				String typee= latarea.getTipo();
				for(int i =0; i<tipos.size();i++ )
				{
					if(typee.equals(tipos.get(i)))
					{
						indice = i;
					}
				}
				estimatotal += latarea.getTiempo();
				realtotal += latarea.getReal();
				if(indice>-1)
				{
					String elti = tipos.get(indice);
					int retime = reales.get(indice);
					int eltime = estimas.get(indice);
					tipos.remove(indice);
					reales.remove(indice);
					estimas.remove(indice);
					eltime+= latarea.getTiempo();
					retime += latarea.getReal();
					tipos.add(elti);
					reales.add(retime);
					estimas.add(eltime);
				}
				else
				{
					int retime = latarea.getReal();
					int eltime = latarea.getTiempo();
					tipos.add(typee);
					reales.add(retime);
					estimas.add(eltime);
				}
				
			}
		}
		return realtotal;
	}
	
	public int sacarTiempEstimaTotal() {
		// TODO Auto-generated method stub
		List<Tarea> tareass = this.darTareas();
		ArrayList<String> tipos = new ArrayList<String>();
		ArrayList<Integer> reales = new ArrayList<Integer>();
		int realtotal = 0;
		ArrayList<Integer> estimas = new ArrayList<Integer>();
		int estimatotal = 0;
		//estimas.add(0);
		//tipos.add("todo!!!!!!");
		if(tareass!=null)
		{
			for(Tarea latarea: tareass)
			{
				int indice = -1;
				String typee= latarea.getTipo();
				for(int i =0; i<tipos.size();i++ )
				{
					if(typee.equals(tipos.get(i)))
					{
						indice = i;
					}
				}
				estimatotal += latarea.getTiempo();
				realtotal += latarea.getReal();
				if(indice>-1)
				{
					String elti = tipos.get(indice);
					int retime = reales.get(indice);
					int eltime = estimas.get(indice);
					tipos.remove(indice);
					reales.remove(indice);
					estimas.remove(indice);
					eltime+= latarea.getTiempo();
					retime += latarea.getReal();
					tipos.add(elti);
					reales.add(retime);
					estimas.add(eltime);
				}
				else
				{
					int retime = latarea.getReal();
					int eltime = latarea.getTiempo();
					tipos.add(typee);
					reales.add(retime);
					estimas.add(eltime);
				}
				
			}
		}
		return estimatotal;
	}
	
	public ArrayList<String> sacarTiposEnOrden() {
		// TODO Auto-generated method stub
		List<Tarea> tareass = this.darTareas();
		ArrayList<String> tipos = new ArrayList<String>();
		ArrayList<Integer> reales = new ArrayList<Integer>();
		int realtotal = 0;
		ArrayList<Integer> estimas = new ArrayList<Integer>();
		int estimatotal = 0;
		//estimas.add(0);
		//tipos.add("todo!!!!!!");
		if(tareass!=null)
		{
			for(Tarea latarea: tareass)
			{
				int indice = -1;
				String typee= latarea.getTipo();
				for(int i =0; i<tipos.size();i++ )
				{
					if(typee.equals(tipos.get(i)))
					{
						indice = i;
					}
				}
				estimatotal += latarea.getTiempo();
				realtotal += latarea.getReal();
				if(indice>-1)
				{
					String elti = tipos.get(indice);
					int retime = reales.get(indice);
					int eltime = estimas.get(indice);
					tipos.remove(indice);
					reales.remove(indice);
					estimas.remove(indice);
					eltime+= latarea.getTiempo();
					retime += latarea.getReal();
					tipos.add(elti);
					reales.add(retime);
					estimas.add(eltime);
				}
				else
				{
					int retime = latarea.getReal();
					int eltime = latarea.getTiempo();
					tipos.add(typee);
					reales.add(retime);
					estimas.add(eltime);
				}
				
			}
		}
		return tipos;
	}


}