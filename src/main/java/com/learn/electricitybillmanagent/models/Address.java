package com.learn.electricitybillmanagent.models;

import lombok.Getter;

@Getter
public class Address {

    private String line1;
    private String line2;

    public Address() {
    }

    private String city;
    private int zip;


    public Address(String street1, String street2, String city, int zipcode) {
        line1 = street1;
        line2 = street2;
        this.city = city;
        this.zip = zipcode;
    }
}
