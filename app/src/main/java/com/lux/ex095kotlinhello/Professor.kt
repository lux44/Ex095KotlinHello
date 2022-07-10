package com.lux.ex095kotlinhello

//보조생성자로 적용해보기 - 부모클래스명 옆에 () 를 쓰지 않고 super() 생성자로 호출
class Professor :Person{

    var subject:String?=null

    constructor(name:String, age:Int,subject:String) : super(name, age) {
        this.subject=subject
        println("create Professor Instance")
    }

    override fun show() {
        println("name : $name,   age:$age,     subject:$subject")
    }
}