package com.lux.ex095kotlinhello

fun main() {
    //안드로이드 많이 사용되는
    //1, inner class & interface 및 익명클래스
    //2. static 대신에 사용하는 companion object [동반객체]
    //3. 늦은 초기화 - lateinit, by lazy

    //1) 이너 클래스
    //AAA.BBB()   //이너클래스는 아우터 클래스만 만들 수  있음.
    val obj = AAA()
    val obj2 = obj.getBBBinstance()
    obj2.show()

    //2. 인터페이스
    //val listner=ClickListener()     //인터페이스는 곧바로 객체 생성 불가
    val listener = Test()
    listener.onClick()

    //3. 익명 클래스를 이용 - 클래스를 설계하면서 객체 생성
    val c =object :ClickListener{
        override fun onClick() {
            println("익명 클래스 click")
            println()
        }
    }
    c.onClick()

    //4. 동반객체 [companion object - static 키워드와 유사한 기능 : 객체 생성 없이 사용 가능한 멤버들]
    //코틀린은 static 키워드가 없음.
    //println(Sample.a)   //error
    println(Sample.title)
    Sample.show()

    //5. 늦은 초기화
    //5-1) lateinit - var 변수에 적용 [기본형에 적용이 안됨.]
    //5-2) by lazy - val 변수에 적용 - 기본형도 가능함.
    val h = Hello()
    h.onCreate()
    h.show()
}
//5.
class Hello{
    lateinit var name:String  //초기화를 미룰 수 있음.
    //lateinit var age:Int  error
    //lateinit val kkk:String  error

    //by lazy {} 안에 실행문은 이 프로퍼티가 처음 사용될때 실행됨.
    val address:String by lazy { "aaa" }
    val age:Int by lazy{if (10>5) 20 else 40}

    fun onCreate(){
        name="sam"
    }
    fun show(){
        println("name : $name")
        println("address : $address")   //이 때 by lazy{} 가 발동함.
    }
}

//4.
class Sample{
    var a:Int=10

    //companion object - static 을 대신함.
    companion object{
        var title:String="Hello" //java 의 static variable 과 같은 역할

        fun show(){     //java 의 static 메소드와 같은 역할
            println("제목 : $title")

            //a=100 ///error
        }
    }
}


//2. 인터페이스 - 추상메소드만 보유한 클래스
interface ClickListener{
    //자동 추상 메소드
    fun onClick()
}
//인터페이스를 구현한 클래스 설계
class Test :ClickListener{      // () 가 없음
    override fun onClick() {
        TODO("Not yet implemented")
        println("click")
        println()
    }

}

//1. 클래스 안에 이너클래스
class AAA{
    var a:Int=0

    fun show(){
        println("AAA 클래스의 show method..")
    }

    //이너클래스 객체를 만들어서 리턴해주는 함수
    fun getBBBinstance():BBB{
        return BBB()
    }

    //inner class - 자바와 다르게 단순히 안에 있다고 이너 클래스라고 하지 않음.
    //inner 키워드를 붙여야만 inner class 이다.
    //특징 - 1. 아우터 클래스만 만들 수 있는 클래스
    //      2. 아우터의 멤버를 내 것인양 쓸 수 있다.
    inner class BBB{
        fun show(){
            println("AAA 클래스의 프로퍼티 a : $a")

            //아우터(AAA)의 show() 호출하기
            this@AAA.show()
        }
    }
}