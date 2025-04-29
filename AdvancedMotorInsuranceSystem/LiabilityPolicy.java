package AdvancedMotorInsuranceSystem;

import java.time.LocalDate;

public class LiabilityPolicy extends InsurancePolicy {

    public LiabilityPolicy(String policyId, Vehicle vehicle, Person policyHolder,
                           double coverageAmount, LocalDate start, LocalDate end) {
        super(policyId, vehicle, policyHolder, coverageAmount, start, end);
    }

    @Override
    public void calculatePremium() {
        this.premiumAmount = coverageAmount * 0.01; // Premium calculation based on coverage
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
        System.out.println("Medical checkup required for policyholder.");
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("==== Liability Policy Report ====");
        System.out.println("Policy ID: " + policyId);
        System.out.println("Holder: " + policyHolder.getFullName());
        System.out.println("Premium: $" + premiumAmount);
        System.out.println("Coverage: $" + coverageAmount);
        System.out.println("Valid: " + policyStartDate + " to " + policyEndDate);
    }
}
