package crutchesbicycles.studyhelper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TeacherSubjectNotFound extends RuntimeException{
    public TeacherSubjectNotFound(String id){
        super("TeacherSubject from teacher with id '" + id + "' not found");
    }
}
