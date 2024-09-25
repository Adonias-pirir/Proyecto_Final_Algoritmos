/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ProyectoCategorias;
        import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
/**
 *
 * @author Dell
 */
public class ProyectoCategorias {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

class Categoria {
    private String nombre;
    private String descripcion;

    public Categoria(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
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
        return nombre + "|" + descripcion;
    }

    public static Categoria fromString(String linea) {
        String[] partes = linea.split("\\|");
        return new Categoria(partes[0], partes.length > 1 ? partes[1] : "");
    }
}

class CategoriaManager {
    private List<Categoria> categorias;
    private final String archivo = "categorias.txt";

    public CategoriaManager() {
        categorias = new ArrayList<>();
        cargarCategorias();
    }

    public void cargarCategorias() {
        File file = new File(archivo);
        if (!file.exists()) {
            try {
                // Si el archivo no existe, lo crea vacío
                file.createNewFile();
            } catch (IOException e) {
                System.out.println("Error al crear el archivo de categorías: " + e.getMessage());
                return;
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                categorias.add(Categoria.fromString(linea));
            }
        } catch (IOException e) {
            System.out.println("Error al cargar el archivo de categorías: " + e.getMessage());
        }
    }

    public void guardarCategorias() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Categoria cat : categorias) {
                bw.write(cat.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Error al guardar el archivo de categorías: " + e.getMessage());
        }
    }

    public void mostrarCategorias() {
        if (categorias.isEmpty()) {
            System.out.println("No hay categorías disponibles.");
        } else {
            for (int i = 0; i < categorias.size(); i++) {
                Categoria cat = categorias.get(i);
                System.out.println((i + 1) + ". " + cat.getNombre() + " - " + cat.getDescripcion());
            }
        }
    }

    public void agregarCategoria(String nombre, String descripcion) {
        if (nombre.isEmpty()) {
            System.out.println("El nombre de la categoría no puede estar vacío.");
            return;
        }

        for (Categoria cat : categorias) {
            if (cat.getNombre().equalsIgnoreCase(nombre)) {
                System.out.println("Ya existe una categoría con ese nombre.");
                return;
            }
        }

        categorias.add(new Categoria(nombre, descripcion));
        guardarCategorias();
        System.out.println("Categoría añadida con éxito.");
    }

    public void modificarCategoria(int indice, String nuevoNombre, String nuevaDescripcion) {
        if (nuevoNombre.isEmpty()) {
            System.out.println("El nuevo nombre de la categoría no puede estar vacío.");
            return;
        }

        for (int i = 0; i < categorias.size(); i++) {
            if (i != indice && categorias.get(i).getNombre().equalsIgnoreCase(nuevoNombre)) {
                System.out.println("Ya existe una categoría con ese nombre.");
                return;
            }
        }

        Categoria cat = categorias.get(indice);
        cat.setNombre(nuevoNombre);
        cat.setDescripcion(nuevaDescripcion);
        guardarCategorias();
        System.out.println("Categoría modificada con éxito.");
    }

    public void eliminarCategoria(int indice) {
        System.out.println("¿Está seguro que desea eliminar la categoría? (s/n)");
        Scanner sc = new Scanner(System.in);
        String confirmacion = sc.nextLine();

        if (confirmacion.equalsIgnoreCase("s")) {
            categorias.remove(indice);
            guardarCategorias();
            System.out.println("Categoría eliminada con éxito.");
        } else {
            System.out.println("Operación cancelada.");
        }
    }
}
}
public class Main {
    public static void main(String[] args) {
        CategoriaManager manager = new CategoriaManager(); // Inicializamos el gestor de categorías
        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Gestión de Categorías ---");
            System.out.println("1. Ver categorías");
            System.out.println("2. Agregar categoría");
            System.out.println("3. Modificar categoría");
            System.out.println("4. Eliminar categoría");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir el salto de línea

            switch (opcion) {
                case 1:
                    manager.mostrarCategorias();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre de la categoría: ");
                    String nombre = sc.nextLine();
                    System.out.print("Ingrese la descripción de la categoría (opcional): ");
                    String descripcion = sc.nextLine();
                    manager.agregarCategoria(nombre, descripcion);
                    break;
                case 3:
                    manager.mostrarCategorias();
                    System.out.print("Seleccione el número de la categoría a modificar: ");
                    int indiceMod = sc.nextInt() - 1;
                    sc.nextLine();
                    if (indiceMod >= 0 && indiceMod < manager.categorias.size()) {
                        System.out.print("Nuevo nombre de la categoría: ");
                        String nuevoNombre = sc.nextLine();
                        System.out.print("Nueva descripción de la categoría (opcional): ");
                        String nuevaDescripcion = sc.nextLine();
                        manager.modificarCategoria(indiceMod, nuevoNombre, nuevaDescripcion);
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 4:
                    manager.mostrarCategorias();
                    System.out.print("Seleccione el número de la categoría a eliminar: ");
                    int indiceElim = sc.nextInt() - 1;
                    sc.nextLine();
                    if (indiceElim >= 0 && indiceElim < manager.categorias.size()) {
                        manager.eliminarCategoria(indiceElim);
                    } else {
                        System.out.println("Índice inválido.");
                    }
                    break;
                case 5:
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);
    }
}

    }