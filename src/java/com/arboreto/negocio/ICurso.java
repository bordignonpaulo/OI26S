
package com.arboreto.negocio;

import com.arboreto.entidade.Curso;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ICurso {
    
    public void create(String nome);
    public List<Curso> consultar();
    
}
