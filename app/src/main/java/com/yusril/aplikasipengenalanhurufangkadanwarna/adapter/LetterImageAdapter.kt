package com.yusril.aplikasipengenalanhurufangkadanwarna.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusril.aplikasipengenalanhurufangkadanwarna.databinding.ItemListLetterImageBinding

class LetterImageAdapter: RecyclerView.Adapter<LetterImageAdapter.ViewHolder>() {

    private val mList: MutableList<Int> = ArrayList()

    fun updateAdapter(list: List<Int>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListLetterImageBinding.inflate(LayoutInflater.from(parent.context),
            parent,false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {

            mList[position].apply {
                Glide.with(holder.itemView.context)
                    .load(this)
                    .into(ivLetterImage)
            }
        }
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder( val binding: ItemListLetterImageBinding) : RecyclerView.ViewHolder(binding.root)

}