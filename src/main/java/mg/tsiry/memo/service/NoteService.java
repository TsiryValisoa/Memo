package mg.tsiry.memo.service;

import mg.tsiry.memo.exception.NoteNotFoundException;
import mg.tsiry.memo.to.NotePagedTO;
import mg.tsiry.memo.to.NoteTO;

import java.util.List;

/**
 * All the usable abstract operation for the note.
 *
 * @author Tsiry Valisoa
 */
public interface NoteService {

    /**
     * Save the note.
     *
     * @param note the note to save.
     * @return the saved note.
     */
    NoteTO save(NoteTO note);

    /**
     * Get all existing notes.
     *
     * @return a list for all existing note.
     */
    List<NoteTO> getAll();

    /**
     * Get all the notes existing in the page.
     *
     * @param page the current page.
     * @param size the number of the note present in the page.
     * @return the data of the note present in the current page.
     */
    NotePagedTO getAll(Integer page, Integer size);

    /**
     * Find the note
     *
     * @param id finding the note by it id.
     * @return the note found.
     * @throws NoteNotFoundException if there is no id corresponding in the note.
     */
    NoteTO findNoteById(Long id) throws NoteNotFoundException;

    NotePagedTO findNoteByKeyWord(Integer page, Integer size, String keyWords);

    /**
     * Update the note.
     *
     * @param id the id of the note who will be updated.
     * @param note the note who will be updated.
     * @return the note updated.
     */
    NoteTO updateNoteById(Long id, NoteTO note);

    /**
     * Deleting the note.
     *
     * @param id the id of the note who will be deleted.
     */
    void deleteNoteById(Long id);
}
