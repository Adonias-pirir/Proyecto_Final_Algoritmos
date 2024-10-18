/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package proyecto;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author corre
 */
public class Principal {
    
    public static void main(String[] args) throws IOException, InterruptedException {
        //declarar variable
        Scanner scan = new Scanner(System.in);
        System.out.println("\n- BIENVENIDO -");
        System.out.println("-- PROYECTO DE ALGORITMOS 2024--");
        System.out.println("----------------------------");
        System.out.println("\n•A continuacion ingrese una opcion que desee ver");
        int opc;
        CategoriaManager manager=new CategoriaManager();
        //RegistroProd registro = new RegistroProd();
        do{
            //System.out.println("1.Gestion de productos\n2.Control de Existencias\nIngrese una opcion:");
            //opc = scan.nextInt();
             //scan.nextLine();
             System.out.println("\n1. Gestion de productos");
            System.out.println("2. Control de Existencias");
            System.out.println("3. Pedidos de Compra"); // Añade más opciones según tus necesidades
            System.out.println("4. Informes y Estadistica");
            System.out.println("5. Salir");
            System.out.print("\n\nOpcion: ");

            opc = scan.nextInt();
            scan.nextLine(); // Consumir el salto de línea
        
        switch (opc) {
                case 1 -> {
                    // Llamar a la gestión de productos utilizando la instancia de CategoriaManager
                    int opcionGestion;
                    do {
                        System.out.println("\n\n--- Gestion de Productos ---");
                        System.out.println("1. Ver categorías");
                        System.out.println("2. Agregar categoria");
                        System.out.println("3. Modificar categoria");
                        System.out.println("4. Eliminar categoria");
                        System.out.println("5. Volver al Inicio");
                        System.out.print("\nSeleccione una opcion: ");

                        opcionGestion = scan.nextInt();
                        scan.nextLine(); // Consumir el salto de línea

                        switch (opcionGestion) {
                            case 1 -> manager.mostrarCategorias();
                            case 2 -> {
                                System.out.print("\nIngrese el codigo de la categoria: ");
                                String codigo = scan.nextLine();
                                System.out.print("\nIngrese el nombre de la categoria: ");
                                String nombre = scan.nextLine();
                                System.out.print("Ingrese la descripcion de la categoria (opcional): ");
                                String descripcion = scan.nextLine();
                                manager.agregarCategoria(codigo, nombre, descripcion);
                            }
                            case 3 -> {
                                manager.mostrarCategorias();
                                System.out.print("\nSeleccione el numero de la categoria a modificar: ");
                                int indiceMod = scan.nextInt() - 1;
                                scan.nextLine();
                                if (indiceMod >= 0 && indiceMod < manager.categorias.size()) {
                                    System.out.print("Nuevo codigo de la categoria: ");
                                    String nuevoCodigo = scan.nextLine();
                                    System.out.print("Nuevo nombre de la categoria: ");
                                    String nuevoNombre = scan.nextLine();
                                    System.out.print("Nueva descripcion de la categoria (opcional): ");
                                    String nuevaDescripcion = scan.nextLine();
                                    manager.modificarCategoria(indiceMod, nuevoCodigo, nuevoNombre, nuevaDescripcion);
                                } else {
                                    System.out.println("Indice invalido.");
                                }
                            }
                            case 4 -> {
                                manager.mostrarCategorias();
                                System.out.print("\nSeleccione el numero de la categoria a eliminar: ");
                                int indiceElim = scan.nextInt() - 1;
                                scan.nextLine();
                                if (indiceElim >= 0 && indiceElim < manager.categorias.size()) {
                                    manager.eliminarCategoria(indiceElim);
                                } else {
                                    System.out.println("\nOpcion no aceptable.");
                                }
                            }
                            case 5 -> System.out.println("\nVolver al Inicio.");
                            default -> System.out.println("\nOpcion incorrecta 1-5.");
                        }
                    } while (opcionGestion != 5);
                }
                case 2 -> {
                    
                    int opcionGestion;
                    do {
                        System.out.println("\n\n--- Entrada de Productos ---");
                        System.out.println("1. Nuevo Producto");
                        System.out.println("2. Buscar Producto");
                        System.out.println("3. Volver al inicio");
                        System.out.print("\nSeleccione una opcion: ");

                        opcionGestion = scan.nextInt();
                        scan.nextLine(); // Consumir el salto de línea

                        switch (opcionGestion) {
                            case 1 -> {
                                //RegistroProd registro = new RegistroProd();
                                RegistroProd.main();
                                //System.out.print("\nNecesito ingresar un  nuevo producto: ");
                            }
                            case 2 -> {
                                System.out.print("\nIngrese el codigo del producto:");
                                
                            }
                            case 3 -> System.out.println("\nVolver al Inicio.");
                            default -> System.out.println("\nOpcion incorrecta 1-3.");
                        }
                    } while (opcionGestion != 3);
                }
               
                case 3 -> {
                }
                case 4 -> {
                }
                case 5 -> {
                    System.out.println("Saliendo del sistema.");
                    System.exit(0);
                }
                default -> System.out.println("Opciin incorrecta.");
            }
            // Agrega lógica para la opción 2
            // Agrega lógica para la opción 3
            // Agrega lógica para la opción 4
                    } while (opc != 5);
    }
}
