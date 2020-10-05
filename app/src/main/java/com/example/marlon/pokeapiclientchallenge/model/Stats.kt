package com.example.marlon.pokeapiclientchallenge.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName

data class Stats(
	@SerializedName("base_stat")
	var baseStat: Int,
	var effort: Int,
	var stat: Stat?
) : Parcelable {
    constructor(parcel: Parcel) : this(
		parcel.readInt(),
		parcel.readInt(),
		parcel.readParcelable(Stat::class.java.classLoader)
	)

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeInt(baseStat)
        parcel.writeInt(effort)
        parcel.writeParcelable(stat, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Stats> {
        override fun createFromParcel(parcel: Parcel): Stats {
            return Stats(parcel)
        }

        override fun newArray(size: Int): Array<Stats?> {
            return arrayOfNulls(size)
        }
    }
}