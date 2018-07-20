/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATCliente;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dalejwtf
 */
public class ConnectionSQL {
<<<<<<< HEAD
    private final String base = "proyectop";
    private final String user = "progAv";
    private final String pass = "progAv123";
=======
    private final String base = "datos1";
    private final String user = "progAv";
    private final String pass = "123123";
>>>>>>> 6936d63608c84257125da24af959a72494f7c0a9
    private final String url = "jdbc:mysql://localhost:3306/" + base;
    private Connection con = null;

    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection(url, user, pass);

        return con;
    }

    
}
