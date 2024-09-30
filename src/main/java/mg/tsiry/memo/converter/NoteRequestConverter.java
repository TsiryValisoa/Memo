package mg.tsiry.memo.converter;

import mg.tsiry.memo.dto.request.NoteRequest;
import mg.tsiry.memo.to.NoteTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Holding the converter of noteRequest and noteTO.
 *
 * @author Tsiry Valisoa
 */
@Component
public class NoteRequestConverter implements Converter<NoteTO, NoteRequest> {

    /**
     * Convert the noteRequest to noteTO.
     *
     * @param source the parameter convert to NoteTO.
     * @return the noteTO converted.
     */
    @Override
    public NoteTO convertToTO(NoteRequest source) {
        NoteTO noteTO = new NoteTO();
        noteTO.setTitle(source.getTitle());
        noteTO.setContent(source.getContent());
        return noteTO;
    }

    /**
     * Convert the list noteRequest to list noteTO.
     *
     * @param sourceList the parameter list convert to list NoteTO.
     * @return the list noteTO converted.
     */
    @Override
    public List<NoteTO> convertToListTO(List<NoteRequest> sourceList) {
        return sourceList.stream()
                .map(this::convertToTO)
                .collect(Collectors.toList());
    }

    /**
     * Throwing the exception of the variable to converted to NoteRequested.
     *
     * @param to the parameter convert to NoteRequested.
     * @return an exception.
     */
    @Override
    public NoteRequest convertFromTO(NoteTO to) {
        throw new UnsupportedOperationException();
    }

    /**
     * Throwing the exception of the list variable toList converted to list NoteRequested.
     *
     * @param toList the parameter list convert to list NoteRequested.
     * @return an exception.
     */
    @Override
    public List<NoteRequest> convertFromListTO(List<NoteTO> toList) {
        throw new UnsupportedOperationException();
    }
}
