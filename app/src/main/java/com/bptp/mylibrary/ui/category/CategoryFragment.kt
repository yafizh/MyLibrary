package com.bptp.mylibrary.ui.category

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bptp.mylibrary.databinding.FragmentGeneralBinding
import com.bptp.mylibrary.ui.utils.adapter.CardViewAdapter
import com.bptp.mylibrary.ui.detail.DetailActivity

private const val ARG_CATEGORY = "CATEGORY"

class GeneralFragment : Fragment() {
    lateinit var binding: FragmentGeneralBinding
    private lateinit var category: String
    lateinit var adapter: CardViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            category = it.getString(ARG_CATEGORY).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentGeneralBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showData()
    }

    private fun showData() {
        binding.rvHero.layoutManager = LinearLayoutManager(context)
        adapter = CardViewAdapter { item ->
            DetailActivity.startActivity(context, item)
        }
        binding.rvHero.adapter = adapter
//        adapter.setItems(BooksData.listData.filter {
//            it.bookCategory.uppercase().contains(category.toString().uppercase())
//        })
    }

    companion object {
        @JvmStatic
        fun newInstance(category: String) =
            GeneralFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_CATEGORY, category)
                }
            }
    }
}