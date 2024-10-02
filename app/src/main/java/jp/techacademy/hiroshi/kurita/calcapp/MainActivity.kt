package jp.techacademy.hiroshi.kurita.calcapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import jp.techacademy.hiroshi.kurita.calcapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binging: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binging = ActivityMainBinding.inflate(layoutInflater)
        val view = binging.root
        setContentView(view)

        binging.button1.setOnClickListener(this)
        binging.button2.setOnClickListener(this)
        binging.button3.setOnClickListener(this)
        binging.button4.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        val intent = Intent(this, SecondActivity::class.java)

        val str1 = binging.editText1.text.toString()
        if (str1.isBlank()) {
            binging.editText1.error = "入力が必要です"
            return
        }
        val num1 = str1.toDouble()

        val str2 = binging.editText2.text.toString()
        if (str2.isBlank()) {
            binging.editText2.error = "入力が必要です"
            return
        }
        val num2 = str2.toDouble()

        var result = 0.0

        when (v.id) {
            R.id.button1 -> {
                result = num1 + num2
            }
            R.id.button2 -> {
                result = num1 - num2
            }
            R.id.button3 -> {
                result = num1 * num2
            }
            R.id.button4 -> {
                if (num2 == 0.0) {
                    binging.editText2.error = "0で除算はできません"
                    return
                }
                result = num1 / num2
            }
        }

        intent.putExtra("result", result)
        startActivity(intent)
    }
}