package com.apiRest.apiRest.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.apiRest.apiRest.models.UsuarioModel;
import com.apiRest.apiRest.repositories.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UsuarioModel usuarioModel = usuarioRepository.findOneByEmail(email)
        .orElseThrow(()-> new UsernameNotFoundException("El usuario con Email "+ email + " No existe"));
        return new UserDetailsImpl(usuarioModel);
    }

    
}
