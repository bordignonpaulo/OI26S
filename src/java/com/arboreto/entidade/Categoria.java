
package com.arboreto.entidade;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Categoria implements Serializable {
    
    @Id@GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    
    @ManyToMany (fetch = FetchType.EAGER, mappedBy = "categorias")
    private List<Plantas> plantas;
    
    public Categoria(){
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Plantas> getPlantas() {
        return plantas;
    }

    public void setPlantas(List<Plantas> plantas) {
        this.plantas = plantas;
    }
    
    

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Categoria other = (Categoria) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Categorias{" + "id=" + id + ", nome=" + nome + '}';
    }
    
    
    
}
