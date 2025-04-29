package AdvancedMotorInsuranceSystem;

import java.time.LocalDate;

public class CollisionPolicy extends InsurancePolicy {

    public CollisionPolicy(String policyId, Vehicle vehicle, Person policyHolder,
                           double coverageAmount, LocalDate start, LocalDate end) {
        super(policyId, vehicle, policyHolder, coverageAmount, start, end);
    }

    @Override
    public void calculatePremium() {
        this.premiumAmount = coverageAmount * 0.05; // Premium based on coverage amount
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
        // Require vehicle safety check before approval
        System.out.println("Safety check required for policy validation.");
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("==== Collision Policy Report ====");
        System.out.println("Policy ID: " + policyId);
        System.out.println("Holder: " + policyHolder.getFullName());
        System.out.println("Premium: $" + premiumAmount);
        System.out.println("Coverage: $" + coverageAmount);
        System.out.println("Valid: " + policyStartDate + " to " + policyEndDate);
    }
}
