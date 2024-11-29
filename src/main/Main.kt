package main

import Model.*

fun main() {
    afficher()

    val prof1 = Enseignant("adil", "anwar", 23, null, "POO", 223000.toFloat())
    val note: Float = 20.toFloat()
    val prof2 = Enseignant("kabbaj", "issam", 23, "issam@gmail.com", "BACK-END", 223000.toFloat())
    prof2.afficherInfos()
    prof1.afficherInfos()

    // Instantiating Etudiant without providing matricule since it is generated in the init block
    val etudiant1 = Etudiant(
        "Othmane",
        "Othmane",
        21,
        null,
        null,
        semestre = Semestre.S1
    )
    val etudiant2 = Etudiant(
        "Salah",
        "Eddine",
        22,
        "salah@gmail.com",
        null,
        semestre = Semestre.S2
    )
    val etudiant3 = Etudiant(
        "Mehdi",
        "Mehdi",
        21,
        null,
        "Marrakech mhamid",
        semestre = Semestre.S3
    )

    etudiant1.notes[Matiere.ALGORITHMIQUE] = 16.5f
    etudiant1.notes[Matiere.BIG_DATA] = 18.0f
    etudiant1.notes[Matiere.RESEAUX] = 14.5f

    etudiant2.notes[Matiere.SYSTEMES_INFORMATIQUES] = 16.5f
    etudiant2.notes[Matiere.DEVELOPPEMENT_MOBIL] = 18.0f
    etudiant2.notes[Matiere.DEVELOPPEMENT_WEB] = 14.5f
    etudiant2.definirMatierePreferee(Matiere.DEVELOPPEMENT_MOBIL)
    etudiant2.verifierMatierePreferee()

    etudiant3.afficherInfos()

    etudiant2.afficherInfos()
    etudiant1.afficherInfos()
    prof1.ajouterMatiere(Matiere.RESEAUX)
    prof1.ajouterMatiere(Matiere.ALGORITHMIQUE)

    prof1.afficherMatieresEnCharge()


    prof1.supprimerMatiere(Matiere.RESEAUX)


    prof1.afficherMatieresEnCharge()

    val bulletin1 = BulletinDeNotes(etudiant1, etudiant1.notes, Semestre.S3)
   print(bulletin1)
}

