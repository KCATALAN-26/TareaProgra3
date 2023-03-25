package menu;

import java.util.Scanner;

public class Menu {
    
    private final Arbol arbol;
    private final Scanner scanner;
    
    public Menu() {
        arbol = new Arbol();
        scanner = new Scanner(System.in);
    }
    
    public void mostrar() {
        int opcion = 0;
        do {
            System.out.println("\n------------Menú------------");
            System.out.println("1. Insertar un nodo");
            System.out.println("2. Buscar un elemento");
            System.out.println("3. Eliminar un nodo");
            System.out.println("4. Listar valores del nodo");
            System.out.println("5. Salir");
            System.out.println("-----------------------------");
            System.out.print("\u001B[35m\nSeleccione una Opción: \u001B[0m");
            opcion = scanner.nextInt();
            scanner.nextLine(); 
            
            switch (opcion) {
                case 1:
                    System.out.print("\nIngrese un número: ");
                    int numero = scanner.nextInt();
                    arbol.insertar(numero);
                    System.out.println("\u001B[34m\nEl número ingresado es: \u001B[0m: "+numero);
                    break;
                case 2:
                    System.out.print("\nIngrese un número: ");
                    int numeroBuscado = scanner.nextInt();
                    arbol.buscar(numeroBuscado);
                    break;
                case 3:
                    System.out.print("\nIngrese un número: ");
                    int numeroEliminado = scanner.nextInt();
                    System.out.println("\u001B[31m\nEl número Eliminado es: \u001B[0m" + numeroEliminado);
                    arbol.eliminar(numeroEliminado);
                    break;
                case 4:
                    System.out.println("\nLista de valores del nodo: ");
                    System.out.println("");
                    arbol.listar();
                                        break;
                case 5:
                    System.out.println("\nSaliendo...");
                    break;
                default:
                    System.out.println("\nOpción inválida.");
                    break;
            }
        } while (opcion != 5);
    }

    public static void main(String[] args) {
         Menu menu = new Menu();
        menu.mostrar();
    }
    
}
