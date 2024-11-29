package Model

enum class Matiere(
    val description: String?,
    val coefficient: Int,
    val semestre: Semestre
) {
    ALGORITHMIQUE("Introduction aux algorithmes", 3, Semestre.S1),
    SYSTEMES_INFORMATIQUES("Systèmes informatiques et architecture", 4, Semestre.S2),
    BASES_DE_DONNEES(" bases de données", 4, Semestre.S2),
    RESEAUX("Réseaux ", 3, Semestre.S3),
    GENIE_LOGICIEL(" logiciel", 5, Semestre.S4),
    DEVELOPPEMENT_WEB("Développement web", 4, Semestre.S5),
    DEVELOPPEMENT_MOBIL("Développement mobile", 4, Semestre.S5),
    BIG_DATA("BIG DATA", 5, Semestre.S6),
    CLOUD_COMPUTING(" Cloud Computing", 5, Semestre.S6);

    fun afficherInfos() {
        println("NOM: ${name}\nDescription (Majuscules): ${description?.uppercase()?:"non encore renseingné"}\n Description(Minuscules) :${description?.lowercase()?:"non encore renseingné"}"+
                "\nCoefficient: $coefficient\nSemestre: $semestre")
    }

    fun afficherToutesLesMatieres() {
        Matiere.values().forEach { it.afficherInfos() }
    }
}