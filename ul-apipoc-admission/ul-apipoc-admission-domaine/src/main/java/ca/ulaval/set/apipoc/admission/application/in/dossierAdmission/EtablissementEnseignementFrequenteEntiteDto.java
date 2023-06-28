package ca.ulaval.set.apipoc.admission.application.in.dossierAdmission;

import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;

import javax.validation.constraints.NotNull;
import java.util.UUID;

import static ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine_Constraints.ValidEtablissementEnseignement;
import static ca.ulaval.set.apipoc.admission.application.in.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine_Constraints.ValidVersion;

public record EtablissementEnseignementFrequenteEntiteDto(
        @NotNull UUID idEtablissementEnseignementFrequente,
        UUID idDossierAdmission,
        @ValidEtablissementEnseignement EtablissementEnseignementEntiteDomaine etablissementEnseignement,
        @ValidVersion Integer version) {}
