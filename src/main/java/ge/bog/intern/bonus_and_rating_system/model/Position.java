package ge.bog.intern.bonus_and_rating_system.model;

public class Position {

    private Integer id;
    private String description;

    public Position (String description){
        this(null, description);
    }

    public Position(Integer id, String description) {
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
