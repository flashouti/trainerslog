package ru.npcric.asparagus.trainerslog.adapter.web.advice;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import ru.npcric.asparagus.trainerslog.adapter.web.errors.AlreadyExistException;
import ru.npcric.asparagus.trainerslog.adapter.web.errors.ErrorResponse;
import ru.npcric.asparagus.trainerslog.adapter.web.errors.UserNotFoundException;

import java.util.List;

@RestControllerAdvice
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class CommonAdvice extends ResponseEntityExceptionHandler {

    static String VALIDATION_ERROR = "validation_error";

    @ExceptionHandler
    public ErrorResponse handleNotFound(UserNotFoundException ex) {
        return new ErrorResponse(ex.getCode(), ex.getMessage());
    }

    @ExceptionHandler
    public ErrorResponse handleAlreadyExist(AlreadyExistException ex) {
        return new ErrorResponse(ex.getCode(), ex.getMessage());
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        List<ErrorResponse> errors = ex.getBindingResult()
                .getFieldErrors().stream().map(fieldError ->
                        new ErrorResponse(VALIDATION_ERROR, fieldError.getField(), fieldError.getDefaultMessage())).
                toList();
        return ResponseEntity.badRequest()
                .body(errors);
    }


}
