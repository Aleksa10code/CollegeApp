import entities.college.College;
import entities.employed.*;
import entities.students.Student;
import entities.students.Studies;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

    Lecturer lecturer1 = new Lecturer("Aleksa", "Jovanovic", "10", 200000, Title.ASSISTANT_PROFESSOR);
    Lecturer lecturer2 = new Lecturer("Nebojsa", "Pesic", "11", 150000, Title.ASSISTANT);
    Lecturer lecturer3 = new Lecturer("Dragan", "Kocic", "12", 120000, Title.ASSOCIATE);

    OtherEmployees otherEmployees1 = new OtherEmployees("Dusan", "Peric", "2202067765464", 80000, Service.LEGAL, 87);
    OtherEmployees otherEmployees2 = new OtherEmployees("Paul", "Mihic", "1702023735641", 140000, Service.IT, 40);
    OtherEmployees otherEmployees3 = new OtherEmployees("Mario", "Delezic", "67855423735641", 180000, Service.STUDENT, 45);

    Student student1 = new Student("Milan", "Ristic", "1610963110002", Studies.DOCTORAL, 1011, 9.9);
    Student student2 = new Student("Ana", "Rancic", "1111265110002", Studies.MASTER, 1002, 10.0);
    Student student3 = new Student("Marija", "Zivadinovic", "1212173999198", Studies.UNDERGRADUATE, 1003, 8.8);
    Student student4 = new Student("Hana", "Karapandzic", "32165173999198", Studies.UNDERGRADUATE, 1005, 7.0);

    College college = new College("Harvard University", 1734);

    List<EmployedPeople> listOfEmployedPeople = Arrays.asList(lecturer1, lecturer2, lecturer3, otherEmployees1, otherEmployees2, otherEmployees3);
    college.setEmployedPeople(listOfEmployedPeople);

    ArrayList<String> listOfLecturer = College.listOfLecturer(college.getLecturer());
    ArrayList<String> listOfOthers = College.listOfOtherEmployees(college.getOtherEmployees());

    System.out.println(lecturer1.compareTo(lecturer2));
    System.out.println(lecturer1.compareTo(lecturer3));

    System.out.println(otherEmployees1.compareTo(otherEmployees2));
    System.out.println(otherEmployees1.compareTo(otherEmployees3));

    List<Student> students = Arrays.asList(student1, student2, student3, student4);
    college.setStudents(students);

    ArrayList<String> undergraduate = College.listOfStudents(students, Studies.UNDERGRADUATE);
    ArrayList<String> master = College.listOfStudents(students, Studies.MASTER);
    ArrayList<String> doctoral = College.listOfStudents(students, Studies.DOCTORAL);

    College.exportToTxt(undergraduate, "students.txt");
    College.exportToTxt(master, "students.txt");
    College.exportToTxt(doctoral, "students.txt");

    College.exportToTxt(listOfLecturer, "lecturers.txt");
    College.exportToTxt(listOfOthers, "othersEmployees.txt");

    }
}