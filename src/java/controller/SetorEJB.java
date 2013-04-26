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
import model.Setor;

/**
 *
 * @author Administrador
 */
@Stateless
public class SetorEJB {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
    @PersistenceContext
    EntityManager em;
    
    public void salvar(Setor setor){
        em.merge(setor);
    }
    
    public List<Setor> findAll(){
        Query query = em.createQuery("SELECT s FROM Setor s");
        return query.getResultList();
          //Outra forma possivel:
        //        return em.createQuery("SELECT s FROM Setor s").getResultList();
    }
    

}
