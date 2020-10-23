package crutchesbicycles.studyhelper.exception;

import crutchesbicycles.studyhelper.domain.GroupMaterial;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class GroupMaterialNotFoundException extends RuntimeException{
    public GroupMaterialNotFoundException(String idGroup, String idMaterial){
        super("GroupMaterial with id '" + idMaterial + "' from group with id '" + idGroup + "' not found");
    }
}
