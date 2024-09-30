package mg.tsiry.memo.dto.request;

import lombok.Data;

/**
 * This class hold the request of the user.
 *
 * @author Tsiry Valisoa
 */
@Data
public class NoteRequest {
    /**
     * Store the title.
     */
    private String title;
    /**
     * Store the content.
     */
    private String content;
}
