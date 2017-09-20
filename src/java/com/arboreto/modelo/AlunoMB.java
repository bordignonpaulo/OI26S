
package com.arboreto.modelo;

import com.aboreto.negocio.IAluno;
import com.aboreto.negocio.ICurso;
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
    private Curso curso;
    
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

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    public List<Curso> listCursos(){
        return cursoBean.consultar();
        
    }
    
    public List<Aluno> listAluno(){
        return alunoBean.consultar();
    }
    
    public void add(String nome, Integer ra, String email, String senha, Curso curso){
        alunoBean.create(nome, ra, email, senha, curso);
    }
    
}
