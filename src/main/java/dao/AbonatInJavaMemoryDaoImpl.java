package main.java.dao;

import main.java.models.Abonat;
import main.java.models.Adresa;

import java.util.ArrayList;
import java.util.List;

/**
 * This keep the list of "Abonati" in the memory of the Java application. When the application
 * is closed, everything is lost.
 * TODO: create AbonatSavedInFileDaoImpl that saves everything to an external file so that nothing is lost
 * TODO: create AbonatSavedInDbImpl that persists everything in a real database
 */
public class AbonatInJavaMemoryDaoImpl implements AbonatDao {


    private static List<Abonat> AGENDA = new ArrayList<>();
    private static Long INDEX = 0L;

    static {
        AGENDA.add(new Abonat(INDEX++, "Popescu", "George", new Adresa("Romania", "Brasov", "Toamnei")));
        AGENDA.add(new Abonat(INDEX++, "Ionescu", "Vasile", new Adresa("Romania", "Bucuresti", "Magheru")));

    }

    @Override
    public List<Abonat> getAllAbonati() {
        return AGENDA;
    }

    @Override
    public Abonat createAbonat(Abonat abonat) {
        abonat.setId(INDEX++);
        AGENDA.add(abonat);
        return abonat;
    }

    @Override
    public Abonat getAbonat(Long id) {
        return AGENDA.stream().filter(a -> a.getId().equals(id)).findFirst().orElse(null);
    }

    @Override
    public List<Abonat> deleteAbonat(Long id) {

        Abonat abonatToDelete = getAbonat(id);
        if (abonatToDelete != null) {
            AGENDA.remove(abonatToDelete);
        }
        return AGENDA;
    }
}
