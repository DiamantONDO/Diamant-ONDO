package AdvancedMotorInsuranceSystem;

import java.time.LocalDate;
import java.util.Scanner;

public class MainInsuranceSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create Vehicle
        System.out.print("Enter vehicle ID: ");
        String vehicleId = scanner.nextLine();

        System.out.print("Enter vehicle make: ");
        String vehicleMake = scanner.nextLine();

        System.out.print("Enter vehicle model: ");
        String vehicleModel = scanner.nextLine();

        System.out.print("Enter vehicle year: ");
        int vehicleYear = scanner.nextInt();
        scanner.nextLine(); // consume newline

        System.out.print("Enter vehicle type: ");
        String vehicleType = scanner.nextLine();

        Vehicle vehicle = new Vehicle(vehicleId, vehicleMake, vehicleModel, vehicleYear, vehicleType);

        // Create Person (Policyholder)
        System.out.print("Enter policyholder ID: ");
        String personId = scanner.nextLine();

        System.out.print("Enter policyholder name: ");
        String fullName = scanner.nextLine();

        System.out.print("Enter policyholder DOB (YYYY-MM-DD): ");
        LocalDate dob = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter policyholder email: ");
        String email = scanner.nextLine();

        System.out.print("Enter policyholder phone: ");
        String phone = scanner.nextLine();

        Person person = new Person(personId, fullName, dob, email, phone);

        // Create Policy
        System.out.print("Enter policy ID: ");
        String policyId = scanner.nextLine();

        System.out.print("Enter coverage amount: ");
        double coverageAmount = scanner.nextDouble();
        scanner.nextLine(); // consume newline

        System.out.print("Enter start date (YYYY-MM-DD): ");
        LocalDate startDate = LocalDate.parse(scanner.nextLine());

        System.out.print("Enter end date (YYYY-MM-DD): ");
        LocalDate endDate = LocalDate.parse(scanner.nextLine());

        // Choose policy type
        System.out.println("Choose policy type: 1. Comprehensive, 2. Third-Party, 3. Collision, 4. Liability, 5. Roadside Assistance");
        int choice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        InsurancePolicy policy = null;

        switch (choice) {
            case 1:
                policy = new ComprehensivePolicy(policyId, vehicle, person, coverageAmount, startDate, endDate);
                break;
            case 2:
                policy = new ThirdPartyPolicy(policyId, vehicle, person, coverageAmount, startDate, endDate);
                break;
            case 3:
                policy = new CollisionPolicy(policyId, vehicle, person, coverageAmount, startDate, endDate);
                break;
            case 4:
                policy = new LiabilityPolicy(policyId, vehicle, person, coverageAmount, startDate, endDate);
                break;
            case 5:
                policy = new RoadsideAssistancePolicy(policyId, vehicle, person, coverageAmount, startDate, endDate);
                break;
            default:
                System.out.println("Invalid choice");
                break;
        }

        // Calculate Premium, validate policy, and generate report
        if (policy != null) {
            policy.calculatePremium();
            policy.validatePolicy();
            policy.generatePolicyReport();
        }
    }
}
