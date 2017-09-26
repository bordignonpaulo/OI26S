
package com.arboreto.modelo;

import com.arboreto.negocio.ICategoria;
import com.arboreto.entidade.Categorias;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class CategoriasMB {
    
    private String nome;
    
    @EJB
    private ICategoria categoriaBean;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<Categorias> listCategoria(){
        return categoriaBean.consultar();
    }
    
    public void add(){
        categoriaBean.create(this.getNome());
    }
    
}
