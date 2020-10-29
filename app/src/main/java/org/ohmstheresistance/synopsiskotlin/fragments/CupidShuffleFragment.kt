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
import kotlinx.android.synthetic.main.cupid_shuffle_fragment.*
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.CupidShuffleFragmentBinding

class CupidShuffleFragment : Fragment(), View.OnClickListener  {

    private lateinit var imageAlertDialog: AlertDialog.Builder
    private lateinit var zoomedImageLayout: View
    private lateinit var zoomedSelectedImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val cupidShuffleBinding = DataBindingUtil.inflate<CupidShuffleFragmentBinding>(inflater, R.layout.cupid_shuffle_fragment, container, false)

        cupidShuffleBinding.cupidShuffleLinkButton.setOnClickListener(this)
        cupidShuffleBinding.csLoginImageview.setOnClickListener(this)
        cupidShuffleBinding.csMainUserImageview.setOnClickListener(this)
        cupidShuffleBinding.csPotentialMatchImageview.setOnClickListener(this)
        cupidShuffleBinding.csListOfLocations.setOnClickListener(this)
        cupidShuffleBinding.csDateReservationImageview.setOnClickListener(this)
        cupidShuffleBinding.csDatePromptImageview.setOnClickListener(this)
        cupidShuffleBinding.csDirectMessagesImageview.setOnClickListener(this)
        cupidShuffleBinding.csConnectionRequestsImageview.setOnClickListener(this)
        cupidShuffleBinding.csDateReservationConfirmationImageview.setOnClickListener(this)



        imageAlertDialog = AlertDialog.Builder(activity, R.style.DialogCustom)
        zoomedImageLayout = inflater.inflate(R.layout.display_zoomed_image_fragment, container, false)
        zoomedSelectedImage = zoomedImageLayout.findViewById(R.id.zoomed_in_image_imageview)

        return cupidShuffleBinding.root
    }

    override fun onClick(view: View?) {

        when (view?.id) {
           cupid_shuffle_link_button.id -> {
               val cupidShuffleURL = "https://github.com/InquisitiveMindHasToKnow/CupidShuffle"
               val cupidShuffleLinkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(cupidShuffleURL))
               startActivity(cupidShuffleLinkIntent)
           }
            cs_login_imageview.id -> {
                setZoomedImage(R.drawable.cs_login_screen)
            }
            cs_main_user_imageview.id -> {
                setZoomedImage(R.drawable.cs_main_user)
            }
            cs_potential_match_imageview.id -> {
                setZoomedImage(R.drawable.cs_potential_match)
            }
            cs_list_of_locations.id -> {
                setZoomedImage(R.drawable.cs_list_of_locations)
            }
            cs_date_reservation_imageview.id -> {
                setZoomedImage(R.drawable.cs_date_reservation)
            }
            cs_date_prompt_imageview.id -> {
                setZoomedImage(R.drawable.cs_date_prompt)
            }
            cs_direct_messages_imageview.id -> {
                setZoomedImage(R.drawable.cs_direct_messages)
            }
            cs_connection_requests_imageview.id -> {
                setZoomedImage(R.drawable.cs_connection_requests)
            }
            cs_date_reservation_confirmation_imageview.id -> {
                setZoomedImage(R.drawable.cs_reservation_confirmation)
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