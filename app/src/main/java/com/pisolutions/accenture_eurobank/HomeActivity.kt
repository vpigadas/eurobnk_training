package com.pisolutions.accenture_eurobank

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pisolutions.accenture_eurobank.databinding.ActivityHomeBinding
import com.pisolutions.accenture_eurobank.list.List2Fragment
import com.pisolutions.accenture_eurobank.listview.RecyclerViewFragment

class HomeActivity : AppCompatActivity() {

    private var binding: ActivityHomeBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        val fragmentContainer = binding?.mainFragmentContainer

        if (fragmentContainer != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(fragmentContainer.id, RecyclerViewFragment())
            transaction.replace(fragmentContainer.id, List2Fragment())
            transaction.commit()
        }

    }
}