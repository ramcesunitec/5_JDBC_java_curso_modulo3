package xca_test_CapaDatos;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import xa_datos_Laboratorio_Inicial.UsuarioDAO;
import xca_datos_CapaDatos.Conexion_CapaDatos;
import xca_datos_CapaDatos.UsuarioDaoJDBC_CapaDatos;
import xca_domain_CapaDatos.UsuarioDTO_CapaDatos;

public class TestManejoUsuarios_CapaDatos {
    public static void main(String[] args) {
       Connection conexion=null;
        try {
            conexion=Conexion_CapaDatos.getConnection();
            if(conexion.getAutoCommit()){
                conexion.setAutoCommit(false);
            }
            
            UsuarioDaoJDBC_CapaDatos usuarioDAO=new UsuarioDaoJDBC_CapaDatos(conexion);

            List<UsuarioDTO_CapaDatos> usuarios=usuarioDAO.seleccionar();
            for(UsuarioDTO_CapaDatos usuario:usuarios){
                System.out.println(usuario);
            }
            
            //NUEVO REGISTRO
            UsuarioDTO_CapaDatos nuevoUsuario=new UsuarioDTO_CapaDatos();
            nuevoUsuario.setUsuarName("danae");
            //nuevaPersona.setApellido("Mendozzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzzz");
            nuevoUsuario.setPassword("HMNNAMRFD12505505");
            usuarioDAO.insertar(nuevoUsuario);
            
            //ACTULIZAR REGISTRO
            UsuarioDTO_CapaDatos cambioUsuario=new UsuarioDTO_CapaDatos();
            cambioUsuario.setIdUsuario(4);
            cambioUsuario.setUsuarName("MALUDIMA");
            cambioUsuario.setPassword("ADSD521552");
            usuarioDAO.actualizar(cambioUsuario);
            
            //BORRAR REGISTRO
            UsuarioDTO_CapaDatos borrarUsuario=new UsuarioDTO_CapaDatos();
            borrarUsuario.setIdUsuario(6);
            usuarioDAO.eliminar(borrarUsuario);
            
            //MOSTRAR
            List<UsuarioDTO_CapaDatos> usuarios1=usuarioDAO.seleccionar();
            for(UsuarioDTO_CapaDatos usuario:usuarios1){
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
