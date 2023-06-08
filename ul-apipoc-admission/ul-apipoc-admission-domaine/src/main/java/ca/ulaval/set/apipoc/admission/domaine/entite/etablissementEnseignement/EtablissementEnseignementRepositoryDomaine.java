package ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement;

import ca.ulaval.set.apipoc.admission.domaine.convertisseur.EtablissementEnseignementConvertisseur;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementRepositoryPort;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.stream.Stream;

@Service
@AllArgsConstructor
public class EtablissementEnseignementRepositoryDomaine {

    private final EtablissementEnseignementRepositoryPort etablissementEnseignementRepository;
    private final EtablissementEnseignementConvertisseur etablissementEnseignementConvertisseur;

    public Stream<EtablissementEnseignementEntiteDomaine> find() {
        Stream<EtablissementEnseignementEntiteDomaine> stream = this.etablissementEnseignementRepository.find()
                .map(this.etablissementEnseignementConvertisseur::toDomaine);
        return stream;
    }
}
