package com.bptp.mylibrary.ui.utils.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bptp.mylibrary.data.network.model.response.Book
import com.bptp.mylibrary.databinding.ItemCardviewHeroBinding

class CardViewAdapter(
    private val itemClick: (Book) -> Unit
) : RecyclerView.Adapter<CardViewAdapter.CardViewViewHolder>() {
    private var items: MutableList<Book> = mutableListOf()


    fun setItems(items: List<Book>) {
        clearItems()
        addItems(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<Book>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }

    class CardViewViewHolder(
        private val binding: ItemCardviewHeroBinding,
        private val itemClick: (item: Book) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(book: Book) {
            with(book) {
                binding.tvAuthor.text = bookAuthor
                binding.tvDescription.text = bookDescription
                binding.tvTitle.text = bookTitle
                binding.ivBook.load("https://magangbptp.000webhostapp.com/uploads/cover/"+bookCoverUri)
                binding.flWrapper.setOnClickListener {
                    itemClick(book)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardViewViewHolder {
        val binding =
            ItemCardviewHeroBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CardViewViewHolder(binding, itemClick)
    }

    override fun onBindViewHolder(holder: CardViewViewHolder, position: Int) {
        holder.bindView(items[position])
    }

    override fun getItemCount(): Int = items.size

}