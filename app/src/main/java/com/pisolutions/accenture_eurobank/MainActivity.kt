package com.pisolutions.accenture_eurobank

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentContainerView
import com.pisolutions.accenture_eurobank.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(a: Bundle?) {
        super.onCreate(a)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

    }


    override fun onPostCreate(a: Bundle?) {
        super.onPostCreate(a)

        val fragmentContainer: FragmentContainerView? = binding?.mainFragmentContainer
        val fragmentContainer2 = binding?.mainFragmentContainer2
        if (fragmentContainer != null) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(fragmentContainer.id, BlankFragment())
            fragmentTransaction.commit()
        }

        if (fragmentContainer2 != null) {


            val fragment = BlankFragment()
            val parameters = Bundle()
            parameters.putString("name", "Vassilis")
            parameters.putInt("age", 100)
            fragment.arguments = parameters
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(fragmentContainer2.id, BlankFragment())
            fragmentTransaction.commit()

        }

//        val intent = Intent(this,SecondActivity::class.java)
//        startActivity(intent)

        if (fragmentContainer2 != null) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(fragmentContainer2.id, BlankFragment())
            fragmentTransaction.commit()

        } else if (fragmentContainer != null) {
//            val fragmentTransaction = supportFragmentManager.beginTransaction()
//            fragmentTransaction.add(fragmentContainer.id, BlankFragment())
//            fragmentTransaction.commit()

            fragmentDisplay(BlankFragment(), fragmentContainer)
        }
        fragmentDisplay(BlankFragment(), fragmentContainer)
    }

    fun fragmentDisplay(f: BlankFragment, fragmentContainer: FragmentContainerView?) {
        if (fragmentContainer != null) {
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(fragmentContainer.id, f)
            fragmentTransaction.commit()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 5000) {
            Activity.RESULT_OK
            Activity.RESULT_CANCELED
            data?.extras?.keySet()?.forEach {
                Log.d("TAG keys", it.plus(" value ->").plus(data.extras?.getInt(it)))
            }

            Log.d("TAG", resultCode.toString())
        }
    }
}