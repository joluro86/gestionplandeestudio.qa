package co.com.udea.plandeestudio.web.httperrorhandler;

import co.com.udea.plandeestudio.domain.errorhandler.BadResponseHandler;
import co.com.udea.plandeestudio.domain.model.Mensaje;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(value = BadResponseHandler.class)
    public ResponseEntity<Mensaje> respuestaFallida(BadResponseHandler badResponseHandler) {
        Mensaje mensaje = new Mensaje(badResponseHandler.getCode(), badResponseHandler.getMessage());
        return new ResponseEntity<>(mensaje, badResponseHandler.getHttpStatus());
    }

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Mensaje> serverError(Exception exception) {
        Mensaje mensaje = new Mensaje(exception.getLocalizedMessage(), exception.getMessage());
        return new ResponseEntity<>(mensaje, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
