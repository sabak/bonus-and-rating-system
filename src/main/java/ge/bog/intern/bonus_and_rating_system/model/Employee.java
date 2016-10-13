package ge.bog.intern.bonus_and_rating_system.model;

public class Employee {


    private Integer id;
    private String name;
    private String surname;
    private String dateOfBirth;
    private String sex;
    private String pid;
    private Position pos;
    private Integer salary;
    private Department department;
    private Integer managerID;

    public Employee(String name, String surname, String dateOfBirth, String sex, String pid, Position pos,
                    Integer salary, Department department, Integer managerID){

        this(null, name, surname, dateOfBirth, sex, pid, pos, salary, department, managerID);
    }

    public Employee(Integer id, String name, String surname, String dateOfBirth, String sex, String pid, Position pos,
                    Integer salary, Department department, Integer managerID) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.sex = sex;
        this.pid = pid;
        this.pos = pos;
        this.salary = salary;
        this.department = department;
        this.managerID = managerID;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getSex() {
        return sex;
    }

    public String getPid() {
        return pid;
    }

    public Position getPos() {
        return pos;
    }

    public Integer getSalary() {
        return salary;
    }

    public Department getDepartment() {
        return department;
    }

    public Integer getManagerID() {
        return managerID;
    }
}
