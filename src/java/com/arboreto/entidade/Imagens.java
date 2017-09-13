
package com.arboreto.entidade;

import java.io.Serializable;
import java.util.Objects;

public class Imagens implements Serializable {
    
    private Long Id;
    private Plantas planta;

    public Imagens() {
        super();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long Id) {
        this.Id = Id;
    }

    public Plantas getPlanta() {
        return planta;
    }

    public void setPlanta(Plantas planta) {
        this.planta = planta;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.Id);
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
        final Imagens other = (Imagens) obj;
        if (!Objects.equals(this.Id, other.Id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Imagens{" + "Id=" + Id + ", planta=" + planta + '}';
    }
    
    
}
