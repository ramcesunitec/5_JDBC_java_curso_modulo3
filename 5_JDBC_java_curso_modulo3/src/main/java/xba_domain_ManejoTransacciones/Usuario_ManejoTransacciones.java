package xba_domain_ManejoTransacciones;


public class Usuario_ManejoTransacciones {
    private int idUsuario;
    private String usuarName;
    private String password;

    public Usuario_ManejoTransacciones() {
    }

    public Usuario_ManejoTransacciones(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario_ManejoTransacciones(String usuarName, String password) {
        this.usuarName = usuarName;
        this.password = password;
    }

    public Usuario_ManejoTransacciones(int idUsuario, String usuarName, String password) {
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
