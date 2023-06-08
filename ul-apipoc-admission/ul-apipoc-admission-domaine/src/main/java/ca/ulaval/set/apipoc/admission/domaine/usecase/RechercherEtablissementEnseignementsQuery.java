package ca.ulaval.set.apipoc.admission.domaine.usecase;

import ca.ulaval.set.apipoc.admission.domaine.in.etablissementEnseignement.EtablissementEnseignementEntiteDto;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.etablissementEnseignement.EtablissementEnseignementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RechercherEtablissementEnseignementsQuery {

    private final EtablissementEnseignementRepository etablissementEnseignementRepository;
    private final EtablissementEnseignementConvertisseur etablissementEnseignementConvertisseur;

    public List<EtablissementEnseignementEntiteDto> apply() {
        List<EtablissementEnseignementEntiteDto> etablissementEnseignementEntiteDtos =
                this.etablissementEnseignementRepository
                        .find()
                        .map(this.etablissementEnseignementConvertisseur::toDomaine)
                        .map(this.etablissementEnseignementConvertisseur::toDto)
                        .collect(Collectors.toList());

        return etablissementEnseignementEntiteDtos;
    }
}
