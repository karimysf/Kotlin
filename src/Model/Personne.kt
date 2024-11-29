package Model

import Model.AgeInvalideException

abstract class Personne(val nom:String, val prenom:String,val age:Int,val email:String?) {

    init {
        if ( age<18) throw AgeInvalideException()
    }

    var adressePostal: String? = null
    constructor(nom:String, prenom:String, age:Int, email:String?, adressePostal:String) : this(
        nom,prenom,age,email
    ){
        this.adressePostal = adressePostal;
    }

    abstract fun afficherInfos()
}
