package com.project.project2.repository;

import com.project.project2.entity.PersonDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<PersonDomain, Long> {

    public List<PersonDomain> findByAge(int age);

    @Query("select p from PersonDomain p where p.name=?1")
    public List<PersonDomain> findByName(String name);
    
    public List<PersonDomain> findByNameContaining(String name);
    
    public List<PersonDomain> findByPhoneNumber(Long phoneNumber);

    @Modifying
    @Transactional
    @Query(value = "update person_domain set name=?1 where id=?2", nativeQuery = true)
    void updatePersonNameById(String name,Long id);

    @Modifying
    @Transactional
    @Query(value = "update person_domain set phone_number=?1 where id=?2", nativeQuery = true)
    void updatePersonPhoneNumberById(Long phone_number,Long id);

    @Modifying
    @Transactional
    @Query(value = "update person_domain set age=?1 where id=?2", nativeQuery = true)
    void updatePersonAgeById(int age,Long id);
    public boolean existsByAge(int age);

    public boolean existsByName(String name);

    public boolean existsByPhoneNumber(Long number);

    public  boolean existsByNameContaining(String name);


}
