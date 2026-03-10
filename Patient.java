import java.util.ArrayList;
import java.util.List;

// A patient of the medical system. Extends Person and keeps track of
// prescriptions and medications associated with the patient.  

public class Patient extends Person {
    // prescriptions the patient has been issued
    private List<Prescription> prescriptions;
    
    // medications currently assigned/held by the patient
    private List<Medication> medications;

    // Creates a new patient with basic identifying information.
    public Patient(int id, String name, int age, String phone) {
        super(id, name, age, phone);
        this.prescriptions = new ArrayList<>();
        this.medications = new ArrayList<>();
    }

    // Add a prescription record to the patient's history.
    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    // Add Medication
    public void addMedication(Medication medication) {
        medications.add(medication);
    }

    // Remove Medication
    public void removeMedication(Medication medication) {
        medications.remove(medication);
    }

    // Get Medications
    public List<Medication> getMedications() {
        return medications;
    }

    // Retrieve the list of prescriptions for this patient.
    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    @Override
    public String toString() {
        // Concise representation for logging/reporting
        return "Patient: " + name + " | Age: " + age + " | Phone: " + phoneNumber;
    }
}
