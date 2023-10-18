package com.UTN.APIRest.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="libro")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Libro extends BaseEntidad{
    @Column(name="titulo")
    private String titulo;
    @Column(name = "fecha")
    private int fecha;
    @Column(name="genero")
    private String genero;
    @Column(name="paginas")
    private int paginas;

    @ManyToMany(cascade = CascadeType.REFRESH)
    @JoinTable(
            name="libro-autor",
            joinColumns = @JoinColumn(name ="libro_id"),
            inverseJoinColumns = @JoinColumn(name="autor_id")
    )
    private List<Autor> autor = new ArrayList<Autor>();
}
