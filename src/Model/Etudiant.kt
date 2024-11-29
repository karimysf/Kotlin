package Model

import Model.Personne

class Etudiant(
    nom: String,
    prenom: String,
    age: Int,
    email: String?,
    var notes: HashMap<Matiere, Float> = hashMapOf(), // Default empty notes map
    val semestre: Semestre = Semestre.S1
) : Personne(nom, prenom, age, email) {
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
        val emailDisplay = this.email ?: "PAS D'EMAIL"

        val notesInfo = if (this.notes.isEmpty()) "Pas de notes à afficher" else "Notes : $notes"

        println("Nom : $nom, Prénom : $prenom,Matricule:$matricule, Age : $age, Email : $emailDisplay, Semestre : $semestre, $notesInfo")

        verifierMatierePreferee()
    }
}
