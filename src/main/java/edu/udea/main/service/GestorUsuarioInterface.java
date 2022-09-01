package edu.udea.main.service;

import edu.udea.main.model.Usuario;

import java.util.List;

public interface GestorUsuarioInterface {

    public List<Usuario> getUsuarios();
    public Usuario getUsuario(String id) throws Exception;
    public String setUsuario(Usuario usuario_parametro);
    public Usuario updateUsuarioAll(Usuario usuario_update, String id) throws Exception;
    public Usuario updateUsuario(Usuario usuario_update, String id) throws Exception;
    public String deleteUsuario(String id);


}












