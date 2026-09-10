package com.loan.system.service;

import com.loan.system.model.Customer;
import com.loan.system.model.LoanApplication;

public class CreditAssessmentTest {

    private final CreditAssessment assessmentEngine = new CreditAssessment();

    public static void main(String[] args) {
        CreditAssessmentTest testRunner = new CreditAssessmentTest();
        System.out.println("=== STARTING SMART LOAN SYSTEM LOCAL VERIFICATION ===");
        
        testRunner.testExactBoundaryLimitsApproval();
        testRunner.testMultipleRejectionReasons();
        
        System.out.println("\n=== ALL SYSTEM TESTS PASSED SUCCESSFULLY ===");
    }

    public void testExactBoundaryLimitsApproval() {
        Customer edgeCustomer = new Customer("Boundary Check", 21, "GOV-7711", 2000.00, 800.00, 600);
        LoanApplication app = new LoanApplication(edgeCustomer, 10000.00); 

        assessmentEngine.evaluateApplication(app);

        if (!"Approved".equals(app.getStatus())) throw new RuntimeException("Test Failed: Expected Approved status");
        if (!"Medium Risk".equals(app.getRiskClassification())) throw new RuntimeException("Test Failed: Expected Medium Risk tier");
        if (!app.getRejectionReasons().isEmpty()) throw new RuntimeException("Test Failed: Reasons list should be empty");
        
        System.out.println("[PASS] testExactBoundaryLimitsApproval completed without errors.");
    }

    public void testMultipleRejectionReasons() {
        Customer failedCustomer = new Customer("Failed Account", 19, "GOV-0000", 2500.00, 200.00, 500);
        LoanApplication app = new LoanApplication(failedCustomer, 90000.00);

        assessmentEngine.evaluateApplication(app);

        if (!"Rejected".equals(app.getStatus())) throw new RuntimeException("Test Failed: Expected Rejected status");
        if (!"High Risk/Rejected".equals(app.getRiskClassification())) throw new RuntimeException("Test Failed: Expected High Risk tier");
        if (app.getRejectionReasons().size() < 2) throw new RuntimeException("Test Failed: Expected multiple rejection trackers");
        
        System.out.println("[PASS] testMultipleRejectionReasons tracking validation verified successfully.");
        
        System.out.println("\n>>> FINAL OUTPUT FOR APPLICATION 2 <<<");
        System.out.println("Final Application Status: " + app.getStatus());
        System.out.println("Risk Tier Classification: " + app.getRiskClassification());
        System.out.println("List of System Rejection Reasons:");
        for (String reason : app.getRejectionReasons()) {
            System.out.println(" - " + reason);
        }
    }
}
