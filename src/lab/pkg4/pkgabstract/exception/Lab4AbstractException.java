package lab.pkg4.pkgabstract.exception;

public class Lab4AbstractException {
    
    private static JuegoAhorcadoFijo juegoFijo;
    private static JuegoAhorcadoAzar juegoAzar;
    private static GUI ventana;
    
    public static void main(String[] args) {
        AdminPalabrasSecretas.AgregarPalabras();
        
        inicializarJuegos();
        
        ventana = new GUI();
        ventana.setVisible(true);
        
        ventana.setJuegos(juegoFijo, juegoAzar);
    }
    
    private static void inicializarJuegos() {
        juegoAzar = new JuegoAhorcadoAzar();
        
        juegoFijo = new JuegoAhorcadoFijo("programacion");
        
        System.out.println("═══════════════════════════════════");
        System.out.println("  JUEGOS INICIALIZADOS");
        System.out.println("  - Juego Fijo: palabra cargada");
        System.out.println("  - Juego Azar: palabra aleatoria");
        System.out.println("═══════════════════════════════════\n");
    }
}