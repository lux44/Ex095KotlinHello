package com.lux.ex095kotlinhello

open class Student constructor(name: String, age: Int, var major:String) :Person(name, age) {
    init {
        println("create Student Instance")
    }

    //ovverride - 자동으로 open 으로 적용됨
    override fun show() {
        println("name : $name,   age:$age,     major:$major")
    }
}