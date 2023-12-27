package com.learn.electricitybillmanagent.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter

@Document(collection = "Bill_Management")
public class Customerdb {
    @Id
    private String firstName;
    private String lastName;
    private List<Address> address = new ArrayList<>();
    public Customerdb() {

    }

    public void setFirstName(String name) {
        this.firstName = name;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public Customerdb(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
