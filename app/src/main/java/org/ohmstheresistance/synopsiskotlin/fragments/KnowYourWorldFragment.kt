package org.ohmstheresistance.synopsiskotlin.fragments

import android.app.AlertDialog
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.databinding.DataBindingUtil
import kotlinx.android.synthetic.main.know_your_world_fragment.*
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.KnowYourWorldFragmentBinding

class KnowYourWorldFragment : Fragment(), View.OnClickListener {

    private lateinit var imageAlertDialog: AlertDialog.Builder
    private lateinit var zoomedImageLayout: View
    private lateinit var zoomedSelectedImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val knowYourWorldBinding = DataBindingUtil.inflate<KnowYourWorldFragmentBinding>(inflater, R.layout.know_your_world_fragment, container, false)

        knowYourWorldBinding.knowYourWorldLinkButton.setOnClickListener(this)
        knowYourWorldBinding.kywMainPageImageview.setOnClickListener(this)
        knowYourWorldBinding.kywStudyImageview.setOnClickListener(this)
        knowYourWorldBinding.kywSelectedCountryImageview.setOnClickListener(this)
        knowYourWorldBinding.kywQuizMainpageImageview.setOnClickListener(this)
        knowYourWorldBinding.kywQuizImageview.setOnClickListener(this)
        knowYourWorldBinding.kywFavoriteCountriesImageview.setOnClickListener(this)

        imageAlertDialog = AlertDialog.Builder(activity, R.style.DialogCustom)
        zoomedImageLayout = inflater.inflate(R.layout.display_zoomed_image_fragment, container, false)
        zoomedSelectedImage = zoomedImageLayout.findViewById(R.id.zoomed_in_image_imageview)

        return knowYourWorldBinding.root
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            know_your_world_link_button.id -> {
                val knowYourWorldURL = "https://github.com/InquisitiveMindHasToKnow/Know-Your-World"
                val knowYourWorldLinkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(knowYourWorldURL))
                startActivity(knowYourWorldLinkIntent)
            }
            kyw_main_page_imageview.id -> {
                setZoomedImage(R.drawable.kyw_main_page_image)
            }
            kyw_study_imageview.id -> {
                setZoomedImage(R.drawable.kyw_study_image)
            }
            kyw_selected_country_imageview.id -> {
                setZoomedImage(R.drawable.kyw_selected_country_image)
            }
            kyw_quiz_mainpage_imageview.id -> {
                setZoomedImage(R.drawable.kyw_quiz_main_page)
            }
            kyw_quiz_imageview.id -> {
                setZoomedImage(R.drawable.kyw_quiz_image)
            }
            kyw_favorite_countries_imageview.id -> {
                setZoomedImage(R.drawable.kyw_favorite_image)
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