/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.SetorEJB;
import javax.inject.Named;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import model.Setor;

/**
 *
 * @author Administrador
 */
@Named(value = "setorMB")
@ViewScoped
public class SetorMB implements Serializable {

    @EJB
    SetorEJB setorEJB;
    
    
    /**
     * Creates a new instance of SetorMB
     */
    public SetorMB() {
    }
    
    
    private Setor setor = new Setor();

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
    
    public void salvar(){
        setorEJB.salvar(setor);
    }
    
}
