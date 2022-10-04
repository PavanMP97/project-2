package com.project.project2.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;
import javax.persistence.*;

@Entity(name = "PersonDomain")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Person_Domain")
public class PersonDomain {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_ID")
    private long id;
    private String name;
    private int age;
    private long phoneNumber;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "vehicle_ID")
    @JsonManagedReference
    private VehicleDomain vehicleDomain;
}
