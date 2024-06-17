package com.pisolutions.accenture_eurobank.database

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.room.Room
import com.pisolutions.accenture_eurobank.databinding.FragmentDatabaseBinding

class DatabaseFragment : Fragment() {

    private lateinit var binding: FragmentDatabaseBinding
    private var autoNumber = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDatabaseBinding.inflate(inflater)
        //binding = FragmentDatabaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val ctx = context
        if (ctx != null) {
            val database =
                Room.databaseBuilder(ctx, MyDatabaseInstance::class.java, "UserDatabase")
                    .allowMainThreadQueries()
                    .build()


            displayDatabaseList(database)

            binding.databaseInsert.setOnClickListener {
                val id = autoNumber++
                database.getUserDao()
                    .save(UserEntity(id, "Vassilis".plus(id), "Pigadas".plus(id), 100, "MDM"))

                displayDatabaseList(database)
            }
        }
    }

    private fun displayDatabaseList(database: MyDatabaseInstance) {

        val dataList = database.getUserDao().readAll()

        if (dataList.isEmpty()) {
            Log.d("Database", "EMPTY")
        } else {
            Log.d("Database", dataList.size.toString())
            dataList.forEach {
                Log.d("Database", it.toString())
            }
        }

        binding.databaseRecyclerView.adapter = DatabaseListAdapter(dataList)
    }
}