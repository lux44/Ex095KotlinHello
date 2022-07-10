package com.lux.ex095kotlinhello

fun main(){
    //7. function 함수
    show()
    output(100,"Hello")
    var sum=sum(50,30)
    println(sum)
    println()

    //** 참고 : 리턴이 없는 함수의 리턴도 받을 수 있음.
    var x=display()
    println(x)      //void 가 아니라 Unit 이라는 자료형이 됨.
///////////////////////////////////////////////////////////////

    //함수 선언의 특이한 점
    //5. 함수 선언의 단순화,,
    var data= getData()
    println(data)

    var data2= getData2(5)
    println(data2)

    var data3= getData2(15)
    println(data3)
    ////////////////////////////////

    println()
    //6. 익명 함수 - 이름이 없는 함수
    aaa()
    bbb()
    ccc()
    ddd()
    eee()
    println()

    ggg("Android")
    hhh("ios")
    iii("hybrid")
    jjj("nice")
    kkk("어려워 힝")
    lll("sam",20)
    println()
    ///////////////////

    val m=mmm()
    println(m)
    println(nnn())
    println(ooo())
    println(ppp())
    println(qqq(10,5))
    println(rrr(20,5))
    println(stringLength("Hello Nice to meet you"))
    ////////////////////////////////////////////////////
    // 함수를 변수에 대입 할 수 있고 그 변수를 다시 다른 변수에 대입할 수 있음.
    val a5:(String)->Int= stringLength
    a5("kkk")

    // "고차함수"  :  함수의 파라미터로 다른 함수를 전달받는 함수
    sss(100)
    ttt(10, sss)

    www("android", stringLength)
    www("ios",{str->str.length+1})
    www("456", stringLength)
    www("456",{s->s.toInt()})
    println()


    xxx(10,20)
    xxx()
    yyy(5,3)
    yyy(b=50)
    zzz("Hello",100)
    zzz(b=200,a="nice")

}//main
//10. 함수 파라미터의 default value
fun zzz(a:String,b:Int){
    println(a)
    println(b)
    println()
}

fun yyy(a:Int=5000,b:Int){
    println(a)
    println(b)
    println()
}


fun xxx(a:Int=0,b:Int=1000){
    println(a)
    println(b)
    println()
}


//9. 고차함수
val www=fun (str:String,aaa:(String)->Int){
    val a=aaa(str)
    println("결과 : $a")
}


val sss=fun (a:Int){
    println("sss : $a")
}
val ttt=fun (num:Int, kkk:(Int)->Unit){
    println("num : $num")
    kkk(500)
}

//8. 리턴 타입이 있는 익명함수
val stringLength:(String)->Int={
    s -> s.length
}

val rrr:(Int,Int)->Int={   a,b->a+b   }

val qqq:(Int,Int)->Int=fun (a:Int,b:Int):Int{
    return a+b
}

val ppp:()->Int={
    40
    50
    //마지막에 쓴 실행문이 리턴값
    60
}

val ooo:()->Int={
    30   //fun() 키워드를 생략했다면 return 키워드도 생략해야 함.
}

val nnn:()->Int=fun ():Int{
    return 20
}

val mmm=fun():Int{
    return 10
}

//7. 파라미터 있는 익명함수
var lll:(String,Int)->Unit={
    name, age -> println("$name : $age")
}

var kkk={
    s:String-> println("글자수 : ${s.length}")
}

//매개변수가 1개라면 생략 가능함
var jjj:(String)->Unit={
    //생략한 파라미터는 자동으로 it 이라는 키워드로 참조됨
    println("글자수 : ${it.length}")
}

var iii:(String)->Unit={
    s -> println("글자수 : ${s.length}")
}

var hhh:(String)->Unit=fun(s:String){
    println("글자수 : ${s.length}")
}

var ggg=fun(s:String){
    println("글자수 : ${s.length}")
}

//6. 익명 함수
//var fff= println("fff")    //이건 익명함수가 아님, {}까지 생략하면 안됨.

//굳이 변수 타입을 명시하지 않아도 자동 추론되므로
var eee={ println("eee")}

//이러고 보니 어차피 참조변수의 타입으로 함수임을 알 수 있으니
//익명 함수 만들때 fun 키워드가 꼭 필요한가?
    var ddd:()->Unit={
        println("ddd")
    }

    var ccc:()->Unit=fun():Unit{
        println("ccc")
    }
//함수가 이름이 없으면 호출이 불가
// 이름이 없으니 함수를 참조하는 참조변수에 대입 [마치 객체 참조하듯이]
//함수를 참조하는 변수 bbb가 이제 함수 이름이 됨.
    var bbb=fun(){
        println("bbb")
    }

    fun aaa(){
        println("aaa")
    }
//함수 이름을 지우고 그냥 만들면 에러
//fun(){
//    println("bbb")
//}


//5. 함수 선언의 단순화 - 리턴 키워드를 할당 연산자(=)로 바꿀 수 있음.
//fun getData():String {
//    return "Hello"
//}

//위 함수를 줄인 표현
    fun getData():String="Hello"

//좀 더 복잡한 함수도 줄여쓰기
    fun getData2(num:Int):String=if (num<10) "Good" else "Bad"


//4.리턴이 없는 함수도 리턴 타입이 있음. 단지, 생략 할 수 있었던 것임. [void 같은 역할]
fun display(){
    println("display")
    println()
}

//3. 리턴을 하는 함수 - 리턴 타입을 명시하는 위치 : 함수명 () 다음에 타입을 명시함.
fun sum(a:Int,b:Int):Int{
    return a+b
}

//2. 파라미터 전달 함수 - var, val 키워드 사용 하지 않음 쓰면 에러남 : 자동으로 무조건 val 로 선언됨.     변수 이름:자료형
fun output(a:Int,b:String){
    println(a)
    println(b)      //매개변수는 무조건 val
    println()
}

//1. 함수를 정의할때 리턴 타입의 위치에 fun 키워드 사용
fun show(){
    println("show function")
    println()
}