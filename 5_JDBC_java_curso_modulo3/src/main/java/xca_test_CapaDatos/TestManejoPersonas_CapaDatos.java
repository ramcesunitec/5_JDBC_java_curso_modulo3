package xca_test_CapaDatos;

import java.sql.*;
import java.util.List;
import xca_datos_CapaDatos.Conexion_CapaDatos;
import xca_datos_CapaDatos.PersonaDAO_CapaDatos;
import xca_datos_CapaDatos.PersonaDaoJDBC_CapaDatos;
import xca_domain_CapaDatos.PersonaDTO_CapaDatos;

public class TestManejoPersonas_CapaDatos {

    public static void main(String[] args) {
        
            Connection conexion=null;
        try {
            conexion=Conexion_CapaDatos.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            PersonaDAO_CapaDatos personaDAO=new PersonaDaoJDBC_CapaDatos(conexion);
            
            //MOSTRAR
            List<PersonaDTO_CapaDatos> personas=personaDAO.seleccionar();
            for(PersonaDTO_CapaDatos persona:personas){
                System.out.println("Persona DTO= "+persona);
            }
            
            //NUEVO REGISTRO
            PersonaDTO_CapaDatos nuevaPersona=new PersonaDTO_CapaDatos();
            nuevaPersona.setNombre("Matilde");
            //nuevaPersona.setApellido("Mendozzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            nuevaPersona.setApellido("Mendoza");
            personaDAO.insertar(nuevaPersona);
            
            //ACTULIZAR REGISTRO
            PersonaDTO_CapaDatos cambioPersona=new PersonaDTO_CapaDatos();
            cambioPersona.setIdPersona(5);
            cambioPersona.setNombre("Maria de Lourdes");
            cambioPersona.setApellido("Diaz");
            cambioPersona.setEmail("lourdes@diaz.com");
            cambioPersona.setTelefono("44444444");
            personaDAO.actualizar(cambioPersona);
            
            //BORRAR REGISTRO
            PersonaDTO_CapaDatos borrarPersona=new PersonaDTO_CapaDatos();
            borrarPersona.setIdPersona(6);
            personaDAO.eliminar(borrarPersona);
            conexion.commit();
            
            System.out.println("Se ha hecho committ de la transaccion");
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
            System.out.println("Entramos al rollback");
                try {
                    conexion.rollback();
                } catch (SQLException ex1) {
                    ex1.printStackTrace(System.out);
                }
        }
    
    }
}