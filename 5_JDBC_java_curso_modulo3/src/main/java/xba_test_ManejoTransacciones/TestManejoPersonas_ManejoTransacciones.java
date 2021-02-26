package xba_test_ManejoTransacciones;

import java.sql.*;
import java.util.List;
import xba_datos_ManejoTransacciones.Conexion_ManejoTransacciones;
import xba_datos_ManejoTransacciones.PersonaJDBC_ManejoTransacciones;
import xba_domain_ManejoTransacciones.*;

public class TestManejoPersonas_ManejoTransacciones {

    public static void main(String[] args) {
        
            Connection conexion=null;
        try {
            conexion=Conexion_ManejoTransacciones.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            PersonaJDBC_ManejoTransacciones personaJDBC=new PersonaJDBC_ManejoTransacciones(conexion);
            
            //MOSTRAR
            List<Persona_ManejoTransacciones> personas=personaJDBC.seleccionar();
            for(Persona_ManejoTransacciones persona:personas){
                System.out.println("Persona= "+persona);
            }
            
            //NUEVO REGISTRO
            Persona_ManejoTransacciones nuevaPersona=new Persona_ManejoTransacciones();
            nuevaPersona.setNombre("Matilde");
            //nuevaPersona.setApellido("Mendozzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            nuevaPersona.setApellido("Mendoza");
            personaJDBC.insertar(nuevaPersona);
            
            //ACTULIZAR REGISTRO
            Persona_ManejoTransacciones cambioPersona=new Persona_ManejoTransacciones();
            cambioPersona.setIdPersona(5);
            cambioPersona.setNombre("Maria de Lourdes");
            cambioPersona.setApellido("Diaz");
            cambioPersona.setEmail("lourdes@diaz.com");
            cambioPersona.setTelefono("44444444");
            personaJDBC.actualizar(cambioPersona);
            
            //BORRAR REGISTRO
            Persona_ManejoTransacciones borrarPersona=new Persona_ManejoTransacciones();
            borrarPersona.setIdPersona(6);
            personaJDBC.eliminar(borrarPersona);
            
            //MOSTRAR
            List<Persona_ManejoTransacciones> personas1=personaJDBC.seleccionar();
            for(Persona_ManejoTransacciones persona:personas1){
                System.out.println("Persona= "+persona);
            }
            
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