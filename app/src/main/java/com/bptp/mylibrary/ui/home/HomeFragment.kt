package com.bptp.mylibrary.ui.home

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.bptp.mylibrary.data.network.service.ApiService
import com.bptp.mylibrary.databinding.FragmentHomeBinding
import com.bptp.mylibrary.ui.utils.adapter.CardViewAdapter
import com.bptp.mylibrary.ui.detail.DetailActivity
import com.mancj.materialsearchbar.MaterialSearchBar
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch


class HomeFragment : Fragment(), MaterialSearchBar.OnSearchActionListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: CardViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchBar.setOnSearchActionListener(this)
        showData()
        getData()
        binding.srlNotes.setOnRefreshListener {
            getData()
            binding.srlNotes.isRefreshing = false
        }
    }

    private fun showData() {
        binding.rvHero.layoutManager = LinearLayoutManager(context)
        adapter = CardViewAdapter { book ->
            DetailActivity.startActivity(context, book)
        }
        binding.rvHero.adapter = adapter
    }

    override fun onSearchStateChanged(enabled: Boolean) {
    }

    override fun onSearchConfirmed(text: CharSequence?) {
//        adapter.setItems(BooksData.listData.filter {
//            it.bookName.uppercase().contains(text.toString().uppercase())
//            ||
//            it.bookAuthor.uppercase().contains(text.toString().uppercase())
//        })
//        val inputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
//        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }

    override fun onButtonClicked(buttonCode: Int) {

    }

    private fun getData(){
        val coroutineJob = Job()
        val scope = CoroutineScope(Dispatchers.IO + coroutineJob)
        scope.launch(Dispatchers.IO) {
            try {
                binding.shimmer.visibility = View.VISIBLE
                val response = ApiService.invoke().getBookData()
                scope.launch(Dispatchers.Main) {
                    adapter.setItems(response)
                    binding.shimmer.visibility = View.GONE
                }
            } catch (cause: Throwable) {
//                when(cause) {
//                    is HttpException -> {
//                        cause.response()?.errorBody()?.source()?.let {
//                            val error = Gson().fromJson(it.readString(Charsets.UTF_8), BaseResponse::class.java)
//                            viewModelScope.launch(Dispatchers.Main) {
//                                getResponseLiveData.value = Resource.Error(error.errorMsg.toString(), null)
//                            }
//                        }
//                    }
//                }
            }
        }
    }




}

