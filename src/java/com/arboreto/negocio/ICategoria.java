
package com.arboreto.negocio;

import com.arboreto.entidade.Categoria;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ICategoria {

    public void create(String nome);
    public List<Categoria> consultar();
    public Categoria selecionar(Long id);
    public boolean remover(Categoria categoria);
}
