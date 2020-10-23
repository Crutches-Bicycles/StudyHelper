package crutchesbicycles.studyhelper.exception;

public class TeacherExistsException extends RuntimeException{
    public TeacherExistsException(String email){
        super("Teacher with email '" + email + "' exists");
    }
}
