public class Employer {
    private String name;
    private float salary;

    public Employer(String name, float salary) {
        
this.name
 = name;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employer{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
} 