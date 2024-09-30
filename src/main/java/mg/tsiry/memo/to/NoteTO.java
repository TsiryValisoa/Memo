package mg.tsiry.memo.to;

import lombok.Data;
import org.joda.time.LocalDateTime;

/**
 * All the important data for the note.
 *
 * @author Tsiry Valisoa
 */
@Data
public class NoteTO {
    /**
     * Store the id.
     */
    private Long id;
    /**
     * Store the title.
     */
    private String title;
    /**
     * Store the content.
     */
    private String content;
    /**
     * Store the created date.
     */
    private LocalDateTime createdDate;
}
