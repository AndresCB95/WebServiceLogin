package edu.udea.main.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="usuario")
public class Usuario {

    @Column
    private String nombre;
    @Id
    private String nombreUsuario;

    @Column
    private String password;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = ROLES.class, fetch = FetchType.EAGER)
    private List<ROLES>roles;

    public Usuario(String nombre, String nombreUsuario, String password, List<ROLES> roles) {
        this.nombre = nombre;
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.roles = roles;
    }

   public Usuario(){

   }

    public List<ROLES>  getRoles() {
      return roles;
    }

    public void setRoles(List<ROLES> roles) {
        this.roles = roles;
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


    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", nombreUsuario='" + nombreUsuario + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }
}
