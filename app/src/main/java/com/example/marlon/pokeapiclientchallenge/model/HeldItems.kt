package com.example.marlon.pokeapiclientchallenge.model

import android.os.Parcel
import android.os.Parcelable

data class HeldItems(
	var item: Item?
) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readParcelable<Item>(Item::class.java.classLoader)
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeParcelable(item, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<HeldItems> {
        override fun createFromParcel(parcel: Parcel): HeldItems {
            return HeldItems(parcel)
        }

        override fun newArray(size: Int): Array<HeldItems?> {
            return arrayOfNulls(size)
        }
    }

}