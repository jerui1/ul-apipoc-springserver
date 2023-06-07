package ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission;

import ca.ulaval.set.apipoc.admission.domaine.entite.etablissementEnseignement.EtablissementEnseignementEntiteDomaine;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.UUID;

import static ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine_Constraints.*;


public record EtablissementEnseignementFrequenteEntiteDto(

        @NotNull
        UUID idEtablissementEnseignementFrequente,

        UUID idDossierAdmission,

        @ValidEtablissementEnseignement
        EtablissementEnseignementEntiteDomaine etablissementEnseignement,
        @ValidVersion
        Integer version
) {

}
