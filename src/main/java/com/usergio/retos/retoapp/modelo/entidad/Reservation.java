package com.usergio.retos.retoapp.modelo.entidad;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Data
@Entity
@Table(name="reservation")
public class Reservation implements Serializable {
    @Id//clave primaria (pk)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReservation;
    private Date startDate;
    private Date devolutionDate;
    private String status = "created";

    @ManyToOne
    @JoinColumn(name="idCar") //foreing key
    @JsonIgnoreProperties("reservations")
    private Car car;

    @ManyToOne
    @JoinColumn(name="idClient") //foreing key
    @JsonIgnoreProperties({"reservations","messages"})
    private Client client;

    @OneToOne(cascade = {CascadeType.PERSIST},mappedBy = "reservation")
    @JsonIgnoreProperties("reservation")
    private Score score;
}
