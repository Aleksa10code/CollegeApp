package entities.employed;

public class OtherEmployees extends EmployedPeople implements Comparable<OtherEmployees> {

    private Service service;
    private int years_of_service;

    public OtherEmployees(String firstName, String lastName, String personId, double salary, Service service, int years_of_service) {
        super(firstName, lastName, personId, salary);
        this.service = service;
        setYears_of_service(years_of_service);
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public int getYears_of_service() {
        return years_of_service;
    }

    public void setYears_of_service(int years_of_service) {
        if (years_of_service < 0) {
            throw new IllegalArgumentException("Years of service can't be negative value!");
        }
    }

    @Override
    public int compareTo(OtherEmployees otherEmployees) {
        if (!this.service.equals(otherEmployees.service)) {
            return 0;
        }
        return Integer.compare(years_of_service, otherEmployees.years_of_service);
    }
}