
package com.arboreto.negocio;

import com.arboreto.entidade.Categorias;
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
        Categorias categoria = new Categorias();
        
        categoria.setNome(nome);
    }

    @Override
    public List<Categorias> consultar() {
        return em.createQuery("SELECT c FROM Categorias c", Categorias.class).getResultList();
    }

    
    
}
