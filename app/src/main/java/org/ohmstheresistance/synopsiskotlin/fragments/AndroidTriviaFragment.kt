package org.ohmstheresistance.synopsiskotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.AndroidTriviaFragmentBinding

class AndroidTriviaFragment : Fragment(), View.OnClickListener  {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val androidTriviaBinding = DataBindingUtil.inflate<AndroidTriviaFragmentBinding>(inflater, R.layout.android_trivia_fragment, container, false)


        return androidTriviaBinding.root
    }

    override fun onClick(view: View?) {

    }
}