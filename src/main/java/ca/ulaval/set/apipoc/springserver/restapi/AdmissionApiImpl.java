package ca.ulaval.set.apipoc.springserver.restapi;

import ca.ulaval.set.apipoc.restapi.api.AdmissionApiDelegate;
import ca.ulaval.set.apipoc.restapi.model.RechercherEtablissementsEnseignementFrequentes200Response;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Set;
import java.util.UUID;

@Service
public class AdmissionApiImpl implements AdmissionApiDelegate {

    @Override
    public ResponseEntity<RechercherEtablissementsEnseignementFrequentes200Response>
            rechercherEtablissementsEnseignementFrequentes(UUID idDossierAdmission, Set<String> references) {
        return ResponseEntity.ok(new RechercherEtablissementsEnseignementFrequentes200Response(
                Collections.emptyList(), Collections.emptyList()));
    }
}
