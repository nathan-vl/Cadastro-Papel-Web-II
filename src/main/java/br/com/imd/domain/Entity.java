package br.com.imd.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public abstract class Entity {
    @Getter
    @Setter
    private Integer id;

    @Getter
    @Setter
    private Date dataCadastro;

    public Entity(Integer id) {
        this.id = id;
        this.dataCadastro = new Date();
    }
}
