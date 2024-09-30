package mg.tsiry.memo.converter;

import mg.tsiry.memo.data.entity.NoteEntity;
import mg.tsiry.memo.to.NoteTO;
import org.joda.time.LocalDateTime;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Holding the converter of noteEntity and noteTO.
 *
 * @author Tsiry Valisoa
 */
@Component
public class NoteEntityConverter implements Converter<NoteTO, NoteEntity> {

    /**
     * Convert the noteEntity to noteTO.
     *
     * @param noteEntity the parameter need to be converted into NoteTO
     * @return the noteTO converted.
     */
    @Override
    public NoteTO convertToTO(NoteEntity noteEntity) {
        NoteTO noteTO = new NoteTO();
        noteTO.setId(noteEntity.getId());
        noteTO.setTitle(noteEntity.getTitle());
        noteTO.setContent(noteEntity.getContent());
        noteTO.setCreatedDate(LocalDateTime.fromDateFields(noteEntity.getCreatedDate()));
        return noteTO;
    }

    /**
     * Convert the list noteEntity to list noteTO.
     *
     * @param sourceList the parameter list convert to list noteTO.
     * @return the list noteTO converted.
     */
    @Override
    public List<NoteTO> convertToListTO(List<NoteEntity> sourceList) {
        return sourceList.stream()
                .map(this::convertToTO)
                .collect(Collectors.toList());
    }

    /**
     * Convert the noteTO to noteEntity.
     *
     * @param to the parameter convert to NoteEntity.
     * @return the noteEntity converted.
     */
    @Override
    public NoteEntity convertFromTO(NoteTO to) {
        NoteEntity noteEntity = new NoteEntity();
        noteEntity.setId(to.getId());
        noteEntity.setTitle(to.getTitle());
        noteEntity.setContent(to.getContent());
        noteEntity.setCreatedDate(to.getCreatedDate().toDate());
        return noteEntity;
    }

    /**
     * Convert the list noteTO to list noteEntity.
     *
     * @param toList the parameter list convert to list NoteEntity.
     * @return the list noteEntity converted.
     */
    @Override
    public List<NoteEntity> convertFromListTO(List<NoteTO> toList) {
        return toList.stream()
                .map(this::convertFromTO)
                .collect(Collectors.toList());
    }
}
