package com.example.marlon.pokeapiclientchallenge.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Pokemon(
        @SerializedName("id")
        var id: Int = 0,
        @SerializedName("name")
        var name: String? = "",
        @SerializedName("base_experience")
        var baseExperience: Int? = null,
        @SerializedName("height")
        var height: Int? = 0,
        @SerializedName("order")
        var order: Int? = 0,
        @SerializedName("weight")
        var weight: Int? = 0,
        @SerializedName("abilities")
        var abilities: List<Abilities>? ,
        @SerializedName("held_items")
        var heldItems: List<HeldItems>? ,
        @SerializedName("moves")
        var moves: List<Moves>? ,
        @SerializedName("sprites")
        var sprites: Sprites?,
        @SerializedName("stats")
        var stats: List<Stats>?
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readInt(),
            parcel.readString(),
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.readValue(Int::class.java.classLoader) as? Int,
            parcel.createTypedArrayList(Abilities),
            parcel.createTypedArrayList(HeldItems),
            parcel.createTypedArrayList(Moves),
            parcel.readParcelable(Sprites::class.java.classLoader),
            parcel.createTypedArrayList(Stats))

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(id)
        parcel.writeString(name)
        parcel.writeValue(baseExperience)
        parcel.writeValue(height)
        parcel.writeValue(order)
        parcel.writeValue(weight)
        parcel.writeTypedList(abilities)
        parcel.writeTypedList(heldItems)
        parcel.writeTypedList(moves)
        parcel.writeParcelable(sprites, flags)
        parcel.writeTypedList(stats)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Pokemon> {
        override fun createFromParcel(parcel: Parcel): Pokemon {
            return Pokemon(parcel)
        }

        override fun newArray(size: Int): Array<Pokemon?> {
            return arrayOfNulls(size)
        }
    }

}