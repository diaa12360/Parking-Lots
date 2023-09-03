package com.example.demo.service;

import com.example.demo.exception.ParkingLotNotFoundException;
import com.example.demo.repository.ParkingLotRepository;
import com.example.demo.model.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
@EnableScheduling
public class ParkingLotService {
    private final ParkingLotRepository parkingLotRepository;

    @Autowired
    public ParkingLotService(ParkingLotRepository parkingLotRepository) {
        this.parkingLotRepository = parkingLotRepository;
    }


    public ParkingLot addParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    public List<ParkingLot> findAllParkingLots() {
        return parkingLotRepository.findAll();
    }

    public ParkingLot updateParkingLot(ParkingLot parkingLot) {
        return parkingLotRepository.save(parkingLot);
    }

    public ParkingLot findParkingLotById(Long id) {
        return parkingLotRepository.findParkingLotById(id)
                .orElseThrow(() -> new ParkingLotNotFoundException("User by id " + id + " was not found"));
    }

    public void deleteParkingLot(Long id) {
        parkingLotRepository.deleteParkingLotById(id);
    }

    @Scheduled(cron = "0 0 * * * *")
    public void schedule(){
        try{
            findAllParkingLots().stream().filter((parkingLot) ->
                    parkingLot.getExpirationDate() != null &&
                            (parkingLot.getExpirationDate().before(new Date()) ||
                                    parkingLot.getExpirationDate().equals(new Date()))
            ).forEach((parkingLot) -> {
                parkingLot.setAvailable(true);
                parkingLot.setColor(null);
                parkingLot.setCarNumber(null);
                parkingLot.setStartDate(null);
                parkingLot.setExpirationDate(null);
                updateParkingLot(parkingLot);
            });
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}