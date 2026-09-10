package com.loan.system.service;

import com.loan.system.model.Customer;
import com.loan.system.model.LoanApplication;

public class CreditAssessment {

    private static final int MIN_AGE = 21;
    private static final double MIN_INCOME = 2000.00;
    private static final int MIN_CREDIT_SCORE = 600;
    private static final int EXCELLENT_CREDIT_SCORE = 750;
    private static final double MAX_DTI_RATIO = 0.40; 
    private static final double CONSERVATIVE_DTI = 0.25;

    public void evaluateApplication(LoanApplication application) {
        Customer customer = application.getCustomer();
        
        if (customer.getGovernmentId() == null || customer.getGovernmentId().trim().isEmpty()) {
            throw new IllegalArgumentException("Government identification number is required.");
        }
        if (application.getRequestedAmount() <= 0) {
            throw new IllegalArgumentException("Loan amount must be greater than zero.");
        }

        double maxPermissibleLoan = customer.getMonthlyIncome() * 5; 
        double dtiRatio = customer.getMonthlyIncome() > 0 ? (customer.getExistingObligations() / customer.getMonthlyIncome()) : 1.0;

        System.out.println("Maximum permissible loan ceiling amount: $" + maxPermissibleLoan);

        if (customer.getAge() < MIN_AGE) {
            application.addRejectionReason("Customer must be at least " + MIN_AGE + " years old.");
        }
        if (customer.getMonthlyIncome() < MIN_INCOME) {
            application.addRejectionReason("Customer must satisfy a minimum monthly income threshold.");
        }
        if (application.getRequestedAmount() > maxPermissibleLoan) {
            application.addRejectionReason("Requested loan amount must not exceed a specified income-dependent limit.");
        }
        if (customer.getCreditScore() < MIN_CREDIT_SCORE) {
            application.addRejectionReason("Customer's credit score must satisfy the minimum requirement.");
        }
        if (dtiRatio > MAX_DTI_RATIO) {
            application.addRejectionReason("Debt-to-income ratio (DTI) exceeds maximum permissible limits.");
        }

        if (!application.getRejectionReasons().isEmpty()) {
            application.setStatus("Rejected");
            application.setRiskClassification("High Risk/Rejected");
        } else {
            application.setStatus("Approved");
            if (customer.getCreditScore() >= EXCELLENT_CREDIT_SCORE && dtiRatio <= CONSERVATIVE_DTI) {
                application.setRiskClassification("Low Risk");
            } else {
                application.setRiskClassification("Medium Risk");
            }
        }
    }
}
