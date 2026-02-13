package lab.pkg4.pkgabstract.exception;
public class JuegoAhorcadoAzar extends JuegoAhorcadoBase{    
    
    public JuegoAhorcadoAzar(){
        intentos=limiteIntentos;
    }
    
    @Override
    public String actualizarPalabraActual(char letra){
        char[] arregloPalabraActual=palabraActual.toCharArray();
        for(int i=0;i<palabraSecreta.length();i++){
            if(letra==palabraSecreta.charAt(i)){
                arregloPalabraActual[i]=letra;
            }
        }
        palabraActual = new String(arregloPalabraActual);
        return palabraActual;
    }
    
    @Override
    public Boolean verificarLetra(char letra){
        for(int i=0;i<palabraSecreta.length();i++){
            if(palabraSecreta.charAt(i)==letra)
                return true;
        }
        return false;
    }
    
    @Override
    public Boolean hasGanado(){
        return palabraSecreta.equalsIgnoreCase(palabraActual);
    }

    @Override
    public void inicializarPalabraSecreta(){
        char[] arregloPalabraActual=new char[palabraSecreta.length()];
        for(int i = 0; i < arregloPalabraActual.length; i++){
        arregloPalabraActual[i] = '_';
    }
    palabraActual = new String(arregloPalabraActual);
    }

    @Override
    public void jugar(){
        
    }    
}
