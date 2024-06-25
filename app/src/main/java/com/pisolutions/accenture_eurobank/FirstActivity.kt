package com.pisolutions.accenture_eurobank

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.pisolutions.accenture_eurobank.databinding.ActivityFirstBinding
import com.pisolutions.accenture_eurobank.features.activity.FeatureActivity
import com.pisolutions.accenture_eurobank.features.fragment.FeatureFragment
import com.pisolutions.accenture_eurobank.features.network.FeatureNetworkActivity
import com.pisolutions.accenture_eurobank.features.score.ScoreActivity

class FirstActivity : AppCompatActivity() {

    private var binding: ActivityFirstBinding? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        setContentView(binding?.root)
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        binding?.firstBtnOne?.setOnClickListener {
            val intent = Intent(this@FirstActivity, FeatureActivity::class.java)
            startActivity(intent)
        }

        binding?.firstBtnTwo?.setOnClickListener {
            val fragmentContainer = binding?.firstFragmentContainer
            if (fragmentContainer != null) {
                fragmentContainer.visibility = View.VISIBLE
                binding?.firstButtonGroup?.visibility = View.GONE
                val transaction = supportFragmentManager.beginTransaction()
                transaction
                    .replace(fragmentContainer.id, FeatureFragment.newInstance())
                    .addToBackStack(null)
                transaction.commit()
            }
        }

        binding?.firstBtnThree?.setOnClickListener {
            val intent = Intent(this@FirstActivity, FeatureNetworkActivity::class.java)
            startActivity(intent)
        }

        binding?.firstBtnFour?.setOnClickListener {
            val intent = Intent(this@FirstActivity, ScoreActivity::class.java)
            startActivity(intent)
        }

        binding?.firstBtnFive?.setOnClickListener {
            finish()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        if (supportFragmentManager.fragments.isEmpty()) {
            binding?.firstFragmentContainer?.visibility = View.GONE
            binding?.firstButtonGroup?.visibility = View.VISIBLE
        }
    }
}