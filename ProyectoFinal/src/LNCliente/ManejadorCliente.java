/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package LNCliente;

import Clases.Cliente;
import Clases.Direccion;
import Clases.Pais;
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
    public Cliente getCliente(String cedula) throws ClassNotFoundException, SQLException{
        ResultSet rs=null;
        Cliente c= new Cliente();
        DATCliente datCliente= new DATCliente();
        rs=datCliente.getCliente(cedula);
        if (rs.next()) {
            c.setCedula(rs.getString("cedula"));
            c.setApellidos(rs.getString("apellidos"));
            c.setNombres(rs.getString("nombres"));
            c.setFechaNacimiento(rs.getDate("fechaNacimiento"));
            c.setNumTelefono(rs.getString("numTelefono"));
            Direccion dir= new Direccion();
            
            
        }
        return c;
    }
    
    public ArrayList <Pais> ObtenerPaises() throws ClassNotFoundException, SQLException{
        ArrayList<Pais>paises= new ArrayList<>();
        DATCliente dATCliente= new DATCliente();
        ResultSet rs= dATCliente.ObtenerPais();
        while (rs.next()) {            
            Pais pais= new Pais(rs.getInt(1),rs.getString(2));
            paises.add(pais);
        }
        
        return paises;
    }
   
}
