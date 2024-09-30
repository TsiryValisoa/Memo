package mg.tsiry.memo.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

/**
 * Holding all the information of the page in the note.
 *
 * @author Tsiry Valisoa
 */
@Data
public class PaginationResponse {
    /**
     * Store the total records.
     * The total number of the note saved.
     */
    @JsonProperty("total_records")
    private Long totalRecords;
    /**
     * Store the current page.
     */
    @JsonProperty("current_page")
    private Integer currentPage;
    /**
     * Store the total pages in the note.
     */
    @JsonProperty("total_pages")
    private Integer totalPages;
    /**
     * Store the next page.
     */
    @JsonProperty("next_page")
    private Integer nextPage;
    /**
     * Store the previous page.
     */
    @JsonProperty("previous_page")
    private Integer previousPage;
}
