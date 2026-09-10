package com.loan.system.service;

import com.loan.system.model.Customer;
import com.loan.system.model.LoanApplication;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CreditAssessmentTest {

    private final CreditAssessment assessmentEngine = new CreditAssessment();

    @Test
    public void testExactBoundaryLimitsApproval() {
        Customer edgeCustomer = new Customer("Boundary Check", 21, "GOV-7711", 2000.00, 800.00, 600);
        LoanApplication app = new LoanApplication(edgeCustomer, 10000.00); 

        assessmentEngine.evaluateApplication(app);

        assertEquals("Approved", app.getStatus(), "Test Failed: Expected Approved status");
        assertEquals("Medium Risk", app.getRiskClassification(), "Test Failed: Expected Medium Risk tier");
        assertTrue(app.getRejectionReasons().isEmpty(), "Test Failed: Reasons list should be empty");
    }

    @Test
    public void testMultipleRejectionReasons() {
        Customer failedCustomer = new Customer("Failed Account", 19, "GOV-0000", 2500.00, 200.00, 500);
        LoanApplication app = new LoanApplication(failedCustomer, 90000.00);

        assessmentEngine.evaluateApplication(app);

        assertEquals("Rejected", app.getStatus(), "Test Failed: Expected Rejected status");
        assertEquals("High Risk/Rejected", app.getRiskClassification(), "Test Failed: Expected High Risk tier");
        assertTrue(app.getRejectionReasons().size() >= 2, "Test Failed: Expected multiple rejection trackers");
    }
}
