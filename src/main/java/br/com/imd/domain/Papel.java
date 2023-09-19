package br.com.imd.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Entity
public class Papel extends br.com.imd.arq.Entity {
    @Getter
    @Setter
    @Column
    private String descricao;

    @Getter
    @Setter
    @ManyToMany
    private Set<Usuario> usuarios;

    public Papel(Integer id, String descricao) {
        super(id);
        this.descricao = descricao;
    }

    public Papel(Integer id) {
        super(id);
    }

    public Papel(String descricao) {
        super();
        this.descricao = descricao;
    }

    public Papel() {
        super();
    }

    @Override
    public int hashCode() {
        return Objects.hash(descricao, getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Papel other = (Papel) obj;
        return getId() == other.getId();
    }

    @Override
    public String toString() {
        return "Papel{" + "descricao='" + descricao + '\'' + ", id=" + getId() + ", dataCadastro=" + getDataCadastro() + '}';
    }
}
