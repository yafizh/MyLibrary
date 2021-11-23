package com.bptp.mylibrary.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import coil.load
import com.bptp.mylibrary.data.network.model.response.Book
import com.bptp.mylibrary.databinding.ActivityDetailBinding
import com.bptp.mylibrary.ui.utils.pdfviewer.FDPViewerActivity

class DetailActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnReadNow.setOnClickListener {
            startActivity(Intent(this, FDPViewerActivity::class.java))
        }
        getIntentData()
    }

    private fun bindData(book: Book?){
        Log.d("HABIS", "bindData: ${book}")
        book?.let {
            with(it) {
                binding.ivBookImg.load("https://magangbptp.000webhostapp.com/uploads/cover/"+bookCoverUri)
                binding.tvBookAuthor.text = bookAuthor
                binding.tvBookDescription.text = bookDescription
                binding.tvBookTitle.text = bookTitle
                binding.tvBookLanguage.text = "INGGRIS"
                binding.tvBookPage.text = "100"
                binding.tvBookPublishYear.text = "2020"
            }
        }
    }

    private fun getIntentData() {
        val x = intent.extras?.getParcelable(EXTRAS_BOOK)
    }

    companion object {
        const val EXTRAS_BOOK = "EXTRAS_BOOK"

        @JvmStatic
        fun startActivity(context: Context?, book: Book) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRAS_BOOK, book)
            context?.startActivity(intent)
        }
    }
}