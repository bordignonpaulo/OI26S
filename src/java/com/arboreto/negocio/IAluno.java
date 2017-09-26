
package com.arboreto.negocio;

import com.arboreto.entidade.Aluno;
import com.arboreto.entidade.Curso;
import java.util.List;
import javax.ejb.Local;

@Local
public interface IAluno {
    
    public void create(String nome, Integer RA, String email, String senha, Long cursoId);
    public List<Aluno> consultar();
    
}
