import java.time.LocalDate;

// Represents a prescription issued by a doctor to a patient for a specific
// medication. Tracks issue and expiry dates.

public class Prescription {
    // unique identifier for the prescription
    private int id;
    
    // prescribing doctor
    private Doctor doctor;
    
    // patient who receives the medication
    private Patient patient;
    
    // medication being prescribed
    private Medication medication;
    
    // date the prescription was created
    private LocalDate issueDate;
    
    // date after which the prescription is no longer valid
    private LocalDate expiryDate;

    // Create a prescription date and create a one year expiry date on it
    public Prescription(int id, Doctor doctor, Patient patient, Medication medication) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.issueDate = LocalDate.now();
        this.expiryDate = issueDate.plusYears(1); //Prescriptions are valid for 1 year.
    }

    // Determine if the medication is passed it's expiry date
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    // Getters used by MedicationSystem and other classes
    // Return a unique identifier
    public int getId() {
        return id;
    }

    // Return the doctor who issued this prescription
    public Doctor getDoctor() {
        return doctor;
    }

    // Return the patient for whom this prescription was written
    public Patient getPatient() {
        return patient;
    }

    // Return the medication being prescribed
    public Medication getMedication() {
        return medication;
    }

    // Return the date the prescription was issued
    public LocalDate getIssueDate() {
        return issueDate;
    }

    @Override
    public String toString() {
        // simple representation for printing
        return "Prescription: " + id + " | Doctor: " + doctor.getName() + " | Patient: " + patient.getName() + " | Medication: " + medication.getName();
    }
}
