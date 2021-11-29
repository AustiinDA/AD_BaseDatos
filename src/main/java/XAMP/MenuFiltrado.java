package XAMP;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MenuFiltrado extends JFrame implements ActionListener {
    private JPanel panelPrincipal;
    private JButton aceptarButton;
    public JTextArea textoAFiltrar;
    private JPanel panelTexto;
    private JPanel panelBotones;
    private JPanel panelLista;
    private JList<Pelicula> listaFiltrada;
    public static DefaultListModel<Pelicula> modeloFiltrado = new DefaultListModel();

    MenuFiltrado() throws SQLException {
        super("Filtrar elementos: ");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setContentPane(panelPrincipal);

        aceptarButton.addActionListener(this);
        filtrarPelicula();
        setPreferredSize(new Dimension(500, 250));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    //El metodo filtra por el nombre del director
    public void filtrarPelicula() throws SQLException {
        Connection miCon = ConexionMySQL.conectar();
        PreparedStatement statement;


        if (textoAFiltrar.getText().equals("")) {

            JOptionPane.showMessageDialog(null, "Recuerda filtrar por nombre completo y no dejar campos vacíos", "Información", JOptionPane.INFORMATION_MESSAGE);
        } else {
            modeloFiltrado.clear();

            try {

                statement = miCon.prepareStatement("SELECT * FROM taquilla WHERE director LIKE ?");
                statement.setString(1, String.valueOf(textoAFiltrar.getText()));

                ResultSet rs = statement.executeQuery();

                while (rs.next()) {
                    //Añade elementos coincidentes a la nueva lista filtrada
                    modeloFiltrado.addElement(new Pelicula(rs.getString("titulo"),
                            rs.getString("director"),
                            rs.getString("genero"),
                            rs.getInt("año"),
                            rs.getInt("duracion")));
                }
                //Recursos cerrados
                rs.close();
                statement.close();
                miCon.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            //Establecemos modelo de la lista filtrada
            listaFiltrada.setModel(modeloFiltrado);

            System.out.println(modeloFiltrado);

        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //Si pulsamos un boton que cumpla con algun requerimiento accionara un metodo
        String txtBotones = e.getActionCommand();

        if (txtBotones.equals("Aceptar")) {

            try {
                filtrarPelicula();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }
}

