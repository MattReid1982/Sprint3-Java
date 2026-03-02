// Made the class abstract because I don't want to generate "person" objects, but I do want to generate Patient and Doctors objects. Extend the persons class to the patient and doctor classes.
// Base class representing a generic person with common attributes.
// Made abstract because we never instantiate a generic Person directly,
// only specialized subclasses such as Doctor or Patient.

public abstract class Person {
    protected int id;
    protected String name;
    protected int age;
    protected String phoneNumber;

    public Person(int id, String name, int age, String phoneNumber) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    // Getters and setters
    // Return unique identifier for this person
    public int getId() {
        return id;
    }

    // Update the person's id.
    public void setId(int id) {
        this.id = id;
    }

    // Return person's full name
    public String getName() {
        return name;
    }

    // Update the person's name.
    public void setName(String name) {
        this.name = name;
    }

    // Return person's age in years
    public int getAge() {
        return age;
    }

    // Update the person's age.
    public void setAge(int age) {
        this.age = age;
    }

    // Return primary phone contact for this person
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Update the person's phone number.
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


}
