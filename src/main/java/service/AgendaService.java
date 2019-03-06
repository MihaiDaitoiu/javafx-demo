package main.java.service;

import main.java.models.Abonat;

import java.util.List;

public interface AgendaService {

    List<Abonat> getAbonati();

    Abonat getAbonat(Long id);

    Abonat createAbonat(Abonat abonat);

    void removeAbonat(Long id);
}
