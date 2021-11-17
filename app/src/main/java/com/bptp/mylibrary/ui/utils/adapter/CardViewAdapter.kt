package com.bptp.mylibrary.ui.utils.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bptp.mylibrary.databinding.ItemCardviewHeroBinding
import com.bptp.mylibrary.ui.data.model.Hero

class CardViewAdapter(
    private val itemClick: (Hero, Int) -> Unit
) : RecyclerView.Adapter<CardViewAdapter.CardViewViewHolder>() {
    private var items: MutableList<Hero> = mutableListOf()


    fun setItems(items: List<Hero>) {
        clearItems()
        addItems(items)
        notifyDataSetChanged()
    }

    fun addItems(items: List<Hero>) {
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    fun clearItems() {
        this.items.clear()
        notifyDataSetChanged()
    }

    class CardViewViewHolder(
        private val binding: ItemCardviewHeroBinding,
        private val itemClick: (item: Hero, position: Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bindView(item: Hero, position: Int) {
            with(item) {
                binding.tvAuthor.text = bookAuthor
                binding.tvDescription.text = bookDescription
                binding.tvTitle.text = bookName
                binding.ivBook.setImageResource(bookImage)
                binding.flWrapper.setOnClickListener {
                    itemClick(item, position)
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
        holder.bindView(items[position], position)
    }

    override fun getItemCount(): Int = items.size

}