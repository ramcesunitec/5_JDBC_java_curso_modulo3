package xa_domain_Laboratorio_Inicial;

public class Usuario {
    private int idUsuario;
    private String usuarName;
    private String password;

    public Usuario() {
    }

    public Usuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(String usuarName, String password) {
        this.usuarName = usuarName;
        this.password = password;
    }

    public Usuario(int idUsuario, String usuarName, String password) {
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
