
package com.aboreto.negocio;

import javax.ejb.Local;

@Local
public interface ICurso {
    
    public void create(String nome);
    
}
