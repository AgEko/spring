package tekcamp.mod12.spring.exercise.DTO;

public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }
 public void setFirstName(String firstName) {
        this.firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1).toLowerCase();
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1).toLowerCase();
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email.toLowerCase();
    }

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}
