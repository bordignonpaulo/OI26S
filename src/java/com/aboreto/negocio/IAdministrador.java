
package com.aboreto.negocio;

import com.arboreto.entidade.Curso;
import javax.ejb.Local;

@Local
public interface IAdministrador {
    
    public void create(String nome, String email, String senha, Curso curso);
    
}
