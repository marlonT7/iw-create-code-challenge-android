package com.example.marlon.pokeapiclientchallenge.model

import android.os.Parcel
import android.os.Parcelable

data class Move(
		val name: String?,
		val url: String?
) : Parcelable {
    constructor(parcel: Parcel) : this(
			parcel.readString(),
			parcel.readString()
	)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(url)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Move> {
        override fun createFromParcel(parcel: Parcel): Move {
            return Move(parcel)
        }

        override fun newArray(size: Int): Array<Move?> {
            return arrayOfNulls(size)
        }
    }
}