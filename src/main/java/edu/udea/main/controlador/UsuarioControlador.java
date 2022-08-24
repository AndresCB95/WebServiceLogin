package edu.udea.main.controlador;


import edu.udea.main.business.GestorUsuario;
import edu.udea.main.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class UsuarioControlador {

    private GestorUsuario gestorUsuario = new GestorUsuario();

    @GetMapping("/usuarios")
    public ResponseEntity<ArrayList<Usuario>> getUsuarios(){
        return new ResponseEntity<>(gestorUsuario.getUsuarios(), HttpStatus.OK);
    }

    @GetMapping("/usuario")
    public ResponseEntity<Object> getUsuario(@RequestParam String id){
        try {
            Usuario usuario = gestorUsuario.getUsuario(id);
            return new ResponseEntity<>(usuario,HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @GetMapping("/usuario/{id}")
    public ResponseEntity<String> getUsuarioPath(@PathVariable String id){
        return new ResponseEntity<>(id,HttpStatus.OK);
    }

}
