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
import kotlinx.android.synthetic.main.android_trivia_fragment.*
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.AndroidTriviaFragmentBinding

class AndroidTriviaFragment : Fragment(), View.OnClickListener  {

    private lateinit var imageAlertDialog: AlertDialog.Builder
    private lateinit var zoomedImageLayout: View
    private lateinit var zoomedSelectedImage: ImageView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val androidTriviaBinding = DataBindingUtil.inflate<AndroidTriviaFragmentBinding>(inflater, R.layout.android_trivia_fragment, container, false)

        androidTriviaBinding.androidTriviaLinkButton.setOnClickListener(this)
        androidTriviaBinding.androidTriviaMainPageImageview.setOnClickListener(this)
        androidTriviaBinding.androidTriviaAboutImageview.setOnClickListener(this)
        androidTriviaBinding.androidTriviaRulesImageview.setOnClickListener(this)
        androidTriviaBinding.androidTriviaQuizImageview.setOnClickListener(this)
        androidTriviaBinding.androidTriviaWinnerImageview.setOnClickListener(this)
        androidTriviaBinding.androidTriviaLoserImageview.setOnClickListener(this)


        imageAlertDialog = AlertDialog.Builder(activity, R.style.DialogCustom)
        zoomedImageLayout = inflater.inflate(R.layout.display_zoomed_image_fragment, container, false)
        zoomedSelectedImage = zoomedImageLayout.findViewById(R.id.zoomed_in_image_imageview)

        return androidTriviaBinding.root
    }

    override fun onClick(view: View?) {

        when (view?.id) {

            android_trivia_link_button.id -> {
                val androidTriviaURL = "https://github.com/InquisitiveMindHasToKnow/AndroidTrivia"
                val androidTriviaLinkIntent = Intent(Intent.ACTION_VIEW, Uri.parse(androidTriviaURL))
                startActivity(androidTriviaLinkIntent)
            }
            android_trivia_main_page_imageview.id -> {
                setZoomedImage(R.drawable.android_trivia_main_page)
            }
            android_trivia_about_imageview.id -> {
                setZoomedImage(R.drawable.android_trivia_about)
            }
            android_trivia_rules_imageview.id -> {
                setZoomedImage(R.drawable.android_trivia_rules)
            }
            android_trivia_quiz_imageview.id -> {
                setZoomedImage(R.drawable.android_trivia_quiz)
            }
            android_trivia_winner_imageview.id -> {
                setZoomedImage(R.drawable.android_trivia_winner)
            }
            android_trivia_loser_imageview.id -> {
                setZoomedImage(R.drawable.android_trivia_loser)
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