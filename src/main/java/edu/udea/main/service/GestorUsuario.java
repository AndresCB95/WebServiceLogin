package edu.udea.main.service;

import edu.udea.main.model.Usuario;
import edu.udea.main.repositorio.UsuarioRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GestorUsuario implements GestorUsuarioInterface{

    @Autowired
    private UsuarioRepositorio repositorio;


    @Override
    public List<Usuario> getUsuarios() {
        return repositorio.findAll();
    }

    @Override
    public Usuario getUsuario(String id) throws Exception {
        Optional<Usuario> usuarioBd = repositorio.findById(id);
        if(usuarioBd.isPresent()){
            return usuarioBd.get();
        }
        throw new Exception("Usuario No Existe");
    }

    @Override
    public String setUsuario(Usuario usuario_parametro) {
        repositorio.save(usuario_parametro);
        return "Usuario creado exitosamente";
    }

    @Override
    public Usuario updateUsuarioAll(Usuario usuario_update, String id) {
        return null;
    }

    @Override
    public Usuario updateUsuario(Usuario usuario_update, String id) {
        return null;
    }

    @Override
    public String deleteUsuario(String id) {
        repositorio.deleteById(id);
        return "Usuario eliminado exitosamente";
    }
}
