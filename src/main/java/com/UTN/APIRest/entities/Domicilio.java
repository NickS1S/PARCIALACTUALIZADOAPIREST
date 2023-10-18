package com.UTN.APIRest.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="domicilio")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Domicilio extends BaseEntidad{
    @Column(name="calle")
    private String calle;
    @Column(name="numero")
    private int numero;

    @ManyToOne(optional = false)
    @JoinColumn(name="localidad_id")
    private Localidad localidad;
}
