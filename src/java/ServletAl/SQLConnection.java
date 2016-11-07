/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ServletAl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author pauva
 */
public class SQLConnection {
    

    public String login = "root";
    public String password = "";
    public String url = "jdbc:mysql://localhost:3306/curso";
    Connection conn = null;

   

    public SQLConnection() {
    }

    public Connection conectar() {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conn = DriverManager.getConnection(this.url, this.login, this.password);

            System.out.println("se ha conectado correctamente");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
           
        }
        return conn;
    }

    public void closeConnection() {
        try {
            conn.close();
            System.out.println("Conexión cerrada");
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Fallo al cerrar la conexión");
        }
    }

    public ResultSet executequery(String query ,Connection conn) {
        ResultSet rs = null;
        try {
            Statement st = conn.createStatement();
            rs = st.executeQuery(query);
            System.out.println("query: " + query + " ejecutado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return rs;// resulset con la lista de alumnos
    }
}
