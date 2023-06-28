package ca.ulaval.set.apipoc.admission.application.out.repository.etablissementEnseignement;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface EtablissementEnseignementRepositoryPort {

    void persist(EtablissementEnseignementEntiteRepo entiteRepo);

    Stream<EtablissementEnseignementEntiteRepo> find();

    Optional<EtablissementEnseignementEntiteRepo> get(UUID idEtablissementEnseignement);
}
