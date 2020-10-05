package com.example.marlon.pokeapiclientchallenge.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.marlon.pokeapiclientchallenge.utils.GlideApp
import com.example.marlon.pokeapiclientchallenge.R
import com.example.marlon.pokeapiclientchallenge.model.Pokemon
import kotlinx.android.synthetic.main.pokemon_item.view.*

class PokemonListAdapter(
    context: Context,
    private val selectedItem: SelectedItem
) : RecyclerView.Adapter<PokemonListAdapter.PokemonViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var pokemons: ArrayList<Pokemon?> = ArrayList()

    inner class PokemonViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    interface SelectedItem {
        fun onItemSelected(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonViewHolder {
        val itemView = inflater.inflate(R.layout.pokemon_item, parent, false)
        return PokemonViewHolder(itemView)
    }

    // Show the anime's name and image
    override fun onBindViewHolder(holder: PokemonViewHolder, position: Int) {
        val current = pokemons[position]
        holder.itemView.apply {
            setOnClickListener { selectedItem.onItemSelected(position) }
            pokemonId.text = current?.id.toString()
            pokemonName.text = current?.name
        }

        val imgUrl = current?.sprites?.frontDefault
        val thumbnail = holder.itemView.pokemonThumbnail
        val progress = holder.itemView.progressThumbnail

        GlideApp.with(holder.itemView)
            .load(imgUrl)
            .override(350, 500)
            .fitCenter()
            .listener(object : RequestListener<Drawable> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    progress.visibility = View.GONE
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    progress.visibility = View.GONE
                    return false
                }
            })
            .into(thumbnail)
    }

    internal fun setPokemons(pokemons: ArrayList<Pokemon?>) {
        this.pokemons = pokemons
        notifyDataSetChanged()
    }

    override fun getItemCount() = pokemons.size
}