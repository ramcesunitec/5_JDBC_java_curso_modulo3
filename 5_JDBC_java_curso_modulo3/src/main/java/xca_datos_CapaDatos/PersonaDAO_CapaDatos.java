package xca_datos_CapaDatos;

import java.sql.SQLException;
import java.util.List;
import xca_domain_CapaDatos.PersonaDTO_CapaDatos;

public interface PersonaDAO_CapaDatos {
    
    public List<PersonaDTO_CapaDatos> seleccionar()throws SQLException;
    public int insertar(PersonaDTO_CapaDatos persona)throws SQLException;
    public int actualizar(PersonaDTO_CapaDatos persona)throws SQLException;
    public int eliminar(PersonaDTO_CapaDatos persona)throws SQLException;
}
