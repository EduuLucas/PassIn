package rocketseat.com.passin.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import rocketseat.com.passin.domain.attendee.exceptions.AttendeeAlreadyRegisteredException;
import rocketseat.com.passin.domain.attendee.exceptions.AttendeeNotFoundException;
import rocketseat.com.passin.domain.checkin.exceptions.CheckInAlreadyExistException;
import rocketseat.com.passin.domain.event.exceptions.EventFullException;
import rocketseat.com.passin.domain.event.exceptions.EventNotFoundException;

@ControllerAdvice
public class ExceptionEntityHandler {
    @ExceptionHandler(EventNotFoundException.class)
    public ResponseEntity handleEventNotFound(EventNotFoundException exception){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(AttendeeNotFoundException.class)
    public ResponseEntity handleAttendeeNotFound(AttendeeNotFoundException exception){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(EventFullException.class)
    public ResponseEntity handleEventFull(EventFullException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(AttendeeAlreadyRegisteredException.class)
    public ResponseEntity handleAttendeeAlreadyRegistered(AttendeeAlreadyRegisteredException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(CheckInAlreadyExistException.class)
    public ResponseEntity handleCheckInAlreadyExist(CheckInAlreadyExistException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }
}
