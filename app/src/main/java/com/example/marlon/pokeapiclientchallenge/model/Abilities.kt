package com.example.marlon.pokeapiclientchallenge.model

import android.os.Parcel
import android.os.Parcelable

data class Abilities(
        var ability: Ability?,
        var slot: Int? = 0
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readParcelable(Ability::class.java.classLoader),
            parcel.readValue(Int::class.java.classLoader) as? Int)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(ability, flags)
        parcel.writeValue(slot)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Abilities> {
        override fun createFromParcel(parcel: Parcel): Abilities {
            return Abilities(parcel)
        }

        override fun newArray(size: Int): Array<Abilities?> {
            return arrayOfNulls(size)
        }
    }

}