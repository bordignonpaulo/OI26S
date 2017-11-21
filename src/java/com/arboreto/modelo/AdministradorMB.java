
package com.arboreto.modelo;

import com.arboreto.negocio.IAdministrador;
import com.arboreto.entidade.Administrador;
import java.awt.event.ActionEvent;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean
@SessionScoped
public class AdministradorMB {
    
    private String nome;
    private String email;
    private String senha;
    
    private Administrador administrador;
    private List<Administrador> administradores;
    
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
            if( admBean.login(this.getEmail(), this.getSenha()) != null)
                return "logado";
            else
                return "erro";
        }catch(Exception e){
            return "erro";
        }
        
    }
    
    public void selecionar(ActionEvent evento) {
        //
        //administrador = admBean.selecionar(id);
    }
 
    public void remover() {
        FacesContext context = FacesContext.getCurrentInstance();
        boolean resultado = admBean.remover(administrador);
 
        if (resultado) {
            administrador = new Administrador();
            context.addMessage(null, new FacesMessage("Cliente removido com sucesso"));
        } else {
            context.addMessage(null, new FacesMessage("Falha ao remover cliente!"));
        }
    }
}
