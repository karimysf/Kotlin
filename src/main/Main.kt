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
    val etu1 = Etudiant("youssoufi", "karim", 20, "karim.youssufi@gmail.com", hashMapOf(Matiere.RÉSEAUX to note), Semestre.S3)
    val etu2 = Etudiant("hassik", "salah", 21, "@gmail.com", hashMapOf(Matiere.BIG_DATA to note), Semestre.S3)
    val etu3 = Etudiant("ennadif", "anas", 22, null, hashMapOf(Matiere.ALGORITHMIQUE to 15.toFloat(),Matiere.ALGORITHMIQUE to 10.toFloat()), Semestre.S4)

    val notes = hashMapOf(Matiere.RÉSEAUX to note, Matiere.ALGORITHMIQUE to 18.toFloat(), Matiere.BASES_DE_DONNEES to 14.toFloat())
    etu2.notes = notes
    etu3.notes = notes
etu2.definirMatierePreferee(Matiere.DEVELOPPEMENT_MOBIL)
    etu2.verifierMatierePreferee()

    etu3.afficherInfos()

    etu2.afficherInfos()
    etu1.afficherInfos()
    prof1.ajouterMatiere(Matiere.RÉSEAUX)
    prof1.ajouterMatiere(Matiere.ALGORITHMIQUE)

    prof1.afficherMatieresEnCharge()


    prof1.supprimerMatiere(Matiere.RÉSEAUX)


    prof1.afficherMatieresEnCharge()

    val bulletin1 = BulletinDeNotes(etu1, etu1.notes, Semestre.S3)
   print(bulletin1)
}

fun afficher() {
    Matiere.values().forEach { it.afficherInfos() }
}
