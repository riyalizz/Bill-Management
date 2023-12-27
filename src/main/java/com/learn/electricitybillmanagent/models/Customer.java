package com.learn.electricitybillmanagent.models;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Getter
@Setter
@Document(collection = "customer")
public class Customer {
    @Id
    private int id;
    private String firstName;
    private String lastName;
    private List<Address> address = new ArrayList<>();

    private Date date = new Date();

    public Customer() {

    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Customer(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public static void main(String[] args) throws JsonProcessingException {

        Customer customer = new Customer();
        customer.firstName = "Riya";
        customer.setFirstName("Riya");
        //customer.lastName = "Liz"
        customer.setLastName("Liz");
        customer.getFirstName();
        customer.getLastName();
        Customer customer1 = new Customer("Riya", "Liz");
        Address address1 = new Address("1603 florida dr", "","Everett", 98203);
        //customer1.setAddress(address1);
        String input = "{\n" +
                "  \"firstName\" : \"Akhil\",\n" +
                "  \"lastName\" : \"Sunny\",\n" +
                "  \"address\"  : [\n" +
                "    {\n" +
                "      \"line1\" : \"1603 Florida Dr\",\n" +
                "      \"line2\" : \"\",\n" +
                "      \"city\" : \"Everett\",\n" +
                "      \"zip\"  : 98203\n" +
                "    }\n" +
                "  ]\n" +
                "}";

        ObjectMapper objectMapper = new ObjectMapper();
        Customer customer3 = objectMapper.readValue(input, Customer.class);
        System.out.println();
    }

}
