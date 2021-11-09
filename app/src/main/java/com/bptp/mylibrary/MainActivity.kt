package com.bptp.mylibrary

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.bptp.mylibrary.databinding.ActivityMainBinding
import com.mancj.materialsearchbar.MaterialSearchBar

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        binding.searchBar.setSpeechMode(true)
    }

    override fun onClick(view: View?) {
        when(view?.id){
            MaterialSearchBar.BUTTON_SPEECH->{
                Log.d("LKjjjjj", "onClick: aaa")
            }
        }
    }
}