package com.arboreto.negocio;

import com.arboreto.entidade.Categorias;
import com.arboreto.entidade.familiaArborea;
import com.arboreto.entidade.Plantas;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class PlantasBean implements IPlantas {

    @PersistenceContext
    private EntityManager em;

    @EJB
    private IfamiliaArborea familiaArboreaBean;

    @EJB
    private ICategoria CategoriaBean;

    public void create(String nome, String origem, String latitude, String longitude, String nomeCientifico, String caracteristicas,
            Long familia, List<Categorias> categoria) {

        familiaArborea farborea = null;
        
        for (familiaArborea fa: familiaArboreaBean.consultar())
            if (fa.getId() == familia)
                farborea = fa;

        Plantas plantas = new Plantas();

        plantas.setNome(nome);
        plantas.setOrigem(origem);
        plantas.setLatitude(latitude);
        plantas.setLongitude(longitude);
        plantas.setNomeCientifico(nomeCientifico);
        plantas.setCaracteristicas(caracteristicas);
        plantas.setFamilia(farborea);
       plantas.setCategoria(categoria);
        
        em.persist(plantas);
    }
    
    public List<Plantas> consultar() {
        return em.createQuery("SELECT p FROM Plantas p", Plantas.class).getResultList();
    }
}

