package mg.tsiry.memo.data.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

/**
 * This is the entity to hold the note data.
 *
 * @author Tsiry Valisoa
 */
@Entity
@Data
@Table(name = "note")
public class NoteEntity {
    /**
     * Store the id of the note for the database.
     */
    @Id
    @GeneratedValue
    private Long id;
    /**
     * Store the title for the database.
     */
    private String title;
    /**
     * Store the content for the database.
     */
    private String content;
    /**
     * Store the created date for the database.
     */
    private Date createdDate;
}
