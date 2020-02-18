package tecsup.example.bibliosocabaya;

public class Usuario {
    int id;
    String Nombres, Apellidos, Usuario, contraseña;

    public Usuario() {
    }

    public Usuario(String nombres, String apellidos, String usuario, String contraseña) {
        Nombres = nombres;
        Apellidos = apellidos;
        Usuario = usuario;
        this.contraseña = contraseña;
    }

    public boolean isNull(){
        if(Nombres.equals("")&&Apellidos.equals("")&&Usuario.equals("")&&contraseña.equals("")){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", Nombres='" + Nombres + '\'' +
                ", Apellidos='" + Apellidos + '\'' +
                ", Usuario='" + Usuario + '\'' +
                ", contraseña='" + contraseña + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombres() {
        return Nombres;
    }

    public void setNombres(String nombres) {
        Nombres = nombres;
    }

    public String getApellidos() {
        return Apellidos;
    }

    public void setApellidos(String apellidos) {
        Apellidos = apellidos;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String usuario) {
        Usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
