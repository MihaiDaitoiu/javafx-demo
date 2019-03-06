package main.java.dao;

import main.java.models.Abonat;

import java.util.List;

public interface AbonatDao {

    List<Abonat> getAllAbonati();

    Abonat createAbonat(Abonat abonat);

    Abonat getAbonat(Long id);

    List<Abonat> deleteAbonat(Long id);
}
