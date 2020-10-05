package com.example.marlon.pokeapiclientchallenge.model

import android.os.Parcel
import android.os.Parcelable

data class Moves(
		val move: Move?
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readParcelable<Move>(Move::class.java.classLoader)
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(move, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Moves> {
        override fun createFromParcel(parcel: Parcel): Moves {
            return Moves(parcel)
        }

        override fun newArray(size: Int): Array<Moves?> {
            return arrayOfNulls(size)
        }
    }

}