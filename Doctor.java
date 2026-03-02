import java.util.ArrayList;
import java.util.List;


// Represents a medical doctor in the system.
// A doctor has a specialization and manages a list of patients.
// Inherits common person attributes (id, name, age, phone) from Person.

public class Doctor extends Person {
    // The medical specialty of this doctor (e.g., "Cardiology").
    private String specialization;
    // Patients currently assigned to this doctor.
    private List<Patient> patients = new ArrayList<>();

     
    // Create a new Doctor with identifying information and a specialty.
    // Param id unique identifier
    // Param name full name
    // Param age doctor's age
    // Param phoneNumber contact number
    // Param specialization medical field of expertise
    
    public Doctor(int id, String name, int age, String phoneNumber, String specialization) {
        super(id, name, age, phoneNumber);
        this.specialization = specialization;
        this.patients = new ArrayList<>(); 
    }

    
    // Assigns a patient to this doctor's care.
    // Param patient patient to add
    
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

    
    // Returns an unmodifiable view of the doctor's patients list.
    public List<Patient> getPatients() {
        return patients;
    }

    @Override
    public String toString() {
        // Provide a concise representation for printing/logging
        return "Doctor: " + name + ", Specialization: " + specialization;
    } 
    
}
