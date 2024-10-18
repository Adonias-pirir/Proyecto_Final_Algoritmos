/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package proyecto;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author corre
 */
class Categoria {
    private String codigo;
    private String nombre;
    private String descripcion;
        

    public Categoria(String codigo, String nombre, String descripcion) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
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
    
 @Override
    public String toString() {
        return codigo + "," + nombre + "," + descripcion;
    }

    public static Categoria fromString(String linea) {
        String[] partes = linea.split("\\,");
        return new Categoria(partes[0], partes.length > 1 ? partes[1] : "", partes.length > 2 ? partes[2] : "" );
    }
}

final class CategoriaManager {
    final List<Categoria> categorias;
    private final String archivo = "categorias.txt";

    public CategoriaManager() {
        categorias = new ArrayList<>();
        cargarCategorias();
    }
    
 public void cargarCategorias() {
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                categorias.add(Categoria.fromString(linea));
            }
        } catch (IOException e) {
            System.out.println("No se pudo cargar el archivo de categorias.");
        }
    }

    public void guardarCategorias() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Categoria cat : categorias) {
                bw.write(cat.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("No se pudo guardar el archivo de categorias.");
        }
    }

    public void mostrarCategorias() {
        if (categorias.isEmpty()) {
            System.out.println("No hay categorias disponibles.");
        } else {
            for (int i = 0; i < categorias.size(); i++) {
                Categoria cat = categorias.get(i);
                System.out.println((i + 1) + "." + cat.getCodigo() + "," + cat.getNombre() + "," + cat.getDescripcion());
            }
        }
    }

    public void agregarCategoria(String codigo, String nombre, String descripcion) {
        if (nombre.isEmpty()) {
            System.out.println("El nombre de la categoria no puede estar vacio.");
            return;
        }

        for (Categoria cat : categorias) {
            if (cat.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Ya existe una categoría con ese nombre.");
                return;
            }
        }

        categorias.add(new Categoria(codigo, nombre, descripcion));
        guardarCategorias();
        System.out.println("Categoria añadida con exito.");
    }

    public void modificarCategoria(int indice, String nuevoCodigo, String nuevoNombre, String nuevaDescripcion) {
        if (nuevoCodigo.isEmpty()) {
            System.out.println("El nuevo codigo de la categoria no puede estar vacio.");
            return;
        }

     if (indice >= 0 && indice < categorias.size()) {
        Categoria categoria = categorias.get(indice);
        categoria.setCodigo(nuevoCodigo);
        categoria.setNombre(nuevoNombre);
        categoria.setDescripcion(nuevaDescripcion);
        guardarCategorias(); // Actualiza el archivo después de modificar
    } else {
        System.out.println("Índice inválido.");
    }

        Categoria cat = categorias.get(indice);
        cat.setCodigo(nuevoCodigo);
        cat.setNombre(nuevoNombre);
        cat.setDescripcion(nuevaDescripcion);
        guardarCategorias();
        System.out.println("Categoría modificada con exito.");
    }

    public void eliminarCategoria(int indice) {
        System.out.println("¿Esta seguro que desea eliminar la categoria? (s/n)");
        Scanner sc = new Scanner(System.in);
        String confirmacion = sc.nextLine();

        if (confirmacion.equalsIgnoreCase("s")) {
            categorias.remove(indice);
            guardarCategorias();
            System.out.println("Categoria eliminada con exito.");
        } else {
            System.out.println("Operacion cancelada.");
        }
    }
}
/**
public class gesProd {
    public static void main(String[] args) {
        CategoriaManager manager = new CategoriaManager();
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Gestion de Categorias ---");
            System.out.println("1. Ver categorias");
            System.out.println("2. Agregar categoria");
            System.out.println("3. Modificar categoria");
            System.out.println("4. Eliminar categoria");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opcion: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1 -> System.out.print("Ingrese el nombre de la categoria: ");//manager.mostrarCategorias();
                case 2 -> {
                    System.out.print("Ingrese el nombre de la categoria: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese la descripcion de la categoria (opcional): ");
                    String descripcion = sc.nextLine();
                    manager.agregarCategoria(nombre, descripcion);
                }
                case 3 -> {
                    //manager.mostrarCategorias();
                    System.out.print("Seleccione el numero de la categoria a modificar: ");
                    int indiceMod = sc.nextInt() - 1;
                    sc.nextLine();
                    if (indiceMod >= 0 && indiceMod < manager.categorias.size()) {
                        System.out.print("Nuevo nombre de la categoria: ");
                        String nuevoNombre = sc.nextLine();
                        System.out.print("Nueva descripcion de la categoria (opcional): ");
                        String nuevaDescripcion = sc.nextLine();
                        manager.modificarCategoria(indiceMod, nuevoNombre, nuevaDescripcion);
                    } else {
                        System.out.println("Indice invalido.");
                    }
                }
                case 4 -> {
                    //manager.mostrarCategorias();
                    System.out.print("Seleccione el numero de la categoria a eliminar: ");
                    int indiceElim = sc.nextInt() - 1;
                    sc.nextLine();
                    if (indiceElim >= 0 && indiceElim < manager.categorias.size()) {
                        manager.eliminarCategoria(indiceElim);
                    } else {
                        System.out.println("Indice invalido.");
                    }
                }
                case 5 -> System.out.println("Saliendo del sistema.");
                default -> System.out.println("Opcion no valida.");
            }
        } while (opcion != 5);
    }**/



