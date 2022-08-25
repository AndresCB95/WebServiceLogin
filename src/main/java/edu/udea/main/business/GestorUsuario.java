package edu.udea.main.business;

import edu.udea.main.model.Usuario;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

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


    public String setUsuario(Usuario usuario_parametro) throws Exception {
        try {
            //Consulta de existencia de usuario
            getUsuario(usuario_parametro.getNombreUsuario());
        } catch (Exception e) {
            // Codigo de crear un usuario
           this.usuarios.add(usuario_parametro);
           return "Creacion del usuario Exitosa";
        }
        //Error si el usuario ya existe
        throw new Exception("Usuario Existe");
    }

    public Usuario updateUsuario(Usuario usuario_update) throws Exception {
        try {
            Usuario usuario_bd = getUsuario(usuario_update.getNombreUsuario());

            if(usuario_update.getNombre() != null && !usuario_update.getNombre().equals("")){
                usuario_bd.setNombre(usuario_update.getNombre());
            }
            if(usuario_update.getPassword() != null && !usuario_update.getPassword().equals("")) {
                usuario_bd.setPassword(usuario_update.getPassword());
            }

            return usuario_bd;
        } catch (Exception e) {
            throw new Exception("Usuario NO existe, fallo actualización de datos");
        }
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
}
