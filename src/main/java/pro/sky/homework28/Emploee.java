package pro.sky.homework28;

public class Emploee {
    private String name;
    private String secondName;
    private Integer departmentNo;
    private Integer salary;

    public Emploee(String name, String secondName, Integer departmentNo, Integer salary) {
        this. name = name;
        this.secondName = secondName;
        this. departmentNo = departmentNo;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return this.name + " " +  this.secondName + ", dep " + departmentNo + ", salary " + salary + ". ";
     }

    public String getName() { return name; }
    public String getSecondName() { return secondName; }
    public Integer getDepartmentNo() { return departmentNo; }
    public Integer getSalary() { return salary; }
    public void setName(String name) { this.name = name; }
    public void setSecondName(String secondName) { this.secondName = secondName; }
    public void setDepartmentNo(Integer departmentNo) { this.departmentNo = departmentNo; }
    public void setSalary(Integer salary) { this.salary = salary; }
}
