package com.lux.ex095kotlinhello

fun main(){
    println("kotlin OOP")

    //1. 클래스 선언 및 객체 생성 - new 키워드가 없어짐.
    val obj=MyClass()
    obj.show()

    //2. 별도의 파일로 클래스를 만들 수도 있음.
    val obj2=MyKotlinClass()
    obj2.show()

    //3. 생성자는 좀 많이 다름 좀 당혹스러울 정도
    //코틀린의 생성자는 2가지 종류 : 주생성자, 보조생성자
    //3.1 주 생성자 (primary constructor)
    val s=Simple()
    val s2=Simple2(10,200)
    var h=Human("sam",20, "seoul")
    h.show()

    // *** 주생성자 오버로딩은 안됨. ***

    //3.2 보조 생성자 (secondary constructor)
    val s3=Simple3()
    val ss3=Simple3(200)

    //3.3)주생성자 + 보조생성자
    val s4=Simple4()
    val ss4=Simple4(300)

    //3.4) 주생성자의 constructor() 키워드 생략 가능함
    Simple5()
    Simple6("robin",20)
}
//3.4) 주생성자의 constructor() 키워드 생략 가능함
class Simple6(var name:String,var age:Int){
    init {
        println("Simple6 constructor")
    }
}


class Simple5(){
    init {
        println("Simple5 constructor")
    }
}

//3.3) 주생성자 + 보조생성자
class Simple4 constructor(){
    init {
        println("Simple4 주생성자")
    }

    //주생성자가 있을때 보조생성자는 반드시 명시적으로
    //주생성자를 호출하는 코드를 써야함. this() 생성자 호출
    constructor(num:Int):this(){
        println("Simple4 의 보조생성자 오버로딩 : $num")
    }

}

//3.2) 보조 생성자 연습 클래스 -- 클래스 {} 영역 안에 constructor() 만들기
class Simple3 {
    constructor(){
        println("Simple3의 보조 생성자")
        println()
    }
    //보조 생성자는 오버로딩이 가능함.
    constructor(num:Int){
        println("Simple3 보조생성자 : $num")
        println()
    }

    //보조생성자의 파라미터에는 var, val 키워드 불가능
//    constructor(val a:Int){
//        //error
//    }

    //멤버변수
    var name:String=""
    var age:Int=0
    constructor(age: Int,name: String){
        this.name=name
        this.age=age
    }

}

//3.1) 주생성자 연습용 클래스 - 클래스명 옆에 constructor() 키워드

class Human constructor(var name:String, var age:Int, var address:String){
    fun show(){
        println("$name : $age - $address")
    }
}


//주생성자의 파라미터에 var, val 키워드 사용하면 이미 멤버변수임
class Simple2 constructor(num:Int, var num3:Int){

    val num2:Int=num    //주생성자의 매개변수를 멤버변수에 대입
    init {
        println("Simple2 primary constructor : $num")
        println("Simple2 primary constructor : $num2")
        println("Simple2 primary constructor : $num3")
    }

    fun show(){
        //println("num ; $num")   //인식불가. 주생성자의 매개변수는 init 이라는 영역 밖에서는 인식 불가
        println("num2 : $num2")     //멤버변수는 class 안에 어디서든 사용가능
        println("num3 : $num3")     //주생성자의 파라미터에 var, val 을 쓰면 멤버변수임.
    }
}

class Simple constructor(){
    // 주생성자는 실행 영역 {} 가 없음.
    // 그래서 존재하는 초기화 영역
    init {
        //객체가 생성될때 무조건 실행되는 영역
        println("Simple primary constructor")
        println()
    }
}

class MyClass{
    //멤버변수 [ Property : 프로퍼티 ] - 멤버변수는 반드시 초기화 되어야 함.
    var a:Int=10

    //멤버 함수 : Method
    fun show(){
        println("show : $a")
        println()
    }
}