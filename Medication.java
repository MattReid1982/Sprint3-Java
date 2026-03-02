import java.time.LocalDate;
import java.util.Random;

//  Medications available in the system.
//  Carries information about dosing, stock levels, and expiry.
public class Medication {
    // unique identifier for the medication
    private int id;
    
    // medication name (e.g., "Ibuprofen")
    private String name;
    
    // standard dose notation (e.g., "200mg")
    private String dose;
    
    // current quantity available in inventory
    private int quantityInStock;
    
    // date after which this medication should not be used
    private LocalDate expiryDate;


    //  Construct a new medication entry with basic details and a randomly
    //  generated expiry within the next year.
    public Medication(int id, String name, String dose, int quantityInStock) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomDate();
    }

    
    //  Helper to create a pseudo-random expiry date within the next year.
    //  This simulates a real-world expiration for testing/demo purposes.
    private LocalDate generateRandomDate() {
        Random random = new Random();
        return LocalDate.now().plusDays(random.nextInt(365)); // Random date within the next year
    }

    
    // Return true if the medication's expiry date has passed
    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    
    // Increase inventory by the specified amount.
    // Params amount number of units to add
    public void restock(int amount) {
        this.quantityInStock += amount;
    }

    // accessors for other classes
    public int getQuantityInStock() {
        return quantityInStock;
    }

    public void setQuantityInStock(int quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    // accessors for other classes
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Medication: " + name + ", Dose: " + dose + " | Stock: " + quantityInStock;
    }
}

