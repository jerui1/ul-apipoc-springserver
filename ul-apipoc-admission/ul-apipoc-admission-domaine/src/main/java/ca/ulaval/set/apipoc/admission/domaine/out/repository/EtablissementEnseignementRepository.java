package ca.ulaval.set.apipoc.admission.domaine.out.repository;

import java.util.List;

public interface EtablissementEnseignementRepository {
    List<EtablissementEnseignementEntiteRepo> rechercher(RechercheCmdRepoDto rechercheCmdRepoDto);
}
