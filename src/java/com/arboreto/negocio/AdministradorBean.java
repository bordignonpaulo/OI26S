
package com.arboreto.negocio;

import com.arboreto.entidade.Administrador;
import com.arboreto.entidade.Curso;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AdministradorBean implements IAdministrador {
    @PersistenceContext
    private EntityManager em;
    
    @EJB
    private ICurso cursoBean;
    
    public void create(String nome, String email, String senha, Long cursoId){
        
        // Descobre o estado que tem esse ID
        Curso curso = null;
        
        for (Curso c: cursoBean.consultar())
            if (c.getId() == cursoId)
                curso = c;
        
        Administrador adm = new Administrador();
        
        adm.setNome(nome);
        adm.setEmail(email);
        adm.setSenha(senha);
        adm.setCurso(curso);
        
        em.persist(adm);
        
    };
    
    @Override
    public List<Administrador> consultar() {
        return em.createQuery("SELECT a FROM Administrador a", Administrador.class).getResultList();
    }
    @Override
    public int login(String email, String senha){
       return em.createQuery("SELECT a FROM Administrador a WHERE (a.Senha = '" + senha + "') AND (a.Email = '"+ email+"')",Administrador.class).getMaxResults();
    }
}
