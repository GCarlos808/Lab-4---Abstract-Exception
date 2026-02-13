package lab.pkg4.pkgabstract.exception;

import java.io.OutputStream;
import javax.swing.*;


public class ConsolaOutputStream extends OutputStream{

    private JTextArea consola;

    public ConsolaOutputStream(JTextArea consola) {
        this.consola = consola;
    }

    @Override
    public void write(int b) {
        consola.append(String.valueOf((char) b));
    }
}
