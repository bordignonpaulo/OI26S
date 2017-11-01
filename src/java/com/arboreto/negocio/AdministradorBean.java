
package com.arboreto.negocio;

import com.arboreto.entidade.Administrador;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AdministradorBean implements IAdministrador {
    @PersistenceContext
    private EntityManager em;
    
    
    public void create(String nome, String email, String senha){
        
        
        Administrador adm = new Administrador();
        
        adm.setNome(nome);
        adm.setEmail(email);
        adm.setSenha(senha);
        
        em.persist(adm);
        
    };
    
    @Override
    public List<Administrador> consultar() {
        return em.createQuery("SELECT a FROM Administrador a", Administrador.class).getResultList();
    }
    @Override
    public List<Administrador> login(String email, String senha){
       return em.createQuery("SELECT a FROM Administrador a WHERE (a.Senha = '" + senha + "') AND (a.Email = '"+ email+"')",Administrador.class).getResultList();
    }
}
