package ge.bog.intern.bonus_and_rating_system.model;

public class ProjectTypes {

    private Integer id;
    private String description;

    public ProjectTypes(String description){
        this(null, description);
    }

    public ProjectTypes(Integer id, String description) {
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
