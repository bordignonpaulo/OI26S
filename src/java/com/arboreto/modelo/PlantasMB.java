package com.arboreto.modelo;

import com.arboreto.entidade.Categoria;
import com.arboreto.entidade.Plantas;
import com.arboreto.entidade.familiaArborea;
import com.arboreto.negocio.ICategoria;
import com.arboreto.negocio.IPlantas;
import com.arboreto.negocio.IfamiliaArborea;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.primefaces.event.map.OverlaySelectEvent;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

@ManagedBean
@SessionScoped
public class PlantasMB {

    private MapModel advancedModel;

    private Marker marker;

    private String nome;
    private String origem;
    private String latitude;
    private String longitude;
    private String nomeCientifico;
    private String caracteristicas;

    private Long familiaarboreaId;

    private List<Categoria> categoria;

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

    public List<Categoria> getCategoria() {
        return categoria;
    }

    public void setCategoria(List<Categoria> categorias) {
        this.categoria = categorias;
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

    public List<familiaArborea> listFamiliaArborea() {
        return familiaArboreaBean.consultar();

    }

    public List<Categoria> listCategorias() {
        return CategoriaBean.consultar();

    }

    public String add() {
        try {
            plantasBean.create(nome, origem, latitude, longitude, nomeCientifico, caracteristicas, familiaarboreaId, categoria);
            return "adicionado";
        } catch (Exception e) {
            return "erro";
        }

    }

    public List<Plantas> listaPlantas() {
        return plantasBean.consultar();
    }

    @PostConstruct
    public void init() {
        advancedModel = new DefaultMapModel();

        plantasBean.consultar().forEach((p) -> {
            double lat = Double.parseDouble(p.getLatitude());
            double lng = Double.parseDouble(p.getLongitude());

            LatLng latlng = new LatLng(lat, lng);

            advancedModel.addOverlay(new Marker(latlng, p.getNome(), p.getCaracteristicas(), "../images/tree.png"));
        });
    }

    public MapModel getAdvancedModel() {
        return advancedModel;
    }

    public void onMarkerSelect(OverlaySelectEvent event) {
        marker = (Marker) event.getOverlay();
    }

    public Marker getMarker() {
        return marker;
    }
}
