package AdvancedMotorInsuranceSystem;

import java.time.LocalDate;

public class RoadsideAssistancePolicy extends InsurancePolicy {

    public RoadsideAssistancePolicy(String policyId, Vehicle vehicle, Person policyHolder,
                                    double coverageAmount, LocalDate start, LocalDate end) {
        super(policyId, vehicle, policyHolder, coverageAmount, start, end);
    }

    @Override
    public void calculatePremium() {
        this.premiumAmount = coverageAmount * 0.02; // Premium calculation based on coverage amount
    }

    @Override
    public void processClaim(double claimAmount) {
        if (claimAmount > coverageAmount) {
            System.out.println("Claim denied. Amount exceeds coverage.");
        } else {
            System.out.println("Claim approved for amount: $" + claimAmount);
        }
    }

    @Override
    public void validatePolicy() {
        // Verify registration and inspection for roadside assistance coverage
        System.out.println("Verification of vehicle registration and inspection is required.");
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("==== Roadside Assistance Policy Report ====");
        System.out.println("Policy ID: " + policyId);
        System.out.println("Holder: " + policyHolder.getFullName());
        System.out.println("Premium: $" + premiumAmount);
        System.out.println("Coverage: $" + coverageAmount);
        System.out.println("Valid: " + policyStartDate + " to " + policyEndDate);
    }
}
