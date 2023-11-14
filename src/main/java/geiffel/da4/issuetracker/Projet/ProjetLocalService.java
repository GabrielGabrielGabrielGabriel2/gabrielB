package geiffel.da4.issuetracker.Projet;

import geiffel.da4.issuetracker.exceptions.ResourceAlreadyExistsException;
import geiffel.da4.issuetracker.exceptions.ResourceNotFoundException;
import geiffel.da4.issuetracker.utils.LocalService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjetLocalService extends LocalService<Projet, Long> implements ProjetService  {
    public ProjetLocalService(List<Projet> projet) {
        super(projet);
    }

    @Override
    protected String getIdentifier() {
        return null;
    }

    @Override
    public List<Projet> getAll() {
        return  super.getAll();
    }


    @Override
    public Projet getByID(Long l) {
        IndexAndValue<Projet> found = this.findByProperty(l);
        return found.value();
    }

    @Override
    public Projet create(Projet newProjet) {
        try {
            this.findByProperty(newProjet.getId());
            throw new ResourceAlreadyExistsException("Projet", newProjet.getId());
        } catch (ResourceNotFoundException e) {
            this.allValues.add(newProjet);
            return newProjet;
        }
    }

    @Override
    public void update(Long code, Projet updatedProjet) {
        IndexAndValue<Projet> found = this.findByProperty(code);
        this.allValues.remove(found.index());
        this.allValues.add(found.index(), updatedProjet);
    }

    @Override
    public void delete(Long code) {
        IndexAndValue<Projet> found = this.findByProperty(code);
        this.allValues.remove(found.index());
    }
}
