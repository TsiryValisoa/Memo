package mg.tsiry.memo.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class hold a message response for the user.
 *
 * @author Tsiry Valisoa
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageResponse {
    /**
     * Store the message.
     */
    private String message;
}
