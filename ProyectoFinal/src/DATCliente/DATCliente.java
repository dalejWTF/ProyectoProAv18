/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATCliente;

import Clases.Cliente;
import Clases.Direccion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dalejwtf
 */
public class DATCliente {
    ConnectionSQL conect= new ConnectionSQL();
    
    public ResultSet getUsrPss() throws ClassNotFoundException, SQLException{
        Statement s= conect.getConnection().createStatement();
        String sql="SELECT u.usuario, u.contrasena FROM usuario u";
        return s.executeQuery(sql);
    }
    
    public ResultSet getCliente(String cedula) throws ClassNotFoundException, SQLException{
        Statement ps= null;
        String sql="SELECT c.cedula, c.apellidos, c.nombres, c.fechaNacimiento, c.numTelefono, p.id pais,d.ciudad, d.calles, g.id genero, u.usuario, u.contrasena, t.id tipo FROM cliente c, pais p, direccion d, genero g, tipo t,usuario u WHERE c.direccion=d.id AND d.id_pais=p.id AND g.id=c.genero AND t.id= u.id_tipo AND c.cedula="+cedula;
        ps= conect.getConnection().createStatement();
        
        return ps.executeQuery(sql);
        
    }
    
    public ResultSet ObtenerPais() throws ClassNotFoundException, SQLException{
        Statement s= conect.getConnection().createStatement();
        String sql="SELECT * FROM pais";
        return s.executeQuery(sql);
        
    }
    
    public PreparedStatement addDireccion(Direccion direccion) throws ClassNotFoundException,SQLException{
        PreparedStatement ps=null;
        String sql="INSERT INTO direccion (id, id_pais, calles, ciudad) VALUES (NULL, ?, ?, ?);";
        ps=conect.getConnection().prepareStatement(sql);
        ps.setInt(1, direccion.getId_pais());
        ps.setString(2, direccion.getCallesRes());
        ps.setString(3, direccion.getCiudad());
        return ps;
    }
    //SELECT * FROM direccion WHERE id = (SELECT MAX(id) FROM direccion)
    public PreparedStatement addCliente(Cliente cliente) throws ClassNotFoundException, SQLException{
        PreparedStatement ps=null;
        String sql="INSERT INTO cliente (id, cedula, apellidos, nombres, fechaNacimiento, genero, numTelefono, direccion) VALUES (NULL, ?, ?, ?, ?,?, ?, ?);";
        ps= conect.getConnection().prepareStatement(sql);
        ps.setString(1, cliente.getCedula());
        ps.setString(2, cliente.getApellidos());
        ps.setString(3, cliente.getNombres());
        ps.setDate(4, cliente.getFechaNacimiento());
        ps.setInt(5, cliente.getGenero());
        ps.setString(6, cliente.getNumTelefono());
        ps.setInt(7, cliente.getDireccionEnvio().getId_direccion());
        return ps;
    }
    
    //SELECT COUNT(*) FROM direccion
    public ResultSet getIdDir() throws ClassNotFoundException, SQLException{
        Statement s;
        s= conect.getConnection().createStatement();
        String sql="SELECT COUNT(*) FROM direccion";
        return s.executeQuery(sql);
    }
    public ResultSet getIdCliente() throws ClassNotFoundException, SQLException{
        Statement s;
        s= conect.getConnection().createStatement();
        String sql="SELECT COUNT(*) FROM cliente";
        return s.executeQuery(sql);
    }
}
