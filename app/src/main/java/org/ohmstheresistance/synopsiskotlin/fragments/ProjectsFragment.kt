package org.ohmstheresistance.synopsiskotlin.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.viewpager.widget.ViewPager
import org.ohmstheresistance.synopsiskotlin.R
import org.ohmstheresistance.synopsiskotlin.adapters.ProjectsViewPagerAdapter
import org.ohmstheresistance.synopsiskotlin.databinding.ProjectsFragmentBinding

class ProjectsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val projectsBinding = DataBindingUtil.inflate<ProjectsFragmentBinding>(inflater, R.layout.projects_fragment, container, false)

        setUpViewPager(projectsBinding.projectsViewPager)
        projectsBinding.tabs.setupWithViewPager(projectsBinding.projectsViewPager)

        return projectsBinding.root
    }

    private fun setUpViewPager(viewPager: ViewPager?) {
        val projectsViewPagerAdapter = activity?.supportFragmentManager?.let {
            ProjectsViewPagerAdapter(
                it
            )
        }
        projectsViewPagerAdapter?.addFragments(EssentialFactsFragment(), "Essential Facts")
        projectsViewPagerAdapter?.addFragments(MastermindFragment(), "Mastermind")
        projectsViewPagerAdapter?.addFragments(KnowYourWorldFragment(), "Know Your World")
        projectsViewPagerAdapter?.addFragments(AndroidTriviaFragment(), "Android Trivia")
        projectsViewPagerAdapter?.addFragments(CupidShuffleFragment(), "Cupid Shuffle")
//        projectsViewPagerAdapter.addFragments(CeeLoFragment(), "CeeLo")
//        projectsViewPagerAdapter.addFragments(TributeFragment(), "Tribute")
        viewPager?.adapter = projectsViewPagerAdapter
        //viewPager.setPageTransformer(true, CubeOutTransformer())
    }

    }
