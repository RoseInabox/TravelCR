package com.tours.TravelCR.security;

import com.tours.TravelCR.dao.UsuarioRepository;
import com.tours.TravelCR.domain.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UserDetails loadUserByUsername(String correo) throws UsernameNotFoundException {

        Usuario usuario = usuarioRepository.findByCorreo(correo)
                .orElseThrow(() -> new UsernameNotFoundException("Usuario no encontrado"));

        System.out.println("LOGIN: " + correo);
        System.out.println("PASS BD: " + usuario.getContrasena());
        System.out.println("ACTIVO: " + usuario.isActivo());
        System.out.println("ROLES: " + usuario.getRoles().size());

        usuario.getRoles().forEach(rol
                -> System.out.println("ROL: " + rol.getNombre())
        );

        return new org.springframework.security.core.userdetails.User(
                usuario.getCorreo(),
                usuario.getContrasena(),
                usuario.isActivo(),
                true,
                true,
                true,
                usuario.getRoles().stream()
                        .map(rol -> new SimpleGrantedAuthority(rol.getNombre()))
                        .collect(Collectors.toList())
        );
    }
}
