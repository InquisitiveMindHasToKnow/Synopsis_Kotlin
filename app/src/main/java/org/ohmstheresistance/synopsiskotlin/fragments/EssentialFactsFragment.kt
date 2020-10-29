package org.ohmstheresistance.synopsiskotlin.fragments

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.essential_facts_fragment.*
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.EssentialFactsFragmentBinding

class EssentialFactsFragment : Fragment(), View.OnClickListener {

    private lateinit var imageAlertDialog: AlertDialog.Builder
    private lateinit var zoomedImageLayout: View
    private lateinit var zoomedSelectedImage: ImageView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val essentialFactsBinding = DataBindingUtil.inflate<EssentialFactsFragmentBinding>(
            inflater,
            R.layout.essential_facts_fragment,
            container,
            false
        )

        essentialFactsBinding.efLinkButton.setOnClickListener(this)
        essentialFactsBinding.efLinkToSurveyTextview.setOnClickListener(this)
        essentialFactsBinding.efAboutImageview.setOnClickListener(this)
        essentialFactsBinding.efDescriptionTextview.setOnClickListener(this)
        essentialFactsBinding.efMainPageImageview.setOnClickListener(this)
        essentialFactsBinding.efRulesImageview.setOnClickListener(this)
        essentialFactsBinding.efStudyImageview.setOnClickListener(this)
        essentialFactsBinding.efStudyWithAudioImageview.setOnClickListener(this)
        essentialFactsBinding.efTriviaImageview.setOnClickListener(this)
        essentialFactsBinding.essentialFactsImageview.setOnClickListener(this)

        imageAlertDialog = AlertDialog.Builder(activity, R.style.DialogCustom)
        zoomedImageLayout = inflater.inflate(R.layout.display_zoomed_image_fragment, container, false)
        zoomedSelectedImage = zoomedImageLayout.findViewById(R.id.zoomed_in_image_imageview)

        return essentialFactsBinding.root
    }

    override fun onClick(view: View?) {

        when (view?.id) {

            ef_link_button.id -> {
                val linkedInURL = "https://github.com/InquisitiveMindHasToKnow/EssentialFacts"
                val essentialFactsLinkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedInURL))
                startActivity(essentialFactsLinkIntent)
            }
            ef_link_to_survey_textview.id -> {

                val woodrowSurveyURL =
                    "https://woodrow.org/news/national-survey-finds-just-1-in-3-americans-would-pass-citizenship-test/"
                val viewSurveyLinkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(woodrowSurveyURL))
                startActivity(viewSurveyLinkIntent)
            }

            ef_main_page_imageview.id -> {
                setZoomedImage(R.drawable.essential_facts_main_page)
            }
            ef_about_imageview.id -> {
                setZoomedImage(R.drawable.essential_facts_about)
            }
            ef_rules_imageview.id -> {
                setZoomedImage(R.drawable.essential_facts_rules)
            }
            ef_study_imageview.id -> {
                setZoomedImage(R.drawable.essential_facts_study)
            }
            ef_study_with_audio_imageview.id -> {
                setZoomedImage(R.drawable.essential_facts_study_with_audio)
            }
            ef_trivia_imageview.id -> {
                setZoomedImage(R.drawable.essential_facts_trivia)
            }
        }
    }

    private fun setZoomedImage(drawable: Int) {
       val layoutParent = zoomedImageLayout.parent as? ViewGroup

        if (zoomedSelectedImage != null) {
            layoutParent?.removeView(zoomedImageLayout)
        }
        imageAlertDialog.setView(zoomedImageLayout)
        zoomedSelectedImage.setImageResource(drawable)
        imageAlertDialog.show()
    }
}

