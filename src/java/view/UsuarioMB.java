/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.UsuarioEJB;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Usuario;

/**
 *
 * @author Administrador
 */
@ManagedBean
@SessionScoped
public class UsuarioMB {

    /**
     * Creates a new instance of UsuarioMB
     */
    EntityManager em;
    private Usuario usuario = new Usuario();
    
    @EJB
    UsuarioEJB usuarioEJB;

    public UsuarioMB() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Jpa01AbrPU");
        em = emf.createEntityManager();
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public void salvar() {
        usuarioEJB.salvar(usuario);
    }

    public List<Usuario> findAll() {

      return usuarioEJB.findAll();
    }

    public void apaga(Usuario usuario) {

        System.out.println("Vou apagar o usuario " + usuario.getNome() + " id=" + usuario.getId());
        em.getTransaction().begin();
        em.remove(usuario);
        em.getTransaction().commit();
    }

    public void editar(Usuario usuario) {

        System.out.println("Editei=" + usuario.getId());
        this.usuario = usuario;
    }
    
     public List<String> complete(String query) {  
        return usuarioEJB.findByName(query);
     }
    
    
}
