package mg.tsiry.memo.converter;

import mg.tsiry.memo.dto.response.NoteResponse;
import mg.tsiry.memo.to.NoteTO;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Holding the converter of noteResponse and noteTO.
 *
 * @author Tsiry Valisoa
 */
@Component
public class NoteResponseConverter implements Converter<NoteTO, NoteResponse> {

    /**
     * Throwing the exception of the variable source converted to NoteTO.
     *
     * @param source the parameter convert to T.
     * @return an exception.
     */
    @Override
    public NoteTO convertToTO(NoteResponse source) {
        throw new UnsupportedOperationException();
    }

    /**
     * Throwing the exception of the list variable sourceList converted to list NoteTO.
     *
     * @param sourceList the parameter list convert to list NoteTO.
     * @return exception.
     */
    @Override
    public List<NoteTO> convertToListTO(List<NoteResponse> sourceList) {
        throw new UnsupportedOperationException();
    }

    /**
     * Convert the noteTO to noteResponse.
     *
     * @param to the parameter convert to noteResponse..
     * @return the noteResponse converted.
     */
    @Override
    public NoteResponse convertFromTO(NoteTO to) {
        NoteResponse noteResponse = new NoteResponse();
        noteResponse.setId(to.getId());
        noteResponse.setTitle(to.getTitle());
        noteResponse.setContent(to.getContent());
        noteResponse.setCreatedDate(to.getCreatedDate().toString());
        return noteResponse;
    }

    /**
     * Convert the list noteTO to list noteResponse.
     *
     * @param toList the parameter list convert to list noteResponse.
     * @return the noteResponse converted.
     */
    @Override
    public List<NoteResponse> convertFromListTO(List<NoteTO> toList) {
        return toList.stream()
                .map(this::convertFromTO)
                .collect(Collectors.toList());
    }
}
