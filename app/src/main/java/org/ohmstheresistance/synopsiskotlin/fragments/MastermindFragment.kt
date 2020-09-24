package org.ohmstheresistance.synopsiskotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.MastermindFragmentBinding


class MastermindFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mastermindBinding = DataBindingUtil.inflate<MastermindFragmentBinding>(inflater, R.layout.mastermind_fragment, container, false)


        return mastermindBinding.root
    }

    override fun onClick(view: View?) {
        TODO("Not yet implemented")
    }
}