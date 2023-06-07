package ca.ulaval.set.apipoc.admission.domaine.in.dossierAdmission;


import java.util.UUID;


public record RechercheEtablissementEnseignementFrequenteCmdDto(
        UUID idDossierAdmission,  String codePays) {}
