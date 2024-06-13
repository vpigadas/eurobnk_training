package com.pisolutions.accenture_eurobank

import android.app.Activity
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

        val fragmentContainer = binding?.mainFragmentContainer
        val fragmentContainer2 = binding?.mainFragmentContainer2
        if (fragmentContainer != null){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(fragmentContainer.id, BlankFragment())
            fragmentTransaction.commit()
        }

        if(fragmentContainer2 != null){
            val fragmentTransaction = supportFragmentManager.beginTransaction()
            fragmentTransaction.add(fragmentContainer2.id, BlankFragment())
            fragmentTransaction.commit()

        }

//        binding?.mainBtnNext?.setOnClickListener {
//            Log.d("App", "btn clicked!!!")
//        }
//
//        binding?.mainBtnNext?.setOnLongClickListener {
//            Log.d("App", "btn long clicked!!!")
//            return@setOnLongClickListener false
//        }
//
//        binding?.mainImgAndroid?.setOnClickListener {
//            Log.d("App", "img clicked!!!")
//
//            val intent = Intent(this@MainActivity, SecondActivity::class.java)
//            intent.putExtra("name", getString(R.string.dev_name))
////            startActivity(intent)
//            startActivityForResult(intent, 5000)
//        }
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