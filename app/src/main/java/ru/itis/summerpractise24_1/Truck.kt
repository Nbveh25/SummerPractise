package ru.itis.summerpractise24_1

class Truck(
    mark : String,
    model : String,
    year : Int,
    val liftingCapacity : Int
) : Car(mark, model, year){
}