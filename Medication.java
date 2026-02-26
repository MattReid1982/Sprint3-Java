import java.time.LocalDate;
import java.util.Random;
public class Medication {
    private int id;
    private String name;
    private String dose;
    private int quantityInStock;
    private LocalDate expiryDate;

    public Medication(int id, String name, String dose, int quantityInStock) {
        this.id = id;
        this.name = name;
        this.dose = dose;
        this.quantityInStock = quantityInStock;
        this.expiryDate = generateRandomDate();
    }

    private LocalDate generateRandomDate() {
        Random random = new Random();
        return LocalDate.now().plusDays(random.nextInt(365)); // Random date within the next year
    }

    public boolean isExpired() {
        return expiryDate.isBefore(LocalDate.now());
    }

    public void restock(int amount) {
        this.quantityInStock += amount;
    }

    // accessors for other classes
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

