package com.addenisov00.testtaskvk.presentation.search_screen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.addenisov00.domain.models.GiffItem
import com.addenisov00.testtaskvk.R
import com.addenisov00.testtaskvk.databinding.GiffListItemBinding
import com.bumptech.glide.Glide

class SearchAdapter(private val listener: Listener) :
    ListAdapter<GiffItem, SearchAdapter.ItemHolder>(object : DiffUtil.ItemCallback<GiffItem>() {
        override fun areItemsTheSame(oldItem: GiffItem, newItem: GiffItem): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: GiffItem, newItem: GiffItem): Boolean {
            return oldItem == newItem
        }

    }) {
    class ItemHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun setData(item: GiffItem, listener: Listener) {
            val binding = GiffListItemBinding.bind(view)
            Glide.with(binding.root.context).load(item.url).centerCrop().into(binding.imGiff)
            this.itemView.setOnClickListener {
                listener.onClick()
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemHolder = ItemHolder(
        LayoutInflater.from(
            parent
                .context
        ).inflate(R.layout.giff_list_item, parent, false)
    )

    override fun onBindViewHolder(holder: ItemHolder, position: Int) {
        holder.setData(getItem(position), listener)
    }

    interface Listener {
        fun onClick()
    }
}