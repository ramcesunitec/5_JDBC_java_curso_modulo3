package xba_datos_ManejoTransacciones;

import xba_domain_ManejoTransacciones.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PersonaJDBC_ManejoTransacciones {

    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT * FROM persona";// SELECT id_persona,nombre, apellido, email,telefono
    private static final String SQL_INSERT = "INSERT INTO persona(nombre,apellido,email,telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE id_persona=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";

    public PersonaJDBC_ManejoTransacciones() {
    }

    public PersonaJDBC_ManejoTransacciones(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<Persona_ManejoTransacciones> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Persona_ManejoTransacciones persona = null;
        List<Persona_ManejoTransacciones> personas = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion_ManejoTransacciones.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                persona = new Persona_ManejoTransacciones(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
            }
        } finally {
                Conexion_ManejoTransacciones.close(rs);
                Conexion_ManejoTransacciones.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion_ManejoTransacciones.close(conn);
                }

        }
        return personas;
    }

    public int insertar(Persona_ManejoTransacciones persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion_ManejoTransacciones.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());

            registros = stmt.executeUpdate();
            System.out.println("Registro insertado");
        } finally {
                Conexion_ManejoTransacciones.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion_ManejoTransacciones.close(conn);
                }
        }
        return registros;
    }

    public int actualizar(Persona_ManejoTransacciones persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion_ManejoTransacciones.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());

            registros = stmt.executeUpdate();
            System.out.println("Registro actualizado");
        } finally {
                Conexion_ManejoTransacciones.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion_ManejoTransacciones.close(conn);
                }
        }
        return registros;
    }

    public int eliminar(Persona_ManejoTransacciones persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion_ManejoTransacciones.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());

            registros = stmt.executeUpdate();
            System.out.println("Registro eliminado");
        } finally {
                Conexion_ManejoTransacciones.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion_ManejoTransacciones.close(conn);
                }
        }
        return registros;
    }

}
