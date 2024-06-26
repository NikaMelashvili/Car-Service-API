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
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "car_id")
    private Car car;

    @ManyToOne(fetch = FetchType.LAZY ,cascade = {CascadeType.DETACH, CascadeType.MERGE,
            CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.REMOVE})
    @JoinColumn(name = "service_id")
    private CarServices carServices;
}
