package AdvancedMotorInsuranceSystem;

import java.time.LocalDate;

public class ThirdPartyPolicy extends InsurancePolicy {

    public ThirdPartyPolicy(String policyId, Vehicle vehicle, Person policyHolder,
                            double coverageAmount, LocalDate start, LocalDate end) {
        super(policyId, vehicle, policyHolder, coverageAmount, start, end);
    }

    @Override
    public void calculatePremium() {
        this.premiumAmount = coverageAmount * 0.02; // Sample premium calculation based on coverage
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
        if (!vehicle.getVehicleType().equalsIgnoreCase("Car") && !vehicle.getVehicleType().equalsIgnoreCase("Motorbike")) {
            throw new IllegalArgumentException("Third-party coverage only available for Cars or Motorbikes.");
        }
    }

    @Override
    public void generatePolicyReport() {
        System.out.println("==== Third-Party Policy Report ====");
        System.out.println("Policy ID: " + policyId);
        System.out.println("Holder: " + policyHolder.getFullName());
        System.out.println("Premium: $" + premiumAmount);
        System.out.println("Coverage: $" + coverageAmount);
        System.out.println("Valid: " + policyStartDate + " to " + policyEndDate);
    }
}
