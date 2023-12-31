package geiffel.da4.issuetracker.commentaire;

import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
@Service
public interface CommentaireService {
    List<Commentaire> getAll();

    Commentaire getById(Long id);

    List<Commentaire> getAllByAuthorId(Long id);

    List<Commentaire> getAllByIssueCode(Long code);

    Commentaire create(Commentaire commentaire);

    void update(Long id, Commentaire toUpdate1);

    void delete(Long id);
}
