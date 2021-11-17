package com.bptp.mylibrary.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.bptp.mylibrary.databinding.ActivityDetailBinding
import com.bptp.mylibrary.ui.utils.pdfviewer.FDPViewerActivity
import com.bptp.mylibrary.ui.data.model.Hero

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
    }

    override fun onStart() {
        super.onStart()
        getIntentData()
    }

    private fun bindData(data: Hero?){
        data?.let {
            with(it) {
                binding.ivBookImg.load("https://encrypted-tbn1.gstatic.com/images?q=tbn:ANd9GcTYY7n0e-GylssxKw9s-5EYUo65I3liFsIGEVo5ynV3PZngtaCV")
                binding.tvBookAuthor.text = bookAuthor
                binding.tvBookDescription.text = bookDescription
                binding.tvBookTitle.text = bookName
                binding.tvBookLanguage.text = "INGGRIS"
                binding.tvBookPage.text = "100"
                binding.tvBookPublishYear.text = "2020"
            }
        }
    }

    private fun getIntentData() {
        bindData(intent.extras?.getParcelable(EXTRAS_TASK_DATA))
    }

    companion object {
        const val EXTRAS_TASK_DATA = "EXTRAS_TASK_DATA"

        @JvmStatic
        fun startActivity(context: Context?, task: Hero) {
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(EXTRAS_TASK_DATA, task)
            context?.startActivity(intent)
        }
    }
}