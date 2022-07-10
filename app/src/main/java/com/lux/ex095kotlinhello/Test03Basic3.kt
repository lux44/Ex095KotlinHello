package com.lux.ex095kotlinhello

import java.util.jar.Manifest

fun main(){
    //6. 배열 Array& 컬렉션 Collection
    //6.1 배열 - 요소 개수의 변경이 불가능한 배열 : Array - 변수 선언 시에 [] 키워드가 사용 안 함
    //var arr:Array<Int> = arrayOf(10,20,30)  //배열 만드는 함수를 이용
    var arr= arrayOf(10,20,30)  //타입 추론
    //요소 값 출력
    println(arr[0])
    println(arr[1])
    println(arr[2])
    println()

    //요소 값 변경
    arr[0]=100
    println(arr[0])

    //특이한 점은 코틀린의 모든 변수는 객체 참조변수이고 모두 객체이므로
    //멤버 메소드를 보유하고 있음. 그렇기에 배열도 객체이면서
    //요소값을 변경하는 메소드도 보유하고 있음.
    arr.set(1, 200)     //1번 방의 값을 200으로 변경
    println(arr.get(1))
    println()
    //즉, 마치 리스트처럼 get(), set()을 보유하고 있음.
    //하지만 코틀린의 권장은 그냥 [] 사용

    //배열의 길이값... length 가 아님. 다 size 로 통일됨
    println("요소의 개수 : ${arr.size}")

    //배열 요소값 출력을 일일이 하기 짜증 그래서 반복문 사용
    for (i in 0 until 3){
        println(arr[i])
    }
    println()

    //인덱스 번호로 제어하지 말고 그냥 배열 요소값을
    //바로 반복하면 취득하여 처리 마치 for each 문법과 유사
    for (n in arr){
        println(n)      //n은 요소값 - 인덱스 아님
    }

    //혹시 배열의 인덱스 번호를 얻고 싶다면
    for (i in arr.indices){
        println(i)      //i 는 인덱스 번호를 의미
    }
    println()

    //혹시 인덱스와 값을 모두 받아 처리하고 싶다면
    for ((i,v) in arr.withIndex()){
        println("$i : $v")
    }
    println()

    //배열객체의 멤버에 forEach 기능 메소드가 있음.
    //함수형 프로그래밍 언어들의 배열에 공통으로 있는 기능
    //배열의 요소값 각각을 반복적으로 접근할때마다 {}의 코드가 실행되도록 forEach 라는 기능을 사용함.
    //{} 안에 생략된 변수 it 이 있으며 it 이 요소의 값을 가지고 있음.
//    arr.forEach {
//        println(it)
//    }     밑에 거랑 같음
    /*for (it in arr){
        println(it)
    }*/

    //배열을 만들때 자료형을 명시하여 같은 자료형만 저장하게 할 수 있음.
    //var arr2= arrayOf(10,true,"Hello")  //Any 타입으로 배열요소가 만들어짐.
    var arr3= arrayOf<Int>(10,20,30)    //다른 자료형을 넣으면 에러
    //<> 제네릭 표기가 다소 번거로워 보인다면
    var arr4= intArrayOf(10,20,30)
    //~~ArrayOf() 형태는 기초데이터 타입들은 모두 만들어져 있음. 참조형 없음

    //배열 참조변수의 자료형을 먼저 명시 해보기  [특정 자료형의 배열 타입]
    var arr6:IntArray= intArrayOf(1,2,3)

    //배열은 기본적으로 null 을 저장하지 않음.
    //근데 만약 배열요소의 시작값을 null 로 하고 싶다면
    var arr7= arrayOfNulls<Double>(5)
    for (t in arr7) println(t)
    println()

    //배열 참조 변수에 자동 추론을 하지 않고 자료형을 명시한다면
    //null 을 가질 수 있는 자료형으로 명시해야 함.
    var arr8:Array<Float?> = arrayOfNulls(3)
    //안드로이드에서 배열을 사용하는 모습
    var permissions= arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION)

    //배열은 한번 만들어지면 요소의 개수를 변경할 수 없음
    //요소의 개수가 동적인 Collection
    //6.2 자바의 Collection 과 같은 기능 클래스들
    //1) List -> 순서대로 저장됨, 인덱스 자동부여, 중복데이터 허용
    //2) Set -> 순선대로 저장되지 않음, 인덱스 번호 없음, 중복데이터 허용 하지 않음
    //3) Map -> 순서대로 저장되지 않음, [키, 벨류] 쌍으로 되어있는 요소가 저장됨, Key 는 중복 불가, data 는 중복 허용

    //코틀린의 Collection 들은 모두 요소의 추가/삭제 및 변경이 불가능한 종류와 가능한 종류로 나뉘어짐.
    //6.2.1 : 요소의 개수 추가/삭제/변경이 불기능한 컬렉션들 : listOf(), setOf(), mapOf()
    //6.2.2 : 요소의 개수 추가/삭제/변경이 가능한 mutable 컬렉션들 : mutableListOf(), mutableSetOf(), mutableMapOf()

    //6.2.1 요소의 변경이 불가한 컬렉션
    // 1) List
    val list:List<Int> = listOf(10,20,30,20)
    for (i in list){
        println(i)
    }
    println()

    //값의 추가/삭제/변경에 관련된 기능메소드가 없음 add, remove, set 다 에러!!!!!
    //배열보다 더 엄격한 배열,, 요소 개수 변경 및 값 변경도 못함.

    // 2) Set
    val set:Set<Double> = setOf(3.14, 2.22, 5.55, 3.14)     //중복데이터 3.14는 저장 안됨
    for (e in set){
        println(e)
    }
    println()

    // 3) Map
    // 3.1) Pari 객체 이용
    val map:Map<String, String> = mapOf(Pair("title","Hello"),Pair("msg","nice to meet you"))
    println("요소개수 : ${map.size}")
    for ((key, value) in map) println("$key : $value")

    // 3.2) to 키워드 이용
    val map2:Map<String, String> = mapOf("id" to "mrhi", "pw" to "1234")
    println("요소개수 : ${map2.size}")
    for ((key, value) in map2) println("$key : $value")
    println()


    //6.2.2 요소의 추가/삭제/변경이 가능한 컬렉션들 : mutable
    // 1) MutableList
    val aaa:MutableList<Int> = mutableListOf(10,20,30)
    println("요소 개수 : ${aaa.size}")
    aaa.add(40)
    aaa.add(0,50)   //특정 위치 지정
    println("요소 개수 ㅣ ${aaa.size}")
    //aaa.set(1, 200)     //특정 위치 값 변경 가능
    aaa[1] = 200        //이 표기법을 권장
    for (e in aaa) println(e)
    println()
    // 2) MutableSet
    val bbb:MutableSet<Double> = mutableSetOf()
    bbb.add(5.55)
    bbb.add(3.14)
    bbb.add(5.55)   //중복 데이터를 저장하면 자동으로 무시됨
    for (e in bbb) println(e)
    println()

    // 3) MutableMap
    val ccc:MutableMap<String, String> = mutableMapOf("name" to "sam", Pair("tel", "01012345679"))
    println(ccc.size)
    ccc.put("address", "seoul")
    for ((k,v) in ccc) println("$k : $v")
    println()

    //개발자가 배열이 아니라 컬렉션을 사용한다는 것은 요소의 변경을 의도한 경우가 많음
    //그래서 대부분 mutable Collection 을 사용함

    




}