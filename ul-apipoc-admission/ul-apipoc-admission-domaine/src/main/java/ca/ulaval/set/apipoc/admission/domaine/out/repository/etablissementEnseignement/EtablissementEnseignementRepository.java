package ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface EtablissementEnseignementRepository {

    void persist(EtablissementEnseignementEntiteRepo entiteRepo);

    Stream<EtablissementEnseignementEntiteRepo> find();

    Optional<EtablissementEnseignementEntiteRepo> get(UUID idEtablissementEnseignement);
}
