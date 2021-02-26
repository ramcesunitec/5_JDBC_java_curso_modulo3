package xca_datos_CapaDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import xca_domain_CapaDatos.PersonaDTO_CapaDatos;

public class PersonaDaoJDBC_CapaDatos implements PersonaDAO_CapaDatos{

    private Connection conexionTransaccional;
    private static final String SQL_SELECT = "SELECT * FROM persona";// SELECT id_persona,nombre, apellido, email,telefono
    private static final String SQL_INSERT = "INSERT INTO persona(nombre,apellido,email,telefono) VALUES(?, ?, ?, ?)";
    private static final String SQL_UPDATE = "UPDATE persona SET nombre=?, apellido=?, email=?, telefono=? WHERE id_persona=?";
    private static final String SQL_DELETE = "DELETE FROM persona WHERE id_persona=?";

    public PersonaDaoJDBC_CapaDatos() {
    }

    public PersonaDaoJDBC_CapaDatos(Connection conexionTransaccional) {
        this.conexionTransaccional = conexionTransaccional;
    }

    public List<PersonaDTO_CapaDatos> seleccionar() throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        PersonaDTO_CapaDatos persona = null;
        List<PersonaDTO_CapaDatos> personas = new ArrayList<>();

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion_CapaDatos.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int idPersona = rs.getInt("id_persona");
                String nombre = rs.getString("nombre");
                String apellido = rs.getString("apellido");
                String email = rs.getString("email");
                String telefono = rs.getString("telefono");

                persona = new PersonaDTO_CapaDatos(idPersona, nombre, apellido, email, telefono);
                personas.add(persona);
            }
        } finally {
                Conexion_CapaDatos.close(rs);
                Conexion_CapaDatos.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion_CapaDatos.close(conn);
                }

        }
        return personas;
    }

    public int insertar(PersonaDTO_CapaDatos persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion_CapaDatos.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());

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

    public int actualizar(PersonaDTO_CapaDatos persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion_CapaDatos.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, persona.getNombre());
            stmt.setString(2, persona.getApellido());
            stmt.setString(3, persona.getEmail());
            stmt.setString(4, persona.getTelefono());
            stmt.setInt(5, persona.getIdPersona());

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

    public int eliminar(PersonaDTO_CapaDatos persona) throws SQLException {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = this.conexionTransaccional != null ? this.conexionTransaccional : Conexion_CapaDatos.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, persona.getIdPersona());

            registros = stmt.executeUpdate();
            System.out.println("Registro eliminado");
        } finally {
                Conexion_CapaDatos.close(stmt);
                if (this.conexionTransaccional == null) {
                    Conexion_CapaDatos.close(conn);
                }
        }
        return registros;
    }

    

}
