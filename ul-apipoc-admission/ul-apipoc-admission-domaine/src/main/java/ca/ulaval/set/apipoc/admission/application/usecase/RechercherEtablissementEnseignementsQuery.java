package ca.ulaval.set.apipoc.admission.application.usecase;

import ca.ulaval.set.apipoc.admission.application.adapter.etablissementEnseignement.EtablissementEnseignementConvertisseur;
import ca.ulaval.set.apipoc.admission.application.in.etablissementEnseignement.EtablissementEnseignementEntiteDto;
import ca.ulaval.set.apipoc.admission.application.in.etablissementEnseignement.RechercherEtablissementEnseignementsQueryPort;
import ca.ulaval.set.apipoc.admission.application.adapter.etablissementEnseignement.EtablissementEnseignementRepositoryDomaine;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RechercherEtablissementEnseignementsQuery implements RechercherEtablissementEnseignementsQueryPort {

    private final EtablissementEnseignementRepositoryDomaine repositoryDomaine;
    private final EtablissementEnseignementConvertisseur etablissementEnseignementConvertisseur;

    @Override
    public List<EtablissementEnseignementEntiteDto> apply() {
        List<EtablissementEnseignementEntiteDto> etablissementEnseignementEntiteDtos =
                this.repositoryDomaine.find()
                        .map(this.etablissementEnseignementConvertisseur::toDto)
                        .collect(Collectors.toList());

        return etablissementEnseignementEntiteDtos;
    }
}
