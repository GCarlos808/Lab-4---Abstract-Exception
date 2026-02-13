
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
    
    static public String ObtenerPalabraRNG(){
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
    
    public static void main(String [] args){
        String Palabra;
        while(!ListaPalabras.isEmpty()){
            for(int x=0 ; x<10 ; x++){
                AgregarPalabras();
                Palabra = ObtenerPalabraRNG();
                System.out.println(Palabra);
            }
        }
        
    }
}

    