
package com.arboreto.negocio;

import com.arboreto.entidade.Administrador;
import com.arboreto.entidade.Curso;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IAdministrador {
    
    public void create(String nome, String email, String senha, Long curso);
    public List<Administrador> consultar();
    
}
