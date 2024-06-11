package com.exam.nikolozmelashvili.repository;

import com.exam.nikolozmelashvili.entities.model.ProvidedServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidedServicesRepository extends JpaRepository<ProvidedServices, Long> {

    @Query("SELECT SUM(cs.price) FROM CarServices cs WHERE cs.name = :serviceName")
    Double getTotalRevenueByServiceType(@Param("serviceName") String serviceName);
}
