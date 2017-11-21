
package com.arboreto.modelo;

import com.arboreto.negocio.ICategoria;
import com.arboreto.entidade.Categoria;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class CategoriaMB {
    
    private Categoria categoria = new Categoria();
    
    @EJB
    private ICategoria categoriaBean;
    
    public List<Categoria> listCategoria(){
        return categoriaBean.consultar();
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
    
    public String add(){
        try {
             categoriaBean.create(categoria);
             return "adicionado";
        } catch (Exception e) {
            return "erro";
        }
       
    }
    
}
