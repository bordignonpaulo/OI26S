
package com.arboreto.negocio;

import com.arboreto.entidade.familiaArborea;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IfamiliaArborea {
    
    public void create(String nome);
    public List<familiaArborea> consultar();
    public familiaArborea selecionar(Long id);
    public boolean remover(familiaArborea farborea);
    
}
