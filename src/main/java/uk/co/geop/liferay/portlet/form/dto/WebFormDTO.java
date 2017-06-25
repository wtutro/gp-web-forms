package uk.co.geop.liferay.portlet.form.dto;

/**
 * Web form DTO for storing all entered data.
 *
 * @author Wojciech Tutro
 * @version 25-06-2017
 */
public class WebFormDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String comment;

    public WebFormDTO() {
    }

    public WebFormDTO(String firstName, String lastName, String email, String comment) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.comment = comment;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}
