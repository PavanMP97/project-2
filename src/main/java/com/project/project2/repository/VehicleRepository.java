package com.project.project2.repository;

import com.project.project2.entity.VehicleDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface VehicleRepository extends JpaRepository<VehicleDomain, Long> {
    public List<VehicleDomain> findByBrand(String brand);

    public List<VehicleDomain> findByColour(String colour);

    public List<VehicleDomain> findByType(String type);

    public List<VehicleDomain> findByVehicleNumber(String vehicleNumber);

    @Query(value = "select *  from vehicle_domain v where v.vehicle_number = ?1",nativeQuery = true)
    public  List<VehicleDomain> getVehicleDomainByVehicleNumberNative(String vehicleNumber);

    public  List<VehicleDomain> getVehicleDomainByVehicleNumberContaining(String vehicleNumber);
    public boolean existsByBrand(String brand);

    public boolean existsByColour(String colour);

    public boolean existsByType(String type);

    public boolean existsByVehicleNumber(String number);

    public boolean existsByVehicleNumberContaining(String vehicleNumber);

    @Modifying
    @Transactional
@Query(value = "update vehicle_domain set colour=?1 where vehicle_id=?2",
    nativeQuery = true)
    public int updateColourById(String colour, Long id);
}
