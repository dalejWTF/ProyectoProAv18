/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DATCliente;

import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author dalejwtf
 */
public class DATCliente {
    ConnectionSQL conect= new ConnectionSQL();
    public PreparedStatement getCliente(String cedula) throws ClassNotFoundException, SQLException{
        PreparedStatement ps= null;
        String sql="SELECT c.cedula, c.apellidos, c.nombres, c.fechaNacimiento, c.numTelefono, p.nombre pais,d.ciudad, d.calles, g.nombre genero, t.tipo FROM cliente c, pais p, direccion d, genero g, tipo t,usuario u WHERE d.id_pais=p.id AND g.id=c.genero AND t.id= u.id_tipo AND c.cedula=?";
        ps= conect.getConnection().prepareStatement(sql);
        ps.setString(1, cedula);
        return ps;
    }
    
}
