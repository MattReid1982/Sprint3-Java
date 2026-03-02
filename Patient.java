import java.util.ArrayList;
import java.util.List;
public class Patient extends Person {
    private List<Prescription> prescriptions;
    private List<Medication> medications;

    public Patient(int id, String name, int age, String phone) {
        super(id, name, age, phone);
        this.prescriptions = new ArrayList<>();
        this.medications = new ArrayList<>();
    }

    public void addPrescription(Prescription prescription) {
        prescriptions.add(prescription);
    }

    public List<Prescription> getPrescriptions() {
        return prescriptions;
    }

    @Override
    public String toString() {
        return "Patient: " + name + " | Age: " + age + " | Phone: " + phoneNumber;
    }
}
