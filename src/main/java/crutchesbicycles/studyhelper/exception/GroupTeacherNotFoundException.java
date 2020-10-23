package crutchesbicycles.studyhelper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GroupTeacherNotFoundException extends RuntimeException{
    public  GroupTeacherNotFoundException(String idGroup){
        super("Entity GroupTeacher with id group '" + idGroup + "' not found");
    }
}
