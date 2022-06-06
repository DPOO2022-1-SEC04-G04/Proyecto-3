package model;


import java.io.BufferedReader;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Clase que representa una Marca.
 */
public class Tarea extends NodoTrabajo implements Serializable
{

    // -----------------------------------------------------------------
    // Constantes
    // -----------------------------------------------------------------

    /**
     * Constante que representa el tipo del nodo marca.
     */
    public final static String CLASE = "Tarea";

    // -----------------------------------------------------------------
    // Atributos
    // -----------------------------------------------------------------

    /**
     * Referencia al producto raíz del árbol binario que contiene los productos de la marca.
     */
    private ArrayList<Actividad> actividades;
    private String tipo;
    private int tiempoPlaneado;
    private LocalDate finEstimado;
    private ArrayList<Participante> responsables;

    // -----------------------------------------------------------------
    // Constructores
    // -----------------------------------------------------------------

    /**
     * Construye una nueva marca.<br>
     * <b>post: </b> Se inicializaron los atributos de la clase padre con los valores dados por parámetro y el tipo respectivo. El producto raíz se inicializó en null.
     * @param pIdentificador Identificador único de la marca. pIdentificador != null && pIdentificador != "".
     * @param pNombre Nombre de la marca. pNombre != null && pNombre != "".
     * @param tipo 
     */
    public Tarea( String pIdentificador, String pNombre, String pDesc, String tipoo)
    {
        super( CLASE, pIdentificador, pNombre, pDesc );
        this.actividades = new ArrayList<>();
        this.tipo = tipoo;
        this.finEstimado = null;
        this.tiempoPlaneado = 999999;
    }

    /**
     * Construye una nueva marca a partir de la línea con la información general y el lector para la información adicional.<br>
     * <b>post:</b> Se inicializaron los atributos de la clase padre con el nombre que viene en la línea y el tipo respectivo. Se cargaron los productos de la marca de la
     * información contenida en el lector.
     * @param pLinea Línea que contiene la información general de la marca. pLinea != null && pLinea != "" && pLinea.startsWith(TIPO).
     * @param pLector Lector para acceder a la información de los productos.
     * @throws AlmacenException Si ocurren errores al leer la información de los productos.
     */
    public Tarea( String pLinea, BufferedReader pLector ) throws ProyectoException
    {
        super( CLASE, pLinea.split( ";;;" )[ 1 ], pLinea.split( ";;;" )[ 2 ], pLinea.split( ";;;" )[ 3 ] );
        try
        {
            String datos[] = pLinea.split( ";;;" );
            int numHijos = Integer.parseInt( datos[ 4 ] );
            while( numHijos-- > 0 )
            {
                //Actividad actividad = new Actividad( );
                //agregarProducto( producto );
            }
            this.tipo = datos[5];
            String fecha = datos[6];
            if(fecha.split("/").length > 1)
            {
            	LocalDate lafecha = LocalDate.of(Integer.parseInt(fecha.split("/")[2]), Integer.parseInt(fecha.split("/")[1]), Integer.parseInt(fecha.split("/")[0]));
                this.finEstimado = lafecha;
            }
            else
            {
            	this.finEstimado = null;
            }
            this.tiempoPlaneado = Integer.parseInt(datos[7]);
        }
        catch( Exception e )
        {
            throw new ProyectoException( "Error al leer la tarea:\n" + e.getMessage( ) );
        }

    }

    // -----------------------------------------------------------------
    // Métodos
    // -----------------------------------------------------------------

    @Override
    public void darActividades( List<Actividad> pActividades )
    {
        List<Actividad> inorden = new ArrayList<>( );
    }

    /**
     * Busca el nodo con el identificador dado.
     * @param pIdentificador Identificador del nodo. pIdentificador != null && pIdentificador != "".
     * @return NodoAlmacen con el identificador dado o null si no se encontró el nodo.
     */
    @Override
    public NodoTrabajo buscarNodo( String pIdentificador )
    {
        return identificador.equals( pIdentificador ) ? this : null;
    }
    
    
    public Actividad buscarActividad( String pCodigo )
    {
    	Actividad rta = null;
    	for(Actividad act : actividades)
    	{
    		if(pCodigo.equals("coso"))
    		{
    			rta = act;
    		}
    	}
    	return rta;
    }
    

	@Override
	protected String darHijos() {
		int numero = 0;
		if(actividades != null)
		{
			numero = actividades.size();
		}
		String strnum = String.valueOf(numero);
		return strnum;
	}

	@Override
	protected String darTipo() {
		// TODO Auto-generated method stub
		return this.tipo;
	}

	@Override
	protected String darFecha() {
		// TODO Auto-generated method stub
		String rta ="";
		if (finEstimado!=null)
		{
			rta = rta.concat(String.valueOf(finEstimado.getDayOfMonth()));
			rta = rta.concat("/");
			rta = rta.concat(String.valueOf(finEstimado.getMonthValue()));
			rta = rta.concat("/");
			rta = rta.concat(String.valueOf(finEstimado.getYear()));
		}
		return rta;
	}

	@Override
	protected String darDuracion() {
		// TODO Auto-generated method stub
		return String.valueOf(this.tiempoPlaneado);
	}

	public void agregarActividad(Actividad nuevaA) {
		// TODO Auto-generated method stub
		if(actividades == null)
		{
			actividades = new ArrayList<Actividad>();
		}
		actividades.add(nuevaA);
		System.out.println(actividades);
	}

	public ArrayList<Actividad> sacarActividades() {
		// TODO Auto-generated method stub
		return actividades;
	}

	public void setFecha(LocalDate fechafinal) {
		// TODO Auto-generated method stub
		this.finEstimado = fechafinal;
		System.out.println(this.finEstimado);
	}

	public void addRespon(Participante newAutor) {
		// TODO Auto-generated method stub
		if(responsables == null)
		{
			responsables = new ArrayList<Participante>();
		}
		responsables.add(newAutor);
		newAutor.aniadirTarea(this);
	}

	public void addResponDos(Participante respon) {
		// TODO Auto-generated method stub
		responsables.add(respon);
	}

	public ArrayList<String> getResponString() {
		// TODO Auto-generated method stub
		ArrayList<String> stringParticipantes = new ArrayList<String>();
		if(responsables !=null)
		{
			for (Participante participante: this.responsables)
			{
				String agregar = participante.getNombre() + "  :  " + participante.getCorreo();
				stringParticipantes.add(agregar);
			}
		}
		
		return stringParticipantes;
	}

	public void setTiempo(String tiempo) {
		// TODO Auto-generated method stub
		int tiemp = (Integer.parseInt(tiempo))*3600;
		this.tiempoPlaneado = tiemp;
	}

	public boolean getFin() {
		// TODO Auto-generated method stub
		boolean rta = false;
		if(actividades!=null)
		{
			if(!actividades.isEmpty())
			{
				for(Actividad acti: actividades)
				{
					if (acti.getFinal())
					{
						rta = true;
					}
				}
			}
		}
		return rta;
	}

	public int getTiempo() {
		// TODO Auto-generated method stub
		return tiempoPlaneado;
	}
	
	public int getReal() {
		int rta = 0;
		if(actividades!=null)
		{
			if(!actividades.isEmpty())
			{
				for(Actividad acti: actividades)
				{
					rta +=acti.getDuracion();
				}
			}
		} 
		return rta;
	}

	public String getTipo() {
		// TODO Auto-generated method stub
		return this.tipo;
	}


    

}

