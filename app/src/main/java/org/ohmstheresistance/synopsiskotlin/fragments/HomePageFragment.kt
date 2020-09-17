package org.ohmstheresistance.synopsiskotlin.fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.HomePageFragmentBinding


class HomePageFragment : Fragment() , View.OnClickListener {

    lateinit var binding: HomePageFragmentBinding //ViewDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_page_fragment, container, false)

        val profileAboutMeButton: Button = binding.profileAboutMeButton
        val profileContactMeButton: Button = binding.profileContactMeButton
        val profileProjectsButton: Button = binding.profileProjectsButton
        val profileResumeButton: Button = binding.profileResumeButton
        val navigationIntent: Intent


        return binding.root
}

    @SuppressLint("UseRequireInsteadOfGet")
    override fun onClick(view: View?) {

        val id: Int = view!!.getId()
        when (id) {
            R.id.profile_about_me_button -> {

            }
            R.id.profile_contact_me_button -> {

            }

            R.id.profile_projects_button -> {

            }

            R.id.profile_resume_button -> {

            }
        }
    }
}
