package ru.itis.summerpractise24_1

open class Car(
    val mark: String,
    val model: String,
    val year: Int) {

    override fun toString(): String {
        return "Car(mark = '$mark', model = '$model', year = $year)"
    }

    // 5
    fun race(car : Car): Car {
        return if (this.year > car.year) this else car;
    }

}