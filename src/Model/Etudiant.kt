package Model

import Model.Personne

class Etudiant(nom:String, prenom:String, age:Int, email:String?, adresse:String?,
                val notes:HashMap<Matiere,Float> = hashMapOf(), val semestre: Semestre):Personne(nom,prenom,age,email,adresse?:"non encore renseigné") {
    var matricule: String= genererMatricule()
    lateinit var matierePreferee: Matiere

    companion object {
        private var compteurMatricule = 1

        fun genererMatricule(): String {
            return "ETUDIANT-${compteurMatricule.toString().padStart(4, '0')}"
        }

        fun incrementerCompteur() {
            compteurMatricule++
        }
    }

    init {
        if (matricule == genererMatricule()) {
            incrementerCompteur()
        }
    }

    fun definirMatierePreferee(matiere: Matiere) {
        matierePreferee = matiere
    }

    fun verifierMatierePreferee() {
        if (::matierePreferee.isInitialized) {
            println("Matière préférée : ${matierePreferee.name}")
        } else {
            println("La matière préférée n'est pas définie")
        }
    }

    override fun afficherInfos() {
        println("nom: $nom prenom: $prenom  Âge: $age ${email?:"email non encore renseigné"} " +
                "Adresse postale: $adressePostal Matricule: $matricule\n" +
                "    Semestre: $semestre Notes: ${if (notes.isEmpty()) "Aucune note" else notes}" )
    }
}
