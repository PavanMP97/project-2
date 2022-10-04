package com.project.project2.service;

import com.project.project2.entity.VehicleDomain;
import com.project.project2.exceptions.VehicleNotFoundException;
import com.project.project2.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;


    public String register(VehicleDomain vehicleDomain) {
        vehicleRepository.save(vehicleDomain);
        return "Vehicle registered";
    }

    public String alterData(Long id, VehicleDomain vehicleDomain) {
        VehicleDomain list = vehicleDomain;
        if (vehicleRepository.existsById(id)) {
            vehicleRepository.deleteById(id);
            vehicleRepository.save(vehicleDomain);

        } else {
            try {
                throw new VehicleNotFoundException("Data doesn't exist with the given id" + id);
            } catch (VehicleNotFoundException e) {
                return e.getMessage();
            }
        }
        return "Data Updated Successfully";
    }


    public List<VehicleDomain> showDetails() {
        List<VehicleDomain> list = vehicleRepository.findAll();
        return list;
    }

    public Object showDetailsById(Long id) {
        if (vehicleRepository.existsById(id)) {
            return (Object) vehicleRepository.findById(id);
        } else {
            try {
                throw new VehicleNotFoundException("Data doesn't exist with the given id" + id);
            } catch (VehicleNotFoundException e) {
                return e.getMessage();
            }
        }

    }

    public Object showDetailsBasedOnBrand(String brand) {

        if (vehicleRepository.existsByBrand(brand)) return vehicleRepository.findByBrand(brand);
        else try {
            throw new VehicleNotFoundException("Data doesn't exist with the given brand:  " + brand);
        } catch (VehicleNotFoundException e) {
            return e.getMessage();
        }
    }

    public Object showDetailsBasedOnColour(String colour) {
        if (vehicleRepository.existsByColour(colour)) return vehicleRepository.findByColour(colour);
        else try {
            throw new VehicleNotFoundException("Data doesn't exist with the given Colour:  " + colour);
        } catch (VehicleNotFoundException e) {
            return e.getMessage();
        }
    }

    public Object showDetailsBasedOnType(String type) {
        if (vehicleRepository.existsByType(type)) return vehicleRepository.findByType(type);
        else try {
            throw new VehicleNotFoundException("Data doesn't exist with the given Type:  " + type);
        } catch (VehicleNotFoundException e) {
            return e.getMessage();
        }
    }

    public Object showDetailsBasedOnVehicleNumber(String vehicleNumber) {
        if (vehicleRepository.existsByVehicleNumber(vehicleNumber))
            return vehicleRepository.findByVehicleNumber(vehicleNumber);
        else try {
            throw new VehicleNotFoundException("Data doesn't exist with the given Vehicle-Number:  " + vehicleNumber);
        } catch (VehicleNotFoundException e) {
            return e.getMessage();
        }
    }

    public Object showDetailsBasedOnVehicleNumberNative(String vehicleNumber) {
        if (vehicleRepository.existsByVehicleNumberContaining(vehicleNumber))
            return vehicleRepository.getVehicleDomainByVehicleNumberNative(vehicleNumber);
        else try {
            throw new VehicleNotFoundException("Data doesn't exist with the given Vehicle-Number:  " + vehicleNumber);
        } catch (VehicleNotFoundException e) {
            return e.getMessage();
        }
    }

    public Object showDetailsBasedOnVehicleNumberContaining(String vehicleNumber) {
        if (vehicleRepository.existsByVehicleNumberContaining(vehicleNumber))
            return vehicleRepository.getVehicleDomainByVehicleNumberContaining(vehicleNumber);
        else try {
            throw new VehicleNotFoundException("Data doesn't exist with the given Vehicle-Number:  " + vehicleNumber);
        } catch (VehicleNotFoundException e) {
            return e.getMessage();
        }
    }

    public String updateColourById(String colour, Long vehicle_id) {
        if (vehicleRepository.existsById(vehicle_id)) {
            vehicleRepository.updateColourById(colour,vehicle_id);
            return "Data Updated Successfully";
        } else {
            try {
                throw new VehicleNotFoundException("Data doesn't exist with the given id" + vehicle_id);
            } catch (VehicleNotFoundException e) {
                return e.getMessage();
            }
        }
    }
}
