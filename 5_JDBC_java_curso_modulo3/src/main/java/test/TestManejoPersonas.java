package test;

import datos.PersonaDAO;
import domain.Persona;
import java.util.List;

public class TestManejoPersonas {

    public static void main(String[] args) {
        PersonaDAO personaDAO = new PersonaDAO();
        
        //Mostrando registro de Personas
        List<Persona> personas = personaDAO.seleccionar();
        for (Persona persona : personas) {
            System.out.println("Persona: " + persona);       
        }
        
        //Insertando un nuevo objeto de tipo Persona y listando registros
//        Persona personaNueva=new Persona("Manuel", "Frutos", "manuel@frutos.com", "44444444");
//        personaDAO.insertar(personaNueva);
//        List<Persona> personas = personaDAO.seleccionar();
//        for (Persona persona : personas) {
//            System.out.println("Persona: " + persona);       
//        }
        
        //Actualizar o Modificar un registro y listarlo
//        Persona personaModificar=new Persona(4, "Lourdes", "Diaz", "lourdes@diaz.com", "555555555");
//        personaDAO.actualizar(personaModificar);
//         List<Persona> personas = personaDAO.seleccionar();
//        for (Persona persona : personas) {
//            System.out.println("Persona: " + persona);       
//        }
        
//        //Borrar registro y listarlo
//        Persona personaEliminar= new Persona(4);
//        personaDAO.eliminar(personaEliminar);
//        List<Persona> personas = personaDAO.seleccionar();
//        for (Persona persona : personas) {
//            System.out.println("Persona: " + persona);       
//        }
        
    }
}
