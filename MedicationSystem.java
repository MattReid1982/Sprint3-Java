// Controller class for the medication system
import java.util.*;

public class MedicationSystem {
    private List<Doctor> doctors = new ArrayList<>();
    private List<Patient> patients = new ArrayList<>();
    private List<Medication> medications = new ArrayList<>();
    private List<Prescription> prescriptions = new ArrayList<>();
    
    // Search methods for doctors, patients, medications, and prescriptions
    public void searchPatientByName(String name) {
        for (Patient p : patients) {
            if (p.getName().equalsIgnoreCase(name)) {
                System.out.println(p);
            }
        }
    }

    public void searchDoctorByName(String name) {
        for (Medication m : medications) {
            if (m.isExpired()) {
                System.out.println("Expired: " + m.getName());
            }
        }
    }

    public void restockMedication(int medId, int amount) {
        for (Medication m : medications) {
            if (m.getId() == medId) {
                m.restock(amount);
                break;
            }
        }
    }
    
}
