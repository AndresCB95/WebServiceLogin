package edu.udea.main.controlador;

import edu.udea.main.model.Usuario;
import edu.udea.main.service.GestorUsuario;
import edu.udea.main.service.GestorUsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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
        model.addAttribute("usuarios",gestorUsuario.getUsuarios());
        return "welcome";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute("formUsuario") Usuario usuario){
        System.out.println(usuario);
        return "redirect:/welcome";
    }

}
