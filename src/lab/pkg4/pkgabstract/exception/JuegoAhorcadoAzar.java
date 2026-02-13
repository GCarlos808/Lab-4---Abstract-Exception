package lab.pkg4.pkgabstract.exception;
public class JuegoAhorcadoAzar extends JuegoAhorcadoBase{    
    
    public JuegoAhorcadoAzar(String palabraSecreta){
        this.palabraSecreta=palabraSecreta;
        intentos=0;
    }
    
    @Override
    public String actualizarPalabraActual(char letra){
        char[] arregloPalabraActual=palabraActual.toCharArray();
        for(int i=0;i<palabraSecreta.length();i++){
            if(letra==palabraSecreta.charAt(i)){
                arregloPalabraActual[i]=letra;
            }
        }
        palabraActual=arregloPalabraActual.toString();
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
        for(char c: arregloPalabraActual){
            c='_';
        }
        palabraActual=arregloPalabraActual.toString();
    }

    @Override
    public void jugar(){
        
    }    
}
