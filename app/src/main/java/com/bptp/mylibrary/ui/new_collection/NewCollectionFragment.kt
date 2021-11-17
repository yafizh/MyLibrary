package com.bptp.mylibrary.ui.new_collection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bptp.mylibrary.ui.utils.adapter.ViewPagerAdapter
import com.bptp.mylibrary.databinding.FragmentNewCollectionBinding
import com.bptp.mylibrary.ui.utils.adapter.CardViewAdapter
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
        viewPagerAdapter.addFragment(CollectionFragment.newInstance(), "Koleksi Terbaru")
        viewPagerAdapter.addFragment(CollectionFragment.newInstance(), "Terbitan Terbaru")
        binding.vpTask.adapter = viewPagerAdapter
        //setting title for tab layout
        TabLayoutMediator(binding.tlTask, binding.vpTask, true) { tab, pos ->
            tab.text = viewPagerAdapter.getPageTitle(pos)
        }.attach()
    }
}