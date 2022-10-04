package com.project.project2.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Data
@Transactional
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "vehicle_Domain")
public class VehicleDomain {
    @Id
    @GeneratedValue(
            strategy = GenerationType.AUTO,
            generator = "vehicle_sequence"
    )
    private long vehicle_Id;
    private String vehicleNumber;
    private String brand;
    private String colour;
    private String type;
    @OneToOne(mappedBy = "vehicleDomain")
    @JsonBackReference
    private PersonDomain personDomain;

}
