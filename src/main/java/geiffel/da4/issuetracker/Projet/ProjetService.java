package geiffel.da4.issuetracker.Projet;

import java.util.List;

public interface ProjetService {



    List<Projet> getAll();


    Projet getByID(Long l);

    Projet create(Projet newProjet);

    void update(Long code, Projet updatedProjet);

    void delete(Long code);
}
