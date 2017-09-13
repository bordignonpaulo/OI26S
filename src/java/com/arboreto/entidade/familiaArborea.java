
package com.arboreto.entidade;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class familiaArborea implements Serializable {
    @Id@GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long Id;
    private String Nome;

    public familiaArborea() {
        super();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 37 * hash + Objects.hashCode(this.Id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final familiaArborea other = (familiaArborea) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "familiaArborea{" + "Id=" + Id + ", Nome=" + Nome + '}';
    }
    
    
    
    
}
