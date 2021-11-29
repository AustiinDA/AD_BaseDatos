package XAMP;

import Ejercicio_Biblioteca.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.sql.*;

public class VentanicaGuapa extends JFrame {

    public JPanel panelPrincipal;
    public JPanel panelBotones;

    public  JButton boton1;
    public  JButton boton2;
    public  JButton boton3;

    public  JPanel panelLista;
    private JList<Pelicula> listaPeliculas;

    public static DefaultListModel<Pelicula> modelo = new DefaultListModel<>();


    VentanicaGuapa() throws SQLException {
        super("Base de datos");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panelPrincipal);

        listaPeliculas.setModel(modelo);



        setPreferredSize(new Dimension(660, 400 ));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        poblarLista();
        panelPrincipal.addComponentListener(new ComponentAdapter() {
        });
    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    //Poblar la JList con elementos
    public void poblarLista() throws SQLException {
        Connection miCon = ConexionMySQL.conectar();
        PreparedStatement statement;

        try {
            statement = miCon.prepareStatement("SELECT * FROM taquilla");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) //go through each row that your query returns
            {
                // String itemCode = resultSet.getString("titulo"); //get the element in column "
                modelo.addElement(new Pelicula(resultSet.getString("titulo"),
                        resultSet.getString("director"),
                        resultSet.getString("genero"),
                        resultSet.getInt("año"),
                        resultSet.getInt("duracion")));
                //añadir cada elemento al modelo
            }
            resultSet.close();
            statement.close();
            miCon.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

