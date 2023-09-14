package br.com.imd.domain;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

public abstract class Entity {
    @Getter
    @Setter
    private int id;

    @Getter
    @Setter
    private Date dataCadastro;
}
