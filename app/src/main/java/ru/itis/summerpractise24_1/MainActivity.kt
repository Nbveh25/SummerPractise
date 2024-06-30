package ru.itis.summerpractise24_1

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val race_btn = findViewById<Button>(R.id.btn_Race)
        val carCount_et = findViewById<EditText>(R.id.et_CarCount)

        race_btn.setOnClickListener{
            val inputValue = carCount_et.text.toString()
            val carCount = inputValue.toInt()
            val cars : ArrayList<Car> = createRandomCars(carCount)
            startRace(cars)
        }
    }

    private fun createRandomCars(carCount : Int) : ArrayList<Car> {
        val marks = listOf("Toyota", "Ford", "Lamborghini", "Maserati", "Porsche", "Dodge")
        val models = listOf("AE-86", "Aventador", "Mustang", "Countach", "911", "Challengger")

        var cars : ArrayList<Car> = ArrayList()
        for (i in 1..carCount) {
            val year = Random.nextInt(1980, 2024)
            val car = Builder()
                .setMark(marks.random())
                .setModel(models.random())
                .setYear(year)
                .build()
            cars.add(car)
        }

        return cars
    }

    private fun startRace(cars: ArrayList<Car>) {
        var winners : ArrayList<Car> = ArrayList()
        winners = cars
        while (winners.size > 1) {
            winners = startRound(winners)
        }
        println("Победитель: " + winners.get(0))
    }

    private fun startRound(cars: ArrayList<Car>) : ArrayList<Car> {
        var winners : ArrayList<Car> = ArrayList()

        while (cars.size != 0) {
            if (cars.size == 1) {
                winners.addAll(cars)
                println("Нет пары, следующий круг")
                break
            } else {
                var index1 = Random.nextInt(0, cars.size)
                var index2: Int = Random.nextInt(0, cars.size)
                while (index1 == index2){
                    index2 = Random.nextInt(0, cars.size)
                }

                var car1 : Car = cars.get(index1)
                var car2 : Car = cars.get(index2)

                var winner : Car = car1.race(car2)

                winners.add(winner)
                // вывод победителей
                println("Гонка между ${car1} и ${car2}, Победитель: ${winner}")

                cars.remove(car1)
                cars.remove(car2)
            }
        }

        return winners
    }
}