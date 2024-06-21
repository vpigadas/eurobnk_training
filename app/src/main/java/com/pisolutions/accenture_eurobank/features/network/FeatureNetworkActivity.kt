package com.pisolutions.accenture_eurobank.features.network

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.pisolutions.accenture_eurobank.databinding.ActivityFeatureNetworkBinding
import com.pisolutions.accenture_eurobank.features.network.fragment.NetworkMainFragment
import com.pisolutions.accenture_eurobank.features.network.fragment.NetworkSecondFragment

class FeatureNetworkActivity : AppCompatActivity() {

    private var binding: ActivityFeatureNetworkBinding? = null
    private lateinit var viewModel: NetworkViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFeatureNetworkBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        viewModel = ViewModelProvider(this).get(NetworkViewModel::class.java)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        val fragmentContainer = binding?.featureNetworkFragment

        if (fragmentContainer != null) {
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(fragmentContainer.id, NetworkMainFragment.newInstance())
            transaction.commit()
        }

        viewModel.streamSelectedItem.observe(this, Observer {
            if (fragmentContainer != null) {
                val transaction = supportFragmentManager.beginTransaction()
                transaction.replace(fragmentContainer.id, NetworkSecondFragment.newInstance(it))
                    .addToBackStack(null)
                transaction.commit()
            }
        })
    }

    override fun onResume() {
        super.onResume()

        Log.d("TAG Activity", "selected item value -> ".plus(viewModel.selectedItem))
    }
}