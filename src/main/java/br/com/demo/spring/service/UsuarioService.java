package br.com.demo.spring.service;

import java.util.List;

import br.com.demo.spring.model.Usuario;

public interface UsuarioService {
   void salvar(Usuario user);

   List<Usuario> listar();
}
