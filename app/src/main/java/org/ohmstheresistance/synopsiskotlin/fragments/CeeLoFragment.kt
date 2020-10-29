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
import kotlinx.android.synthetic.main.cee_lo_fragment.*
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.CeeLoFragmentBinding

class CeeLoFragment : Fragment(), View.OnClickListener{

    private lateinit var imageAlertDialog: AlertDialog.Builder
    private lateinit var zoomedImageLayout: View
    private lateinit var zoomedSelectedImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val ceeLoBinding = DataBindingUtil.inflate<CeeLoFragmentBinding>(inflater, R.layout.cee_lo_fragment, container, false)

        ceeLoBinding.ceeloLinkButton.setOnClickListener(this)
        ceeLoBinding.ceeloInstructionsImageview.setOnClickListener(this)
        ceeLoBinding.ceeloRollerImageview.setOnClickListener(this)

        imageAlertDialog = AlertDialog.Builder(activity, R.style.DialogCustom)
        zoomedImageLayout = inflater.inflate(R.layout.display_zoomed_image_fragment, container, false)
        zoomedSelectedImage = zoomedImageLayout.findViewById(R.id.zoomed_in_image_imageview)

        return ceeLoBinding.root
    }

    override fun onClick(view: View?) {

        when (view?.id) {

            ceelo_link_button.id -> {
                val ceeLoURL = "https://github.com/InquisitiveMindHasToKnow/CeeLo"
                val ceeLoLinkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(ceeLoURL))
                startActivity(ceeLoLinkIntent)
            }
            ceelo_instructions_imageview.id -> {
                setZoomedImage(R.drawable.ceelo_instructions)
            }
            ceelo_roller_imageview.id ->{
                setZoomedImage(R.drawable.ceelo_dice_roller)
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