
package com.arboreto.modelo;

import com.arboreto.negocio.IAdministrador;
import com.arboreto.negocio.ICurso;
import com.arboreto.entidade.Administrador;
import com.arboreto.entidade.Curso;
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
    private Long cursoId;
    
    private List<Curso> cursos;
    
    @EJB
    private IAdministrador admBean;
    
    @EJB
    private ICurso cursoBean;

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

    public Long getCursoId() {
        return cursoId;
    }

    public void setCursoId(Long cursoId) {
        this.cursoId = cursoId;
    }

    
    
    
    public List<Curso> listCursos(){
        return cursoBean.consultar();
        
    }
    
    public List<Administrador> listAdministrador(){
        return admBean.consultar();
    }
    
    public void add(){
        try{
            
            admBean.create(this.getNome(), this.getEmail(), this.getSenha(), this.getCursoId());
        }catch(Exception e){
            System.out.println(e);
        }
        
    }
}
