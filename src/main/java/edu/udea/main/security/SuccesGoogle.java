package edu.udea.main.security;

import edu.udea.main.service.GestorUsuario;
import edu.udea.main.service.GestorUsuarioInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.oauth2.core.oidc.user.DefaultOidcUser;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class SuccesGoogle implements AuthenticationSuccessHandler {

    @Autowired
    GestorUsuarioInterface gestorUsuario;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {


        DefaultOidcUser user = (DefaultOidcUser) authentication.getPrincipal();

        System.out.println(user);

        String correoUser = user.getEmail();

        System.out.println(correoUser + " Correo Google!!!");
        try {
            gestorUsuario.getUsuario(correoUser);
            response.sendRedirect("/welcome");
        } catch (Exception e) {
            e.printStackTrace();
            new SecurityContextLogoutHandler().logout(request,response,authentication);
            //logout
            //response.sendRedirect("/login");

        }



    }
}
