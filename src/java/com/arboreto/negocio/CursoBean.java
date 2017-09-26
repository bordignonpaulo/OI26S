package com.arboreto.negocio;

import com.arboreto.entidade.Curso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class CursoBean implements ICurso {

    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(String nome) {
        try {
            Curso curso = new Curso();
            curso.setDescricao(nome);

            em.persist(curso);
            
        } catch(Exception e){
            
        }

    }

    @Override
    public List<Curso> consultar() {
        return em.createQuery("SELECT c FROM Curso c", Curso.class).getResultList();
    }

}
