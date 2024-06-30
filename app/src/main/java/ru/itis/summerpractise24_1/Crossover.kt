package ru.itis.summerpractise24_1

class Crossover (
    mark: String,
    model: String,
    year: Int,
    val drive: DriveType,
    var power: Int
) : Car(mark, model, year) {

}