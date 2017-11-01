
package com.arboreto.modelo;

import com.arboreto.negocio.IAdministrador;
import com.arboreto.entidade.Administrador;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AdministradorMB {
    
    private String nome;
    private String email;
    private String senha;
    
    @EJB
    private IAdministrador admBean;
    

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


  
    
    public List<Administrador> listAdministrador(){
        return admBean.consultar();
    }
    
    public String add(){
        try{
            admBean.create(this.getNome(), this.getEmail(), this.getSenha());
            return "adicionado";
        }catch(Exception e){
            return "erro";
        }
        
    }
    
    public String login(){
        
        try{
           
            if(admBean.login(this.getEmail(), this.getSenha()) != null)
                return "logado";
            else
                return "erro";
        }catch(Exception e){
            return "erro";
        }
        
    }
}
