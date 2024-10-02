package jp.techacademy.hiroshi.kurita.calcapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import jp.techacademy.hiroshi.kurita.calcapp.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        binding = ActivitySecondBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val result = intent.getDoubleExtra("result", 0.0)

        binding.textView.text = "$result"

    }
}