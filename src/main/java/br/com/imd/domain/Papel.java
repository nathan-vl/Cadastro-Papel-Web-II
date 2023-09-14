package br.com.imd.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

public class Papel extends Entity {
    @Getter
    @Setter
    private String descricao;

    public Papel(Integer id, String descricao) {
        super(id);
        this.descricao = descricao;
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
        return "Papel{" +
                "descricao='" + descricao + '\'' +
                ", id=" + getId() +
                ", dataCadastro=" + getDataCadastro() +
                '}';
    }
}
