/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import javax.swing.JOptionPane;
/**
 *
 * @author Dell
 */
public class Archivo {
    private final String categoria;

    public Archivo(String categoria) {
        this.categoria = categoria;
    }
    
    public LinkedList<String> obtenerTextoDelArchivo() {
        LinkedList<String> lineasDeTexto=null;
        try {            
            File archivo = obtenerArchivo();     
            if (archivo.exists()) {
                lineasDeTexto=new LinkedList();
                try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                    String linea;
                    while ((linea = br.readLine()) != null) {
                        System.out.println(linea);
                        lineasDeTexto.add(linea);
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "El archivo de texto no existe");
            }
        } catch (HeadlessException | IOException ex) {
            JOptionPane.showMessageDialog(null, "Se produjo un Error ");
        }
        return lineasDeTexto;
    }

    
    private File obtenerArchivo() {       
        try {
            URL url = getClass().getClassLoader().getResource("archivos/"+categoria);
            return new File(url.toURI());            
        } catch (URISyntaxException ex) {
            return null;
        }
    }

    boolean registrar(String string) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    boolean borrarContenido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public boolean registrar1(String linea){
        File archivo=obtenerArchivo();
        try{
            if(archivo.exists()){
                FileWriter fw=new FileWriter(archivo,true);
                BufferedWriter bw=new BufferedWriter(fw);
                try (PrintWriter pw = new PrintWriter(bw)) {
                    pw.println(linea);
                    pw.flush();
                }
                return true;
            }
        }catch(IOException error){
        }
        return false;
    }
    /**
    public boolean borrarContenido(){
        try{
            File archivo=obtenerArchivo();
            String directorio=archivo.getParent();
            archivo.delete();
            new FileWriter(directorio + "/productos.txt",true);
        }catch(IOException ex){
            ex.printStackTrace();
        }
        return false;
    }*/
}
    
    

