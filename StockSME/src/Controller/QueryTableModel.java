package Controller;

import javax.swing.table.DefaultTableModel;

/**
 * Redefinimos el tableModel para que acepte imagenes en la cuarta fila.
 * @author Stefano Mazzuka
 *
 */
public class QueryTableModel extends DefaultTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Especificamos una columna con imagenes.
	 * @param body Cuerpo de la tabla.
	 * @param head Cabecera de la tabla.
	 */
	public QueryTableModel(Object body[][], Object head[]) {
		super(body, head);
	}
	
    public boolean isCellEditable(int row, int column) {
        //all cells false
        return false;
     }
}