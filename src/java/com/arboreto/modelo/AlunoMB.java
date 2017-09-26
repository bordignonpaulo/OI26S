
package com.arboreto.modelo;

import com.arboreto.negocio.IAluno;
import com.arboreto.negocio.ICurso;
import com.arboreto.entidade.Aluno;
import com.arboreto.entidade.Curso;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class AlunoMB {
    
    private String nome;
    private String email;
    private Integer ra;
    private String senha;
    private Long cursoId;
    
    @EJB
    private ICurso cursoBean;
    
    @EJB
    private IAluno alunoBean;

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
    
    public List<Aluno> listAluno(){
        return alunoBean.consultar();
    }
    
    public void add(){
        alunoBean.create(this.getNome(), this.getRa(), this.getEmail(), this.getSenha(), this.getCursoId());
    }
    
}
