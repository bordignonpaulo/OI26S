
package com.arboreto.modelo;

import com.aboreto.negocio.IAdministrador;
import com.aboreto.negocio.ICurso;
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
    private Integer ra;
    private Curso curso;
    
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

    public Integer getRa() {
        return ra;
    }

    public void setRa(Integer ra) {
        this.ra = ra;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public List<Curso> listCursos(){
        return cursoBean.consultar();
        
    }
    
    public List<Administrador> listAdministrador(){
        return admBean.consultar();
    }
    
    public void add(String nome, String email, String senha, Curso curso ){
        admBean.create(nome, email, senha, curso);
    }
}
