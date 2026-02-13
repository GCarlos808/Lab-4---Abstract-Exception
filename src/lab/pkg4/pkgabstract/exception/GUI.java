package lab.pkg4.pkgabstract.exception;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;
import java.io.PrintStream;
import static javax.swing.WindowConstants.EXIT_ON_CLOSE;

public class GUI extends JFrame {

    private static JLabel campoPalabraSecreta;
    private static JLabel intentosRestantes;
    private static JTextField contador;
    private static JTextField mensajeGuia;
    private static  JButton intentar;
    private static JTextField guia;
    private static JButton reiniciar;
    
    private final Color CPRIMARIO = new Color(51, 51, 51);
    private final Color CSECUNDARIO = new Color(255, 255, 255);
    private final Color CACENTO = new Color(76, 175, 80);
    private final Color CFONDO = new Color(245, 245, 245);
    private final Color CTEXTO = new Color(33, 33, 33);
    private final Color CTEXTO2 = new Color(117, 117, 117);
    
    public GUI(){
    
        setTitle("Juego Ahorcado Six");
        setSize(540, 600);
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
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(15, 30, 15, 30));

        JTextArea consolaArea = new JTextArea();
        consolaArea.setEditable(false);
        consolaArea.setFont(new Font("SegoeUI", Font.PLAIN, 13));
        consolaArea.setBackground(new Color(30, 30, 30));
        consolaArea.setForeground(new Color(180, 255, 180));
        consolaArea.setCaretColor(Color.WHITE);
        consolaArea.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        JScrollPane scroll = new JScrollPane(consolaArea);
        scroll.setPreferredSize(new Dimension(480, 150));
        scroll.setMaximumSize(new Dimension(Integer.MAX_VALUE, 150));
        scroll.setBorder(BorderFactory.createLineBorder(new Color(220, 220, 220), 1));

        ConsolaOutputStream consolaStream = new ConsolaOutputStream(consolaArea);
        PrintStream printStream = new PrintStream(consolaStream, true);
        
        
        System.setOut(printStream);
        System.setErr(printStream);
        
        panel.add(scroll, BorderLayout.CENTER);
        return panel;
        
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
        JButton button = new JButton("INICIAR JUEGO");
        button.setFont(new Font("Segoe UI", Font.BOLD, 15));
        button.setForeground(CSECUNDARIO);
        button.setBackground(CACENTO);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setPreferredSize(new Dimension(200, 45));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));

        button.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                button.setBackground(new Color(67, 160, 71));
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
}