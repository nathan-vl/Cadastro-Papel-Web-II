package br.com.imd.arq;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@MappedSuperclass
public abstract class Entity {
    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    private Date dataCadastro;

    public Entity() {
        this.dataCadastro = new Date();
    }

    public Entity(Integer id) {
        this.id = id;
        this.dataCadastro = new Date();
    }
}
