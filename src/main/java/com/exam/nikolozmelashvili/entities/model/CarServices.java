package com.exam.nikolozmelashvili.entities.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "service")
public class CarServices {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Long id;

    @Column(name = "service_name", nullable = false)
    private String name;

    @Column(name = "service_description", nullable = false)
    private String description;

    @Column(name = "price", nullable = false)
    private double price;

}
