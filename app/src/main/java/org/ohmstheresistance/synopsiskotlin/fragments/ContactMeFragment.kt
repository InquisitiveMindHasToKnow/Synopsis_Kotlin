package org.ohmstheresistance.synopsiskotlin.fragments

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.contact_me_fragment.*
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.ContactMeFragmentBinding

class ContactMeFragment : Fragment(), View.OnClickListener {

    lateinit var contactIntent: Intent

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        activity?.overridePendingTransition(0, R.anim.slide_out_right)

        val contactMeBinding = DataBindingUtil.inflate<ContactMeFragmentBinding>(
            inflater,
            R.layout.contact_me_fragment,
            container,
            false
        )

        contactMeBinding.contactMePhoneCallButton.setOnClickListener(this)
        contactMeBinding.contactMeGmailButton.setOnClickListener(this)
        contactMeBinding.contactMeGithubButton.setOnClickListener(this)
        contactMeBinding.contactMeLinkedInButton.setOnClickListener(this)


        contactMeBinding.waysToContactLinear.startAnimation(
            AnimationUtils.loadAnimation(context, R.anim.slide_in_bottom))

        contactMeBinding.contactMeAndroidRobot.startAnimation(
            AnimationUtils.loadAnimation(context, R.anim.slide_in_bottom))

        Handler().postDelayed({
            contactMeBinding.contactMeAndroidRobot.startAnimation(
                AnimationUtils.loadAnimation(context, R.anim.exit_bottom))
        }, 3000)


        return contactMeBinding.root

    }

    override fun onClick(view: View?) {

        when (view?.id) {

            contact_me_phone_call_button.id -> {

                val numberToCall = "973-289-2836"

                contactIntent = Intent(Intent.ACTION_DIAL)
                contactIntent.data = Uri.parse("tel:$numberToCall")
                startActivity(contactIntent)

                activity?.overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit)
            }

            contact_me_gmail_button.id -> {

                contactIntent = Intent(Intent.ACTION_SEND)
                contactIntent.type = "message/rfc822"
                contactIntent.putExtra(Intent.EXTRA_EMAIL, arrayOf("raymondomardev@gmail.com"))
                contactIntent.putExtra(Intent.EXTRA_SUBJECT, "Hello, Omar!")

                try {
                    startActivity(Intent.createChooser(contactIntent, "Email me"))
                } catch (ex: ActivityNotFoundException) {
                    Toast.makeText(
                        context,
                        "There are no email clients installed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                activity?.overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit)
            }

            contact_me_github_button.id -> {

                val githubURL = "https://github.com/InquisitiveMindHasToKnow"

                contactIntent = Intent(Intent.ACTION_VIEW, Uri.parse(githubURL))
                startActivity(contactIntent)
                activity?.overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit)
            }

            contact_me_linked_in_button.id -> {

                val linkedInURL = "https://www.linkedin.com/in/omarraymond"

                contactIntent = Intent(Intent.ACTION_VIEW, Uri.parse(linkedInURL))
                startActivity(contactIntent)
                activity?.overridePendingTransition(R.anim.zoom_enter, R.anim.zoom_exit)

            }
        }
    }
}
