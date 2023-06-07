package ca.ulaval.set.apipoc.admission.domaine.in;

import static ca.ulaval.set.apipoc.admission.domaine.in.EtablissementEnseignementFrequenteEntiteDomaine_Constraints.*;

public record EtablissementEnseignementDto(@ValidCodePays String codePays, @ValidLabel String label) {
}
