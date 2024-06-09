package com.exam.nikolozmelashvili.repository;

import com.exam.nikolozmelashvili.entities.model.ProvidedServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvidedServicesRepository extends JpaRepository<ProvidedServices, Long> {
}
