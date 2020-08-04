package tekcamp.mod12.spring.exercise.Model.Response;

public enum ErrorMessages {

    FIELD_CANNOT_BE_EMPTY ("You are missing data in a required field."),
    EMAIL_IN_USE ("That email is already in use.");

    private String errorMessage;

    ErrorMessages(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
