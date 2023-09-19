package br.com.imd.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;
import java.util.Set;

@Entity
public class Usuario extends br.com.imd.arq.Entity {
    @Getter
    @Setter
    @Column
    private String nome;

    @Getter
    @Setter
    @ManyToMany
    private Set<Papel> papeis;

    public Usuario(Integer id, String nome, Set<Papel> papeis) {
        super(id);
        this.nome = nome;
        this.papeis = papeis;
    }

    public Usuario(String nome, Set<Papel> papeis) {
        super();
        this.nome = nome;
        this.papeis = papeis;
    }

    public Usuario() {
        super();
    }

    public String papeisFormatado() {
        return String.join(", ", papeis.stream().map(Papel::getDescricao).toList());
    }

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
