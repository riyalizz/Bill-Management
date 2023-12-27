package com.learn.electricitybillmanagent.database;

import com.learn.electricitybillmanagent.models.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface CustomerCollectionRepository extends MongoRepository<Customer, Integer> {

    List<Customer> findByFirstNameAndLastName(String fName, String lName);
}
