package com.bptp.mylibrary.ui.utils.pdfviewer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bptp.mylibrary.databinding.ActivityFdpviewerBinding

class FDPViewerActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFdpviewerBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFdpviewerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showPdfFromAssets("homo_deus.pdf")
    }

    private fun showPdfFromAssets(pdfName: String) {
        binding.pdfView.fromAsset(pdfName)
            .password(null) // if password protected, then write password
            .defaultPage(0) // set the default page to open
            .onPageError { page, _ ->
                Toast.makeText(
                    this@FDPViewerActivity,
                    "Error at page: $page", Toast.LENGTH_LONG
                ).show()
            }
            .load()
    }
}