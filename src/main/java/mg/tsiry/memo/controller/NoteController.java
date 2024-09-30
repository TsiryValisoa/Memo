package mg.tsiry.memo.controller;

import mg.tsiry.memo.converter.NoteRequestConverter;
import mg.tsiry.memo.converter.NoteResponseConverter;
import mg.tsiry.memo.converter.PaginationResponseConverter;
import mg.tsiry.memo.dto.request.NoteRequest;
import mg.tsiry.memo.dto.response.MessageResponse;
import mg.tsiry.memo.dto.response.NotePagedResponse;
import mg.tsiry.memo.dto.response.NoteResponse;
import mg.tsiry.memo.dto.response.PaginationResponse;
import mg.tsiry.memo.exception.NoteNotFoundException;
import mg.tsiry.memo.service.NoteService;
import mg.tsiry.memo.to.NotePagedTO;
import mg.tsiry.memo.to.NoteTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * A class who handle a requests, process them and returns a response.
 *
 * @author Tsiry Valisoa
 */
@RestController
public class NoteController {

    /**
     * Store the request converter.
     */
    @Autowired
    private NoteRequestConverter noteRequestConverter;

    /**
     * Store the response converter.
     */
    @Autowired
    private NoteResponseConverter noteResponseConverter;

    /**
     * Store the pagination response converter.
     */
    @Autowired
    private PaginationResponseConverter paginationResponseConverter;

    /**
     * Store the business logic of the note.
     */
    @Autowired
    private NoteService noteService;

    /**
     * Create the note.
     *
     * @param noteRequest the requested note from the user.
     * @return the response of the note.
     */
    @PostMapping("/note")
    public NoteResponse createNote(@RequestBody NoteRequest noteRequest) {
        NoteTO noteTOConverted = noteRequestConverter.convertToTO(noteRequest);
        NoteTO noteTOSaved = noteService.save(noteTOConverted);
        NoteResponse noteResponseSaved = noteResponseConverter.convertFromTO(noteTOSaved);
        return noteResponseSaved;
    }

    /**
     * List the note.
     *
     * @return the list of the all note present.
     */
    @GetMapping("/note")
    public List<NoteResponse> listNote() {
       List<NoteTO> noteTOList = noteService.getAll();
       return noteResponseConverter.convertFromListTO(noteTOList);
    }

    /**
     * Showing the list of the note present in the page, and the page information in the note.
     *
     * @param page the current page.
     * @param size the number of the note in one page.
     * @return the notes in the page indicated, and the information of the page in the note.
     */
    @GetMapping("/note/page")
    public NotePagedResponse listPagedNote(@RequestParam Integer page, @RequestParam Integer size) {
        NotePagedTO notePagedTO = noteService.getAll(page, size);

        // Manage the note list
        List<NoteTO> noteTOList = notePagedTO.getNoteTOList();
        List<NoteResponse> noteResponseList = noteResponseConverter.convertFromListTO(noteTOList);
        // Manage pagination
        PaginationResponse paginationResponse = paginationResponseConverter.convertFromTO(notePagedTO.getPageInfoTO());

        // Build the note paged response
        NotePagedResponse notePagedResponse = new NotePagedResponse();
        notePagedResponse.setData(noteResponseList);
        notePagedResponse.setPagination(paginationResponse);

        return notePagedResponse;
    }

    /**
     * Searching a note by it id.
     *
     * @param id the id used for searching a note.
     * @return the note searched.
     * @throws NoteNotFoundException
     */
    @GetMapping("/note/{id}")
    public NoteResponse searchNote(@PathVariable Long id) throws NoteNotFoundException {
        NoteTO noteTO = noteService.findNoteById(id);
        return noteResponseConverter.convertFromTO(noteTO);
    }

    /**
     * Updating the note.
     *
     * @param id the id of the note who will be updated.
     * @param noteRequest the note who will be updated.
     * @return the note updated.
     */
    @PutMapping("/note/{id}")
    public NoteResponse updateNote(@PathVariable Long id, @RequestBody NoteRequest noteRequest) {
        NoteTO noteTO = noteRequestConverter.convertToTO(noteRequest);
        NoteTO noteTOUpdated = noteService.updateNoteById(id, noteTO);
        NoteResponse noteResponseUpdated = noteResponseConverter.convertFromTO(noteTOUpdated);
        return noteResponseUpdated;
    }

    /**
     * Deleting a note.
     *
     * @param id the id of the not who will be deleted.
     * @return the note deleted.
     */
    @DeleteMapping("/note/{id}")
    public MessageResponse deleteNote(@PathVariable Long id) {
        noteService.deleteNoteById(id);
        MessageResponse messageResponse = new MessageResponse("Note deleted successfully");
        return messageResponse;
    }

}
