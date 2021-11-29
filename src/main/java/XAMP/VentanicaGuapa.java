package XAMP;

import Ejercicio_Biblioteca.Conexion;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.sql.*;

public class VentanicaGuapa extends JFrame implements ActionListener {

    public JPanel panelPrincipal;
    public JPanel panelBotones;

    public JButton boton1;
    public JButton boton2;
    public JButton boton3;

    public JPanel panelLista;
    public JList<Pelicula> listaPeliculas;

    public static DefaultListModel<Pelicula> modelo = new DefaultListModel<>();


    VentanicaGuapa() throws SQLException {
        super("Base de datos");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setContentPane(panelPrincipal);

        listaPeliculas.setModel(modelo);

        boton1.addActionListener(this);
        boton2.addActionListener(this);
        boton3.addActionListener(this);

        setPreferredSize(new Dimension(660, 400));
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
        poblarLista();

    }


    private void createUIComponents() {
        // TODO: place custom component creation code here
    }

    //Poblar la JList con elementos
    public static void poblarLista() throws SQLException {
        Connection miCon = ConexionMySQL.conectar();
        PreparedStatement statement;
        modelo.clear();
        try {
            statement = miCon.prepareStatement("SELECT * FROM taquilla");
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next())
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

    @Override
    public void actionPerformed(ActionEvent e) {
        Connection miCon = ConexionMySQL.conectar();
        PreparedStatement statement;

        String txtBotones = e.getActionCommand();


        if (txtBotones.equals("Añadir")) {
            listaPeliculas.clearSelection();
            try {
                new MenuAñadir();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } else if (txtBotones.equals("Eliminar")) {
            try {
                statement = miCon.prepareStatement("DELETE FROM taquilla WHERE titulo='"+listaPeliculas.getSelectedValue().titulo+ "';");
                statement.execute();

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            modelo.remove(listaPeliculas.getSelectedIndex());


        }


    }
}

