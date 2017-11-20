package com.arboreto.negocio;

import com.arboreto.entidade.Categoria;
import com.arboreto.entidade.Plantas;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IPlantas {

    public void create(String nome, String origem, String latitude, String longitude, String nomeCientifico, 
            Long familia, List<Categoria> categoria);

    public List<Plantas> consultar();
    
    public Plantas selecionar(Long id);
    public boolean remover(Plantas planta);
}
