package org.ohmstheresistance.synopsiskotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.CupidShuffleFragmentBinding

class CupidShuffleFragment : Fragment(), View.OnClickListener  {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val cupidShuffleBinding = DataBindingUtil.inflate<CupidShuffleFragmentBinding>(inflater, R.layout.cupid_shuffle_fragment, container, false)

        return cupidShuffleBinding.root
    }

    override fun onClick(view: View?) {

    }
}