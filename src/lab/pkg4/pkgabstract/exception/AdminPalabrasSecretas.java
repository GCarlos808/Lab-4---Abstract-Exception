
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
        String Palabra;
        if (ListaPalabras.isEmpty()) { 
            return "Ya no quedan palabras"; 
        }
        
        Random BuscarRNG = new Random();
        indiceRNG = BuscarRNG.nextInt(ListaPalabras.size());    
        Palabra = ListaPalabras.remove(indiceRNG);
        
        return Palabra;
    }
    
   
        
    }


    