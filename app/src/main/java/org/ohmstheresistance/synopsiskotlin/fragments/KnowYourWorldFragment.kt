package org.ohmstheresistance.synopsiskotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.KnowYourWorldFragmentBinding

class KnowYourWorldFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val knowYourWorldBinding = DataBindingUtil.inflate<KnowYourWorldFragmentBinding>(inflater, R.layout.know_your_world_fragment, container, false)


        return knowYourWorldBinding.root
    }

    override fun onClick(p0: View?) {
        TODO("Not yet implemented")
    }
}