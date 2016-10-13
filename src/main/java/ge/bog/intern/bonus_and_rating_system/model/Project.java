package ge.bog.intern.bonus_and_rating_system.model;

public class Project {

    private Integer id;
    private String name;
    private String startDate;
    private String endDate;
    private String customer;
    private Integer cost;
    private Integer bonus;
    private String projectStatus;

    public Project(String name, String startDate, String endDate, String customer, Integer cost, Integer bonus, String projectStatus) {
        this(null, name, startDate, endDate, customer, cost, bonus, projectStatus);
    }

    public Project(Integer id, String name, String startDate, String endDate, String customer, Integer cost, Integer bonus, String projectStatus) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.customer = customer;
        this.cost = cost;
        this.bonus = bonus;
        this.projectStatus = projectStatus;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStartDate() {
        return startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getCustomer() {
        return customer;
    }

    public Integer getCost() {
        return cost;
    }

    public Integer getBonus() {
        return bonus;
    }

    public String getProjectStatus() {
        return projectStatus;
    }
}
