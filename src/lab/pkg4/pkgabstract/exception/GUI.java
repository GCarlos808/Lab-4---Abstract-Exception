package lab.pkg4.pkgabstract.exception;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.io.PrintStream;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GUI extends JFrame {

    private JLabel campoPista;
    private JTextField campoLetra;
    private JButton btnIntentar;
    private JButton btnRandom;
    private JButton btnFijo;
    private JTextField campoPalabra;
    private JButton btnAgregar;
    
    private JuegoAhorcadoFijo juegoFijo;
    private JuegoAhorcadoAzar juegoAzar;
    private JuegoAhorcadoBase juegoActual;
    private boolean juegoEnCurso = false;
    
    private final Color CPRIMARIO = new Color(51, 51, 51);
    private final Color CSECUNDARIO = new Color(255, 255, 255);
    private final Color CACENTO = new Color(76, 175, 80);
    private final Color CFONDO = new Color(245, 245, 245);
    private final Color CTEXTO = new Color(33, 33, 33);
    private final Color CTEXTO2 = new Color(117, 117, 117);
    
    public GUI(){
        setTitle("Juego Ahorcado Six");
        setSize(620, 670);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
        
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        initComponents();
    }
    
    public void setJuegos(JuegoAhorcadoFijo fijo, JuegoAhorcadoAzar azar) {
        this.juegoFijo = fijo;
        this.juegoAzar = azar;
    }
    
    public void initComponents(){
        JPanel panelPrincipal = new JPanel();
        panelPrincipal.setLayout(new BorderLayout());
        panelPrincipal.setBackground(CFONDO);

        JPanel Header = HeaderPanel();
        JPanel Body = BodyPanel();
        JPanel Footer = FooterPanel();

        panelPrincipal.add(Header, BorderLayout.NORTH);
        panelPrincipal.add(Body, BorderLayout.CENTER);
        panelPrincipal.add(Footer, BorderLayout.SOUTH);
        
        add(panelPrincipal);
    }
    
    private JPanel HeaderPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(CPRIMARIO);
        panel.setPreferredSize(new Dimension(520, 100));
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 30, 20, 30));

        JLabel lblTitulo = new JLabel("AHORCADO SIX");
        lblTitulo.setFont(new Font("Segoe UI", Font.BOLD, 28));
        lblTitulo.setForeground(CSECUNDARIO);
        lblTitulo.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel lblSubtitulo = new JLabel("Por cada fallo se irá dibujando el ahorcado");
        lblSubtitulo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        lblSubtitulo.setForeground(new Color(200, 200, 200));
        lblSubtitulo.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblSubtitulo.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        
        panel.add(lblTitulo);
        panel.add(lblSubtitulo);
        
        return panel;
    }
    
    private JPanel BodyPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(CFONDO);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));
        
        JTextArea consolaArea = new JTextArea();
        consolaArea.setEditable(false);
        consolaArea.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        consolaArea.setBackground(new Color(30, 30, 30));
        consolaArea.setForeground(new Color(180, 255, 180));
        consolaArea.setCaretColor(Color.WHITE);
        consolaArea.setBorder(BorderFactory.createEmptyBorder(8, 10, 8, 10));
        
        JScrollPane scroll = new JScrollPane(consolaArea);
        scroll.setPreferredSize(new Dimension(480, 180));
        scroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 180));
        scroll.setMinimumSize(new Dimension(100, 180));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));
        scroll.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        ConsolaOutputStream consolaStream = new ConsolaOutputStream(consolaArea);
        PrintStream printStream = new PrintStream(consolaStream, true);
        System.setOut(printStream);
        System.setErr(printStream);
        
        JSeparator separador = new JSeparator();
        separador.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        separador.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JPanel controlesPanel = new JPanel();
        controlesPanel.setLayout(new BoxLayout(controlesPanel, BoxLayout.Y_AXIS));
        controlesPanel.setBackground(CFONDO);
        controlesPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel lblModo = new JLabel("Modo de juego:");
        lblModo.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblModo.setForeground(CTEXTO);
        lblModo.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblModo.setBorder(BorderFactory.createEmptyBorder(0, 0, 6, 0));

        JPanel modoRow = new JPanel(new FlowLayout(FlowLayout.LEFT, 8, 0));
        modoRow.setBackground(CFONDO);
        modoRow.setAlignmentX(Component.LEFT_ALIGNMENT);
        modoRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));

        btnRandom = new JButton("Random");
        btnRandom.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnRandom.setForeground(CSECUNDARIO);
        btnRandom.setBackground(new Color(33, 150, 243));
        btnRandom.setFocusPainted(false);
        btnRandom.setBorderPainted(false);
        btnRandom.setPreferredSize(new Dimension(130, 36));
        btnRandom.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnRandom.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) {
                btnRandom.setBackground(new Color(25, 118, 210));
            }
            @Override public void mouseExited(MouseEvent e) {
                btnRandom.setBackground(new Color(33, 150, 243));
            }
        });
        btnRandom.addActionListener(e -> iniciarJuegoRandom());

        btnFijo = new JButton("Fijo");
        btnFijo.setFont(new Font("Segoe UI", Font.BOLD, 13));
        btnFijo.setForeground(CSECUNDARIO);
        btnFijo.setBackground(new Color(156, 39, 176));
        btnFijo.setFocusPainted(false);
        btnFijo.setBorderPainted(false);
        btnFijo.setPreferredSize(new Dimension(130, 36));
        btnFijo.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnFijo.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) {
                btnFijo.setBackground(new Color(123, 31, 162));
            }
            @Override public void mouseExited(MouseEvent e) {
                btnFijo.setBackground(new Color(156, 39, 176));
            }
        });
        btnFijo.addActionListener(e -> iniciarJuegoFijo());

        modoRow.add(btnRandom);
        modoRow.add(btnFijo);
        
        JSeparator sepInterno = new JSeparator();
        sepInterno.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        sepInterno.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel lblPalabraPista = new JLabel("Palabra secreta:");
        lblPalabraPista.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblPalabraPista.setForeground(CTEXTO);
        lblPalabraPista.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblPalabraPista.setBorder(BorderFactory.createEmptyBorder(10, 0, 5, 0));
        
        campoPista = new JLabel("Selecciona un modo para empezar");
        campoPista.setFont(new Font("Monospaced", Font.BOLD, 18));
        campoPista.setForeground(CTEXTO2);
        campoPista.setAlignmentX(Component.LEFT_ALIGNMENT);
        campoPista.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));
        
        JPanel inputRow = new JPanel(new BorderLayout(8, 0));
        inputRow.setBackground(CFONDO);
        inputRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 45));
        inputRow.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        campoLetra = STextField("Ingresa una letra...");
        campoLetra.setEnabled(false);
        
        btnIntentar = SButton();
        btnIntentar.setEnabled(false);
        btnIntentar.addActionListener(e -> intentarLetra());
        
        inputRow.add(campoLetra, BorderLayout.CENTER);
        inputRow.add(btnIntentar, BorderLayout.EAST);
        
        JSeparator sepInterno2 = new JSeparator();
        sepInterno2.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
        sepInterno2.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        JLabel lblAgregarPalabra = new JLabel("Agregar palabra al índice:");
        lblAgregarPalabra.setFont(new Font("Segoe UI", Font.BOLD, 13));
        lblAgregarPalabra.setForeground(CTEXTO);
        lblAgregarPalabra.setAlignmentX(Component.LEFT_ALIGNMENT);
        lblAgregarPalabra.setBorder(BorderFactory.createEmptyBorder(10, 0, 6, 0));
        
        JPanel palabraRow = new JPanel(new BorderLayout(8, 0));
        palabraRow.setBackground(CFONDO);
        palabraRow.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        palabraRow.setAlignmentX(Component.LEFT_ALIGNMENT);
        
        campoPalabra = STextField("Nueva palabra...");
        
        btnAgregar = new JButton("+ Agregar");
        btnAgregar.setFont(new Font("Segoe UI", Font.BOLD, 12));
        btnAgregar.setForeground(CSECUNDARIO);
        btnAgregar.setBackground(new Color(255, 152, 0));
        btnAgregar.setFocusPainted(false);
        btnAgregar.setBorderPainted(false);
        btnAgregar.setPreferredSize(new Dimension(100, 36));
        btnAgregar.setCursor(new Cursor(Cursor.HAND_CURSOR));
        btnAgregar.addMouseListener(new MouseAdapter() {
            @Override public void mouseEntered(MouseEvent e) {
                btnAgregar.setBackground(new Color(230, 120, 0));
            }
            @Override public void mouseExited(MouseEvent e) {
                btnAgregar.setBackground(new Color(255, 152, 0));
            }
        });
        btnAgregar.addActionListener(e -> agregarPalabra());
        
        palabraRow.add(campoPalabra, BorderLayout.CENTER);
        palabraRow.add(btnAgregar, BorderLayout.EAST);
        
        controlesPanel.add(lblModo);
        controlesPanel.add(modoRow);
        controlesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        controlesPanel.add(sepInterno);
        controlesPanel.add(lblPalabraPista);
        controlesPanel.add(campoPista);
        controlesPanel.add(inputRow);
        controlesPanel.add(Box.createRigidArea(new Dimension(0, 10)));
        controlesPanel.add(sepInterno2);
        controlesPanel.add(lblAgregarPalabra);
        controlesPanel.add(palabraRow);

        panel.add(scroll);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(separador);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(controlesPanel);

        return panel;
    }
    
    
    private void iniciarJuegoRandom() {
        juegoAzar = new JuegoAhorcadoAzar();
        juegoActual = juegoAzar;
        juegoActual.inicializarPalabraSecreta();
        iniciarJuego("RANDOM");
    }
    
    private void iniciarJuegoFijo() {
        String palabra = JOptionPane.showInputDialog(this, 
            "Ingresa la palabra secreta:", 
            "Modo Fijo", 
            JOptionPane.PLAIN_MESSAGE);
        
        if (palabra == null || palabra.trim().isEmpty()) {
            System.out.println("⚠️ Palabra inválida");
            return;
        }
        
        juegoFijo = new JuegoAhorcadoFijo(palabra.trim().toLowerCase());
        juegoActual = juegoFijo;
        juegoActual.inicializarPalabraSecreta();
        iniciarJuego("FIJO");
    }
    
    private void iniciarJuego(String modo) {
        juegoEnCurso = true;
        
        campoLetra.setEnabled(true);
        btnIntentar.setEnabled(true);
        campoPista.setForeground(CACENTO);
        actualizarPantalla();
        
        System.out.println("\n═══════════════════════════════════");
        System.out.println("  MODO: " + modo);
        System.out.println("  Intentos restantes: " + juegoActual.intentos);
        System.out.println("═══════════════════════════════════\n");
    }
    
    private void intentarLetra() {
        if (!juegoEnCurso) return;
        
        String texto = campoLetra.getText().trim();
        
        if (texto.isEmpty() || texto.equals("Ingresa una letra...")) {
            System.out.println("⚠️ Debes ingresar una letra");
            return;
        }
        
        if (texto.length() != 1) {
            System.out.println("⚠️ Ingresa solo UNA letra");
            campoLetra.setText("");
            return;
        }
        
        char letra = texto.toLowerCase().charAt(0);
        
        if (juegoActual.letraRepetida(letra)) {
            System.out.println("⚠️ Letra repetida: " + letra);
            campoLetra.setText("");
            return;
        }
        
        if (juegoActual.verificarLetra(letra)) {
            System.out.println("✅ ¡Correcto! La letra '" + letra + "' está en la palabra");
            juegoActual.actualizarPalabraActual(letra);
        } else {
            juegoActual.intentos--;
            System.out.println("❌ La letra '" + letra + "' NO está en la palabra");
            System.out.println("Intentos restantes: " + juegoActual.intentos);
        }
        
        campoLetra.setText("");
        actualizarPantalla();
        verificarFinJuego();
    }
    
    private void actualizarPantalla() {
        campoPista.setText(juegoActual.palabraActual.replace("", " ").trim());
        
        int errores = juegoActual.limiteIntentos - juegoActual.intentos;
        if (errores < juegoActual.figuraAhorcado.size()) {
            System.out.println(juegoActual.figuraAhorcado.get(errores));
        }
    }
    
    private void verificarFinJuego() {
        if (juegoActual.hasGanado()) {
            System.out.println("\n🎉 ¡FELICIDADES! Has ganado");
            System.out.println("La palabra era: " + juegoActual.palabraSecreta);
            finalizarJuego();
        } else if (juegoActual.intentos <= 0) {
            System.out.println("\n💀 GAME OVER");
            System.out.println("La palabra era: " + juegoActual.palabraSecreta);
            System.out.println(juegoActual.figuraAhorcado.get(juegoActual.figuraAhorcado.size() - 1));
            finalizarJuego();
        }
    }
    
    private void finalizarJuego() {
        juegoEnCurso = false;
        campoLetra.setEnabled(false);
        btnIntentar.setEnabled(false);
        campoPista.setText("Selecciona un modo para empezar");
        campoPista.setForeground(CTEXTO2);
    }
    
    private void agregarPalabra() {
        String palabra = campoPalabra.getText().trim();
        
        if (palabra.isEmpty() || palabra.equals("Nueva palabra...")) {
            System.out.println("⚠️ Ingresa una palabra válida");
            return;
        }
        
        AdminPalabrasSecretas.ListaPalabras.add(palabra.toLowerCase());
        System.out.println("✅ Palabra agregada: " + palabra);
        campoPalabra.setText("");
    }
    
    
    private JTextField STextField(String placeholder) {
        JTextField textField = new JTextField(20);
        textField.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        textField.setForeground(CTEXTO);
        textField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(220, 220, 220), 1),
            BorderFactory.createEmptyBorder(10, 15, 10, 15)
        ));

        textField.setText(placeholder);
        textField.setForeground(CTEXTO2);
        
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (textField.getText().equals(placeholder)) {
                    textField.setText("");
                    textField.setForeground(CTEXTO);
                }
            }
            
            @Override
            public void focusLost(FocusEvent e) {
                if (textField.getText().isEmpty()) {
                    textField.setText(placeholder);
                    textField.setForeground(CTEXTO2);
                }
            }
        });
        
        return textField;
    }
    
    private JButton SButton() {
        JButton button = new JButton("PROBAR LETRA");
        button.setFont(new Font("Segoe UI", Font.BOLD, 13));
        button.setForeground(CSECUNDARIO);
        button.setBackground(CACENTO);
        button.setFocusPainted(false);
        btnBorderPainted(false);
        button.setPreferredSize(new Dimension(150, 45));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                if (button.isEnabled()) {
                    button.setBackground(new Color(67, 160, 71));
                }
            }
            
            @Override
            public void mouseExited(MouseEvent e) {
                button.setBackground(CACENTO);
            }
        });
        
        return button;
    }
    
    private JPanel FooterPanel() {
        JPanel panel = new JPanel();
        panel.setBackground(CFONDO);
        panel.setPreferredSize(new Dimension(520, 40));
        panel.setBorder(BorderFactory.createEmptyBorder(0, 30, 10, 30));
        
        JLabel lblInfo = new JLabel("Adivina la palabra secreta para ganar");
        lblInfo.setFont(new Font("Segoe UI", Font.ITALIC, 12));
        lblInfo.setForeground(CTEXTO2);
        
        panel.add(lblInfo);
        
        return panel;
    }

    private void btnBorderPainted(boolean b) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}