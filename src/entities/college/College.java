package entities.college;

import entities.employed.EmployedPeople;
import entities.employed.Lecturer;
import entities.employed.OtherEmployees;
import entities.students.Student;
import entities.students.Studies;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class College {

    private String collegeName;
    private long collegeId;
    private List<EmployedPeople> employedPeople;
    private List<Student> students;

    public College(String collegeName, long collegeId) {
        this.collegeName = collegeName;
        this.collegeId = collegeId;
        this.employedPeople = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public String getCollegeName() {
        return collegeName;
    }

    public void setCollegeName(String collegeName) {
        this.collegeName = collegeName;
    }

    public long getCollegeId() {
        return collegeId;
    }

    public void setCollegeId(long collegeId) {
        this.collegeId = collegeId;
    }

    public List<EmployedPeople> getEmployedPeople() {
        return employedPeople;
    }

    public void setEmployedPeople(List<EmployedPeople> employedPeople) {
        this.employedPeople = employedPeople;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public List<EmployedPeople> getLecturer() {
        ArrayList<EmployedPeople> listLecturer = new ArrayList<>();
        for (EmployedPeople employedPerson : employedPeople) {
            if (employedPerson instanceof Lecturer) {
                listLecturer.add(employedPerson);
            }
        }
        return listLecturer;
    }

    public List<EmployedPeople> getOtherEmployees() {
        ArrayList<EmployedPeople> listOtherEmployees = new ArrayList<>();
        for (EmployedPeople employedPerson : employedPeople) {
            if (employedPerson instanceof OtherEmployees) {
                listOtherEmployees.add(employedPerson);
            }
        }
        return listOtherEmployees;
    }

    public static ArrayList<String> listOfStudents(List<Student> students, Studies studies) {
        ArrayList<String> listOfStudents = new ArrayList<>();

        for (Student student : students) {
            if (student.equals(studies)) {
                listOfStudents.add(student.getFirstName() + " " + student.getLastName());
                listOfStudents.add(String.valueOf(student.getIndexNumber()));
                listOfStudents.add(String.valueOf(student.getStudentAverage()));
            }
        }
        return listOfStudents;
    }

    public static ArrayList<String> listOfLecturer(List<EmployedPeople> employedPeople) {
        ArrayList<String> listOfLecturer = new ArrayList<>();
        for (EmployedPeople employedPerson : employedPeople) {
            listOfLecturer.add(employedPerson.getFirstName() + " " + employedPerson.getLastName());
            listOfLecturer.add(employedPerson.getPersonId());
            listOfLecturer.add(String.valueOf(((Lecturer)employedPerson).getTitle()));
            listOfLecturer.add(String.valueOf(employedPerson.getSalary()));
        }
        return listOfLecturer;
    }

    public static ArrayList<String> listOfOtherEmployees(List<EmployedPeople> employedPeople) {
        ArrayList<String> listOfOtherEmployees = new ArrayList<>();
        for (EmployedPeople employedPerson : employedPeople) {
            listOfOtherEmployees.add(employedPerson.getFirstName() + " " + employedPerson.getLastName());
            listOfOtherEmployees.add(employedPerson.getPersonId());
            listOfOtherEmployees.add(String.valueOf(((OtherEmployees) employedPerson).getYears_of_service()));
        }
        return listOfOtherEmployees;
    }

    public static void exportToTxt(List<String> list, String fileName) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, true);
            for (String s : list) {
                writer.write(s + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
      }
   }