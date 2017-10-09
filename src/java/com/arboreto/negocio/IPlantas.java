package com.arboreto.negocio;

import com.arboreto.entidade.Categorias;
import com.arboreto.entidade.Plantas;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IPlantas {
 
public void create(String nome, String origem, String latitude, String longitude, String nomeCientifico, String caracteristicas, 
        Long familia, List<Categorias> categoria);
public List<Plantas> consultar();            
}

