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
public class RegistroProd {
    public RegistroProd(){
        
    }
    public static void main() {
        String archivo1 = "categorias.txt"; // Especifica la ruta del archivo de texto

        try (BufferedReader br = new BufferedReader(new FileReader(archivo1))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                // Separar la línea en código, nombre y descripción
                String[] partes = linea.split(",");
                if (partes.length == 3) {String codigo = partes[0];String nombre = partes[1];String descripcion = partes[2];

                    // Mostrar la información en el formato deseado
                    System.out.println("Código: " + codigo);
                    System.out.println("Nombre: " + nombre);
                    System.out.println("Descripción: " + descripcion);
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
        System.out.println("Ingrese el codigo: ");
        int codigo = scanner.nextInt();
        
        // Limpiar el buffer de entrada de teclado después de leer el entero
        scanner.nextLine(); // Consumir el carácter de nueva línea pendiente

        System.out.println("Ingrese el producto: ");
        String nombreProd = scanner.nextLine();

        System.out.println("Ingrese la cantidad : ");
        int cantidad = scanner.nextInt();

        // Crear una cadena de texto con los datos ingresados
        String datos = "Codigo: " + codigo + " Producto: " + nombreProd + " Cantidad: " + cantidad + "\n";

        // Guardar los datos en un archivo de texto
        try {
            FileWriter escritor = new FileWriter("productos.txt", true); // El 'true' añade los datos al final
            escritor.write(datos);
            escritor.close();
            System.out.println("Los datos han sido guardados en el archivo 'productos.txt'.");
        } catch (IOException e) {
            System.out.println("Ocurrió un error al guardar los datos.");
        }
    }
    
}

/**
class Productos {
    private String codigo;
    private String nombre;
    private String descripcion;
    private String caracteristica;
    private int cantidad;
        

    public Productos(String codigo, String nombre, String descripcion, String caracteristica, int cantidad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
    }
    public String getCodigo(){
        return codigo;
    }    
    public void setCodigo(String codigo){
        this.codigo = codigo;   
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getCaracteristica() {
        return caracteristica;
    }
    public void setcaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }
     public int getCantidad() {
        return cantidad;
    }
    public void setcantidad(int cantidad) {
        this.cantidad = cantidad;
    }
}**/

