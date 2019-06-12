package com.example.myapplication1

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    var isAdd: Boolean = false
    var isSubtract: Boolean = false
    var isMultiply: Boolean  = false
    var isDivide: Boolean = false
    var x: Double = 0.0
    var y: Double = 0.0
    var answer: Double = 0.0
    var isResult: Boolean = false
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun addTxtString(view: View){
        var b: Button = view as Button

        when(b.text as String){
            "x" as String -> {isMultiply = true
                    isSubtract=false
                    isAdd = false
                    isDivide = false
                    x = textView.text.toString().toDouble()
                    textView.text = ""}
            "-" -> {isMultiply = false
                    isSubtract=true
                    isAdd = false
                    isDivide = false
                    x = textView.text.toString().toDouble()
                    textView.text = ""}
            "+" -> {isMultiply = false
                    isSubtract=false
                    isAdd = true
                    isDivide = false
                    x = textView.text.toString().toDouble()
                    textView.text = ""}
            "/" -> {isMultiply = false
                    isSubtract=false
                    isAdd = false
                    isDivide = true
                    x = textView.text.toString().toDouble()
                    textView.text = ""}
            "=" -> {
                answer()
            }
            "CLEAR" -> {
                x = 0.0
                y = 0.0
                answer = 0.0
                isMultiply = false
                isSubtract=false
                isAdd = false
                isDivide = false
                isResult = false
                textView.text = ""
            }
            else -> {
                if(isResult){textView.text = ""}
                var txt: String? = textView.text as String

                var btnHit: String? = b.text.toString()
                textView.text = txt as String + btnHit as String
            }
        }





    }

    fun answer(){
        y = textView.text.toString().toDouble()

        if(isMultiply){
            answer = (x * y)
        }   else if (isSubtract){
            answer = (x - y)
        }   else if (isDivide){
            answer = (x / y)
        } else if (isAdd){
            answer = (x + y)
        }
        textView.text = answer.toString()
        x = answer
        isMultiply = false
        isSubtract=false
        isAdd = false
        isDivide = false
    }
}
