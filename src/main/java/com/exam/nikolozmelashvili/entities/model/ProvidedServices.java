package com.exam.nikolozmelashvili.entities.model;

import com.exam.nikolozmelashvili.entities.base.AppEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@Table(name = "provided_services")
@AllArgsConstructor
@NoArgsConstructor
public class ProvidedServices extends AppEntity {

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
