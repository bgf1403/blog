package com.digitalhouse.blog.Security;

import com.digitalhouse.blog.Model.Usuario;
import com.digitalhouse.blog.Repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceDetailsImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String username){
        Optional<Usuario> user = usuarioRepository.findByUsuario(username);
        user.orElseThrow(() -> new UsernameNotFoundException(username + " not found."));

        return user.map(UserDetailsImpl::new).get();
    }

}
