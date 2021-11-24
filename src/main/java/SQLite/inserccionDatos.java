package SQLite;

import javax.swing.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class inserccionDatos {

    public static ArrayList<Pelicula> peliculas = new ArrayList<>();


    public static void crearDatosPelicula() {


    }

    public void poblarLista(JList list, String consulta, Connection miCon) throws SQLException {
        DefaultListModel model = new DefaultListModel(); //create a new list model

        Statement statement = miCon.createStatement();
        ResultSet resultSet = statement.executeQuery(consulta); //run your query

        while (resultSet.next()) //go through each row that your query returns
        {
            String itemCode = resultSet.getString("item_code"); //get the element in column "item_code"
            model.addElement(itemCode); //add each item to the model
        }
        list.setModel(model);

        resultSet.close();
        statement.close();

    }
}
