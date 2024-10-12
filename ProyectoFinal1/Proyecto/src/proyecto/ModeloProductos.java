package proyecto;

import javax.swing.table.AbstractTableModel;

/**
 *
 * @author el profe ariel
 */
public class ModeloProductos extends AbstractTableModel{

    private final  listaProductos productos;

    public ModeloProductos() {
        productos=new listaProductos();
        productos.cargarProductos();
    }
    
    
    @Override
    public int getRowCount() {
        return productos.total();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Producto aux=productos.obtener(rowIndex);
        return switch (columnIndex) {
            case 0 -> aux.getCodigo();
            case 1 -> aux.getCategoria();
            case 2 -> aux.getDescripcion();
            case 3 -> aux.getPrecio();
            default -> aux.getExistencias();
        };
    }
    
    @Override
    public String getColumnName(int col) {
        return switch (col) {
            case 0 -> "CÓDIGO";
            case 1 -> "CATEGORIA";
            case 2 -> "DESCRIPCIÓN";
            case 3 -> "PRECIO";
            default -> "EXISTENCIAS";
        };
    }
    
    @Override
    public Class getColumnClass(int col) {
        return switch (col) {
            case 0 -> String.class;
            case 1 -> String.class;
            case 2 -> String.class;
            case 3 -> Float.class;
            default -> Integer.class;
        };
    }
    
    @Override
    public boolean isCellEditable(int row, int col) {
        return true;        
    }
  
    @Override
    public void setValueAt(Object value, int fila, int columna) {
        Producto aux=productos.obtener(fila);
        switch(columna){
            case 0 -> aux.setCodigo((String)value);
            case 1 -> aux.setCategoria((String)value);
            case 2 -> aux.setDescripcion((String)value);
            case 3 -> aux.setPrecio((float)value);
            default -> aux.setExistencias((int)value);
        }
        fireTableCellUpdated(fila, columna);
    }
    
    public void agregarProducto(Producto producto){
        productos.agregar(producto);
        this.fireTableDataChanged();   
    }
    
    public void eliminarProducto(int indice){
        productos.eliminar(indice);
        this.fireTableDataChanged(); 
    }
    
    public void guardarEnArchivo(){
        productos.guardarEnArchivo();
    }
}
