package com.lux.ex095kotlinhello

fun main(){
    //상속
    var obj=Second()
    obj.a=10
    obj.b-20
    obj.show()
    println()

    //업캐스팅, 다운캐스팅
    var f:First=Second()    //부모 -> 자식 [업캐스팅]
    f.show()    //실제 참조하는 객체의 show() 가 발동
    //f.aaa()     //자식의 고유멤버는 인식 불가

    //다운캐스팅을 하면 사용 할 수 있다.
    //var s:Second=f      //자식 -> 부모 X [형변환]
    //코틀린의 형변환 연산자 as
    val s:Second= f as Second
    s.show()
    s.aaa()
    println()

    //상속 마무리 연습
    var p=Person("sam",20)
    p.show()
    println()

    var stu=Student("robin",22, "kotlin android")
    stu.show()
    println()

    var alba=AlbaStudent("hong",25,"java android", "Pc task")
    alba.show()
    println()

    var pro=Professor("tom",44,"programming")
    pro.show()
    println()


}

//상속해줄 클래스 - open 키워드를 적용해야만 상속해줄 수 있음.
open class First{
    //Property - 멤버변수
    var a:Int=10

    //메소드 - 멤버메소드
    //오버라이드를 허용하려면 open 키워드 필요
    open fun show(){
        println("a: $a")
    }
}

//First 를 상속하는 클래스 - 반드시 부모 클래스의 생성자를 명시적으로 호출해야 함
class Second : First(){
    var b:Int=20

    //상속받은 show() 메소드의 기능을 개선 ,, override
    //코틀린은 반드시 override 키워드를 명시해야만 함.
    override fun show(){
        super.show()
        println("b: $b")
    }

    //자식클래스가 가지는 고유한 메소드
    fun aaa(){
        println("Second 클래스의 고유 메소드")
    }
}
