package com.project.project2.controll;

import com.project.project2.entity.PersonDomain;
import com.project.project2.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person")
class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public String addVehicle(@RequestBody PersonDomain personDomain) {
        return personService.register(personDomain);
    }


    @PutMapping("/update-name-by-id/{name}/{id}")
    public String updateNameById(@PathVariable String name,@PathVariable Long id, @RequestBody PersonDomain personDomain) {
        return personService.updatePersonNameById(name,id);
    }

    @PutMapping("/update-phone_number-by-id/{phone_number}/{id}")
    public String updatePhoneNumberById(@PathVariable Long phone_number,@PathVariable Long id, @RequestBody PersonDomain personDomain) {
        return personService.updatePersonPhoneNumberById(phone_number,id);
    }

    @PutMapping("/update-age-by-id/{age}/{id}")
    public String updateAgeById(@PathVariable int age,@PathVariable Long id, @RequestBody PersonDomain personDomain) {
        return personService.updatePersonAgeById(age,id);
    }


    @GetMapping("/details")
    public ResponseEntity<List<PersonDomain>> getDetails() {
        return new ResponseEntity<List<PersonDomain>>(personService.showDetails(), HttpStatus.OK);
    }

    @GetMapping("/details/ById=/{id}")
    public ResponseEntity<Object> getDetailsById(@PathVariable Long id) {

        return new ResponseEntity<Object>(personService.showDetailsById(id), HttpStatus.OK);
    }

    @GetMapping("/details/ByAge=/{age}")
    public ResponseEntity<Object> getDetailsByAge(@PathVariable int age) {
        return new ResponseEntity<Object>(personService.showDetailsByAge(age), HttpStatus.OK);
    }

    @GetMapping("/details/ByName=/{name}")
    public ResponseEntity<Object> getDetailsByName(@PathVariable String name) {
        return new ResponseEntity<Object>(personService.showDetailsByName(name), HttpStatus.OK);
    }

    @GetMapping("/details/ByPhoneNumber=/{phoneNumber}")
    public ResponseEntity<Object> getDetailsByPhoneNumber(@PathVariable Long phoneNumber) {
        return new ResponseEntity<Object>(personService.showDetailsByPhoneNumber(phoneNumber), HttpStatus.OK);
    }

    @GetMapping("/details/ByNameContaining=/{name}")
    public ResponseEntity<Object> getDetailsByNameContaining(@PathVariable String name) {
        return new ResponseEntity<Object>(personService.showDetailsByNameContaining(name), HttpStatus.OK);
    }

}
