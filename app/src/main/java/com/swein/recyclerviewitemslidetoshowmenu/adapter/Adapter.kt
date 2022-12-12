package com.swein.recyclerviewitemslidetoshowmenu.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.swein.recyclerviewitemslidetoshowmenu.databinding.ViewHolderItemBinding

class Adapter(var list: ArrayList<String>) : RecyclerView.Adapter<Adapter.ItemViewHolder>() {

    inner class ItemViewHolder(val binding: ViewHolderItemBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val binding =
            ViewHolderItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        return ItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.binding.textView.text = list[position]

        holder.binding.textViewDelete.setOnClickListener {

            list.removeAt(position)
            notifyItemRemoved(position)
        }
        holder.itemView.scrollTo(0, 0)
    }

    override fun getItemCount(): Int {
        return list.size
    }
}