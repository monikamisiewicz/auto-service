package pl.coderslab.model;

import java.sql.Date;
import java.sql.Timestamp;

public class Order {

    private int id;
    private Date repairAcceptanceDate;
    private Date plannedRepairStart;
    private Date repairStart;
    private String problemDescription;
    private String repairDescription;
    private double customerCost;
    private double sparepartsCost;
    private double manHourCost;
    private int manHourAmount;
    private int customerId;
    private int employeeId;
    private int vehicleId;
    private int statusId;

    public Order() {
    }

    public Order(Date repairAcceptanceDate, Date plannedRepairStart, Date repairStart, String problemDescription, String repairDescription, double customerCost, double sparepartsCost, double manHourCost, int manHourAmount, int customerId, int employeeId, int vehicleId, int statusId) {
        this.repairAcceptanceDate = repairAcceptanceDate;
        this.plannedRepairStart = plannedRepairStart;
        this.repairStart = repairStart;
        this.problemDescription = problemDescription;
        this.repairDescription = repairDescription;
        this.customerCost = customerCost;
        this.sparepartsCost = sparepartsCost;
        this.manHourCost = manHourCost;
        this.manHourAmount = manHourAmount;
        this.customerId = customerId;
        this.employeeId = employeeId;
        this.vehicleId = vehicleId;
        this.statusId = statusId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getRepairAcceptanceDate() {
        return repairAcceptanceDate;
    }

    public void setRepairAcceptanceDate(Date repairAcceptanceDate) {
        this.repairAcceptanceDate = repairAcceptanceDate;
    }

    public Date getPlannedRepairStart() {
        return plannedRepairStart;
    }

    public void setPlannedRepairStart(Date plannedRepairStart) {
        this.plannedRepairStart = plannedRepairStart;
    }

    public Date getRepairStart() {
        return repairStart;
    }

    public void setRepairStart(Date repairStart) {
        this.repairStart = repairStart;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public void setProblemDescription(String problemDescription) {
        this.problemDescription = problemDescription;
    }

    public String getRepairDescription() {
        return repairDescription;
    }

    public void setRepairDescription(String repairDescription) {
        this.repairDescription = repairDescription;
    }

    public double getCustomerCost() {
        return customerCost;
    }

    public void setCustomerCost(double customerCost) {
        this.customerCost = customerCost;
    }

    public double getSparepartsCost() {
        return sparepartsCost;
    }

    public void setSparepartsCost(double sparepartsCost) {
        this.sparepartsCost = sparepartsCost;
    }

    public double getManHourCost() {
        return manHourCost;
    }

    public void setManHourCost(double manHourCost) {
        this.manHourCost = manHourCost;
    }

    public int getManHourAmount() {
        return manHourAmount;
    }

    public void setManHourAmount(int manHourAmount) {
        this.manHourAmount = manHourAmount;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getStatusId() {
        return statusId;
    }

    public void setStatusId(int statusId) {
        this.statusId = statusId;
    }
}
