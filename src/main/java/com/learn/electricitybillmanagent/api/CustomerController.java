package com.learn.electricitybillmanagent.api;

import com.learn.electricitybillmanagent.database.MongdbClient;
import com.learn.electricitybillmanagent.models.Customer;
import com.learn.electricitybillmanagent.sqs.SQSMessage;
import com.learn.electricitybillmanagent.sqs.SqsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;
import java.util.Random;

@RestController
public class CustomerController
{

    @Autowired
    MongdbClient mongdbClient;

    @Autowired
    private SqsService sqsService;

    @GetMapping("/health_check")
    public String sayHello() {
        return "Hello, World!";
    }

    @PostMapping("/create_customer")
    public Customer createCustomer(@RequestBody Customer customer)
    {

        //create customer details
        customer.setId(new Random().nextInt(1000000));
        Date currentDate = new Date();
        customer.setDate(new Date());

        //fetch the request body

        // post to database

        Customer customerResponse = mongdbClient.saveEntity(customer);
        //Customer customer2 = mongdbClient.findById("")
        //customerResponse.getId();


        return customerResponse;
    }
    @GetMapping("/getcustomer/{id}")
    public ResponseEntity<Object> getcustomer(@PathVariable int id )
    {
        Customer customer=mongdbClient.findById(id);
        try {
            if (customer == null) {
                sqsService.sendMessage(new SQSMessage(String.valueOf(id)));
                return ResponseEntity.status(404).body("");

            }
        }
        catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return ResponseEntity.ok(customer);
    }

    @GetMapping("/customers/all")
    public List<Customer> getAllCustomers(@RequestHeader("Authorization") String auth)
    {
        if(!auth.equalsIgnoreCase("Imbachi"))
            return null;
        List<Customer> customers=mongdbClient.findAll();
        return customers;
    }

    @GetMapping("/customer")
    public List<Customer> getCustomerByName(@RequestParam("first-name") String fName,
                                            @RequestParam("last-name") String lName)
    {
        List<Customer> customers=mongdbClient.findByFirstName(fName, lName);
        return customers;
    }

    int calculate(int a, int b)
    {
        return a + b;
    }

}
