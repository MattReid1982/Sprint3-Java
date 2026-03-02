import java.time.LocalDate;
public class Prescription {
    private int id;
    private Doctor doctor;
    private Patient patient;
    private Medication medication;
    private LocalDate issueDate;
    private LocalDate expiryDate;

    public Prescription(int id, Doctor doctor, Patient patient, Medication medication) {
        this.id = id;
        this.doctor = doctor;
        this.patient = patient;
        this.medication = medication;
        this.issueDate = LocalDate.now();
        this.expiryDate = issueDate.plusYears(1); //Prescriptions are valid for 1 year.
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    // Getters used by MedicationSystem and other classes
    public int getId() {
        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Patient getPatient() {
        return patient;
    }

    public Medication getMedication() {
        return medication;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    @Override
    public String toString() {
        return "Prescription: " + id + " | Doctor: " + doctor.getName() + " | Patient: " + patient.getName() + " | Medication: " + medication.getName();
    }
}
