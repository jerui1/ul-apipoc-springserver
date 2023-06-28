package ca.ulaval.set.apipoc.admission.application.adapter.etablissementEnseignement;

import ca.ulaval.set.apipoc.admission.application.out.repository.etablissementEnseignement.EtablissementEnseignementRepositoryPort;
import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;
import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementRepositoryDomainePort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class EtablissementEnseignementRepositoryDomaine implements EtablissementEnseignementRepositoryDomainePort {

    private final EtablissementEnseignementRepositoryPort etablissementEnseignementRepository;
    private final EtablissementEnseignementConvertisseur etablissementEnseignementConvertisseur;
    private final EtablissementEnseignementEntiteDomaine.Outillage outillage;

    public Stream<EtablissementEnseignementEntiteDomaine> find() {
        Stream<EtablissementEnseignementEntiteDomaine> stream = this.etablissementEnseignementRepository
                .find()
                .map(ee -> this.etablissementEnseignementConvertisseur.toDomaine(ee, outillage));
        return stream;
    }

    public Optional<EtablissementEnseignementEntiteDomaine> get(UUID idEtablissementEnseignement) {
        return this.etablissementEnseignementRepository
                .get(idEtablissementEnseignement)
                .map(ee -> this.etablissementEnseignementConvertisseur.toDomaine(ee, outillage));
    }
}
