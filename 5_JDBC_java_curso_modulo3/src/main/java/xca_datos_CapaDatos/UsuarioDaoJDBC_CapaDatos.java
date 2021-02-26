package xca_datos_CapaDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import xca_domain_CapaDatos.UsuarioDTO_CapaDatos;

public class UsuarioDaoJDBC_CapaDatos implements UsuarioDAO{
    
    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT * FROM usuario";// SELECT id_usuario,username,password
    private static final String SQL_INSERT = "INSERT INTO usuario(username,password) VALUES(?, ?)";
    private static final String SQL_UPDATE = "UPDATE usuario SET username=?, password=? WHERE id_usuario=?";
    private static final String SQL_DELETE = "DELETE FROM usuario WHERE id_usuario=?";

    public UsuarioDaoJDBC_CapaDatos() {
    }

    public UsuarioDaoJDBC_CapaDatos(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    
    public List<UsuarioDTO_CapaDatos> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        UsuarioDTO_CapaDatos usuario = null;
        List<UsuarioDTO_CapaDatos> usuarios = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion_CapaDatos.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idUsuario = rs.getInt("id_usuario");
                String userName = rs.getString("username");
                String password=rs.getString("password");
                
                usuario=new UsuarioDTO_CapaDatos(idUsuario, userName, password);
                usuarios.add(usuario);
            }
        } finally {
            Conexion_CapaDatos.close(rs);
                Conexion_CapaDatos.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion_CapaDatos.close(conn);
                }
        }
        return usuarios;
    }

    public int insertar(UsuarioDTO_CapaDatos usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion_CapaDatos.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, usuario.getUsuarName());
            stmt.setString(2, usuario.getPassword());

            registros = stmt.executeUpdate();
            System.out.println("Registro insertado");

        } finally {
            Conexion_CapaDatos.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion_CapaDatos.close(conn);
                }
        }
        return registros;
    }

    public int actualizar(UsuarioDTO_CapaDatos usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion_CapaDatos.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, usuario.getUsuarName());
            stmt.setString(2, usuario.getPassword());
            stmt.setInt(3, usuario.getIdUsuario());

            registros = stmt.executeUpdate();
            System.out.println("Registro actualizado");

        } finally {
            Conexion_CapaDatos.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion_CapaDatos.close(conn);
                }
        }
        return registros;
    }

    public int eliminar(UsuarioDTO_CapaDatos usuario) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion_CapaDatos.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, usuario.getIdUsuario());

            registros = stmt.executeUpdate();
            System.out.println("Registro eliminado");

        }  finally {
            Conexion_CapaDatos.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion_CapaDatos.close(conn);
                }
        }
        return registros;
    }

}
