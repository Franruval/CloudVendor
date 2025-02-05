package com.ruvalcaba.restapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "cloud_vendor_info")
public class CloudVendor {

    @Id
    private Integer id;
    private String name;
    private String address;
    private String phoneNumber;

    public CloudVendor() {
    }

    public CloudVendor(Integer id, String phoneNumber, String address, String name) {
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.name = name;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
}
