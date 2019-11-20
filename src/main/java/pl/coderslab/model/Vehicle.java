package pl.coderslab.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Vehicle {

    private int id;
    private String model;
    private String brand;
    private int yearOfProduction;
    private String registrationNumber;
    private Date nextService;
    private int customerId;

    public Vehicle() {
    }

    public Vehicle(String model, String brand, int yearOfProduction, String registrationNumber, Date nextService, int customerId) {
        this.model = model;
        this.brand = brand;
        this.yearOfProduction = yearOfProduction;
        this.registrationNumber = registrationNumber;
        this.nextService = nextService;
        this.customerId = customerId;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(int yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public Date getNextService() {
        return nextService;
    }

    public void setNextService(Date nextService) {
        this.nextService = nextService;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }
}
