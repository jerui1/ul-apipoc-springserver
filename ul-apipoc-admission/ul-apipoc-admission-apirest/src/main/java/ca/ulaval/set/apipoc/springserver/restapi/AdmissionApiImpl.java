package ca.ulaval.set.apipoc.springserver.restapi;

import ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission.RechercheEtablissementEnseignementFrequenteCmdDto;
import ca.ulaval.set.apipoc.admission.domaine.usecase.RechercherEtablissementEnseignementFrequenteQuery;
import ca.ulaval.set.apipoc.restapi.api.AdmissionApiDelegate;
import ca.ulaval.set.apipoc.restapi.model.EtablissementEnseignementFrequente;
import ca.ulaval.set.apipoc.restapi.model.RechercherEtablissementsEnseignementFrequentes200Response;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class AdmissionApiImpl implements AdmissionApiDelegate {

    private final RechercherEtablissementEnseignementFrequenteQuery rechercherEtablissementEnseignementFrequenteQuery;
    private final EtablissementEnseignementFrequenteConvertisseurRest etablissementEnseignementFrequenteConvertisseur;

    @Override
    public ResponseEntity<RechercherEtablissementsEnseignementFrequentes200Response>
            rechercherEtablissementsEnseignementFrequentes(UUID idDossierAdmission, String codePays) {

        List<EtablissementEnseignementFrequente> resultats = this.rechercherEtablissementEnseignementFrequenteQuery
                .apply(new RechercheEtablissementEnseignementFrequenteCmdDto(idDossierAdmission, codePays))
                .stream()
                .map(this.etablissementEnseignementFrequenteConvertisseur::toRest)
                .collect(Collectors.toList());

        return ResponseEntity.ok(new RechercherEtablissementsEnseignementFrequentes200Response(resultats));
    }
}
