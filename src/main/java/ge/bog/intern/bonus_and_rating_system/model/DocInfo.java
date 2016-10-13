package ge.bog.intern.bonus_and_rating_system.model;


public class DocInfo {

    private Integer id;
    private String documentType;
    private String documentNumber;
    private String issueDate;
    private String issuingAuthority;
    private String validThru;

    public DocInfo (String documentType, String documentNumber, String issueDate, String issuingAuthority, String validThru){
        this (null, documentType, documentNumber, issueDate, issuingAuthority, validThru);
    }

    public DocInfo(Integer id, String documentType, String documentNumber, String issueDate, String issuingAuthority, String validThru) {
        this.id = id;
        this.documentType = documentType;
        this.documentNumber = documentNumber;
        this.issueDate = issueDate;
        this.issuingAuthority = issuingAuthority;
        this.validThru = validThru;
    }

    public Integer getId() {
        return id;
    }

    public String getDocumentType() {
        return documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getIssuingAuthority() {
        return issuingAuthority;
    }

    public String getValidThru() {
        return validThru;
    }
}
