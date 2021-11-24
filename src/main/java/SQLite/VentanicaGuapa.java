package SQLite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.sql.SQLException;

public class VentanicaGuapa extends JFrame{

    JPanel panelPrincipal;
    JPanel panelBotones;

    JButton boton1;
    JButton boton2;
    JButton boton3;

    JPanel panelLista;
    JList listadoBD;


    VentanicaGuapa() {
        super("Base de datos");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panelPrincipal);


        setPreferredSize(new Dimension(320, 390));
        this.pack();
        setLocationRelativeTo(null);
        setVisible(true);

        panelPrincipal.addComponentListener(new ComponentAdapter() {
        });
    }

    public static void main(String[] args) {
        new VentanicaGuapa();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

}

