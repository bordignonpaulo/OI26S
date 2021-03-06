
package com.arboreto.entidade;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Plantas implements Serializable {
@Id@GeneratedValue (strategy = GenerationType.IDENTITY)
private long Id;
private String nome;
private String origem;
private String latitude;
private String longitude;
private String nomeCientifico;
private String caracteristicas;

@ManyToOne (fetch = FetchType.EAGER )
private familiaArborea familia;

@ManyToMany (fetch = FetchType.EAGER)
private Categorias categoria;

    public Plantas() {
        super();
    }

    public long getId() {
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

    public String getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(String caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public familiaArborea getFamilia() {
        return familia;
    }

    public void setFamilia(familiaArborea id) {
        this.familia = id;
    }

    public Categorias getCategoria() {
        return categoria;
    }

    public void setCategoria(Categorias id) {
        this.categoria = id;
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
        return "Plantas{" + "Id=" + Id + ", nome=" + nome + ", origem=" + origem + ", latitude=" + latitude + ", longitude=" + longitude + ", nomeCientifico=" + nomeCientifico + ", caracteristicas=" + caracteristicas + ", familia=" + familia + ", categoria=" + categoria + '}';
    }

    
    
    


    
}