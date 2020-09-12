package crutchesbicycles.studyhelper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentMaterialNotFoundException  extends RuntimeException{
    public StudentMaterialNotFoundException(String idStudent, String idMaterial){
        super("У пользователя c id: " + idStudent + "не найден материал с id: " + idMaterial);
    }
}
