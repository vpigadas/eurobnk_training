package com.pisolutions.accenture_eurobank.features.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pisolutions.accenture_eurobank.databinding.ActivityFeatureBinding

class FeatureActivity : AppCompatActivity() {

    private var binding: ActivityFeatureBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeatureBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        binding?.featureExit?.setOnClickListener {
            finish()
        }
    }
}