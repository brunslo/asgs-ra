package com.github.brunslo.asgsra.domain.remotenessarea;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "ra_2016_aust")
@Data
public class RemotenessAreaEntity {
    @Id
    @Column(name = "primaryindex")
    private Integer id;

    @Column(name = "ra_code_2016")
    @Convert(converter = RemotenessAreaConverter.class)
    private RemotenessArea remotenessArea;
}
