/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
/**
 *
 * @author Dell
 */
public class InventarioActual {
    public InventarioActual(){
        
    }
    public static void main(String[] args) {
        String archivoTexto = "productos.txt"; // Archivo de texto fuente
        String archivoCSV = "productos.csv"; // Archivo CSV de destino

        try (BufferedReader br = new BufferedReader(new FileReader(archivoTexto));
             FileWriter escritorCSV = new FileWriter(archivoCSV)) {

            String linea;
            while ((linea = br.readLine()) != null) {
                // Separar la línea en código, proveedor y cantidad
                String[] partes = linea.split(" ");
                if (partes.length >= 6) {
                    // Extraer los datos relevantes del formato del archivo
                    String codigo = partes[1];
                    String producto = partes[3];
                    String cantidad = partes[5];

                    // Formatear la línea para el archivo CSV
                    String lineaCSV = codigo + "," + producto + "," + cantidad + "\n";

                    // Escribir la línea en el archivo CSV
                    escritorCSV.write(lineaCSV);
                } else {
                    System.out.println("Formato de línea incorrecto: " + linea);
                }
            }
            System.out.println("Exportación a CSV completada con éxito.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al exportar a CSV: " + e.getMessage());
        }
    }
    
}
