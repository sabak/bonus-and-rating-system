package ge.bog.intern.bonus_and_rating_system.model;

public class Task {

    private Integer id;
    private String name;
    private Integer plannedTime;
    private Integer timeSpent;
    private String status;

    public Task (String name, Integer plannedTime, Integer timeSpent, String status){
        this(null, name, plannedTime, timeSpent, status);
    }

    public Task(Integer id, String name, Integer plannedTime, Integer timeSpent, String status) {
        this.id = id;
        this.name = name;
        this.plannedTime = plannedTime;
        this.timeSpent = timeSpent;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPlannedTime() {
        return plannedTime;
    }

    public Integer getTimeSpent() {
        return timeSpent;
    }

    public String getStatus() {
        return status;
    }
}
