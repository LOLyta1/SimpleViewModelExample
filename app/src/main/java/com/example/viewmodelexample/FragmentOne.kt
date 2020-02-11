package com.example.viewmodelexample

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import kotlinx.android.synthetic.main.fragment_one.view.*

class FragmentOne:Fragment() {
   lateinit var  viewModel: SimpleViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.let {
            viewModel = ViewModelProviders.of(it).get(SimpleViewModel::class.java)
        }

    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_one,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.plus_button.setOnClickListener {
            viewModel.countA=viewModel.countA+1
        }

        view.minus_button.setOnClickListener {
            viewModel.countA=viewModel.countA-1
        }

        view.open_button.setOnClickListener {
            activity?.supportFragmentManager?.beginTransaction()
                ?.replace(R.id.container,FragmentTwo(), "fragment_two")
                ?.addToBackStack("go_to_fragment_two")
                ?.commit()
        }
    }
}