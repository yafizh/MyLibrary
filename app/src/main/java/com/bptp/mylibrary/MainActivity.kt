package com.bptp.mylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bptp.mylibrary.databinding.ActivityMainBinding
import com.bptp.mylibrary.ui.category.CategoryFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private fun setupViewPager() {
        val viewPagerAdapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPagerAdapter.addFragment(HomeFragment.newInstance(), "Undone Task")
        viewPagerAdapter.addFragment(NewCollectionFragment.newInstance(), "aaa Task")
        viewPagerAdapter.addFragment(CategoryFragment.newInstance(), "Undone Task")
        binding.viewpager2.adapter = viewPagerAdapter
        binding.viewpager2.isUserInputEnabled = false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        setupViewPager()


        binding.bubbleTabBar.addBubbleListener { id ->
            when (id) {
                R.id.home -> {
                    binding.viewpager2.currentItem = 0
                }
                R.id.news -> {
                    binding.viewpager2.currentItem = 1
                }
                R.id.category -> {
                    binding.viewpager2.currentItem = 2
                }
            }
        }

    }

}
