
package com.arboreto.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Plantas implements Serializable {
@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
private Long Id;
private String nome;
private String origem;
private String latitude;
private String longitude;
private String nomeCientifico;


@ManyToOne (fetch = FetchType.EAGER )
private familiaArborea familia;


@ManyToMany (fetch = FetchType.EAGER)
private List<Categoria> categorias;

    public Plantas() {
        super();
    }

    public Long getId() {
        return Id;
    }

    public void setId(long Id) {
        this.Id = Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    } 
    
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }
    
    public String getNomeCientifico() {
        return nomeCientifico;
    }

    public void setNomeCientifico(String nomeCientifico) {
        this.nomeCientifico = nomeCientifico;
    }


    public familiaArborea getFamilia() {
        return familia;
    }

    public void setFamilia(familiaArborea id) {
        this.familia = id;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categoria) {
        this.categorias = categoria;
    }

   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (int) (this.Id ^ (this.Id >>> 32));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Plantas other = (Plantas) obj;
        if (this.Id != other.Id) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Plantas{" + "Id=" + Id + ", nome=" + nome + ", origem=" + origem + ", latitude=" + latitude + ", longitude=" + longitude + ", nomeCientifico=" + nomeCientifico + ", familia=" + familia + ", categorias=" + categorias + '}';
    }
    
}