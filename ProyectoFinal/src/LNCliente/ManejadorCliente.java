/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LNCliente;

import Clases.Cliente;
import Clases.Direccion;
import Clases.Pais;
import Clases.Usuario;
import DATCliente.DATCliente;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author dalejwtf
 */
public class ManejadorCliente {

    public Usuario getCliente(String cedula) throws ClassNotFoundException, SQLException {
        ResultSet rs = null;
        Cliente c= new Cliente();
        Usuario u = new Usuario();
        DATCliente datCliente = new DATCliente();
        rs = datCliente.getCliente(cedula);
        if (rs.next()) {
            c.setCedula(rs.getString("cedula"));
            c.setApellidos(rs.getString("apellidos"));
            c.setNombres(rs.getString("nombres"));
            c.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            c.setNumTelefono(rs.getString("numTelefono"));
            Direccion dir = new Direccion();
            dir.setId_pais(rs.getInt("pais"));
            dir.setCiudad(rs.getString("ciudad"));
            dir.setCallesRes(rs.getString("calles"));
            c.setDireccionEnvio(dir);
            c.setGenero(rs.getInt("genero"));
            u.setCliente(c);
            u.setUsuario(rs.getString("usuario"));
            u.setPass(rs.getString("contrasena"));
            u.setId_tipo(rs.getInt("tipo"));
        }
        return u;
    }
    
    public ArrayList<Pais> ObtenerPaises() throws ClassNotFoundException, SQLException {
        ArrayList<Pais> paises = new ArrayList<>();
        DATCliente dATCliente = new DATCliente();
        ResultSet rs = dATCliente.ObtenerPais();
        while (rs.next()) {
            Pais pais = new Pais(rs.getInt(1), rs.getString(2));
            paises.add(pais);
        }

        return paises;
    }
    
    public ArrayList<Usuario> obtenerUsuarios() throws ClassNotFoundException, SQLException{
        ArrayList<Usuario> users= new ArrayList<>();
        DATCliente datc= new DATCliente();
        ResultSet rs= datc.getUsrPss();
        while (rs.next()) {
            Usuario u= new Usuario();
            u.setUsuario(rs.getString("usuario"));
            u.setPass(rs.getString("contrasena"));
            users.add(u);
            
        }
        return users;
    }
    
    public int getIdDirAgr() throws ClassNotFoundException, SQLException{
        int index=0;
        DATCliente datc= new DATCliente();
        ResultSet rs=null;
        rs= datc.IdDireccionAgregada();
        if (rs.next()) {
            index=rs.getInt("id");
        }
        return index;
    }
    
    public int getIdClienteAgr() throws ClassNotFoundException, SQLException{
        int index=0;
        DATCliente datc= new DATCliente();
        ResultSet rs=null;
        rs= datc.IdClienteAgregado();
        if (rs.next()) {
            index=rs.getInt("id");
        }
        return index;
    }
    
    public boolean  AgregarCliente(Cliente cliente) throws ClassNotFoundException, SQLException{
        DATCliente datc= new DATCliente();
        PreparedStatement ps=null;
        ps= datc.addCliente(cliente);
        if (ps!=null) {
            ps.execute();
            return true;
        }else
            return false;
        
        
    }
    
    public boolean AgregarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException{
        DATCliente datc= new DATCliente();
        PreparedStatement ps= null;
        ps= datc.addUsuario(usuario);
        if (ps!=null) {
            ps.execute();
            return true;
        }else
            return false;
    }
    
    public boolean AgregarDireccion(Direccion direccion) throws ClassNotFoundException, SQLException{
        DATCliente datc= new DATCliente();
        PreparedStatement ps= null;
        ps= datc.addDireccion(direccion);
        if (ps!=null) {
            ps.execute();
            return true;
        }else
            return false;
        
    }
    
    public int getIdUsr(String cedula) throws ClassNotFoundException, SQLException{
        DATCliente datc= new DATCliente();
        int i=0;
        ResultSet rs= datc.getIdCliente(cedula);
        if (rs.next()) {
            i= rs.getInt("id");
        }
        return i;
    }
    
    public boolean EditarCliente(Cliente cliente) throws ClassNotFoundException, SQLException{
        DATCliente datc= new DATCliente();
        PreparedStatement ps= null;
        ps= datc.EditarCliente(cliente);
        if (ps!=null) {
            ps.executeUpdate();
            return true;
        }else
            return false;
    }
    
    public boolean EditarDireccion(Direccion direccion) throws ClassNotFoundException, SQLException{
        DATCliente datc= new DATCliente();
        PreparedStatement ps= null;
        ps= datc.EditarDireccion(direccion);
        if (ps!=null) {
            ps.executeUpdate();
            return true;
        }else
            return false;
    }
    
    public boolean EditarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException{
        DATCliente datc= new DATCliente();
        PreparedStatement ps=null;
        ps= datc.EditarUsuario(usuario);
        if (ps!=null) {
            ps.executeUpdate();
            return true;
        }else
            return false;
    }
    
    public boolean EliminarCliente(Cliente cliente) throws ClassNotFoundException, SQLException{
        DATCliente datc= new DATCliente();
        PreparedStatement ps= null;
        ps= datc.EliminarCliente(cliente);
        if (ps!=null) {
            ps.executeUpdate();
            return true;
        }else
            return false;
    }
    
    public boolean EliminarDireccion(Direccion direccion) throws ClassNotFoundException, SQLException{
        DATCliente datc= new DATCliente();
        PreparedStatement ps= null;
        ps= datc.EliminarDireccion(direccion);
        if (ps!=null) {
            ps.executeUpdate();
            return true;
        }else
            return false;
    }
    
    public boolean EliminarUsuario(Usuario usuario) throws ClassNotFoundException, SQLException{
        DATCliente datc= new DATCliente();
        PreparedStatement ps= null;
        ps= datc.EliminarUsuario(usuario);
        if (ps!=null) {
            ps.executeUpdate();
            return true;
        }else
            return false;
    }
    
}
