package ca.ulaval.set.apipoc.admission.persistance;

import ca.ulaval.set.apipoc.admission.domaine.out.repository.EtablissementEnseignementEntiteRepo;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.EtablissementEnseignementRepository;
import ca.ulaval.set.apipoc.admission.domaine.out.repository.RechercheCmdRepoDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EtablissementEnseignementRepositoryJpa implements EtablissementEnseignementRepository {

    private final ArrayList<EtablissementEnseignementEntiteRepo> etablissements;

    public EtablissementEnseignementRepositoryJpa() {
        etablissements = new ArrayList<>();
        etablissements.add(new EtablissementEnseignementEntiteRepo(UUID.randomUUID(), "ca", "Univ Laval"));
        etablissements.add(new EtablissementEnseignementEntiteRepo(UUID.randomUUID(), "fr", "Paris Dauphine"));
    }

    @Override
    public List<EtablissementEnseignementEntiteRepo> rechercher(RechercheCmdRepoDto rechercheCmdRepoDto) {

        List<EtablissementEnseignementEntiteRepo> collected = this.etablissements.stream()
                .filter(et -> et.getCodePays().equalsIgnoreCase(rechercheCmdRepoDto.codePays()))
                .collect(Collectors.toList());

        return collected;
    }
}
