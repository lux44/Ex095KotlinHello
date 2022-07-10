package com.lux.ex095kotlinhello

//무조건 main() 함수가 프로그램 시작점
fun main(){
    //3. 연산자 특이점 ///////////
    //숫자 타입 간의 연산은 자동 형변환이 수행됨
    println(10+3.14)    //작은 것-> 큰 것

    //숫자 타입이 아닌 자료형과는 자동 형변환이 수행되지 않음
    //println(10+true)      error
    //println(10+'A')       error  -> Char 은 숫자 타입이 아님 그래서 연산이 불가능

    //자료형을 체크해주는 연산자 : is
    var n=10
    if (n is Int) {
        println("n4변수는 Int 타입입니다.")
    }
    var s:String="Hello"
    if (s is String) println("s 변수는 String 입니다.")
    if (s is String?)  println("s 변수는 String 입니다.")
    //is 는 nullanle 자료형을 다른 자료형으로 구분하지 않음.

    if (s !is String) println("s 는 String 이 아닙니다.")

    //is 는 다른 자료형은 문법적으로 검사해주지 않음
    //if (n is String){}  //error

    //결국 is 는 Any 타입을 검사할때 사용함.
    var obj:Any
    obj=10
    if (obj is Int) println("${obj} 는 Int 입니다.")
    if (obj is Double) println("${obj} 는 Double 입니다.")

    //java 의 instance of 연산자와 비슷한 기능

    class Person{
        //코틀린에서는 멤버변수는 무조건 초기화가 되어 있어야 함.
        var name:String="sam"
        var age=20
    }
    //Person p = new Person()
    var p=Person()
    if (p is Person){
        println(p.name +","+p.age)
    }
    var obj2:Any
    obj2=Person()
    if (obj2 is Person){
        //is 조건이 참인 영역 안에서는 obj2 참조변수가 자동으로 다운 캐스팅이 됨.
        println(obj2.name +":" +obj2.age)
    }

    //비트 연산자가 없음. 대신 비트 연산자들에 대응하는 메소드가 있으며 가독성을 높인 표기법도 제공함.
    //println(7|3) error - 비트 연산 기호가 없음
    var k:Int=7
    println(k.or(3))
    println(k or 3)
    println(true and false)
    //println(3.14 and 5.55) error : Double 타입은 Bit 연산 안됨, 문자열도 안됨. 정수나 불린 타입에서만 쓸 수 있음.
    ////////////

    //4. 제어문에서 특이한 점!
    //제어문의 종류 : if, when, while, for [switch 없음]

    //삼항연산자가 없고 if 문이 대신함.
    //var str=(10>5)?"Hello":"Nice"  //error
    var str=if (10>5) "Hello" else "Nice"
    //if 문이 결과를 만들어냄. 마치 연산자처럼

    //혹시  if 문 안에 실행문이 여러개일때는 마지막 값이 결과값
    str=if (10<5) {
        "zzz"
        "aaa"
    }else{
        "www"
        println("else")
        "bbb"
    }
    println(str)

    //이런 특징때문에 if 문을 if 표현식이라고 부름.
    println()

    //4.2 switch 문법이 없음. 대신 when,, 더 업그레이드 됨.
    var h:Any? = null

    h=10
    when(h){
        10-> println("aaa")
        20-> println("bbb")
        "Hello"-> println("Hello")
        n-> println("n 변수값과 같다.")
        30,40-> println("30 or 40")

        else -> {
            println("ccc")
            println("ddd")
            println("default")
        }
    }
    //when 도 if 처럼 표현식이어서 결과값을 대입할 수 있음.
    h=20
    var result=when(h){
        10->"Hello"
        20->"Nice"
        else->{
            println("add")
            "else"
        }
    }
    println(result)

    //when 을 특정 수식으로 제어하고 싶다면
    var score=85
    when{
        //score>=90 &&  score<100-> println("A학점 입니다.")
        score in 90..100 -> println("A학점입니다.")
        score>=80-> println("B학점입니다.")
        score>=70-> println("C학점입니다.")
        score>=60-> println("D학점입니다.")
        else-> println("F학점입니다.")
    }

    //5. 반복문
    // while 문은 특별할 게 없음, 똑같음
    // for 문은 작성문법이 완전 다름.

    //0부터 5까지 6번 반복하는 반복문
    for (i in 0..5){
        println(i)
    }
    println()
    for (n in 0 until 10){  //0~9까지
        println(n)
    }
    println()

    //2칸씩 증가
    for (r in 0..10 step 2) println(r)
    println()

    //값의 감소는 (downTo)
    for (n in 10 downTo 0) println(n)
    println()
    for (n in 10 downTo 0 step 3) println(n)
    println()

    // break, continue 는 동일함

    //권장하지는 않지만 break 에 의해서 멈추는 반복문을 선택할 수 있음.
    for (n in 0..5){
        if (n==3) break
        print("$n   ")
    }
    println()

    for (y in 0..5){
        print("$y : ")
        for (x in 0..10){
            if (x==6) break
            print("$x  ")
        }
        println()
    }

    println()

    //@ label 을 통해 break 될 반복문을 선택 할 수 있음.
    kkk@ for (y in 0..5){
        print("$y : ")
        for (x in 0..10){
            if (x==6) break@kkk
            print("$x  ")
        }
        println()
    }
}