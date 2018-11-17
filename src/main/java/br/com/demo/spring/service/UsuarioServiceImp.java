package br.com.demo.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.demo.spring.dao.UsuarioDao;
import br.com.demo.spring.model.Usuario;

@Service
public class UsuarioServiceImp implements UsuarioService {

   @Autowired
   private UsuarioDao userDao;

   @Transactional
   public void salvar(Usuario user) {
      userDao.salvar(user);
   }

   @Transactional(readOnly = true)
   public List<Usuario> listar() {
      return userDao.listar();
   }

}
