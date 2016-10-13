package ge.bog.intern.bonus_and_rating_system.model;

public class Address {

    private Integer id;
    private String details;

    public Address (String details){
        this(null, details);
    }

    public Address(Integer id, String details) {
        this.id = id;
        this.details = details;
    }

    public Integer getId() {
        return id;
    }

    public String getDetails() {
        return details;
    }
}
