package ge.bog.intern.bonus_and_rating_system.model;

public class TaskTypes {

    private Integer id;
    private String description;

    public TaskTypes(String description){
        this(null, description);
    }

    public TaskTypes(Integer id, String description) {
        this.id = id;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }
}
