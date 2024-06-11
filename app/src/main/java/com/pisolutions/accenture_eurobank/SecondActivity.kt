package com.pisolutions.accenture_eurobank

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pisolutions.accenture_eurobank.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private var binding: ActivitySecondBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        //binding?.secondTitle?.text = getString(R.string.app_name)
        val name = intent.extras?.getString("name")
        binding?.secondTitle?.text = name ?: getString(R.string.app_name)
    }
}