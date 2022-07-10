package com.lux.ex095kotlinhello

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

// 대략적인 코틀린 코딩 방식 살펴보기

//kotlin에서 클래스 상속 키워드 ":" 이며 상속하는 클래스명 옆에 주생성자를 호출하는()가 필수임.
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //변수는 var 키워드 사용
        var  btn:Button =findViewById(R.id.btn)    //문장의 끝인 ; 이 필수 아님.
        btn.setOnClickListener {
            clickBtn()
        }
    }

    //kotlin 에서 함수는 fun 키워드 사용
    fun clickBtn(){
        var tv = findViewById<TextView>(R.id.tv)
        //tv.setText("nice to meet you")

        //kotlin 에서는 set~~~() 메소드를 권장하지 않음.
        //그냥 ~~~를 멤버변수 다루듯이 대입하는 코딩스타일 권장
        tv.text="nice to meet you"
    }

    //Override 메소드가 Java 에서는 @Override 어노테이션 사용했지만
    //kotlin 에서는 override 키워드를 메소드 앞에 명시함.
    override fun onResume() {
        super.onResume()
        //kotlin 으로 개발할때 안드로이드 스튜디오 편집기가 Toast 자동완성 기능을 제공하지 않음.
        //소문자로 toast 를 써야 자동완성 써줌.
        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show()
    }
}