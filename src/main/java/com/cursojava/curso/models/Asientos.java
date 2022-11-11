package com.cursojava.curso.models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import java.time.*;

import javax.persistence.*;

@Entity
@Table(name = "asientos")
@ToString @EqualsAndHashCode
public class Asientos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //para valores con auto increment
    @Getter @Setter @Column(name = "id")
    private Long id;

    @Getter @Setter @Column(name = "costo")
    private String costo;

    @Getter @Setter @Column(name = "asiento")
    private String asiento;

    @Getter @Setter @Column(name = "fecha")
    private LocalDateTime fecha;

    @Getter @Setter @Column(name = "idcliente")
    private String idcliente;
}
