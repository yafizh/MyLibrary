package com.bptp.mylibrary.ui.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Hero(
    var bookName: String = "",
    var bookAuthor: String = "",
    var bookImage: Int = 0,
    var bookDescription: String = "",
    var bookCategory: String = ""
): Parcelable