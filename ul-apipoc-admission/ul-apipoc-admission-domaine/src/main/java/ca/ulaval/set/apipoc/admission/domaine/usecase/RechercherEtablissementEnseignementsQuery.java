package ca.ulaval.set.apipoc.admission.domaine.usecase;

import ca.ulaval.set.apipoc.admission.domaine.adapter.convertisseur.EtablissementEnseignementConvertisseur;
import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementRepositoryDomaine;
import ca.ulaval.set.apipoc.admission.domaine.in.etablissementEnseignement.EtablissementEnseignementEntiteDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class RechercherEtablissementEnseignementsQuery {

    private final EtablissementEnseignementRepositoryDomaine repositoryDomaine;
    private final EtablissementEnseignementConvertisseur etablissementEnseignementConvertisseur;

    public List<EtablissementEnseignementEntiteDto> apply() {
        List<EtablissementEnseignementEntiteDto> etablissementEnseignementEntiteDtos =
                this.repositoryDomaine.find()
                        .map(this.etablissementEnseignementConvertisseur::toDto)
                        .collect(Collectors.toList());

        return etablissementEnseignementEntiteDtos;
    }
}
