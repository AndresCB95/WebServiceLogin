package edu.udea.main.service;

import edu.udea.main.model.MyUserDetail;
import edu.udea.main.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailService implements UserDetailsService {

    @Autowired
    GestorUsuarioInterface gestorUsuarioInterface;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        try {
            System.out.println(username);
            Usuario user = gestorUsuarioInterface.getUsuario(username);
            System.out.println(user);
            return new MyUserDetail(user);
        } catch (Exception e) {
            e.printStackTrace();
            throw new UsernameNotFoundException(e.getMessage());
        }

    }
}
