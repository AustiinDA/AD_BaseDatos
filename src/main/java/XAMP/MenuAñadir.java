package XAMP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MenuAñadir extends JFrame implements ActionListener {
    private JPanel panelBotones;
    private JPanel panelPrincipal;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel panelTexto;
    private JTextField textoTitulo;
    private JPanel panelTexto2;
    private JTextField textoDuracion;
    private JTextField textoGenero;
    private JTextField textoDirector;
    private JTextField textoAño;

    public void guardarPelicula() throws SQLException { //Este método se encarga de guardar las películas en la lista

        Connection miCon = ConexionMySQL.conectar();
        PreparedStatement statement;

        //Condiciones para el cumplimiento de sintaxis, errores, etc..
        if (textoTitulo.getText().equals("") || textoDirector.equals("") || textoGenero.equals("") ||
                textoAño.equals("") || textoDuracion.equals("")) {

            JOptionPane.showMessageDialog(null, "No pueden haber campos vacíos", "Error", JOptionPane.ERROR_MESSAGE);

        } else {
            try {
                //Consultas para insertar los datos en la BDD
                statement = miCon.prepareStatement("INSERT IGNORE INTO taquilla (titulo, director, genero, año, duracion) VALUES (?,?,?,?,?)");
                statement.setString(1, String.valueOf(textoTitulo.getText()));
                statement.setString(2, String.valueOf(textoDirector.getText()));
                statement.setString(3, String.valueOf(textoGenero.getText()));
                statement.setInt(4, Integer.parseInt(String.valueOf(textoAño.getText())));
                statement.setInt(5, Integer.parseInt(String.valueOf(textoDuracion.getText())));

                statement.executeUpdate();

            //Recursos cerrados
                statement.close();
                miCon.close();

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        //Metodo para rellenar la lista con el contenido
        VentanicaGuapa.poblarLista();

    }

    //Interfaz
    MenuAñadir() throws SQLException {
        super("Añadir nuevos elementos: ");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(panelPrincipal);


        aceptarButton.addActionListener(this);


        setPreferredSize(new Dimension(500, 250));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Si pulsamos un boton que cumpla con algun requerimiento accionara un metodo
        String txtBotones = e.getActionCommand();
        try {
            if (txtBotones.equals("Aceptar")) {
                try {
                    guardarPelicula();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }

        } catch (NumberFormatException e2) {
            JOptionPane.showMessageDialog(null, "No puede haber caracteres en campos númericos", "Error", JOptionPane.ERROR_MESSAGE);
            //e2.printStackTrace();
        }

    }


}
