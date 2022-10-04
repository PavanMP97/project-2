package com.project.project2.controll;

import com.project.project2.entity.VehicleDomain;
import com.project.project2.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleController {


    @Autowired
    private VehicleService vehicleService;

    @GetMapping("/details")
    public ResponseEntity<List<VehicleDomain>> getDetails() {

        return new ResponseEntity<List<VehicleDomain>>(vehicleService.showDetails(), HttpStatus.OK);
    }

    @GetMapping("/detailsById/{id}")
    public ResponseEntity<Object> getDetailsById(@PathVariable Long id) {
        return new ResponseEntity<Object>(vehicleService.showDetailsById(id), HttpStatus.OK);
    }

    @GetMapping("details/ByBrand/{brand}")
    public ResponseEntity<Object> getDetailsBasedOnBrand(@PathVariable String brand) {
        return new ResponseEntity<Object>(vehicleService.showDetailsBasedOnBrand(brand), HttpStatus.OK);
    }

    @GetMapping("details/ByColour/{colour}")
    public ResponseEntity<Object> getDetailsBasedOnColour(@PathVariable String colour) {
        return new ResponseEntity<Object>(vehicleService.showDetailsBasedOnColour(colour), HttpStatus.OK);
    }

    @GetMapping("details/ByType/{type}")
    public ResponseEntity<Object> getDetailsBasedOnType(@PathVariable String type) {
        return new ResponseEntity<Object>(vehicleService.showDetailsBasedOnType(type), HttpStatus.OK);
    }

    @GetMapping("details/ByVehicleNumber/{vehicleNumber}")
    public ResponseEntity<Object> getDetailsBasedOnVehicleNumber(@PathVariable String vehicleNumber) {
        return new ResponseEntity<Object>(vehicleService.showDetailsBasedOnVehicleNumber(vehicleNumber), HttpStatus.OK);
    }
    @GetMapping("details/ByVehicleNumberNative/{vehicleNumber}")
    public ResponseEntity<Object> getDetailsBasedOnVehicleNumberNative(@PathVariable String vehicleNumber) {
        return new ResponseEntity<Object>(vehicleService.showDetailsBasedOnVehicleNumberNative(vehicleNumber), HttpStatus.OK);
    }

    @GetMapping("details/ByVehicleNumberContaining/{vehicleNumber}")
    public ResponseEntity<Object> getDetailsBasedOnVehicleNumberContaining(@PathVariable String vehicleNumber) {
        return new ResponseEntity<Object>(vehicleService.showDetailsBasedOnVehicleNumberContaining(vehicleNumber), HttpStatus.OK);
    }
    @PutMapping("/update-colour-by-id/{colour}/{vehicle_id}")
    public ResponseEntity<String> updateColourById(@PathVariable String colour,@PathVariable Long vehicle_id){
        return new ResponseEntity<String>(vehicleService.updateColourById(colour,vehicle_id), HttpStatus.OK);
    }
}
