
package com.arboreto.negocio;

import com.arboreto.entidade.Categoria;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ICategoria {

    public void create(Categoria categoria);
    public List<Categoria> consultar();
    public Categoria selecionar(Long id);
    public boolean remover(Categoria categoria);
}
