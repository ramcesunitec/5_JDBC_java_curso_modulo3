package xca_domain_CapaDatos;



public class UsuarioDTO_CapaDatos {
    private int idUsuario;
    private String usuarName;
    private String password;

    public UsuarioDTO_CapaDatos() {
    }

    public UsuarioDTO_CapaDatos(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public UsuarioDTO_CapaDatos(String usuarName, String password) {
        this.usuarName = usuarName;
        this.password = password;
    }

    public UsuarioDTO_CapaDatos(int idUsuario, String usuarName, String password) {
        this.idUsuario = idUsuario;
        this.usuarName = usuarName;
        this.password = password;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getUsuarName() {
        return usuarName;
    }

    public void setUsuarName(String usuarName) {
        this.usuarName = usuarName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" + "idUsuario=" + idUsuario + ", usuarName=" + usuarName + ", password=" + password + '}';
    }
    
    
    
}
