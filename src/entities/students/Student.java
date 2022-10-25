package entities.students;

import entities.Person;

public class Student extends Person implements Comparable<Student>{

    private Studies studies;
    private int indexNumber;
    private double studentAverage;

    public Student(String firstName, String lastName, String personId, Studies studies, int indexNumber, double studentAverage) {
        super(firstName, lastName, personId);
        this.studies = studies;
        setIndexNumber(indexNumber);
        this.studentAverage = studentAverage;
    }

    public Studies getStudies() {
        return studies;
    }

    public void setStudies(Studies studies) {
        this.studies = studies;
    }

    public int getIndexNumber() {
        return indexNumber;
    }

    public void setIndexNumber(int indexNumber) {
        if (indexNumber < 1000) {
            throw new IllegalArgumentException("Index number can not be less than 1000");
        }
    }

    public double getStudentAverage() {
        return studentAverage;
    }

    public void setStudentAverage(double studentAverage) {
        this.studentAverage = studentAverage;
    }

    @Override
    public int compareTo(Student student) {
        if (!studies.equals(student.studies)) {
            throw new IllegalArgumentException("Students are not on the same studies!");
        }
        return Double.compare(studentAverage, student.studentAverage);
    }
}