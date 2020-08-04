package tekcamp.mod12.spring.exercise.Model.Response;

import org.springframework.http.HttpStatus;

public class UserResponse {

    private Long id;
    private String firstName;
    private String lastName;
    private String emailAddress;
    private HttpStatus httpStatus;

    public UserResponse(Long id, String firstName, String lastName, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = email;
    }
    public UserResponse(){
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) { this.id = id; }
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
    public String getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }
    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }
}
