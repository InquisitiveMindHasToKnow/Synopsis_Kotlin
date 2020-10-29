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
import kotlinx.android.synthetic.main.tribute_fragment.*
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.TributeFragmentBinding

class TributeFragment : Fragment(), View.OnClickListener{

    private lateinit var imageAlertDialog: AlertDialog.Builder
    private lateinit var zoomedImageLayout: View
    private lateinit var zoomedSelectedImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val tributeBinding = DataBindingUtil.inflate<TributeFragmentBinding>(inflater, R.layout.tribute_fragment, container, false)

        tributeBinding.tributeLinkButton.setOnClickListener(this)
        tributeBinding.tributeSigninImageview.setOnClickListener(this)
        tributeBinding.tributeRegistrationImageview.setOnClickListener(this)
        tributeBinding.tributeMainPageImageview.setOnClickListener(this)
        tributeBinding.tributeStockNamesImageview.setOnClickListener(this)
        tributeBinding.tributeSelectedPersonImageview.setOnClickListener(this)
        tributeBinding.tributeAddedPersonImageview.setOnClickListener(this)


        imageAlertDialog = AlertDialog.Builder(activity, R.style.DialogCustom)
        zoomedImageLayout = inflater.inflate(R.layout.display_zoomed_image_fragment, container, false)
        zoomedSelectedImage = zoomedImageLayout.findViewById(R.id.zoomed_in_image_imageview)

        return tributeBinding.root
    }

    override fun onClick(view: View?) {

        when (view?.id) {

            tribute_link_button.id -> {
                val tributeURL = "https://github.com/InquisitiveMindHasToKnow/Tribute"
                val tributeLinkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(tributeURL))
                startActivity(tributeLinkIntent)
            }
            tribute_signin_imageview.id -> {
                setZoomedImage(R.drawable.tribute_signin_page)
            }
            tribute_registration_imageview.id -> {
                setZoomedImage(R.drawable.tribute_registration_page)
            }
            tribute_main_page_imageview.id -> {
                setZoomedImage(R.drawable.tribute_main_page)
            }
            tribute_stock_names_imageview.id -> {
                setZoomedImage(R.drawable.tribute_stock_names)
            }
            tribute_selected_person_imageview.id -> {
                setZoomedImage(R.drawable.tribute_selected_person)
            }
            tribute_added_person_imageview.id -> {
                setZoomedImage(R.drawable.tribute_added_name)
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