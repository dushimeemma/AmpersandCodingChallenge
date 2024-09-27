package com.ampersandcodingchallenge.retrofitgetrecyclerview.models

import android.os.Parcel
import android.os.Parcelable

data class Data(
    val cpu: String?,
    val capacity: String?,
    val case: String?,
    val color: String,
    val description: String?,
    val generation: String,
    val hard: String?,
    val screen: Double?,
    val strap: String?,
    val capacityGB: Int?,
    val price: Double?,
    val year: Int?
) : Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString(),
        parcel.readString(),
        parcel.readString(),
        parcel.readString() ?: "",
        parcel.readString(),
        parcel.readString() ?: "",
        parcel.readString(),
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readString(),
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Double::class.java.classLoader) as? Double,
        parcel.readValue(Int::class.java.classLoader) as? Int
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cpu)
        parcel.writeString(capacity)
        parcel.writeString(case)
        parcel.writeString(color)
        parcel.writeString(description)
        parcel.writeString(generation)
        parcel.writeString(hard)
        parcel.writeValue(screen)
        parcel.writeString(strap)
        parcel.writeValue(capacityGB)
        parcel.writeValue(price)
        parcel.writeValue(year)
    }

    override fun describeContents(): Int = 0

    companion object CREATOR : Parcelable.Creator<Data> {
        override fun createFromParcel(parcel: Parcel): Data {
            return Data(parcel)
        }

        override fun newArray(size: Int): Array<Data?> {
            return arrayOfNulls(size)
        }
    }
}
