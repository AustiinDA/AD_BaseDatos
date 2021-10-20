import javax.swing.*;
import java.awt.*;

public class VentanicaGuapa extends JFrame {
    private JPanel panelPrincipal;

    JMenu menu, submenu;
    JMenuBar menuBar;
    private JButton button1;

    VentanicaGuapa(){
        super("hola");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panelPrincipal);

        JMenuBar menuBar = new JMenuBar();
        menuBar.add(menu = new JMenu("Servidor"));
        menuBar.add(submenu = new JMenu("Opciones"));
        setJMenuBar(menuBar);

        setPreferredSize(new Dimension(320, 390));
        this.pack();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    public static void main(String[] args) {
        new VentanicaGuapa();
    }
}

