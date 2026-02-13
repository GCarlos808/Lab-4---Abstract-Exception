package lab.pkg4.pkgabstract.exception;
import java.util.ArrayList;
public abstract class JuegoAhorcadoBase implements JuegoAhorcado{
    protected String palabraSecreta, palabraActual;
    protected int intentos;
    protected final int limiteIntentos=6;
    ArrayList<Character> letrasUsadas=new ArrayList<>();
    ArrayList<String> figuraAhorcado=new ArrayList<>();
    
    abstract String actualizarPalabraActual(char letra);
    
    abstract Boolean verificarLetra(char letra);
    
    abstract Boolean hasGanado();
    
    public Boolean letraRepetida(char letra){
    for(char l: letrasUsadas){
        if(l==letra){
            return true;
        }
    }
    return false;
    }
}
