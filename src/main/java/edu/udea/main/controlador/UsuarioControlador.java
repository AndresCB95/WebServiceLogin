package edu.udea.main.controlador;


import edu.udea.main.service.GestorUsuario;
import edu.udea.main.service.GestorUsuarioInterface;
import edu.udea.main.service.GestorUsuarioList;
import edu.udea.main.model.ObjetoRespuesta;
import edu.udea.main.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UsuarioControlador {

    @Autowired
    private GestorUsuarioInterface gestorUsuario;

    @GetMapping("/usuario/usuarios")
    public ResponseEntity<List<Usuario>> getUsuarios(){
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

    @PostMapping("/usuario")
    public ResponseEntity<String> postUsuario(@RequestBody Usuario usuario_parametro){

        try {
            String mensaje = gestorUsuario.setUsuario(usuario_parametro);

            return new ResponseEntity<>(mensaje,HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    @PutMapping("/usuario/{id}")
    public ResponseEntity<ObjetoRespuesta> putUsuario(@RequestBody Usuario usuario_update, @PathVariable String id){

        try {
            Usuario usuario_bd = gestorUsuario.updateUsuarioAll(usuario_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa",usuario_bd),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PatchMapping("/usuario/{id}")
    public ResponseEntity<ObjetoRespuesta> patchUsuario(@RequestBody Usuario usuario_update, @PathVariable String id ){

        try {
            Usuario usuario_bd = gestorUsuario.updateUsuario(usuario_update, id);
            return new ResponseEntity<>(new ObjetoRespuesta("Actualización Exitosa",usuario_bd),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<ObjetoRespuesta> deleteUsuario(@PathVariable String id){

        try {
            String mensaje = gestorUsuario.deleteUsuario(id);

            return new ResponseEntity<>(new ObjetoRespuesta(mensaje,null),HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(new ObjetoRespuesta(e.getMessage(),null),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


}





















