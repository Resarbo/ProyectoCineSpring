package com.cursojava.curso.service;

import com.cursojava.curso.Controllers.dto.UsuarioRegistroDTO;
import com.cursojava.curso.dao.UsuarioDao;
import com.cursojava.curso.models.Rol;
import com.cursojava.curso.models.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioServicioImpl implements UsuarioServicio{
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    private UsuarioDao usuarioDao;

    public UsuarioServicioImpl(UsuarioDao usuarioDao) {
        super();
        this.usuarioDao = usuarioDao;
    }

    @Override
    public Usuario guardar(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(),
                registroDTO.getApellido(),
                registroDTO.getEmail(),
                registroDTO.getDni(),
                registroDTO.getTelefono(),
                passwordEncoder.encode(registroDTO.getPassword()),
                Arrays.asList(new Rol("ROLE_USER")));
        return usuarioDao.save(usuario);
    }

    @Override
    public Usuario guardarUsuarioAdmin(UsuarioRegistroDTO registroDTO) {
        Usuario usuario = new Usuario(registroDTO.getNombre(),
                registroDTO.getApellido(),
                registroDTO.getEmail(),
                registroDTO.getDni(),
                registroDTO.getTelefono(),
                passwordEncoder.encode(registroDTO.getPassword()),
                Arrays.asList(new Rol("ROLE_ADMIN")));
        return usuarioDao.save(usuario);
    }

    @Override
    public List<Usuario> listarUsuarios() {
        return usuarioDao.findAll();
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Usuario usuario = usuarioDao.findByEmail(username);
        if(usuario == null) {
            throw new UsernameNotFoundException("Usuario o password inválidos");
        }
        return new User(usuario.getEmail(),usuario.getPassword(), mapearAutoridadesRoles(usuario.getRoles()));
    }

    private Collection<? extends GrantedAuthority> mapearAutoridadesRoles(Collection<Rol> roles){
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
    }
}
