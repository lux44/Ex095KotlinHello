package com.lux.ex095kotlinhello

// constructor 키워드는 생략 가능
class AlbaStudent (name: String, age: Int, major: String, var task:String) :Student(name, age, major){
    init {
        println("create Alba Student Instance")
    }

    override fun show() {
        println("name : $name   age : $age,   major : $major,   task : $task")
    }
}