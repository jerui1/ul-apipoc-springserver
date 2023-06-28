package ca.ulaval.set.apipoc.springserver.restapi;

import ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.DossierAdmissionEntiteDto;
import ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.RechercheEtablissementEnseignementFrequenteCmdDto;
import ca.ulaval.set.apipoc.admission.application.in.etablissementEnseignement.EtablissementEnseignementEntiteDto;
import ca.ulaval.set.apipoc.admission.application.usecase.*;
import ca.ulaval.set.apipoc.restapi.api.AdmissionApiDelegate;
import ca.ulaval.set.apipoc.restapi.model.*;
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

    private final CreerDossierAdmissionUC creerDossierAdmissionUC;

    private final CreerEtablissementEnseignementUC creerEtablissementEnseignementUC;
    private final RechercherEtablissementEnseignementsQuery rechercherEtablissementEnseignementsQuery;
    private final EtablissementEnseignementConvertisseurRest etablissementEnseignementConvertisseur;

    private final CreerEtablissementEnseignementFrequenteUC creerEtablissementEnseignementFrequenteUC;
    private final RechercherDossierAdmissionsQuery rechercheDossierAdmissionsQuery;
    private final DossierAdmissionConvertisseurRest dossierAdmissionConvertisseur;

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

    @Override
    public ResponseEntity<UUID> admissionCandidatsDossieradmissionPut(
            AdmissionCandidatsDossieradmissionPutRequest putRequest) {

        UUID id = this.creerDossierAdmissionUC.apply(putRequest.getNi());

        return ResponseEntity.ok(id);
    }

    @Override
    public ResponseEntity<UUID> putAdmissionEtablissementenseignement(
            PutAdmissionEtablissementenseignementRequest putRequest) {

        UUID id = this.creerEtablissementEnseignementUC.apply(
                putRequest.getNomEtablissementEnseignement(), putRequest.getCodePays());

        return ResponseEntity.ok(id);
    }

    @Override
    public ResponseEntity<List<EtablissementEnseignement>> getAdmissionEtablissementenseignement() {

        List<EtablissementEnseignementEntiteDto> dtoList = this.rechercherEtablissementEnseignementsQuery.apply();
        List<EtablissementEnseignement> apiList = dtoList.stream()
                .map(this.etablissementEnseignementConvertisseur::toRest)
                .collect(Collectors.toList());

        return ResponseEntity.ok(apiList);
    }

    @Override
    public ResponseEntity<List<DossierAdmission>> getDossieradmission(String ni) {

        List<DossierAdmissionEntiteDto> dtoList = this.rechercheDossierAdmissionsQuery.apply(ni);
        List<DossierAdmission> restList =
                dtoList.stream().map(this.dossierAdmissionConvertisseur::toRest).collect(Collectors.toList());

        return ResponseEntity.ok(restList);
    }

    @Override
    public ResponseEntity<UUID> putEtablissementenseignementfrequente(
            UUID iddossieradmission, PutEtablissementenseignementfrequenteRequest putRequest) {
        UUID uuid = this.creerEtablissementEnseignementFrequenteUC.apply(
                iddossieradmission, putRequest.getIdEtablissementEnseignement());
        return ResponseEntity.ok(uuid);
    }

    @Override
    public ResponseEntity<UUID> putAdmissionCandidatsEtudesanterieuresEtablissementsenseignementfrequentes(
            EtablissementEnseignementFrequente etablissementEnseignementFrequente) {
        return AdmissionApiDelegate.super.putAdmissionCandidatsEtudesanterieuresEtablissementsenseignementfrequentes(
                etablissementEnseignementFrequente);
    }
}
