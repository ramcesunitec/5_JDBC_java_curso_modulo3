package xca_datos_CapaDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import xca_domain_CapaDatos.UsuarioDTO_CapaDatos;


public interface UsuarioDAO {
    
    public List<UsuarioDTO_CapaDatos> seleccionar() throws SQLException;
    public int insertar(UsuarioDTO_CapaDatos usuario) throws SQLException; 
    public int actualizar(UsuarioDTO_CapaDatos usuario) throws SQLException;
    public int eliminar(UsuarioDTO_CapaDatos usuario) throws SQLException;
}
