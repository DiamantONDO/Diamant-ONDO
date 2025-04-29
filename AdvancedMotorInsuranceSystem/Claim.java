package AdvancedMotorInsuranceSystem;

import java.time.LocalDate;

public class Claim {
    private String claimId;
    private double claimAmount;
    private LocalDate claimDate;
    private String claimStatus;

    public Claim(String claimId, double claimAmount, LocalDate claimDate) {
        this.claimId = claimId;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.claimStatus = "Pending";
    }

    public void approveClaim() {
        this.claimStatus = "Approved";
    }

    public void rejectClaim() {
        this.claimStatus = "Rejected";
    }

    public String getClaimStatus() { return claimStatus; }
    public double getClaimAmount() { return claimAmount; }
}
