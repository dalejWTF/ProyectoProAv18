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

}
