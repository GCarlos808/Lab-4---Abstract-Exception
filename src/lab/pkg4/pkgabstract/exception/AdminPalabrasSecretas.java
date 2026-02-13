
package lab.pkg4.pkgabstract.exception;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AdminPalabrasSecretas {
    static ArrayList<String> ListaPalabras = new ArrayList<>();
    
    static public void AgregarPalabras(){
        ListaPalabras.add("gato");
        ListaPalabras.add("perro");
        ListaPalabras.add("telefono");
        ListaPalabras.add("laptop");
        ListaPalabras.add("cargador");
        ListaPalabras.add("vaso");
        ListaPalabras.add("arbol");
        ListaPalabras.add("pelo");
        ListaPalabras.add("mochila");
        ListaPalabras.add("chimbo");
    }
    
    public static String ObtenerPalabraRNG(){
        int indiceRNG;
        
        Random BuscarRNG = new Random();
        indiceRNG = BuscarRNG.nextInt(ListaPalabras.size());
        return ListaPalabras.get(indiceRNG);
    }
    
    public static void main(String [] args){
        Scanner n = new Scanner(System.in);
        String Palabra;
        int opcion=1;
        AgregarPalabras();
        Palabra = ObtenerPalabraRNG();
        while(opcion==1){
            System.out.println("agrege");
            opcion = n.nextInt();

            System.out.println(Palabra);
        }
    }
}

    