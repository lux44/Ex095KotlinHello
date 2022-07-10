package com.lux.ex095kotlinhello

open class Person constructor(var name:String, var age:Int) {
    init {
        println("created Person Instance")
    }
    open fun show(){
        println("name : $name   age : $age")
    }
}