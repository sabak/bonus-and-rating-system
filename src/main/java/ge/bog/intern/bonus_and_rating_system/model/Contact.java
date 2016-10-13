package ge.bog.intern.bonus_and_rating_system.model;

public class Contact {

    private Integer id;
    private String contactType;
    private String contactDetails;

    public Contact (String contactType, String contactDetails){
        this(null, contactType, contactDetails);
    }

    public Contact(Integer id, String contactType, String contactDetails) {
        this.id = id;
        this.contactType = contactType;
        this.contactDetails = contactDetails;
    }

    public Integer getId() {
        return id;
    }

    public String getContactType() {
        return contactType;
    }

    public String getContactDetails() {
        return contactDetails;
    }
}
