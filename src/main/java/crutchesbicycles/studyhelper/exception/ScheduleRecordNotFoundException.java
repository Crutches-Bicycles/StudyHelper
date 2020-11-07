package crutchesbicycles.studyhelper.exception;

public class ScheduleRecordNotFoundException extends RuntimeException{
    public ScheduleRecordNotFoundException(String message) {
        super("ScheduleRecord with id '" + message + "' not found");
    }
}
