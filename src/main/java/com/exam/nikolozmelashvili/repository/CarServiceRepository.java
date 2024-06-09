package com.exam.nikolozmelashvili.repository;

import com.exam.nikolozmelashvili.entities.model.CarServices;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarServiceRepository extends JpaRepository<CarServices, Long> {
}
