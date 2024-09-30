package mg.tsiry.memo.data.repository;

import mg.tsiry.memo.data.entity.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for the note to connect the data source.
 *
 * @author Tsiry Valisoa
 */
@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {

}
