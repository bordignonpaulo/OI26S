
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

    @Override
    public Categoria selecionar(Long id) {
        Categoria categoria = null;
        try{
            categoria = em.find(Categoria.class, id);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return categoria;
    }

    @Override
    public boolean remover(Categoria categoria) {
         boolean sucesso = false;
        try {
            categoria = em.find(Categoria.class, categoria.getId() );
            em.remove(categoria);
            sucesso = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
 
        return sucesso;
        
    }

    
    
}
