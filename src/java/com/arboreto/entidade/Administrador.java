
package com.arboreto.entidade;

import java.io.Serializable;
import javax.persistence.Entity;

@Entity
public class Administrador implements Serializable {
    
    private Long id;
    private String Nome;
    private String Email;
    private String Senha;
    private Curso curso;
    
}