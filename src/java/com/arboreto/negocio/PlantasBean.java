package com.arboreto.negocio;

import com.arboreto.entidade.Categoria;
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

    @Override
    public void create(String nome, String origem, String latitude, String longitude, String nomeCientifico, 
            Long familia, List<Categoria> categoria) {

        familiaArborea farborea = null;

        for (familiaArborea fa : familiaArboreaBean.consultar()) {
            if (fa.getId() == familia) {
                farborea = fa;
            }
        }

        Plantas plantas = new Plantas();

        plantas.setNome(nome);
        plantas.setOrigem(origem);
        plantas.setLatitude(latitude);
        plantas.setLongitude(longitude);
        plantas.setNomeCientifico(nomeCientifico);
        plantas.setFamilia(farborea);
        plantas.setCategorias(categoria);

        em.persist(plantas);
    }

    @Override
    public List<Plantas> consultar() {
        return em.createQuery("SELECT p FROM Plantas p", Plantas.class).getResultList();
    }

    @Override
    public Plantas selecionar(Long id) {
        Plantas planta = null;
        try {
            planta = em.find(Plantas.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return planta;
    }

    @Override
    public boolean remover(Plantas planta) {
        boolean sucesso = false;
        try {
            planta = em.find(Plantas.class, planta.getId());
            em.remove(planta);
            sucesso =  true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return sucesso;
    }
}
