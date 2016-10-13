package ge.bog.intern.bonus_and_rating_system.model;


public class Department {

    private Integer id;
    private String departmentName;

    public Department(String departmentName){
        this(null, departmentName);
    }

    public Department(Integer id, String departmentName) {
        this.id = id;
        this.departmentName = departmentName;
    }

    public Integer getId() {
        return id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

}
