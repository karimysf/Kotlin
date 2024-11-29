package Model

import Model.Personne
import Model.Matiere

class Enseignant(
    nom: String,
    prenom: String,
    age: Int,
    email: String?,
    val speciality: String,
    val Salaire: Float
) : Personne(nom, prenom, age, email) {

    val matieresEnCharge: ArrayList<Matiere> by lazy { ArrayList<Matiere>() }

    override fun afficherInfos() {
        var email = this.email
        var adresse = this.adressePostale

        if (email == null)
            email = "PAS D'EMAIL"
        if (adresse == null)
            adresse = "Pas D'adresse"

        println("Nom: $nom Prénom: $prenom Âge: $age Email: $email Spécialité: $speciality Adresse postale: $adresse")
    }

    fun ajouterMatiere(matiere: Matiere) {
        if (!matieresEnCharge.contains(matiere)) {
            matieresEnCharge.add(matiere)
            println("Matière ${matiere.name} ajoutée à la liste.")
        } else {
            println("La matière ${matiere.name} est déjà assignée.")
        }
    }

    fun supprimerMatiere(matiere: Matiere) {
        if (matieresEnCharge.contains(matiere)) {
            matieresEnCharge.remove(matiere)
            println("Matière ${matiere.name} supprimée de la liste.")
        } else {
            println("La matière ${matiere.name} n'est pas dans la liste.")
        }
    }

    fun afficherMatieresEnCharge() {
        if (matieresEnCharge.isEmpty()) {
            println("Aucune matière assignée.")
        } else {
            println("Matières en charge de $prenom $nom :")
            matieresEnCharge.forEach { println(it.name) }
        }
    }
}
