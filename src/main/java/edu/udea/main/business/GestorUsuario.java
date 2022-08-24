package edu.udea.main.business;

import edu.udea.main.model.Usuario;

import java.util.ArrayList;

public class GestorUsuario {

    private ArrayList<Usuario> usuarios;

    public GestorUsuario(){

        this.usuarios = new ArrayList<>();

        this.usuarios.add(new Usuario("Prueba1", "Prueba","1234"));
        this.usuarios.add(new Usuario("Prueba1", "Andres","1234"));
    }


    public Usuario getUsuario(String nombreUsuario) throws Exception {
        for(Usuario usuario: this.usuarios){
            if(usuario.getNombreUsuario().equals(nombreUsuario) ){
                    return usuario;
            }
        }
        throw new Exception("Usuario No Existe");
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
