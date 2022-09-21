package edu.udea.main.controlador;

import edu.udea.main.model.ROLES;
import edu.udea.main.model.Usuario;
import edu.udea.main.service.GestorUsuario;
import edu.udea.main.service.GestorUsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@Controller
public class FrontendController {

    @Autowired
    private GestorUsuarioInterface gestorUsuario;

    @GetMapping("/")
    public String getIndex(){
        return "index";
    }

    @GetMapping("/login")
    public String getLogin(Model model){
        model.addAttribute("formUsuario",new Usuario());
        return "login";
    }

    @GetMapping("/welcome")
    public String getWelcome(Model model){

        model.addAttribute("rol",ROLES.ADMIN);
        model.addAttribute("usuarios",gestorUsuario.getUsuarios());
        return "welcome";
    }

    @GetMapping("/addUser")
    public String getAddUser(Model model){
        model.addAttribute("user",new Usuario());
        model.addAttribute("ROLES", ROLES.values());
        return "add-user";
    }

    @PostMapping("/usuario/front")
    public String postUsuario(
            @ModelAttribute("user") Usuario usuario_parametro){
        try {
            System.out.println(usuario_parametro);
            String mensaje = gestorUsuario.setUsuario(usuario_parametro);
            return "redirect:/welcome";

        } catch (Exception e) {
        }
        return "redirect:/error";
    }

    @GetMapping("/updateUser")
    public String getUpdateUser(Model model){
        System.out.println(model.getAttribute("userUpdate"));
        return "update-user";
    }

    @GetMapping("/usuario/front/{id}")
    public String getUsuario(@PathVariable String id, Model model){
        try {
            System.out.println(id);
            System.out.println(gestorUsuario.getUsuario(id));
            model.addAttribute("userUpdate",gestorUsuario.getUsuario(id));
            model.addAttribute("ROLES", ROLES.values());
            return "update-user";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }


    @DeleteMapping("/usuario/front/{id}")
    public String deleteUser(@PathVariable String id, Model model){
        try {
            gestorUsuario.deleteUsuario(id);
            return "redirect:/welcome";
        } catch (Exception e) {
            return "redirect:/error";
        }
    }

    @PutMapping("/usuario/front/update")
    public String putUsuario(@ModelAttribute("userUpdate") Usuario usuario){

        try {
            System.out.println(usuario);
            gestorUsuario.updateUsuario(usuario,usuario.getNombreUsuario());
            return "redirect:/welcome";
        } catch (Exception e) {
            return "redirect:/error";
        }

    }

}
