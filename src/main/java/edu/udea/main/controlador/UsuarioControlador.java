package edu.udea.main.controlador;


import edu.udea.main.business.GestorUsuario;
import edu.udea.main.model.Usuario;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class UsuarioControlador {

    private GestorUsuario gestorUsuario = new GestorUsuario();

    @GetMapping("/usuario")
    public ResponseEntity<ArrayList<Usuario>> getUsuarios(){
        return new ResponseEntity<>(gestorUsuario.getUsuarios(), HttpStatus.ACCEPTED);
    }

}
