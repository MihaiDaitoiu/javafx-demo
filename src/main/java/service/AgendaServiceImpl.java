package main.java.service;

import main.java.dao.AbonatDao;
import main.java.dao.AbonatInJavaMemoryDaoImpl;
import main.java.models.Abonat;

import java.util.Comparator;
import java.util.List;

public class AgendaServiceImpl implements AgendaService {

    //this should be done with dependency injection
    private AbonatDao abonatDao = new AbonatInJavaMemoryDaoImpl();

    @Override
    public List<Abonat> getAbonati() {
        List<Abonat> abonati = abonatDao.getAllAbonati();

        abonati.sort(Comparator.comparing(Abonat::getNume));

        return abonati;
    }

    @Override
    public Abonat getAbonat(Long id) {
        return abonatDao.getAbonat(id);
    }

    @Override
    public Abonat createAbonat(Abonat abonat) {
        return abonatDao.createAbonat(abonat);
    }

    @Override
    public void removeAbonat(Long id) {
        abonatDao.deleteAbonat(id);

    }
}
