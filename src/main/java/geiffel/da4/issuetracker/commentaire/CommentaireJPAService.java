package geiffel.da4.issuetracker.commentaire;

import geiffel.da4.issuetracker.exceptions.ResourceAlreadyExistsException;
import geiffel.da4.issuetracker.exceptions.ResourceNotFoundException;
import geiffel.da4.issuetracker.issue.Issue;
import geiffel.da4.issuetracker.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("jpa")
@Primary
public class CommentaireJPAService implements CommentaireService {

    @Autowired
    private CommentaireRepository commentaireRepository;
    @Override
    public List<Commentaire> getAll() {
        return commentaireRepository.findAll();
    }


    @Override
    public Commentaire getById(Long id) {
        Optional<Commentaire> commentaire = commentaireRepository.findById(id);
        if (commentaire.isPresent()) {
            return commentaire.get();
        } else {
            throw new ResourceNotFoundException("commentaire", id);
        }
    }

    @Override
    public List<Commentaire> getAllByAuthorId(Long id) {
        return null;

    }

    @Override
    public List<Commentaire> getAllByIssueCode(Long code) {
        return null;
    }

    @Override
    public Commentaire create(Commentaire Newcommentaire) {
        if (commentaireRepository.existsById(Newcommentaire.getId())) {
            throw  new ResourceAlreadyExistsException("commentaire",Newcommentaire.getId());
        }else{
            return commentaireRepository.save(Newcommentaire);
        }
    }

    @Override
    public void update(Long id, Commentaire uptdatecommentaire) {
        if (commentaireRepository.existsById(id)) {
            commentaireRepository.save(uptdatecommentaire);
        } else {
            throw new ResourceNotFoundException("commentaire", id);
        }
    }

    @Override
    public void delete(Long id) {
        if (commentaireRepository.existsById(id)){
            commentaireRepository.deleteById(id);
        }else{
            throw new  ResourceNotFoundException("commentaire",id);
        }
    }
}
