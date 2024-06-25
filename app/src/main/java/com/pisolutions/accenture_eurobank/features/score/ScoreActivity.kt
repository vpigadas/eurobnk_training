package com.pisolutions.accenture_eurobank.features.score

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.pisolutions.accenture_eurobank.R
import com.pisolutions.accenture_eurobank.databinding.ActivityScoreBinding

class ScoreActivity : AppCompatActivity() {

    private var binding: ActivityScoreBinding? = null
    private lateinit var viewModel: ScoreViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this).get(ScoreViewModel::class.java)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        viewModel.onStart()

        val fragmentContainerTop = binding?.fragmentContainerTop
        if(fragmentContainerTop != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(fragmentContainerTop.id,ScoreFragment.newInstance())
            transaction.commit()
        }

        val fragmentContainerBottom = binding?.fragmentContainerBottom
        if(fragmentContainerBottom != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(fragmentContainerBottom.id,ScoreCountFragment.newInstance())
            transaction.commit()
        }
    }
}