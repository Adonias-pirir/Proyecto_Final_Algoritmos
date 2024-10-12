/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.util.LinkedList;
import java.util.StringTokenizer;
/**
 *
 * @author Dell
 */
public class BDProductos {
    public LinkedList<Producto> obtener(){
        LinkedList<Producto> productos=null;
        Archivo archivo=new Archivo("productos.txt");
        LinkedList<String> lineas=archivo.obtenerTextoDelArchivo();
        if(lineas!=null){
            productos=new LinkedList();
            for(int i=0;i<lineas.size();i++){
                String linea=lineas.get(i);
                StringTokenizer tokens=new StringTokenizer(linea,",");
                String codigo=tokens.nextToken();
                String categoria=tokens.nextToken();
                String descripcion=tokens.nextToken();
                float precio=Float.parseFloat(tokens.nextToken());
                int existencias=Integer.parseInt(tokens.nextToken());                
                productos.add(new Producto(codigo,categoria,descripcion, precio, existencias));
            }
        }
        return productos;
    }
    
    public boolean registrarProducto(Producto p){
        Archivo archivo=new Archivo("productos.txt");
        return archivo.registrar(p.getCodigo()+";"
               + p.getCategoria() + ";"
               + p.getDescripcion() + ";"
               + p.getPrecio() + ";" + p.getExistencias());
    }
    
    public boolean borrarTodo(){
        Archivo archivo=new Archivo("productos.txt");
        return archivo.borrarContenido();                
    }

    //LinkedList<Producto> obtener() {
    //    throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
