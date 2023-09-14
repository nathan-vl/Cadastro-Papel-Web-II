package br.com.imd.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Objects;

public class Usuario extends Entity {
    @Getter
    @Setter
    private String nome;

    @Getter
    @Setter
    private List<Papel> papeis;

    @Override
    public int hashCode() {
        return Objects.hash(getId(), nome, papeis);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;
        Usuario other = (Usuario) obj;
        return getId() == other.getId() && Objects.equals(nome, other.nome) && Objects.equals(papeis, other.papeis);
    }
}
