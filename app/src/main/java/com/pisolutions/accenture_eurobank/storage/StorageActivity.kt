package com.pisolutions.accenture_eurobank.storage

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pisolutions.accenture_eurobank.databinding.ActivityStorageBinding

class StorageActivity : AppCompatActivity() {

    private var binding: ActivityStorageBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityStorageBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        val preferences = getPreferences(MODE_PRIVATE)
        val sharedPreferences = getSharedPreferences("abc", MODE_PRIVATE)

        val fragmentContainer = binding?.storageFragmentContainer
        binding?.storageTitle?.text = sharedPreferences.getInt("number", 0).toString()

        if (fragmentContainer != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(fragmentContainer.id, StorageFragment())
            transaction.commit()
        }
    }
}