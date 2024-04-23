package Controlador;
public class Cliente {
    private String pkid;
    private String nombre;
    private String idTipo;
    private String apellido;
    private String nit;
    private String telefono;
    private String direccion;
    private String correo;
    private String estatus;

    public Cliente() {
    }

    public Cliente(String pkid, String nombre, String idTipo, String apellido, String nit, String telefono, String direccion, String correo, String estatus) {
        this.pkid = pkid;
        this.nombre = nombre;
        this.idTipo = idTipo;
        this.apellido = apellido;
        this.nit = nit;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
        this.estatus = estatus;
    }

    public String getPkid() {
        return pkid;
    }

    public void setPkid(String pkid) {
        this.pkid = pkid;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(String idTipo) {
        this.idTipo = idTipo;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstatus() {
        return estatus;
    }

    public void setEstatus(String estatus) {
        this.estatus = estatus;
    }

    @Override
    public String toString() {
    return "Usuario{" + "pkid='" + pkid + "'" + ", nombre='" + nombre + "'" + ", idTipo='" + idTipo + "'" + ", apellido='" + apellido + "'" + ", nit='" + nit + "'" + ", telefono='" + telefono + "'" + ", direccion='" + direccion + "'" + ", correo='" + correo + "'" + ", estatus='" + estatus + "'" + '}';
}


}

