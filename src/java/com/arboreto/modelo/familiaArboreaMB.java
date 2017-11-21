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
public class familiaArboreaMB implements Serializable {

    private familiaArborea farborea = new familiaArborea();

    @EJB
    private IfamiliaArborea farboreaBean;

    public familiaArborea getFarborea() {
        return farborea;
    }

    public void setFarborea(familiaArborea farborea) {
        this.farborea = farborea;
    }

    

    public List<familiaArborea> listFamiliaArborea() {
        return farboreaBean.consultar();
    }

    public String add() {
        try {
            farboreaBean.create(farborea);
            return "adicionado";
        } catch (Exception e) {
            return "erro";
        }

    }
}
