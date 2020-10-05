package com.example.marlon.pokeapiclientchallenge.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.marlon.pokeapiclientchallenge.R
import kotlinx.android.synthetic.main.name_item.view.*

class NameListAdapter(
    context: Context
) : RecyclerView.Adapter<NameListAdapter.NameViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var names: ArrayList<String?> = ArrayList()

    inner class NameViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NameViewHolder {
        val itemView = inflater.inflate(R.layout.name_item, parent, false)
        return NameViewHolder(itemView)
    }

    // Show the anime's name and image
    override fun onBindViewHolder(holder: NameViewHolder, position: Int) {
        holder.itemView.name.text = names[position]
    }

    internal fun setNames(names: ArrayList<String?>) {
        this.names = names
        notifyDataSetChanged()
    }

    override fun getItemCount() = names.size
}