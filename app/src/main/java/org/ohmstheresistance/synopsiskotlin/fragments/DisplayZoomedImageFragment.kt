package org.ohmstheresistance.synopsiskotlin.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.DisplayZoomedImageFragmentBinding

class DisplayZoomedImageFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val displayZoomedFragmentBinding = DataBindingUtil.inflate<DisplayZoomedImageFragmentBinding>(inflater, R.layout.display_zoomed_image_fragment, container, false)


        return displayZoomedFragmentBinding.root
    }
}