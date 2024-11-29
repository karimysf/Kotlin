package Model

class Enseignant(nom:String, prenom:String, age:Int, email:String?,adresse:String?,
                 val specialite:String, val salaire:Float):Personne(nom,prenom,age,email,adresse?:"non encore renseigné"){

    val matieresEnCharge: ArrayList<Matiere> by lazy { ArrayList<Matiere>() }

    override fun afficherInfos() {
        println("nom: $nom prenom: $prenom  Âge: $age ${email?:"email non encore renseigné"} " +
                "Spécialité: $specialite Adresse postale: $adressePostal")
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
