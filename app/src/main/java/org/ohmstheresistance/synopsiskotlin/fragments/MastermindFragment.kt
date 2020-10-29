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
import kotlinx.android.synthetic.main.mastermind_fragment.*
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.MastermindFragmentBinding


class MastermindFragment : Fragment(), View.OnClickListener {

    private lateinit var imageAlertDialog: AlertDialog.Builder
    private lateinit var zoomedImageLayout: View
    private lateinit var zoomedSelectedImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val mastermindBinding = DataBindingUtil.inflate<MastermindFragmentBinding>(inflater, R.layout.mastermind_fragment, container, false)

        mastermindBinding.mastermindLinkButton.setOnClickListener(this)
        mastermindBinding.mastermindMainPageImageview.setOnClickListener(this)
        mastermindBinding.mastermindInstructionsImageview.setOnClickListener(this)
        mastermindBinding.mastermindGameImageview.setOnClickListener(this)
        mastermindBinding.mastermindWinnerImageview.setOnClickListener(this)
        mastermindBinding.mastermindLoserImageview.setOnClickListener(this)

        imageAlertDialog = AlertDialog.Builder(activity, R.style.DialogCustom)
        zoomedImageLayout = inflater.inflate(R.layout.display_zoomed_image_fragment, container, false)
        zoomedSelectedImage = zoomedImageLayout.findViewById(R.id.zoomed_in_image_imageview)

        return mastermindBinding.root
    }

    override fun onClick(view: View?) {
        when (view?.id) {

            mastermind_link_button.id -> {
                val mastermindURL = "https://github.com/InquisitiveMindHasToKnow/Mastermind"
                val mastermindLinkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(mastermindURL))
                startActivity(mastermindLinkIntent)
            }
            mastermind_main_page_imageview.id -> {
                setZoomedImage(R.drawable.mastermind_main_page)
            }
            mastermind_instructions_imageview.id -> {
                setZoomedImage(R.drawable.master_mind_instructions)
            }
            mastermind_game_imageview.id -> {
                setZoomedImage(R.drawable.mastermind_game)
            }
            mastermind_winner_imageview.id -> {
                setZoomedImage(R.drawable.mastermind_winner)
            }
            mastermind_loser_imageview.id -> {
                setZoomedImage(R.drawable.mastermind_loser)
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