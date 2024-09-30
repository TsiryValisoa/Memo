package mg.tsiry.memo.dto.response;

import lombok.Data;

import java.util.List;

/**
 * Response of the list note present in the page, and all the information of the pages available.
 *
 * @author Tsiry Valisoa
 */
@Data
public class NotePagedResponse {
    /**
     * Store the list of the data.
     */
    private List<NoteResponse> data;
    /**
     * Store the pagination.
     */
    private PaginationResponse pagination;
}
