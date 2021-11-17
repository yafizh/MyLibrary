package com.bptp.mylibrary.ui.category

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import com.bptp.mylibrary.ui.utils.adapter.ViewPagerAdapter
import com.bptp.mylibrary.databinding.FragmentCategoryBinding
import com.bptp.mylibrary.ui.data.source.BooksData
import com.google.android.material.tabs.TabLayoutMediator
import com.mancj.materialsearchbar.MaterialSearchBar

class CategoriesFragment : Fragment(), MaterialSearchBar.OnSearchActionListener {
    lateinit var binding: FragmentCategoryBinding
    private lateinit var viewPagerAdapter: ViewPagerAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCategoryBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupViewPager()
        binding.searchBar.setOnSearchActionListener(this)
    }

    private fun setupViewPager() {
        viewPagerAdapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        //adding fragment to adapter
        val categories = arrayListOf<String>(
            "Umum",
            "Filsafat",
            "Ilmu Pengetahuan Masyarakat",
            "Bahasa",
            "Matematika",
            "Ilmu Pengetahuan Terapan",
            "Kesenian",
            "Literatur",
            "Sejarah"
        )
        for (category in categories) viewPagerAdapter.addFragment(GeneralFragment.newInstance(category), category)
        binding.vpTask.adapter = viewPagerAdapter
        //setting title for tab layout
        TabLayoutMediator(binding.tlTask, binding.vpTask, true) { tab, pos ->
            tab.text = viewPagerAdapter.getPageTitle(pos)
        }.attach()
    }

    override fun onSearchStateChanged(enabled: Boolean) {
    }

    override fun onSearchConfirmed(text: CharSequence?) {
        (viewPagerAdapter.getCurrentFragment(binding.vpTask.currentItem) as GeneralFragment).
        adapter.setItems(BooksData.listData.filter {
            it.bookName.uppercase().contains(text.toString().uppercase())
            ||
            it.bookAuthor.uppercase().contains(text.toString().uppercase())
            &&
            it.bookCategory.uppercase().contains(viewPagerAdapter.getPageTitle(binding.vpTask.currentItem).uppercase())
        })
        val inputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }

    override fun onButtonClicked(buttonCode: Int) {
    }
}