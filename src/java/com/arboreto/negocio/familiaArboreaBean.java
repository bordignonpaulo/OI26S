
package com.arboreto.negocio;

import com.arboreto.entidade.familiaArborea;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class familiaArboreaBean implements IfamiliaArborea  {
    
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void create(String nome) {
        familiaArborea farborea = new familiaArborea();
        
        farborea.setNome(nome);
        
        em.persist(nome);
        
    }

    @Override
    public List<familiaArborea> consultar() {
        return em.createQuery("SELECT f FROM familiaArborea f", familiaArborea.class).getResultList();
    }

    

    
}
