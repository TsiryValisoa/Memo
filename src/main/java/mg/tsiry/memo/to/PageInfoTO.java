package mg.tsiry.memo.to;

import lombok.Data;

/**
 * Important and most useful information of the page in the note.
 *
 * @author Tsiry Valisoa
 */
@Data
public class PageInfoTO {
    /**
     * Store the total of the note saved.
     */
    private Long totalElements;
    /**
     * Store the total of the page available.
     */
    private Integer totalPages;
    /**
     * Store the current page.
     */
    private Integer currentPage;
    /**
     * Store the next page.
     */
    private Integer nextPage;
    /**
     * Store the previous page.
     */
    private Integer previousPage;
}
