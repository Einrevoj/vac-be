package capstone.project.exception;

import capstone.project.util.DateTimeUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class AppExceptionHandler {
    private final DateTimeUtil dateTimeUtil;

    @ExceptionHandler(UserAlreadyExist.class)
    public ResponseEntity<Object> handlerUserAlreadyExist(UserAlreadyExist exception) {
        return new ResponseEntity<Object>(new ApiError(exception.getMessage(), HttpStatus.BAD_REQUEST, dateTimeUtil.currentDate()), HttpStatus.BAD_REQUEST);
    }

}
