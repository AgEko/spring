package tekcamp.mod12.spring.exercise.Exceptions;

public class UserServiceException extends RuntimeException{

    private static final long serialVersionUID = -5569923165332665447L;

    public UserServiceException(String exceptionMessage) {
        super(exceptionMessage);
    }
}
