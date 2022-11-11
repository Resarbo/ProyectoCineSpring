package com.cursojava.curso.service;

import com.cursojava.curso.Controllers.dto.UsuarioRegistroDTO;
import com.cursojava.curso.models.Usuario;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UsuarioServicio extends UserDetailsService{
    public Usuario guardar(UsuarioRegistroDTO registroDTO);
    public Usuario guardarUsuarioAdmin(UsuarioRegistroDTO registroDTO);
    public List<Usuario> listarUsuarios();
}
