
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
    public void create(familiaArborea farborea) {
                
        em.persist(farborea);
        
    }

    @Override
    public List<familiaArborea> consultar() {
        return em.createQuery("SELECT f FROM familiaArborea f", familiaArborea.class).getResultList();
    }

    @Override
    public familiaArborea selecionar(Long id) {
        familiaArborea farborea = null;
         try {
            farborea = em.find(familiaArborea.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return farborea;
    }

    @Override
    public boolean remover(familiaArborea farborea) {
       boolean sucesso = false;
        try {
            farborea = em.find(familiaArborea.class, farborea.getId());
            em.remove(farborea);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sucesso;
    }

    

    
}
