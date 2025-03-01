package tech.spec.exception;

import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserhubGlobalExceptionHandler {

    @ExceptionHandler(UserhubException.class)
    public ResponseEntity<ProblemDetail> handleUserhubException(UserhubException ex) {
        return ResponseEntity.of(buildBase(ex)).build();
    }

    protected ProblemDetail buildBase(UserhubException ex) {
        final var base = ProblemDetail.forStatus(ex.getStatus());

        base.setProperty("code", ex.getStatus());
        base.setProperty("title", ex.getTitle());
        base.setProperty("detail", ex.getDetail());

        return base;
    }
}
