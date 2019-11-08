package com.Model;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import com.Entities.Usuario;;

public class UsuarioModel {
	
	EntityManager entity = Conexion.getEntityManagerFactory().createEntityManager();

	// guardar usuario
	public void guardar(Usuario usuario) {
		entity.getTransaction().begin();
		entity.persist(usuario);
		entity.getTransaction().commit();
		//JPAUtil.shutdown();
	}

	// editar usuario
	public void editar(Usuario usuario) {
		entity.getTransaction().begin();
		entity.merge(usuario);
		entity.getTransaction().commit();
		/// JPAUtil.shutdown();
	}

	// buscar usuario
	public Usuario buscar(Long id) {
		Usuario c = new Usuario();
		c = entity.find(Usuario.class, id);
		// JPAUtil.shutdown();
		return c;
	}

	/// eliminar usuario
	public void eliminar(Long id) {
		Usuario c = new Usuario();
		c = entity.find(Usuario.class, id);
		entity.getTransaction().begin();
		entity.remove(c);
		entity.getTransaction().commit();
	}

	// obtener todos los usuarios
	public List<Usuario> obtenerClientes() {
		List<Usuario> listaUsuarios = new ArrayList<Usuario>();
		Query q = entity.createQuery("SELECT c FROM Cliente c");
		listaUsuarios = q.getResultList();
		return listaUsuarios;
	}

}
