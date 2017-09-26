
package com.arboreto.modelo;

import com.arboreto.negocio.ICurso;
import com.arboreto.entidade.Curso;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class CursoMB {
    
    private String nome;
    
    @EJB
    private ICurso cursoBean;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Curso> listCurso(){
        return cursoBean.consultar();
    }
    
    public String add(){
        try {
            cursoBean.create(this.getNome());
            return "adicionado";
        } catch (Exception e) {
            return "erro";
        }
        
    }
    
}
