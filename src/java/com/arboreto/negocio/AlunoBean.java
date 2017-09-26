
package com.arboreto.negocio;

import com.arboreto.entidade.Aluno;
import com.arboreto.entidade.Curso;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AlunoBean implements IAluno{
    
    @PersistenceContext
    private EntityManager em;
    
    @EJB
    private ICurso cursoBean;

    @Override
    public void create(String nome, Integer RA, String email, String senha, Long cursoId) {
        
        // Descobre o estado que tem esse ID
        Curso curso = null;
        
        for (Curso c: cursoBean.consultar())
            if (c.getId() == cursoId)
                curso = c;
        
        
        Aluno aluno = new Aluno();
        
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setRa(RA);
        aluno.setSenha(senha);
        aluno.setCurso(curso);
        
        em.persist(aluno);
    }
    
    @Override
    public List<Aluno> consultar() {
        return em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
    }
    
}
