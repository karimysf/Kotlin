package Model

data class BulletinDeNotes(
    val etudiant: Etudiant,
    val notes: Map<Matiere, Float>,
    val semestre: Semestre
) {
    val moyenneGenerale: Float by lazy {
        var total = 0.toFloat()
        var totalCoefficients = 0.toFloat()

        notes.forEach { (matiere, note) ->
            total += note * matiere.coefficient
            totalCoefficients += matiere.coefficient
        }

        if (totalCoefficients == 0.toFloat()) 0f else total / totalCoefficients
    }

    val mention: String by lazy {
        when {
            moyenneGenerale >= 16 -> "Très Bien"
            moyenneGenerale >= 14 -> "Bien"
            moyenneGenerale >= 12 -> "Assez Bien"
            moyenneGenerale >= 10 -> "Passable"
            else -> "Non validé"
        }
    }

    override fun toString(): String {
        val dateGeneration = java.time.LocalDate.now()

        // Construction de l'affichage des notes
        val notesAffichage = if (notes.isNotEmpty()) {
            notes.entries.joinToString("\n") { (matiere, note) ->
                "- ${matiere.name.uppercase()} : ${"%.1f".format(note)} / 20"
            }
        } else {
            "Pas de notes à afficher."
        }

        return """
        ******** Bulletin de Notes ********
        Généré le : $dateGeneration
        Nom & Prénom : ${etudiant.nom} ${etudiant.prenom}
        Semestre : $semestre

        --- Notes par Matière ---
        $notesAffichage

        Moyenne Générale : ${"%.2f".format(moyenneGenerale)}
        Mention : $mention
        ************************************
    """.trimIndent()
}}
