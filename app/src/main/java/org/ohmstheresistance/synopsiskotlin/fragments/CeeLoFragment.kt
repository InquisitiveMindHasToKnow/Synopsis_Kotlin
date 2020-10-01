package org.ohmstheresistance.synopsiskotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.CeeLoFragmentBinding

class CeeLoFragment : Fragment(), View.OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val ceeLoBinding = DataBindingUtil.inflate<CeeLoFragmentBinding>(inflater, R.layout.cee_lo_fragment, container, false)

        return ceeLoBinding.root
    }

    override fun onClick(view: View?) {

    }
}