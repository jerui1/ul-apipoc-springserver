package ca.ulaval.set.apipoc.admission.domaine.in.etablissementEnseignement;

import java.util.UUID;

import static ca.ulaval.set.apipoc.admission.domaine.in.etablissementEnseignement.EtablissementEnseignementEntiteDomaine_Constraints.*;

public record EtablissementEnseignementEntiteDto(
        UUID idEtablissementEnseignement,
        @ValidNomEtablissementEnseignement String nomEtablissementEnseignement,
        @ValidCodePays String codePays,
        @ValidCodeProvinceEtat String codeProvinceEtat,
        @ValidEstEtablissementUniversitaire Boolean estEtablissementUniversitaire) {}
