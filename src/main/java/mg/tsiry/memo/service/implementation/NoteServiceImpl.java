package mg.tsiry.memo.service.implementation;

import mg.tsiry.memo.converter.NoteEntityConverter;
import mg.tsiry.memo.data.entity.NoteEntity;
import mg.tsiry.memo.data.repository.NoteRepository;
import mg.tsiry.memo.exception.NoteNotFoundException;
import mg.tsiry.memo.service.NoteService;
import mg.tsiry.memo.to.NotePagedTO;
import mg.tsiry.memo.to.NoteTO;
import mg.tsiry.memo.to.PageInfoTO;
import org.joda.time.LocalDateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementation of all the usable methods for the note.
 *
 * @author Tsiry Valisoa
 */
@Service
public class NoteServiceImpl implements NoteService {

    /**
     * Store the entity converter.
     */
    @Autowired
    private NoteEntityConverter noteEntityConverter;

    /**
     * Store the repository of the note.
     */
    @Autowired
    private NoteRepository noteRepository;

    /**
     * The full process saving method of the note.
     *
     * @param noteTO the note to save.
     * @return the note saved
     */
    @Override
    public NoteTO save(NoteTO noteTO) {
        // Add the created date in the TO
        noteTO.setCreatedDate(LocalDateTime.now());
        // Convert Entity to TO because repository only accept Entity
        NoteEntity noteEntity = noteEntityConverter.convertFromTO(noteTO);
        // Save in the repository the note entity
        NoteEntity noteEntitySaved = noteRepository.save(noteEntity);
        // Convert to TO Entity because service only accept TO
        NoteTO noteTOSaved = noteEntityConverter.convertToTO(noteEntitySaved);
        // Return the TO converted
        return noteTOSaved;
    }

    /**
     * The full List of all the note.
     *
     * @return all the note list.
     */
    @Override
    public List<NoteTO> getAll() {
        // Get from repository all note. Repository return only Entity so we must convert into TO
        List<NoteEntity> noteEntityList = noteRepository.findAll();
        // Convert the note entity list into note TO
        List<NoteTO> noteTOList = noteEntityConverter.convertToListTO(noteEntityList);
        // Return the note TO list converted
        return noteTOList;
    }

    /**
     * Getting all the data note present in the page. And showing the information of the page.
     *
     * @param page the current page.
     * @param size the number of the note present in the page.
     * @return the note in the current page and the information of the page.
     */
    @Override
    public NotePagedTO getAll(Integer page, Integer size) {
        Page<NoteEntity> noteEntityPage = noteRepository.findAll(PageRequest.of(page - 1, size));

        NotePagedTO notePagedTO = pageNote(page, noteEntityPage);

        return notePagedTO;
    }

    /**
     * The full process of the note researched.
     *
     * @param id finding the note by it id.
     * @return the note found.
     * @throws NoteNotFoundException if there is no id corresponding to the note.
     */
    @Override
    public NoteTO findNoteById(Long id) throws NoteNotFoundException {
        // Get from repository the entity corresponding to the id
        NoteEntity noteEntity = noteRepository.findById(id)
                .orElseThrow(() -> new NoteNotFoundException(id));
        // Or, repository return entity. SOw we must convert into TO
        NoteTO noteTO = noteEntityConverter.convertToTO(noteEntity);
        // Return the note to converted
        return noteTO;
    }

    @Override
    public NotePagedTO findNoteByKeyWord(Integer page, Integer size, String keyWords) {
        Pageable pageableRequest = PageRequest.of(page - 1, size, Sort.Direction.ASC, "id");
        Page<NoteEntity> noteEntityPage = noteRepository.findByKeyWords(keyWords, pageableRequest);

        NotePagedTO notePagedTO = pageNote(page, noteEntityPage);

        return notePagedTO;
    }

    /**
     * Process of the note updated.
     *
     * @param id the id of the note who will be updated.
     * @param noteTO the note to update.
     * @return the note updated.
     */
    @Override
    public NoteTO updateNoteById(Long id, NoteTO noteTO) {
        // Begin the business logic : set the id into TO
        noteTO.setId(id);
        // Set the created date (the modified date)
        noteTO.setCreatedDate(LocalDateTime.now());
        // We must convert the TO into Entity because repository accept only Entity
        NoteEntity noteEntity = noteEntityConverter.convertFromTO(noteTO);
        // Update the note (using the save method)
        NoteEntity noteEntityUpdated = noteRepository.save(noteEntity);
        // Or, service only work with TO. Sow we convert the entity to TO
        NoteTO noteTOUpdated = noteEntityConverter.convertToTO(noteEntityUpdated);
        // Return the note TO updated
        return noteTOUpdated;
    }

    /**
     * Deleting the note.
     *
     * @param id the id of the note who will be deleted.
     */
    @Override
    public void deleteNoteById(Long id) {
        noteRepository.deleteById(id);
    }

    private NotePagedTO pageNote(Integer page, Page<NoteEntity> noteEntityPage) {
        // Build the page info
        PageInfoTO pageInfoTO = new PageInfoTO();
        pageInfoTO.setTotalElements(noteEntityPage.getTotalElements());
        pageInfoTO.setTotalPages(noteEntityPage.getTotalPages());
        pageInfoTO.setCurrentPage(page);
        // Make the ternary in 2 lines
        Integer nextPage = noteEntityPage.hasNext() ? page + 1 : null;
        pageInfoTO.setNextPage(nextPage);
        // Single line ternary
        pageInfoTO.setPreviousPage(noteEntityPage.hasPrevious() ? page - 1 : null);

        // Build the note paged
        NotePagedTO notePagedTO = new NotePagedTO();
        List<NoteEntity> noteEntityList = noteEntityPage.toList();
        notePagedTO.setNoteTOList(noteEntityConverter.convertToListTO(noteEntityList));
        notePagedTO.setPageInfoTO(pageInfoTO);

        return notePagedTO;
    }
}
