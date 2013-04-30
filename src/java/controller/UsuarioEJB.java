/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import model.Usuario;

/**
 *
 * @author Administrador
 */
@Stateless
public class UsuarioEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    @PersistenceContext
    EntityManager em;

    public void salvar(Usuario usuario) {
        System.out.println("ID=" + usuario.getId());
        em.merge(usuario);
    }

    public List<Usuario> findAll() {
        Query query = em.createQuery("select u from Usuario u");
        return query.getResultList();
    }
    
    public List<String> findByName(String nome){
        Query query = em.createQuery("select u.nome from Usuario u WHERE u.nome like :nome");
        query.setParameter("nome", "%"+nome+"%");
        return query.getResultList();
    }
}
