package com.customer.demo.repository;

import com.customer.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


/**
 * JPA - Java persistence API
 * <p>
 * JPA repo gives below methods for free to use
 * <p>
 * save()<br>
 * findById(id) = ORM generate this SQL - select * from customer where id = 001<br>
 * findAll()<br>
 * delete()<br>
 * deleteById()<br>
 * count()  AND some of them
 */

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByEmail(String email);
    boolean existsByEmail(String email);
    List<Customer> findByFirstName(String firstName);

    List<Customer> findByFirstNameContainingIgnoreCaseOrLastNameContainingIgnoreCase(String firstname , String lastname);

    List<Customer> findByLastName(String lastName);

}
