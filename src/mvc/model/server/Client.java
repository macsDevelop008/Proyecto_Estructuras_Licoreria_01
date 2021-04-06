package mvc.model.server;

import java.io.Serializable;

public class Client implements Serializable {

    private static final long serialVersionUID = 3452345324524523L;
    private String firstName;
    private String lastName;
    private String program;
    private String message;

    public Client(String firstName, String lastName, String program, String message) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.program = program;
        this.message = message;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
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

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "Client{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", program='" + program + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
