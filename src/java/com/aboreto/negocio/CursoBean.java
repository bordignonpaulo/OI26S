
package com.aboreto.negocio;

import com.arboreto.entidade.Curso;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CursoBean implements ICurso {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void create(String nome){
       Curso curso = new Curso();
        
        curso.setDescricao(nome);
        
        em.persist(curso);
    }
    
}
