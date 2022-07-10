package com.lux.ex095kotlinhello

import android.app.AlertDialog

fun main() {
    //NPE [Null Pointer Exception] 에 대한 앱의 버그를 문법적으로 막아주기 위한 Null Safety 관련 문법

    //코틀린은 null 값을 저장할 수 있는 타입을 아예 명시적으로 구분하도록
    //var s1:String=null error - non nullable 변수
    var s2: String? = null     //nullable variable
    println(s2)

    //nullable 변수를 사용할 때 특이점 :
    var str1: String = "Hello"
    var str2: String? = "Nice"
    println("글자수 : ${str1.length} ")//ok
    //println("글자수 : ${str2.length}") //error 일 수도 있다.

    //해결책
    if (str2 != null) println("글자수 : ${str2.length}")

    //해결책2 if() 문이 조금 번거로움
    // ?.  연산자 - null safety 연산자
    println("글자수 : " + str2?.length)

    //진짜로 str2 가 null dlaus
    str2 = null
    println("글자수 : " + str2?.length)

    //만약 null 일때 null 결과 말고 다른 결과가 나오게 하고 싶다면?
    //null 이면 -1, 아니면 글자수
    val len = if (str2 != null) -str2.length else -1
    println("글자수 : $len")

    //if() else() 이 번거롭다면
    // 2) 앨비스 연산자 -    ?:
    val len2 = str2?.length ?: -1
    println("글자수 : $len2")

    //NPE 에러를 그냥 발생하겠다 즉, 자바처럼 그냥 하고 싶다면
    //3) non-null asserted      - !! 연산자
    var ss: String? = "Hello"
    //println(ss.length)  error
    println(ss!!.length)

    var ss2: String? = null
    //println(ss2!!.length) //error

    //4) 안전한 형변환 연산자 as?
    val mmm:MMM= MMM()

    //val zzz:ZZZ=mmm as ZZZ
    //println(zzz.a)

    val zzz:ZZZ?=mmm as? ZZZ  //안전한 캐스트를 사용했다면 결과가 null 일 수도 있음.
    println(zzz)

    //5) scope 함수 : apply, let, run, also

    //어떤 객체의 멤버를 여러개 사용할 때
    val crew= Crew()
    crew.name="sam"
    crew.age=20
    crew.address="seoul"
    crew.show()

    var crew2= Crew()
    crew2.apply {
        this.name="robin"  //this 가 crew2 를 의미함
        age=30
        address="Busan"
        show()
    }

    val crew3=Crew()
    crew3.let {
        it.name="hong"  //it 이 crew3 을 의미함.
        it.age=12
        it.show()
    }

//    val builder:AlertDialog.Builder=AlertDialog.Builder(this)
//    builder.apply {
//        setTitle("")
//        setMessage("d")
//        setPositiveButton("ok", null)
//        setNegativeButton("cancle",null)
//    }



}
class Crew(){
    var name:String?=null
    var age:Int?=null
    var address:String?= null

    fun show(){
        println("$name    $age    $address")
    }
}

class MMM{
    var a= 10
}

class ZZZ{
    var a =20
}