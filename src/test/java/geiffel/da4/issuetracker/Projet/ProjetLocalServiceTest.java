package geiffel.da4.issuetracker.Projet;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.internal.matchers.Equals;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProjetLocalServiceTest {

@BeforeEach
void setUp() {
    List<Projet> projet = new ArrayList<>() {{
        add(new Projet(1L, "projet1"));
        add(new Projet(2L, "projet2"));
        add(new Projet(3L, "projet3"));
        add(new Projet(4L, "projet4"));
    }};

}

    private List<Projet> projet;
    ProjetLocalService projetService = new ProjetLocalService(projet);


    @Test
    void testgetall(){
        List<Projet> lesprojets = projetService.getAll();
        assertEquals(4,lesprojets.size());
    }

    @Test
    void testgetByID(){
        projetService.getByID(1L);
        assertEquals(1L,"projet1");
    }


}
