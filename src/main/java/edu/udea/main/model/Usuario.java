package edu.udea.main.model;

public class Usuario {

    private String nombre;
    private String nombreUsuario;
    private String password;

    public Usuario(String nombre, String nombreUsuario, String password) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
