
package com.aboreto.negocio;

import com.arboreto.entidade.Categorias;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ICategoria {

    public void create(String nome);
    public List<Categorias> consultar();
}
