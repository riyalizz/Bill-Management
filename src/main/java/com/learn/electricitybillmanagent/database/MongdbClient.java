package com.learn.electricitybillmanagent.database;


import com.learn.electricitybillmanagent.AppConfigs;
import com.learn.electricitybillmanagent.models.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MongdbClient {

    private final CustomerCollectionRepository mongoRepository;

    public AppConfigs appConfigs;

    private String connectionString = "mongodb://localhost:27017";

    @Autowired
    public MongdbClient(CustomerCollectionRepository mongoRepository) {
        this.mongoRepository = mongoRepository;
        //AppConfigs.
    }

    public Customer saveEntity(Customer entity) {
        return mongoRepository.save(entity);
    }

    public Customer findById(int id) {
        return mongoRepository.findById(id).orElse(null);
    }

    public List<Customer> findAll() {
        return mongoRepository.findAll();
    }

    public static void main(String[] args) {
        
    }

    public List<Customer> findByFirstName(String fName, String lName) {
        return mongoRepository.findByFirstNameAndLastName(fName, lName);
    }
}
