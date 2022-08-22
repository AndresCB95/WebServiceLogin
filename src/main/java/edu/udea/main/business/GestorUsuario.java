package edu.udea.main.business;

import edu.udea.main.model.Usuario;

import java.util.ArrayList;

public class GestorUsuario {

    private ArrayList<Usuario> usuarios;

    public GestorUsuario(){

        this.usuarios = new ArrayList<>();

        this.usuarios.add(new Usuario("Prueba1", "Prueba","1234"));
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
