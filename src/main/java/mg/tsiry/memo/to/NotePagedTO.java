package mg.tsiry.memo.to;

import lombok.Data;

import java.util.List;

/**
 * Holding the list of note in the pagination, and the information of the page in the note
 *
 * @author Tsiry Valisoa
 */
@Data
public class NotePagedTO {
    /**
     * Store the List of the note present in the page.
     */
    private List<NoteTO> noteTOList;
    /**
     * Store the information of the page.
     */
    private PageInfoTO pageInfoTO;
}
