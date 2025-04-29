package AdvancedMotorInsuranceSystem;

import java.time.LocalDate;

public class Person {
    private String personId;
    private String fullName;
    private LocalDate dob;
    private String email;
    private String phone;

    public Person(String personId, String fullName, LocalDate dob, String email, String phone) {
        this.personId = personId;
        this.fullName = fullName;
        this.dob = dob;
        this.email = email;
        this.phone = phone;
    }

    // Getters
    public String getFullName() { return fullName; }
}
