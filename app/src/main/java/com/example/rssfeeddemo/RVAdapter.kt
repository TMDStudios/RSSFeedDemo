package com.example.rssfeeddemo

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.rssfeeddemo.databinding.ItemRowBinding

class RVAdapter(private var articles: List<Article>): RecyclerView.Adapter<RVAdapter.ItemViewHolder>() {
    class ItemViewHolder(val binding: ItemRowBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(ItemRowBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val article = articles[position]

        holder.binding.apply {
            tvTitle.text = article.title
            tvDescription.text = article.description
        }
    }

    override fun getItemCount() = articles.size

    fun update(articles: List<Article>){
        this.articles = articles
        notifyDataSetChanged()
    }
}