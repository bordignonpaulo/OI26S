
package com.arboreto.modelo;

import com.arboreto.negocio.IfamiliaArborea;
import com.arboreto.entidade.familiaArborea;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean
@SessionScoped
public class familiaArboreaMB implements Serializable{
    
    private String nome;
    
    @EJB
    private IfamiliaArborea farboreaBean;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public List<familiaArborea> listFamiliaArborea(){
        return farboreaBean.consultar();
    }
    
    public void add(String nome){
        farboreaBean.create(nome);
    }
    
}
