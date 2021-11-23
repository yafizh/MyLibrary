package com.bptp.mylibrary.ui.newcollection

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.bptp.mylibrary.databinding.FragmentNewBPTPPublishingBinding
import com.bptp.mylibrary.ui.utils.adapter.CardViewAdapter
import com.bptp.mylibrary.ui.detail.DetailActivity

class CollectionFragment : Fragment() {
    private lateinit var binding: FragmentNewBPTPPublishingBinding
    private lateinit var adapter: CardViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    private fun showData() {
        binding.rvHero.layoutManager = LinearLayoutManager(context)
        adapter = CardViewAdapter({ item ->
//            DetailActivity.startActivity(context, item)
        })
        binding.rvHero.adapter = adapter

//        adapter.setItems(BooksData.listData)
//        adapter.setOnItemClickCallback(object : CardViewAdapter.OnItemClickCallback {
//            override fun onItemClicked(data: Hero) {
//                Toast.makeText(context, "MASUKKKK", Toast.LENGTH_SHORT).show()
//            }
//        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentNewBPTPPublishingBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showData()
    }
    companion object {

        @JvmStatic
        fun newInstance() =
            CollectionFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}