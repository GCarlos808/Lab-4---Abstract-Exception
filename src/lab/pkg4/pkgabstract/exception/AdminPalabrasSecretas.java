package lab.pkg4.pkgabstract.exception;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;


public class AdminPalabrasSecretas {
    private static ArrayList<String> listaPalabras = new ArrayList<>();
    private static Random rng = new Random();

    public static boolean agregarPalabra(String palabra){
        palabra = palabra.toLowerCase().trim(); 
        if (!listaPalabras.contains(palabra)) {
            listaPalabras.add(palabra);
            return true; 
        } else {
            return false; 
        }
    }

    public static String obtenerPalabraRNG(){
        if (listaPalabras.isEmpty()) {
            return "No hay palabras disponibles.";
        }
        int indice = rng.nextInt(listaPalabras.size());
        return listaPalabras.get(indice);
    }
    

    public static void main(String[] args){
        Scanner n = new Scanner(System.in);
        String opcion;

        System.out.println("=== Juego de Palabras Secretas ===");

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Agregar palabra");
            System.out.println("2. Obtener palabra aleatoria");
            System.out.println("3. Mostrar todas las palabras");
            System.out.println("4. Salir");
            System.out.print("Elige una opcion: ");
            opcion = n.nextLine();

            switch(opcion){
                case "1":
                    System.out.print("Ingresa la palabra: ");
                    String nuevaPalabra = n.nextLine();
                    if (agregarPalabra(nuevaPalabra)) {
                        System.out.println("Palabra agregada correctamente.");
                    } else {
                        System.out.println("Esa palabra ya existe en la lista.");
                    }
                    break;
                case "2":
                    System.out.println("Palabra aleatoria: " + obtenerPalabraRNG());
                    break;
                case "3":
                    System.out.println("Saliendo del programa...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (!opcion.equals("3"));

        n.close();
    }
}
