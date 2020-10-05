package com.example.marlon.pokeapiclientchallenge.adapter

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.example.marlon.pokeapiclientchallenge.utils.GlideApp
import com.example.marlon.pokeapiclientchallenge.R
import com.example.marlon.pokeapiclientchallenge.model.Pokemon
import kotlinx.android.synthetic.main.fragment_pokemon_list.view.*
import kotlinx.android.synthetic.main.pokemon_detail_item.view.*

class PokemonDetailAdapter(
        context: Context
) : RecyclerView.Adapter<PokemonDetailAdapter.PokemonDetailViewHolder>() {

    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var pokemons: ArrayList<Pokemon?>? = ArrayList()

    inner class PokemonDetailViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PokemonDetailViewHolder {
        val itemView = inflater.inflate(R.layout.pokemon_detail_item, parent, false)
        return PokemonDetailViewHolder(itemView)
    }

    // Show the anime's detail
    override fun onBindViewHolder(holder: PokemonDetailViewHolder, position: Int) {
        val current = pokemons?.get(position)
        val view = holder.itemView
        current?.apply {
            view.pokemon_id.text = id.toString()
            view.pokemon_name.text = name
            view.pokemon_height.text = height.toString()
            view.pokemon_weight.text = weight.toString()
            var statsString = ""
            stats?.forEach {
                statsString += it.stat?.name
            }
            view.pokemon_stats.text = statsString

        }
        val imgUrl = current?.sprites?.frontDefault
        val thumbnail = view.pokemon_thumbnail
        val progress = view.progress

        val abilitiesRecycler = view.abilitiesRecycler
        val abilitiesAdapter = NameListAdapter(view.context)
        abilitiesRecycler.adapter = abilitiesAdapter
        abilitiesRecycler.layoutManager = GridLayoutManager(view.context, 3)
        val abilities = arrayListOf<String?>()
        current?.abilities?.forEach {
            abilities.add(it.ability?.name)
        }
        abilitiesAdapter.setNames(abilities)

        val heldItemsRecycler = view.heldItemsRecycler
        val heldItemsAdapter = NameListAdapter(view.context)
        heldItemsRecycler.adapter = heldItemsAdapter
        heldItemsRecycler.layoutManager = GridLayoutManager(view.context, 3)
        val heldItems = arrayListOf<String?>()
        current?.heldItems?.forEach {
            heldItems.add(it.item?.name)
        }
        heldItemsAdapter.setNames(heldItems)

        val movesAdapter = NameListAdapter(view.context)
        view.movesRecycler.adapter = movesAdapter
        view.movesRecycler.layoutManager = GridLayoutManager(view.context, 3)
        val moves = arrayListOf<String?>()
        current?.moves?.forEach {
            moves.add(it.move?.name)
        }
        movesAdapter.setNames(moves)

        // Show the anime's image
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

    internal fun setPokemons(pokemons: ArrayList<Pokemon?>?) {
        this.pokemons = pokemons
        notifyDataSetChanged()
    }

    override fun getItemCount() = pokemons?.size ?: 0
}