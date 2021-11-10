package com.bptp.mylibrary

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bptp.mylibrary.databinding.FragmentNewCollectionBinding
import com.google.android.material.tabs.TabLayoutMediator

class NewCollectionFragment : Fragment() {
    private lateinit var binding: FragmentNewCollectionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewCollectionBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
    }

    private fun setupViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        //adding fragment to adapter
        viewPagerAdapter.addFragment(NewBPTPPublishingFragment.newInstance(), "Koleksi Terbaru")
        viewPagerAdapter.addFragment(NewBPTPPublishingFragment.newInstance(), "Terbitan Terbaru")
        binding.vpTask.adapter = viewPagerAdapter
        //setting title for tab layout
        TabLayoutMediator(binding.tlTask, binding.vpTask, true) { tab, pos ->
            tab.text = viewPagerAdapter.getPageTitle(pos)
        }.attach()
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            NewCollectionFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}