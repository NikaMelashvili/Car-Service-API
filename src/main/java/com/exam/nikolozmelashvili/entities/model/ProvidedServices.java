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

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "car")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH})
    @JoinColumn(name = "service")
    private CarServices carServices;

    @Column(name = "price")
    private double price;
}
