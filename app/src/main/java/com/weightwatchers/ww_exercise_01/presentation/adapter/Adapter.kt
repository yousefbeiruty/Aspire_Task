package com.weightwatchers.ww_exercise_01.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.weightwatchers.ww_exercise_01.R
import com.weightwatchers.ww_exercise_01.data.remote.model.Collections
import com.weightwatchers.ww_exercise_01.data.remote.model.CollectionsItem
import com.weightwatchers.ww_exercise_01.databinding.ItemBinding

class Adapter (private val context: Context, private val list:Collections
,private val clickListener: (CollectionsItem) -> Unit) :
    RecyclerView.Adapter<Adapter.Holder>()  {

    inner class Holder(val binding: ItemBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(part: CollectionsItem, clickListener: (CollectionsItem) -> Unit) {
            binding.root.setOnClickListener { clickListener(part) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding: ItemBinding= DataBindingUtil.inflate(
            LayoutInflater.from(context),
            R.layout.item,parent,false)
        return Holder(binding)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {

        Glide
            .with(context)
            .load("https://www.weightwatchers.com/${list[position].image}")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_background)
            .into(holder.binding.img)

        holder.binding.tvTitle.text=list[position].title

        holder.bind(list[position], clickListener)


    }

    override fun getItemCount(): Int {
       return list.size
    }
}