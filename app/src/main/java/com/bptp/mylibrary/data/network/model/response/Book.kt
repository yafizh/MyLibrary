package com.bptp.mylibrary.data.network.model.response


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Book(
    @SerializedName("book_author")
    var bookAuthor: String,
    @SerializedName("book_category_id")
    var bookCategoryId: String,
    @SerializedName("book_classification_number")
    var bookClassificationNumber: String,
    @SerializedName("book_cover_uri")
    var bookCoverUri: String,
    @SerializedName("book_description")
    var bookDescription: String,
    @SerializedName("book_file_uri")
    var bookFileUri: String,
    @SerializedName("book_height")
    var bookHeight: String,
    @SerializedName("book_id")
    var bookId: String,
    @SerializedName("book_illustration")
    var bookIllustration: String,
    @SerializedName("book_isbn_number")
    var bookIsbnNumber: String,
    @SerializedName("book_language_id")
    var bookLanguageId: String,
    @SerializedName("book_page")
    var bookPage: String,
    @SerializedName("book_publish_date")
    var bookPublishDate: String,
    @SerializedName("book_publish_place")
    var bookPublishPlace: String,
    @SerializedName("book_publisher")
    var bookPublisher: String,
    @SerializedName("book_stock")
    var bookStock: String,
    @SerializedName("book_sub_title")
    var bookSubTitle: String,
    @SerializedName("book_title")
    var bookTitle: String,
    @SerializedName("book_width")
    var bookWidth: String
): Parcelable