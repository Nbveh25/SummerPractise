package ru.itis.summerpractise24_1

//4
class Builder(){
    private var mark: String = ""
    private var model: String = ""
    private var year: Int = 0

    fun setMark(mark: String) : Builder {
        this.mark = mark
        return this
    }

    fun setModel(model: String) : Builder {
        this.model = model
        return this
    }
    fun setYear(year: Int) : Builder {
        this.year = year
        return this
    }

    fun build() : Car {
        return Car(mark, model, year)
    }
}