package ca.ulaval.set.apipoc.admission.application.in.dossierAdmission;


import java.util.UUID;


public record RechercheEtablissementEnseignementFrequenteCmdDto(
        UUID idDossierAdmission,  String codePays) {}
