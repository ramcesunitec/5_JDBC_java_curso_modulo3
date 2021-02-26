package xba_test_ManejoTransacciones;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import xba_datos_ManejoTransacciones.Conexion_ManejoTransacciones;
import xba_datos_ManejoTransacciones.PersonaJDBC_ManejoTransacciones;
import xba_datos_ManejoTransacciones.UsuarioJDBC_ManejoTransacciones;
import xba_domain_ManejoTransacciones.Persona_ManejoTransacciones;
import xba_domain_ManejoTransacciones.Usuario_ManejoTransacciones;

public class TestManejoUsuarios_ManejoTransacciones {
    public static void main(String[] args) {
       Connection conexion=null;
        try {
            conexion=Conexion_ManejoTransacciones.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            UsuarioJDBC_ManejoTransacciones usuarioJDBC=new UsuarioJDBC_ManejoTransacciones(conexion);

            List<Usuario_ManejoTransacciones> usuarios=usuarioJDBC.seleccionar();
            for(Usuario_ManejoTransacciones usuario:usuarios){
                System.out.println(usuario);
            }
            
            //NUEVO REGISTRO
            Usuario_ManejoTransacciones nuevoUsuario=new Usuario_ManejoTransacciones();
            nuevoUsuario.setUsuarName("danae");
            //nuevaPersona.setApellido("Mendozzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            nuevoUsuario.setPassword("HMNNAMRFD12505505");
            usuarioJDBC.insertar(nuevoUsuario);
            
            //ACTULIZAR REGISTRO
            Usuario_ManejoTransacciones cambioUsuario=new Usuario_ManejoTransacciones();
            cambioUsuario.setIdUsuario(4);
            cambioUsuario.setUsuarName("MALUDIMA");
            cambioUsuario.setPassword("ADSD521552");
            usuarioJDBC.actualizar(cambioUsuario);
            
            //BORRAR REGISTRO
            Usuario_ManejoTransacciones borrarUsuario=new Usuario_ManejoTransacciones();
            borrarUsuario.setIdUsuario(6);
            usuarioJDBC.eliminar(borrarUsuario);
            
            //MOSTRAR
            List<Usuario_ManejoTransacciones> usuarios1=usuarioJDBC.seleccionar();
            for(Usuario_ManejoTransacciones usuario:usuarios1){
                System.out.println(usuario);
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
