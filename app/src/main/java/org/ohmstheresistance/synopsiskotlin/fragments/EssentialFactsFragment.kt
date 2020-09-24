package org.ohmstheresistance.synopsiskotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.EssentialFactsFragmentBinding

class EssentialFactsFragment : Fragment(), View.OnClickListener {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val essentialFactsBinding = DataBindingUtil.inflate<EssentialFactsFragmentBinding>(inflater, R.layout.essential_facts_fragment, container, false)


        return essentialFactsBinding.root


    }

    override fun onClick(view: View?) {
        TODO("Not yet implemented")
    }
}