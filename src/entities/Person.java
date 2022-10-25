package entities;

public abstract class Person {

    private String firstName;
    private String lastName;
    private String personId;

    protected Person(String firstName, String lastName, String personId) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.personId = personId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }
}
