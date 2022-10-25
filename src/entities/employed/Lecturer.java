package entities.employed;

public class Lecturer extends EmployedPeople implements Comparable<Lecturer>{

    private Title title;

    public Lecturer(String firstName, String lastName, String personId, double salary, Title title) {
        super(firstName, lastName, personId, salary);
        this.title = title;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    @Override
    public int compareTo(Lecturer lecturer) {
        return this.title.compareTo(lecturer.getTitle());
    }
}