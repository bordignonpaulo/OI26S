
package com.aboreto.negocio;

import com.arboreto.entidade.Curso;
import javax.ejb.Local;

@Local
public interface IAluno {
    
    public void create(String nome, Integer RA, String email, String senha, Curso curso);
    
}
