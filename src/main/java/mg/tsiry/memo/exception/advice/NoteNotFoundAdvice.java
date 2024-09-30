package mg.tsiry.memo.exception.advice;

import mg.tsiry.memo.dto.response.MessageResponse;
import mg.tsiry.memo.exception.NoteNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * This class handle the message response error in the note.
 *
 * @author Tsiry Valisoa
 */
@RestControllerAdvice
public class NoteNotFoundAdvice {

    /**
     * Calling the exception message response.
     *
     * @param e the default variable.
     * @return the message exception.
     */
    @ExceptionHandler(NoteNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public MessageResponse noteNotFoundHandler(NoteNotFoundException e) {
        MessageResponse messageResponse = new MessageResponse(e.getMessage());
        return messageResponse;
    }
}
