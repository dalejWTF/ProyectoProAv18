/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATCliente;

import Clases.Cliente;
import Clases.Direccion;
import Clases.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author dalejwtf
 */
public class DATCliente {

    ConnectionSQL conect = new ConnectionSQL();

    //Metodos GET
    
    //Devuelve lista de usuarios y pass para validaciones
    public ResultSet getUsrPss() throws ClassNotFoundException, SQLException {
        Statement s = conect.getConnection().createStatement();
        String sql = "SELECT u.usuario, u.contrasena FROM usuario u";
        return s.executeQuery(sql);
    }

    //Devuelve un cliente que ha sido buscado
    public ResultSet getCliente(String cedula) throws ClassNotFoundException, SQLException {
        Statement ps = null;
        String sql = "SELECT c.cedula, c.apellidos, c.nombres, c.fechaNacimiento, c.numTelefono, p.id pais,d.ciudad, d.calles, g.id genero, u.usuario, u.contrasena, t.id tipo FROM cliente c, pais p, direccion d, genero g, tipo t,usuario u WHERE c.direccion=d.id AND d.id_pais=p.id AND g.id=c.genero AND t.id= u.id_tipo AND c.cedula=" + cedula;
        ps = conect.getConnection().createStatement();

        return ps.executeQuery(sql);

    }

    //Retorna la lista de paises
    public ResultSet ObtenerPais() throws ClassNotFoundException, SQLException {
        Statement s = conect.getConnection().createStatement();
        String sql = "SELECT * FROM pais";
        return s.executeQuery(sql); 

    }

    //Metodos Para obtener el ultimo Id de las tablas para enlazar al momento de agregar
    public ResultSet getIdDir() throws ClassNotFoundException, SQLException {
        Statement s;
        s = conect.getConnection().createStatement();
        String sql = "SELECT COUNT(*) FROM direccion";
        return s.executeQuery(sql);
    }

    public ResultSet getIdCliente() throws ClassNotFoundException, SQLException {
        Statement s;
        s = conect.getConnection().createStatement();
        String sql = "SELECT COUNT(*) FROM cliente";
        return s.executeQuery(sql);
    }

    //Fin metodos GET
    
    
    //Metodos ADD
    
    //Metodo para agregar Direccion
    public PreparedStatement addDireccion(Direccion direccion) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO direccion (id, id_pais, calles, ciudad) VALUES (NULL, ?, ?, ?);";
        ps = conect.getConnection().prepareStatement(sql);
        ps.setInt(1, direccion.getId_pais());
        ps.setString(2, direccion.getCallesRes());
        ps.setString(3, direccion.getCiudad());
        return ps;
    }

    //SMetodo para agregar Cliente
    public PreparedStatement addCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO cliente (id, cedula, apellidos, nombres, fechaNacimiento, genero, numTelefono, direccion) VALUES (NULL, ?, ?, ?, ?,?, ?, ?);";
        ps = conect.getConnection().prepareStatement(sql);
        ps.setString(1, cliente.getCedula());
        ps.setString(2, cliente.getApellidos());
        ps.setString(3, cliente.getNombres());
        ps.setDate(4, cliente.getFechaNacimiento());
        ps.setInt(5, cliente.getGenero());
        ps.setString(6, cliente.getNumTelefono());
        ps.setInt(7, cliente.getDireccionEnvio().getId_direccion());
        return ps;
    }

    //SMetodo para agregar Usuario
    public PreparedStatement addUsuario(Usuario usuario) throws ClassNotFoundException, SQLException {
        PreparedStatement ps = null;
        String sql = "INSERT INTO usuario (id, id_cliente, id_tipo, usuario, contrasena) VALUES (NULL, ?, ?, ?, ?);";
        ps = conect.getConnection().prepareStatement(sql);
        ps.setInt(1, usuario.getCliente().getId());
        ps.setInt(2, usuario.getId_tipo());
        ps.setString(3, usuario.getUsuario());
        ps.setString(4, usuario.getPass());
        return ps;
    }
    //Fin metodos ADD
    
    //Metodos Editar
    
    public PreparedStatement EditarCliente(Cliente cliente) throws ClassNotFoundException, SQLException {
        PreparedStatement ps=null;
        String sql="UPDATE cliente SET cedula = ?, apellidos = ?, nombres = ?, "
                + "fechaNacimiento = ?, genero = ?, numTelefono = ? WHERE cliente.id = ?;";
        ps= conect.getConnection().prepareStatement(sql);
        ps.setString(1, cliente.getCedula());
        ps.setString(2, cliente.getApellidos());
        ps.setString(3, cliente.getNombres());
        ps.setDate(4, cliente.getFechaNacimiento());
        ps.setInt(5, cliente.getId());
        ps.setString(6, cliente.getNumTelefono());
        ps.setInt(7, cliente.getId());
        
        return ps;
    }

    public PreparedStatement EditarUsuario() throws ClassNotFoundException, SQLException {
PreparedStatement ps=null;
String sql="UPDATE usuario SET id_cliente = ?, id_tipo = ?, usuario = ?, contrasena = ? WHERE usuario.id = ?;";
        ps= conect.getConnection().prepareStatement(sql);
        return ps;
    }

    public PreparedStatement EditarDireccion(Direccion direccion) throws ClassNotFoundException, SQLException {
        PreparedStatement ps=null;
        String sql="UPDATE direccion SET id_pais = ?, calles = ?, ciudad = ? WHERE direccion.id = ?;";
        ps= conect.getConnection().prepareStatement(sql);
        ps.setInt(1, direccion.getId_pais());
        ps.setString(2, direccion.getCallesRes());
        ps.setString(3, direccion.getCiudad());
        ps.setInt(4, direccion.getId_direccion());
        return ps;
    }
    //Fin metodos Editar
}
