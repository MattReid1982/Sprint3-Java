public class Main {
    public static void main(String[] args){
        System.out.println("=== Starting System Tests ===");

        MedicationSystem system = new MedicationSystem();

        // Now set up the test data
        Doctor d1 = new Doctor(1, "Dr. Kieley", 50, "555-1234", "General Practitioner");
        Doctor d2 = new Doctor(2, "Dr. Powell", 65, "555-4321", "Cardiology");

        Patient p1 = new Patient(1, "Alicia Reid", 41, "555-5555");
        Patient p2 = new Patient(2, "Kayleigh Reid", 13, "555-6666");

        Medication m1 = new Medication(1, "Asparin", "200mg", 20); 
        Medication m2 = new Medication(2, "Ibuprofen", "400mg", 15);
        
        // Adding Data
        System.out.println("\n=== TEST 1: ADDING DATA ===");

        system.addDoctor(d1);
        system.addDoctor(d2);
        system.addPatient(p1);
        system.addPatient(p2);
        system.addMedication(m1);
        system.addMedication(m2);

        system.generateReport(); // Should show all doctors, patients, and medications added to the system

        // Editing Data
        System.out.println("\n=== TEST 2: EDITING PATIENT ===");

        p1.setName("Alicia Updated"); // Update the patient's name
        
        system.searchPatientByName("Alicia Updated"); // Should find the patient with the updated name


        // Search Function
        System.out.println("\n=== TEST 3: SEARCH FUNCTION ===");
        
        system.searchDoctorByName("Dr. Powell"); // Should find Dr. Powell
        
        system.searchMedicationByName("Ibuprofen"); // Should find Ibuprofen and show its details

        // Accept Prescription
        System.out.println("\n=== TEST 4: ACCEPT PRESCRIPTION ===");

        Prescription prescription = new Prescription(1, d2, p2, m2); // Dr. Powell prescribes Ibuprofen to Kayleigh Reid
        
        system.acceptPrescription(prescription); // Should add the prescription to the system and associate it with the patient and doctor

        system.generateReport(); // Should show the new prescription under Kayleigh Reid and Dr. Powell

        // Add Patient to Doctor
        System.out.println("\n=== TEST 5: ADD PATIENT TO DOCTOR ===");
        
        d1.addPatient(p1); // Dr. Kieley manages Alicia Reid
        
        d1.addPatient(p2); // Dr. Kieley also manages Kayleigh Reid

        for (Patient p : d1.getPatients()) {
            System.out.println("Doctor manages: " + p.getName()); // Should show both Alicia Reid and Kayleigh Reid as patients of Dr. Kieley
        }

        // Full system report
        System.out.println("\n=== TEST 6: FULL REPORT ==="); // Should show all doctors, patients, medications, and prescriptions in a comprehensive report
        
        system.generateReport();

        // Check for expired medications
        System.out.println("\n=== TEST 7: CHECK EXPIRED MEDICATIONS ==="); // Should check all medications and report any that are expired
        
        system.checkExpiredMedications(); // Should show if any medications are expired based on their randomly generated expiry dates

        // Prescription by Doctor
        System.out.println("\n=== TEST 8: PRESCRIPTIONS BY DOCTOR ===");
        
        system.getPrescriptionsByDoctor(d2); // Should show all prescriptions made by Dr. Powell, which should include the prescription for Kayleigh Reid

        // Past year prescriptions summary
        System.out.println("\n=== TEST 9: PAST YEAR PRESCRIPTIONS SUMMARY ===");
        
        system.getPastYearPrescriptionsSummary(); // Should show a summary of all prescriptions made in the past year, which should include the prescription for Kayleigh Reid if it was created within the last year

        // Restock medication
        System.out.println("\n=== TEST 10: RESTOCK MEDICATION ===");
        
        system.restockAllMedications(); // Should restock all medications in the system by a certain amount (e.g., 10 units each)

        system.generateReport(); // Quantity should increase for all medications

        // Delete test
        System.out.println("\n=== TEST 11: DELETE PATIENT ===");

        system.deletePatient(p2.getId()); // Should remove Kayleigh Reid from the system

        system.generateReport(); // Should no longer show Kayleigh Reid in the patient list

        System.out.println("\n=== All Tests Completed ===");

    }
}
