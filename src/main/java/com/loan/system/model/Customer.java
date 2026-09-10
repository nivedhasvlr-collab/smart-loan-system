package com.loan.system.model;

public class Customer {
    private String name;
    private int age;
    private String governmentId;
    private double monthlyIncome;
    private double existingObligations;
    private int creditScore;

    public Customer(String name, int age, String governmentId, double monthlyIncome, double existingObligations, int creditScore) {
        this.name = name;
        this.age = age;
        this.governmentId = governmentId;
        this.monthlyIncome = monthlyIncome;
        this.existingObligations = existingObligations;
        this.creditScore = creditScore;
    }

    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGovernmentId() { return governmentId; }
    public double getMonthlyIncome() { return monthlyIncome; }
    public double getExistingObligations() { return existingObligations; }
    public int getCreditScore() { return creditScore; }
}
