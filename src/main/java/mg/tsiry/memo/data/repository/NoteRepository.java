package mg.tsiry.memo.data.repository;

import mg.tsiry.memo.data.entity.NoteEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for the note to connect the data source.
 *
 * @author Tsiry Valisoa
 */
@Repository
public interface NoteRepository extends JpaRepository<NoteEntity, Long> {
    @Query("SELECT n FROM NoteEntity n WHERE n.title LIKE %:keyWords% OR n.content LIKE %:keyWords%")
    Page<NoteEntity> findByKeyWords(@Param("keyWords") String keyWords, Pageable pageable);
}
