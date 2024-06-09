package com.exam.nikolozmelashvili.entities.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "provided_services")
@AllArgsConstructor
@NoArgsConstructor
public class ProvidedServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "provided_service_id")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "car")
    private Car car;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "service")
    private CarServices carServices;

    @Column(name = "price")
    private double price;
}
