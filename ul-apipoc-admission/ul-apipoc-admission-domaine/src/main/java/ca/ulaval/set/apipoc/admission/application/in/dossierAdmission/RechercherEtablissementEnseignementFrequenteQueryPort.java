package ca.ulaval.set.apipoc.admission.application.in.dossierAdmission;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.UUID;

public interface RechercherEtablissementEnseignementFrequenteQueryPort {

    @NotNull List<EtablissementEnseignementFrequenteEntiteDto> apply(
            @NotNull @Valid RechercheEtablissementEnseignementFrequenteCmdDto rechercheCmdDto);

    record RechercheEtablissementEnseignementFrequenteCmdDto(
            UUID idDossierAdmission, String codePays) {}
}
