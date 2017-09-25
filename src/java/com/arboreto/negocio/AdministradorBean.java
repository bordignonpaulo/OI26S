
package com.arboreto.negocio;

import com.arboreto.entidade.Administrador;
import com.arboreto.entidade.Curso;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AdministradorBean implements IAdministrador {
    @PersistenceContext
    private EntityManager em;
    
    @Override
    public void create(String nome, String email, String senha, Curso curso){
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
}
