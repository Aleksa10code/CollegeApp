package entities.employed;

import entities.Person;

public abstract class EmployedPeople extends Person {

    private double salary;

    protected EmployedPeople(String firstName, String lastName, String personId, double salary) {
        super(firstName, lastName, personId);
        setSalary(salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        if (salary < 0) {
            throw new IllegalArgumentException("Salary can't be negative value.");
        }
    }
}