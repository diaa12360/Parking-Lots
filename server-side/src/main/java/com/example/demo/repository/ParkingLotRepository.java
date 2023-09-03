package com.example.demo.repository;

import com.example.demo.model.ParkingLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@RepositoryDefinition(domainClass = ParkingLot.class, idClass = Long.class)
@EnableJpaRepositories(basePackages = "org.progressoft.interns.parking.model")
public interface ParkingLotRepository extends JpaRepository<ParkingLot, Long> {
    Optional<ParkingLot> findParkingLotById(Long id);

    void deleteParkingLotById(Long id);
    void deleteByName(String name);
}
