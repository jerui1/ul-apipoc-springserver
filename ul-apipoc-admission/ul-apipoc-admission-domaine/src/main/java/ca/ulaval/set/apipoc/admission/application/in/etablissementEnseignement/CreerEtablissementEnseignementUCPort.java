package ca.ulaval.set.apipoc.admission.application.in.etablissementEnseignement;

import java.util.UUID;

public interface CreerEtablissementEnseignementUCPort {
    UUID apply(String nomEtablissementEnseignement, String codePays);
}
