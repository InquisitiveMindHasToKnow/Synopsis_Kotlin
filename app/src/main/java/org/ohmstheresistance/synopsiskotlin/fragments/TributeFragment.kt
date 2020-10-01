package org.ohmstheresistance.synopsiskotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.TributeFragmentBinding

class TributeFragment : Fragment(), View.OnClickListener{

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val tributeBinding = DataBindingUtil.inflate<TributeFragmentBinding>(inflater, R.layout.tribute_fragment, container, false)

        return tributeBinding.root
    }

    override fun onClick(view: View?) {

    }
}