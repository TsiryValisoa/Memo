package mg.tsiry.memo.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A class who hold the response of the data that the user requested.
 *
 * @author Tsiry Valisoa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NoteResponse {
    /**
     * Store the id of the note.
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
    @JsonProperty("created_date")
    private String createdDate;
}
