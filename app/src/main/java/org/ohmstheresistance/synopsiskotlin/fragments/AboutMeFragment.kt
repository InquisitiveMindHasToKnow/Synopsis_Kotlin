package org.ohmstheresistance.synopsiskotlin.fragments

import android.graphics.Typeface
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.ViewFlipper
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.AboutMeFragmentBinding


class AboutMeFragment : Fragment() {

    private lateinit var descriptiveWordsViewFlipper: ViewFlipper

    private val descriptiveList = arrayOf("Analytical", "Goal-Oriented", "Innovative", "Motivated", "Hardworking", "Team-Oriented",
        "Charismatic", "Professional", "Driven", "Forward-Thinking")

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val aboutMeBinding = DataBindingUtil.inflate<AboutMeFragmentBinding>(
            inflater,
            R.layout.about_me_fragment,
            container,
            false
        )

        descriptiveWordsViewFlipper = aboutMeBinding.descriptiveWordsViewFlipper


        for (descriptiveWord in descriptiveList) {
           val descriptiveWordsTextView = TextView(context)
            descriptiveWordsTextView.text = descriptiveWord
            descriptiveWordsTextView.gravity = Gravity.CENTER
            descriptiveWordsTextView.textSize = 40f
            descriptiveWordsTextView.setTextColor(resources.getColor(R.color.textColor))
            descriptiveWordsTextView.setTypeface(
                descriptiveWordsTextView.typeface,
                Typeface.BOLD_ITALIC
            )
            descriptiveWordsViewFlipper.addView(descriptiveWordsTextView)
        }

        descriptiveWordsViewFlipper.setInAnimation(context, R.anim.scaleup)
        descriptiveWordsViewFlipper.setOutAnimation(context, R.anim.slide_out_right)
        descriptiveWordsViewFlipper.flipInterval = 4000
        descriptiveWordsViewFlipper.startFlipping()
        return aboutMeBinding.root
    }
}