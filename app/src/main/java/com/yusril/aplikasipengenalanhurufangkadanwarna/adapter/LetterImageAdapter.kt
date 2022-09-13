package com.yusril.aplikasipengenalanhurufangkadanwarna.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yusril.aplikasipengenalanhurufangkadanwarna.R
import kotlinx.android.synthetic.main.item_list_letter_image.view.*
import java.util.*

class LetterImageAdapter: RecyclerView.Adapter<LetterImageAdapter.ViewHolder>() {

    private val mList: MutableList<Int> = ArrayList()

    fun updateAdapter(list: List<Int>) {
        mList.clear()
        mList.addAll(list)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val itemView = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_list_letter_image, parent, false)
        return ViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.itemView.apply {

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

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

}