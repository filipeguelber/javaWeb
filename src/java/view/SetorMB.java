/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SetorEJB;
import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import model.Setor;

/**
 *
 * @author Administrador
 */
@ManagedBean
@ViewScoped
public class SetorMB implements Serializable {

    @EJB
    SetorEJB setorEJB;
    private Setor setor;
    
    /**
     * Creates a new instance of SetorMB
     */
    public SetorMB() {
        System.out.println("Criei um novo setorMB");
        setor = new Setor();
    }
    
    
    

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
    
    public void salvar(){
        System.out.println("Salvando setor="+setor.getDescricao());
        setorEJB.salvar(setor);
    }
    
}
