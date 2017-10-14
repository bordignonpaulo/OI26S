
package com.arboreto.negocio;

import com.arboreto.entidade.Categoria;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CategoriaBean implements ICategoria{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(String nome) {
        Categoria categoria = new Categoria();
        
        categoria.setNome(nome);
        
        em.persist(categoria);
    }

    @Override
    public List<Categoria> consultar() {
        return em.createQuery("SELECT c FROM Categoria c", Categoria.class).getResultList();
    }

    
    
}
