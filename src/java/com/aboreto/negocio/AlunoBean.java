
package com.aboreto.negocio;

import com.arboreto.entidade.Aluno;
import com.arboreto.entidade.Curso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AlunoBean implements IAluno{
    
    @PersistenceContext
    private EntityManager em;

    @Override
    public void create(String nome, Integer RA, String email, String senha, Curso curso) {
        Aluno aluno = new Aluno();
        
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setRa(RA);
        aluno.setSenha(senha);
        aluno.setCurso(curso);
        
        em.persist(aluno);
    }
    
    public List<Aluno> consultar() {
        return em.createQuery("SELECT a FROM Aluno a", Aluno.class).getResultList();
    }
    
}
