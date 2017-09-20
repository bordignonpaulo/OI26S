
package com.aboreto.negocio;

import com.arboreto.entidade.Administrador;
import com.arboreto.entidade.Curso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AdministradorBean {
    @PersistenceContext
    private EntityManager em;
    
    public void cadastrar(Curso curso){
        Administrador adm = new Administrador();
        
        adm.setCurso(curso);
        em.persist(adm);
        
    }; 
}
