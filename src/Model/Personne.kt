package Model

import Model.AgeInvalideException

abstract class Personne(val nom: String, val prenom: String, val age: Int, val email: String? = null) {
    var adressePostale: String = ""

    init {
        if (age < 18) {
            throw AgeInvalideException()
        }
    }


    constructor(nom: String, prenom: String, age: Int, email: String?, adressePostale: String) :
            this(nom, prenom, age, email) {
        this.adressePostale = adressePostale
    }

    abstract fun afficherInfos()
}

