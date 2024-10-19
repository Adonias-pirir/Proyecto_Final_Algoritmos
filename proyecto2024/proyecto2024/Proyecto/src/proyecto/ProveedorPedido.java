/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileWriter;
import java.util.Scanner;
/**
 *
 * @author Dell
 */
public class ProveedorPedido {
    public ProveedorPedido(){
        
    }
    public static void main() {
        String archivo2 = "productos.txt"; // Especifica la ruta del archivo de texto

        try (BufferedReader br = new BufferedReader(new FileReader(archivo2))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Separar la línea en código, nombre y descripción
                String[] partes = linea.split(",");
                if (partes.length == 3) {String codigo = partes[0];String nombre = partes[1];String descripcion = partes[2];

                    // Mostrar la información en el formato deseado
                    System.out.println("Código: " + codigo);
                    System.out.println("Proveedor: " + nombre);
                    System.out.println("Cantidad: " + descripcion);
                    System.out.println("-------------------------");
                } else {
                    System.out.println("Formato de línea incorrecto: " + linea);
                }
            }
        } catch (IOException e) {
            System.out.println("Ocurrió un error al leer el archivo: " + e.getMessage());
        }
    
        // Crear el objeto Scanner para leer datos de la entrada del usuario
        Scanner scanner = new Scanner(System.in);

        // Solicitar al usuario que ingrese datos
        System.out.println("Ingrese el codigo de categoria para agregaqarle proveedor: ");
        int codigo = scanner.nextInt();
        
        // Limpiar el buffer de entrada de teclado después de leer el entero
        scanner.nextLine(); // Consumir el carácter de nueva línea pendiente

        System.out.println("Ingrese el proveedor: ");
        String nombreProd = scanner.nextLine();

        System.out.println("Cantidad deseada a comprar : ");
        int cantidad = scanner.nextInt();

        // Crear una cadena de texto con los datos ingresados
        String datos = "Codigo: " + codigo + " Proveedor: " + nombreProd + " Cantidad: " + cantidad + "\n";

        // Guardar los datos en un archivo de texto
        try {
            FileWriter escritor = new FileWriter("proveedor.txt", true); // El 'true' añade los datos al final
            escritor.write(datos);
            escritor.close();
            System.out.println("Los datos han sido guardados en el archivo 'proveedor.txt'.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar los datos.");
        }
    }
    
}
