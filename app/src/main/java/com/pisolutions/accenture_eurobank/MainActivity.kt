package com.pisolutions.accenture_eurobank

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.pisolutions.accenture_eurobank.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        binding?.mainBtnNext?.setOnClickListener {
            Log.d("App", "btn clicked!!!")
        }

        binding?.mainBtnNext?.setOnLongClickListener {
            Log.d("App", "btn long clicked!!!")
            return@setOnLongClickListener false
        }

        binding?.mainImgAndroid?.setOnClickListener {
            Log.d("App", "img clicked!!!")

            val intent = Intent(this@MainActivity, SecondActivity::class.java)
            intent.putExtra("name", getString(R.string.dev_name))
            startActivity(intent)
        }
    }
}