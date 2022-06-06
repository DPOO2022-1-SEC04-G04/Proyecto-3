package model;

@SuppressWarnings("serial")
public class ProyectoException extends Exception{

    /**
     * Construye una nueva excepción con el mensaje dado..
     * @param pMensaje Mensaje de la excepción. pMensaje != null && pMensaje != "".
     */
	public ProyectoException(String pMensaje) {
	    super(pMensaje );
	}
}