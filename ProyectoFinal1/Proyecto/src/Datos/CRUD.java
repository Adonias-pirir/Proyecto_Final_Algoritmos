/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Datos;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dell
 */
public class CRUD {
    
    public boolean escribirDatos(String nombreDb, String contenido)
    {
        boolean estadoEscritura = false;
        
            String carpetaProyecto = "BdDatos";
            
            String nombreArchivo = nombreDb + ".txt";
        File carpeta = new File(carpetaProyecto);
        File f = new File(carpeta, nombreArchivo);
        
        try {
                    //para abrir archivo es FileWriter
                    FileWriter fw = new FileWriter(f, true);
                    //write es: escribir
                    //si se escribe un nuevo texto se almacenan vario, almacenamiento temporal
                    BufferedWriter bw = new BufferedWriter(fw);
                    //write es: escribir
                    bw.write(contenido+"\n");
                    bw.close();
                    estadoEscritura = true;
                } catch (IOException ex) {
                    System.out.println("Error: "+ ex);
                    //Logger.getLogger(EscrituraDeArchivosSA.class.getName()).log(Level.SEVERE, null, ex);//null ausencia
                }
        return estadoEscritura;
    }
}
