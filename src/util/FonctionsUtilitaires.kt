package utils

import Model.BulletinDeNotes
import Model.Matiere

fun calculerMoyenneParMatiere(bulletins: List<BulletinDeNotes>): Map<Matiere, Float> {
    return bulletins
        .flatMap { it.notes.entries }
        .groupBy({ it.key }, { it.value })
        .mapValues { (_, notes) -> notes.average().toFloat() }
}

fun matieresAvecMoyenneSup12(bulletins: List<BulletinDeNotes>): List<Matiere> {
    return calculerMoyenneParMatiere(bulletins)
        .filter { (_, moyenne) -> moyenne > 12 }
        .map { it.key }
}

fun etudiantsAvecMoyenneSup10(bulletins: List<BulletinDeNotes>): List<BulletinDeNotes> {
    return bulletins.filter { it.moyenneGenerale >= 10 }
}

fun trierEtudiantsParMoyenneDesc(bulletins: List<BulletinDeNotes>): List<BulletinDeNotes> {
    return bulletins.sortedByDescending { it.moyenneGenerale }
}
