// Controller class for the medication system
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;

public class MedicationSystem {
    
    private List<Doctor> doctors = new ArrayList<>(); // List to store doctors
    
    private List<Patient> patients = new ArrayList<>(); // List to store patients
    
    private List<Medication> medications = new ArrayList<>(); // List to store medications
    
    private List<Prescription> prescriptions = new ArrayList<>(); // List to store prescriptions

    // Add Methods
    public void addDoctor(Doctor doctor) {
        doctors.add(doctor); // Add doctor to the system
    }

    public void addPatient(Patient patient) {
        patients.add(patient); // Add patient to the system
    }

    public void addMedication(Medication medication) {
        medications.add(medication); // Add medication to the system
    }

    // Delete Methods
    public void deletePatient(int patientId) {
        patients.removeIf(patient -> patient.getId() == patientId); // Remove patient by ID
    }

    // Search Methods
    public void searchDoctorByName(String name) {
        for (Doctor doctor : doctors) {
            if (doctor.getName().equalsIgnoreCase(name)) {
                System.out.println(doctor); // Print doctor details if name matches
            }
        }
    }

    public void searchPatientByName(String name) {
        for (Patient patient : patients) {
            if (patient.getName().equalsIgnoreCase(name)) {
                System.out.println(patient); // Print patient details if name matches
            }
        }
    }

    public void searchMedicationByName(String name) {
        for (Medication medication : medications) {
            if (medication.getName().equalsIgnoreCase(name)) {
                System.out.println(medication); // Print medication details if name matches
            }
        }
    }

    // Prescriptions

    public void acceptPrescription(Prescription prescription) {
        prescriptions.add(prescription); // Add prescription to the system
        prescription.getPatient().addPrescription(prescription); // Associate prescription with patient
        prescription.getDoctor().addPatient(prescription.getPatient()); // Associate patient with doctor
    }

    public void generateReport() {
        System.out.println("\n--- Doctors ---");
        for (Doctor d : doctors) {
            System.out.println(d);
        }

        System.out.println("\n--- Patients ---");
        for (Patient p : patients) {
            System.out.println(p);
        }

        System.out.println("\n--- Medications ---");
        for (Medication m : medications) {
            System.out.println(m);
        }

        System.out.println("\n--- Prescriptions ---");
        for (Prescription p : prescriptions) {
            System.out.println(p);
        }
    }

    public void checkExpiredMedications() {
        for (Medication m : medications) {
            if (m.isExpired()) {
                System.out.println("Expired: " + m);
            }
        }
    }

    public void getPrescriptionsByDoctor(Doctor doctor) {
        for (Prescription pr : prescriptions) {
            if (pr.getDoctor().equals(doctor)) {
                System.out.println(pr);
            }
        }
    }

    public void restockAllMedications() {
        for (Medication m : medications) {
            m.restock(10);
        }
    }

    // Overload to accept Patient object (Main calls deletePatient(p2))
    public void deletePatient(Patient patient) {
        if (patient == null) return;
        patients.removeIf(p -> p.getId() == patient.getId());
        // remove prescriptions for that patient
        prescriptions.removeIf(pr -> pr.getPatient().getId() == patient.getId());
        // remove patient from any doctor's patient lists
        for (Doctor d : doctors) {
            d.getPatients().removeIf(p -> p.getId() == patient.getId());
        }
    }

    public void getPastYearPrescriptionsSummary() {
        java.time.LocalDate oneYearAgo = java.time.LocalDate.now().minusYears(1);
        int count = 0;
        for (Prescription pr : prescriptions) {
            if (pr.getIssueDate() != null && pr.getIssueDate().isAfter(oneYearAgo)) {
                count++;
            }
        }
        System.out.println("Prescriptions in past year: " + count);
    }

    
}
