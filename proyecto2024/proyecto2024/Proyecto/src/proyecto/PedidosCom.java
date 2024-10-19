/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author corre
 */
public class PedidosCom {
    public PedidosCom(){
        
    }
    
        public static void main() {
        // Archivos de entrada
        String archivoCat = "categorias.txt";
        String archivoProd = "productos.txt";

        // Mostrar los datos combinados de ambos archivos
        System.out.println("Categorias y sus productos:");
        System.out.println("===========================================");
        
        // Mostrar categorías
        System.out.println("Categorías:");
        MostrarArchivo(archivoCat);
        
        // Mostrar productos
        System.out.println("\nProductos:");
        MostrarArchivo(archivoProd);
    }

    // Método para leer un archivo y mostrar su contenido
    private static void MostrarArchivo(String archivo) {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
        } catch (IOException e) {
            System.out.println("Error al leer el archivo " + archivo + ": " + e.getMessage());
        }
    }
}
