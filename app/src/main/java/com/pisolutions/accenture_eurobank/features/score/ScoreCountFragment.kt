package com.pisolutions.accenture_eurobank.features.score

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.pisolutions.accenture_eurobank.databinding.FragmentScoreCountBinding

class ScoreCountFragment : Fragment() {

    private lateinit var binding: FragmentScoreCountBinding
    private lateinit var viewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val act = activity
        viewModel = when (act) {
            is Activity -> ViewModelProvider(act).get(ScoreViewModel::class.java)
            else -> ViewModelProvider(this).get(ScoreViewModel::class.java)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentScoreCountBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.scoreCountBtnLeft.setOnClickListener {
            viewModel.increaseNumber()
        }

        binding.scoreCountBtnRight.setOnClickListener {
            viewModel.decreaseNumber()
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ScoreCountFragment()
    }
}