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
    GestorUsuario gestorUsuario;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Usuario user = null;
        try {
            System.out.println(gestorUsuario);
            System.out.println(userName);
            user = gestorUsuario.getUsuario(userName);
            System.out.println(user);
        } catch (Exception e) {
            throw new UsernameNotFoundException("Not found: " + userName);
        }

        return new MyUserDetail(user);
    }
}
