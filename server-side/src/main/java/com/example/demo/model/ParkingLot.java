package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Entity
@Data
public class ParkingLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // TODO, close the brackets
    @Column(name="id")
    private Long id;
    @Column(
            name="name",
            updatable = true,
            columnDefinition = "TEXT",
            unique = true
    )
    private String name;
    @Column(
            name="available",
            updatable = true
    )
    private boolean available;
    @Column(
            name="customer_name",
            updatable = true,
            columnDefinition = "TEXT"
    )
    private String customerName;
    @Column(
            name="car_number",
            updatable = true,
            columnDefinition = "TEXT"
    )
    private String carNumber;
    @Column(
            name="car_color",
            updatable = true,
            columnDefinition = "TEXT"
    )
    private String color;
    @Column(
            name="start_date",
            updatable = true,
            columnDefinition = "DATE"
    )
    private Date startDate;
    @Column(
            name="expiration_date",
            updatable = true,
            columnDefinition = "DATE"
    )
    private Date expirationDate;
    @Column(
            name="phone_number",
            updatable = true,
            columnDefinition = "TEXT"
    )
    private String phoneNumber;
}
