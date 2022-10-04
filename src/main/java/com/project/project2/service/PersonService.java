package com.project.project2.service;

import com.project.project2.entity.PersonDomain;
import com.project.project2.exceptions.PersonNotFoundException;
import com.project.project2.repository.PersonRepository;
import com.project.project2.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private VehicleRepository vehicleRepository;
    @Autowired
    private PersonRepository personRepository;


    public String register(PersonDomain personDomain) {
        personRepository.save(personDomain);
        return "Data Stored Successfully";
    }

//    public String alterData(Long id, PersonDomain personDomain) {
//        if (personRepository.existsById(id)) {
//            vehicleRepository.save(personDomain.getVehicleDomain());
//            personRepository.save(personDomain);
//            return "Data Updated Successfully";
//        } else {
//            try {
//                throw new PersonNotFoundException("Data doesn't exist with the given id: " + id);
//            } catch (PersonNotFoundException e) {
//                return e.getMessage();
//            }
//        }
//
//    }

    public List<PersonDomain> showDetails() {
        List<PersonDomain> list = personRepository.findAll();
        return list;
    }

    public Object showDetailsById(Long id) {
        if (personRepository.existsById(id)) {
            return personRepository.findById(id);
        } else {
            try {
                throw new PersonNotFoundException("Data doesn't exist with the given id: " + id);

            } catch (PersonNotFoundException e) {
                return e.getMessage();
            }
        }

    }


    public Object showDetailsByAge(int age) {
        if (personRepository.existsByAge(age)) {
            return personRepository.findByAge(age);
        } else {
            try {
                throw new PersonNotFoundException("Data doesn't exist with the given Age: " + age);

            } catch (PersonNotFoundException e) {
                return e.getMessage();
            }
        }
    }

    public Object showDetailsByName(String name) {
        if (personRepository.existsByName(name)) {
            return personRepository.findByName(name);
        } else {
            try {
                throw new PersonNotFoundException("Data doesn't exist with the given Name: " + name);

            } catch (PersonNotFoundException e) {
                return e.getMessage();
            }
        }
    }
    public  Object showDetailsByNameContaining(String name){
        if (personRepository.existsByNameContaining(name)) {
            return personRepository.findByNameContaining(name);
        } else {
            try {
                throw new PersonNotFoundException("Data doesn't exist with the given Name: " + name);

            } catch (PersonNotFoundException e) {
                return e.getMessage();
            }
        }
    }

    public Object showDetailsByPhoneNumber(Long number) {
        if (personRepository.existsByPhoneNumber(number)) {
            return personRepository.findByPhoneNumber(number);
        } else {
            try {
                throw new PersonNotFoundException("Data doesn't exist with the given PhoneNumber: " + number);

            } catch (PersonNotFoundException e) {
                return e.getMessage();
            }
        }
    }


    public String updatePersonNameById(String name, Long id) {
        if (personRepository.existsById(id)) {
                 personRepository.updatePersonNameById(name,id);
                 return "Data Updated Successfully";
        } else {
            try {
                throw new PersonNotFoundException("Data doesn't exist with the given id: " + id);

            } catch (PersonNotFoundException e) {
                return e.getMessage();
            }
        }
    }

    public String updatePersonPhoneNumberById(Long phone_number, Long id) {
        if (personRepository.existsById(id)) {
            personRepository.updatePersonPhoneNumberById(phone_number,id);
            return "Data Updated Successfully";
        } else {
            try {
                throw new PersonNotFoundException("Data doesn't exist with the given id: " + id);

            } catch (PersonNotFoundException e) {
                return e.getMessage();
            }
        }
    }

    public String updatePersonAgeById(int age, Long id) {
        if (personRepository.existsById(id)) {
            personRepository.updatePersonAgeById(age,id);
            return "Data Updated Successfully";
        } else {
            try {
                throw new PersonNotFoundException("Data doesn't exist with the given id: " + id);

            } catch (PersonNotFoundException e) {
                return e.getMessage();
            }
        }
    }
}
