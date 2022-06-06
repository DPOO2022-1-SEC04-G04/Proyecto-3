package model;

@SuppressWarnings("serial")
public class ProyectoException extends Exception{

    /**
     * Construye una nueva excepci�n con el mensaje dado..
     * @param pMensaje Mensaje de la excepci�n. pMensaje != null && pMensaje != "".
     */
	public ProyectoException(String pMensaje) {
	    super(pMensaje );
	}
}