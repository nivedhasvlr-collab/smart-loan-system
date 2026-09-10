package com.loan.system.model;

import java.util.ArrayList;
import java.util.List;

public class LoanApplication {
    private Customer customer;
    private double requestedAmount;
    private String status;               // "Approved" or "Rejected"
    private String riskClassification;   // "Low Risk", "Medium Risk", "High Risk/Rejected"
    private List<String> rejectionReasons;

    public LoanApplication(Customer customer, double requestedAmount) {
        this.customer = customer;
        this.requestedAmount = requestedAmount;
        this.status = "Pending";
        this.riskClassification = "Pending Assessment";
        this.rejectionReasons = new ArrayList<>();
    }

    public void addRejectionReason(String reason) {
        this.rejectionReasons.add(reason);
    }

    public Customer getCustomer() { return customer; }
    public double getRequestedAmount() { return requestedAmount; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public String getRiskClassification() { return riskClassification; }
    public void setRiskClassification(String riskClassification) { this.riskClassification = riskClassification; }
    public List<String> getRejectionReasons() { return rejectionReasons; }
}
