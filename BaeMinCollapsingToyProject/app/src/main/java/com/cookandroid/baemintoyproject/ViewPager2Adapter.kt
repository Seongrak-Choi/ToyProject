package com.cookandroid.baemintoyproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.cookandroid.baemintoyproject.databinding.ItemViewPager2Binding

class ViewPager2Adapter(private val imgList:ArrayList<Int>) : RecyclerView.Adapter<ViewPager2Adapter.ViewHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewPager2Adapter.ViewHolder {
        val binding = ItemViewPager2Binding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewPager2Adapter.ViewHolder, position: Int) {
        holder.bind(imgList[position])
    }

    override fun getItemCount(): Int = imgList.size

    inner class ViewHolder(var binding:ItemViewPager2Binding) : RecyclerView.ViewHolder(binding.root){
        fun bind(data:Int){
            binding.img.setImageResource(data)
        }
    }

}