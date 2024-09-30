package mg.tsiry.memo.exception;

/**
 * Handling the error exception in the note.
 *
 * @author Tsiry Valisoa
 */
public class NoteNotFoundException extends Exception {

    /**
     * Calling the constructor with parameter type String in the class Exception.
     *
     * @param id the id of the note who doesn't exist.
     */
    public NoteNotFoundException(Long id) {
        super("Could not find note with id : " + id);
    }
}
