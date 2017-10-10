
package com.arboreto.modelo;

import com.arboreto.entidade.Categorias;
import com.arboreto.negocio.ICategoria;
import com.arboreto.negocio.IPlantas;
import com.arboreto.negocio.IfamiliaArborea;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;



@ManagedBean
@SessionScoped
public class PlantasMB {
    
    private String nome;
    private String origem;
    private String latitude;
    private String longitude;
    private String nomeCientifico;
    private String caracteristicas;
    
    private Long familiaarboreaId;
    
    private Categorias categoria;
    private List<Categorias> categorias;
    
    @EJB
    private IfamiliaArborea familiaArboreaBean;
    
    @EJB
    private ICategoria CategoriaBean;
    
    @EJB
    private IPlantas plantasBean;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Long getFamiliaarboreaId() {
        return familiaarboreaId;
    }

    public void setFamiliaarboreaId(Long familiaarboreaId) {
        this.familiaarboreaId = familiaarboreaId;
    }

    public List<Categorias> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categorias> categorias) {
        this.categorias = categorias;
    }

    public IfamiliaArborea getFamiliaArboreaBean() {
        return familiaArboreaBean;
    }

    public void setFamiliaArboreaBean(IfamiliaArborea familiaArboreaBean) {
        this.familiaArboreaBean = familiaArboreaBean;
    }

    public ICategoria getCategoriaBean() {
        return CategoriaBean;
    }

    public void setCategoriaBean(ICategoria CategoriaBean) {
        this.CategoriaBean = CategoriaBean;
    }
    
    public String adicionaPassageiro() {

        if (categorias == null) {
            categorias = new ArrayList<>();
        }

        categorias.add(categoria);

        categoria = new Categorias();
        
        return "adicionado";
    }
    
    public String add(){
        try {
            plantasBean.create(this.getNome(), this.getOrigem(), this.getLatitude(), this.getLongitude(), this.getNomeCientifico(), this.getCaracteristicas(), this.getFamiliaarboreaId(),this.getCategorias());
            return "adicionado";
        } catch (Exception e) {
            return "erro";
        }
        
    }    
}
