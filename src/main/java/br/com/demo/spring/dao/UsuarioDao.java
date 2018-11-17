package br.com.demo.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import br.com.demo.spring.model.Usuario;

@Repository
public class UsuarioDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void salvar(Usuario usuario) {
		sessionFactory.getCurrentSession().save(usuario);
	}

	public List<Usuario> listar() {
		@SuppressWarnings("unchecked")
		TypedQuery<Usuario> query = sessionFactory.getCurrentSession().createQuery("from Usuario");
		return query.getResultList();
	}

}
