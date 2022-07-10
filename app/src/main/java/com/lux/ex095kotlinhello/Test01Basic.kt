package com.lux.ex095kotlinhello

//kotlin 언어 기초 문법 [코틀린 연습 사이트 : https://try.kotlinlang.org ]

//문법적인 주요 특징
//A. 문장의 끝을 나타내는 ; 을 사용하지 않음. 써도 에러는 아니지만 무시됨.
//B. 변수를 만들 때 자료형을 먼저 명시하지 않고 var, val 키워드를 사용함. 단, 자료형은 존재함. 없는게 아님.
//C. new 키워드가 없이 객체를 생성함. new String() --> String()
//D. 안전하게  null 을 다룰 수 있는 문법을 제공함.
//E. 코틀린은 함수형 언어이다. 즉, 함수를 객체처럼 변수에 저장하고 파라미터로 넘겨주는 등의 작업이 가능함. [객체지향언어가 아님]

// #. 프로그램의 시작 함수인 main 함수가 반드시 있어야 함.
// #. 함수를 정의할 때 리턴타입의 위치에 'fun' 키워드(function 의 약자) 사용
fun main() {

    /* .kt 코틀린 파일만 별도로 실행하려면 마우스 우클릭으로 해당 파일 run 메뉴 실행 [결과는 하단 run 탭에서 확인] */

    //1. 화면 출력 : print(), println() 함수
    print(10)
    print(3.14)
    print("nice")

    //print()는 자동으로 줄바꿈 되지 않음. 자동 줄바꿈을 하고 싶다면
    println()
    println("Hello kotlin")
    println(10)
    println(10.5)
    println('A')
    println(true)
    println(3 + 5)

    //변수명을 전달하면 변수 안에 있는 값이 출력됨.
    var a: Int = 10
    println(a)
    var b: String = "Hello"
    println(b)
    println()
    ///////////////////////////

    //2. 자료형과 변수
    //* 코틀린 자료형의 종류
    // 1) 기초타입 : Boolean, Byte, Char, Short, Int, Long, Float, Double [기본적으로 kotlin은 모든 변수가 객체임. 즉, 모두 참조변수임.]
    // 2) 참조타입 : String, Any(Java의 Object와 비슷), Unit(java의 void) 그 외 kotlin APIs, Java APIs,,,,

    //* 변수를 만드는 2가지 키워드 : var, val [문법 - var 변수명:자료형 or val 변수명:자료형 ]
    //2.1 var [ 값 변경이 가능한 변수 : variable ]
    var num: Int = 10
    println(num)

    var num2: Double = 3.14
    println(num2)

    //권장하지 않지만 변수만 먼저 만들고 나중에 값을 대입해도 됨. [지역변수만 가능함 - 추후 추가 설명]
    var num3: Float
    num3 = 5.23f

    //변수이므로 변수가 가지고 있는 값 변경 가능함
    num = 20
    num2 = 50.5
    num3 = 10.6f
    println(num)
    println(num2)
    println(num3)

    //자료형이 있는 변수이므로 다른 자료형을 대입하면 에러
    //num=3.14 //error [int에다가 Double 대입]
    //num2=50    //error [Double 변수에 Int 대입] - 자동형변환 없음.

    //명시적으로 형변환 하는 방법 [.to~~()로 변환 가능함 - 기초타입의 경우에만 사용]
    //num=(Int)3.14 //이런식의 자바 형변환 문법 없음.
    num = 3.14.toInt()
    num2 = 50.toDouble()
    println(num)
    println(num2)

    //문자열 string 객체
    var s: String = "Hello"
    println(s)
    //var s2:String= String("Nice")   //error - 단순 "문자열" 객체를 생성할때 String 생성자를 사용할 수 없음.[buffer나 byte 배열을 String으로 만들때만 사용]
    println()

    //2.2 val [ 값 변경이 불가한 읽기 전용 변수 : value ]
    val n1: Int = 100
    //n1=200  error
    println(n1)

    val n2: Boolean = true
    //n2=false         error
    println(n2)

    //권장하지 않지만 변수를 만들때 값을 지정하지 않으면 한 번은 대입 할 수 있음. - 그 이후로는 값 변경이 불가함.
    val n3: String
    n3 = "nice"
    //n3="good"       error
    println(n3)

    //## var, val 사용 팁 : 데이터를 가지는 변수는 var [ex) 이름, 나이, title,,,,,],
    // 객체를 참조하는 변수는 val [ex) TextView, ImageView, NotificationManager,,,,]

    //2.3 자료형을 생략하며 변수 선언이 가능함. - 자료형은 자동 추론됨.
    var aa = 20   //Int로 추론
    println(aa)

    var bb = 3.14     //Double 추론
    println(bb)

    var cc = 3.14f    //Float 추론
    println(cc)

    var dd = true //Boolean
    println(dd)

    var ee = 'A'  //Char
    println(ee)

    val ff = "집에 가고 싶다"   //String
    println(ff)

    //***주의! 자동추론되어도 정적 타입언어여서 다른 자료형 대입 불가 ***
    //ff=50   error

    //var gg      error : 자료형을 명시하지 않으면 값 대입이 되어 있어야 함.
    //gg=10

    //val hh    error
    //hh="aaa"

    //2.4 kotlin 만의 자료형 타입
    //Any 타입 [어떤 타입이든 참조 가능한 자료형] - Java 의 Object 와 비슷 : 최상위 클래스
    var v: Any
    v = 20
    println()
    println(v)

    v = 3.14
    println(v)

    v = "배고파"
    println(v)
    println()

    // ** 변수에 값을 대입할 때 특이점 [null 안전성 문법 - null 값을 저장할 수 있는 타입이 별도로 있음.]
    //코틀린은 자료형을 명시하면 기본적으로 null을 저장할 수 없음
    //var nn:Int=null //error
    //var s:String=null   //error

    //null 값을 가질 수 있는 타입의 변수라고 표시해야만 함. [nullable 변수]
    var nn: Int? = null
    var s2:String?=null
    println(nn)
    println(s2)
    println()

    //nullable 변수의 멤버 사용하기
    var bbb:String?="Hello"
    //println(bbb.length)     //error - null 일 수도 있어서
    println(bbb?.length)    // ?. null safety 연산자
    bbb=null
    println(bbb?.length)    //NullPointException 에러가 발생하지 않음.

    var t=null      //자동추론 [Any?]
    println(t)
    println()

    // ** 화면 출력의 format 만들기 ****
    println("Hello" +
            "kotlin" )

    //하지만 Number 타입에서 String 타입으로 자동 변환은 이루어지지 않음
    //println(10+"Hello")     //error
    //어처구니 없이 순서를 바꾸면 가능함
    println("hello" +
            10)
    //숫자를 먼저 쓰고 싶다면 Int 를 String 으로 변환
    println(""+10+"Nice")
    println(10.toString()+"Nice")

    //2개의 정수형 변수 값을 덧셈하여 출력하는 프로그램
    var nnn1=50
    var nnn2=30
    println(""+nnn1+"+"+nnn2+"="+(nnn1+nnn2))
    println(nnn1.toString()+"+"+nnn2.toString()+"="+(nnn1+nnn2))

    //위 2가지 모두 결합연산을 사용하기에 코드 가독성이 매우 떨어지고 작성도 번거로움
    //그래서 등장한 [문자열 템플릿] 이라는 문법을 사용함. - 마치 php 처럼
    println("$nnn1+$nnn2=${nnn1+nnn2}")

    //즉
    var name="sam"
    var age=20
    println("이름 : $name \n나이 : $age")
    

}