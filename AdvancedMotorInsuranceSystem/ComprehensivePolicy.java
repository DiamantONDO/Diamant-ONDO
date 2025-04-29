package AdvancedMotorInsuranceSystem;

import java.time.LocalDate;

public class ComprehensivePolicy extends InsurancePolicy {

    public ComprehensivePolicy(String policyId, Vehicle vehicle, Person policyHolder,
                               double coverageAmount, LocalDate start, LocalDate end) {
        super(policyId, vehicle, policyHolder, coverageAmount, start, end);
    }

    @Override
    public void calculatePremium() {
        int vehicleAge = LocalDate.now().getYear() - vehicle.getVehicleYear();
        this.premiumAmount = coverageAmount * (0.03 + (vehicleAge * 0.01)); // Sample formula
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
        if (vehicle.getVehicleType() == null || vehicle.getVehicleYear() < 2000) {
            throw new IllegalArgumentException("Vehicle not eligible for comprehensive policy.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("==== Comprehensive Policy Report ====");
        System.out.println("Policy ID: " + policyId);
        System.out.println("Holder: " + policyHolder.getFullName());
        System.out.println("Premium: $" + premiumAmount);
        System.out.println("Coverage: $" + coverageAmount);
        System.out.println("Valid: " + policyStartDate + " to " + policyEndDate);
    }
}
