package org.ohmstheresistance.synopsiskotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import kotlinx.android.synthetic.main.home_page_fragment.*
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.databinding.HomePageFragmentBinding


class HomePageFragment : Fragment(), View.OnClickListener {

    lateinit var binding: HomePageFragmentBinding //ViewDataBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.home_page_fragment, container, false)

        binding.profileAboutMeButton.setOnClickListener(this)
        binding.profileContactMeButton.setOnClickListener(this)
        binding.profileProjectsButton.setOnClickListener(this)
        binding.profileResumeButton.setOnClickListener(this)

        return binding.root
    }

    override fun onClick(view: View?) {

        val id: Int? = view?.id
        when (id) {

            profile_about_me_button.id -> {
                findNavController().navigate(HomePageFragmentDirections.actionHomePageFragmentToAboutMeFragment())
            }
            profile_contact_me_button.id -> {

                findNavController().navigate(HomePageFragmentDirections.actionHomePageFragmentToContactMeFragment())
            }

            profile_projects_button.id -> {
                findNavController().navigate(HomePageFragmentDirections.actionHomePageFragmentToProjectsFragment())
            }

            profile_resume_button.id -> {
                findNavController().navigate(HomePageFragmentDirections.actionHomePageFragmentToResumeFragment())

            }
        }
    }
}
