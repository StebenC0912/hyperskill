import com.project.noteapp.domain.model.Notebook;
import org.springframework.stereotype.Repository;
@Repository
public interface NotebookRepository {
    Notebook save(Notebook notebook);
    List<Notebook> findAll();
    Notebook findByTitle(String title);
}
