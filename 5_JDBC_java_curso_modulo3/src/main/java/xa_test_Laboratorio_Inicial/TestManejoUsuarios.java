package xa_test_Laboratorio_Inicial;

import java.util.List;
import xa_datos_Laboratorio_Inicial.UsuarioDAO;
import xa_domain_Laboratorio_Inicial.Usuario;

public class TestManejoUsuarios {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO=new UsuarioDAO();
        
        //Mostrando registro de la tabla usuario 
        List<Usuario> usuarios = usuarioDAO.seleccionar();
        for (Usuario usuario : usuarios) {
            System.out.println("Usuario: " + usuario);       
        }
         
        //Insertando un nuevo objeto de tipo usuario y listando registros
//        Usuario usuarioNuevo=new Usuario("santi", "290517");
//        usuarioDAO.insertar(usuarioNuevo);
//        List<Usuario> usuarios = usuarioDAO.seleccionar();
//        for (Usuario usuario : usuarios) {
//            System.out.println("Usuarios: " + usuario);       
//        }
        
        //Actualizar o Modificar un registro y listarlo
//        Usuario usuarioModificar=new Usuario(2, "nan992104", "0987654321");
//        usuarioDAO.actualizar(usuarioModificar);
//        List<Usuario> usuarios = usuarioDAO.seleccionar();
//        for (Usuario usuario : usuarios) {
//            System.out.println("Usuarios: " + usuario);       
//        }
        
        //Borrar registro y listarlo
//        Usuario usuarioEliminar= new Usuario(3);
//        usuarioDAO.eliminar(usuarioEliminar);
//        List<Usuario> usuarios = usuarioDAO.seleccionar();
//        for (Usuario usuario : usuarios) {
//            System.out.println("Usuarios: " + usuario);       
//        }
        
    }
}
