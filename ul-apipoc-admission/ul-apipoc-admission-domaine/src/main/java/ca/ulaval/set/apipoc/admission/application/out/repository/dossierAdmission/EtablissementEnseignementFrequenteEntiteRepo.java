package ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission;

import ca.ulaval.set.apipoc.admission.application.out.repository.etablissementEnseignement.EtablissementEnseignementEntiteRepo;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotNull;
import java.util.UUID;

import static ca.ulaval.set.apipoc.admission.application.out.repository.dossierAdmission.EtablissementEnseignementFrequenteEntiteDomaine_Constraints.*;

@Data
@Accessors(chain = true)
@EqualsAndHashCode(exclude = {"idEtablissementEnseignementFrequente", "dossierAdmissionParent"})
@ToString(exclude = "dossierAdmissionParent")
public class EtablissementEnseignementFrequenteEntiteRepo {

    private UUID idEtablissementEnseignementFrequente;

    @NotNull
    private DossierAdmissionEntiteRepo dossierAdmissionParent;

    @ValidEtablissementEnseignement
    private EtablissementEnseignementEntiteRepo etablissementEnseignement;

    @ValidVersion
    private Integer version;
}
