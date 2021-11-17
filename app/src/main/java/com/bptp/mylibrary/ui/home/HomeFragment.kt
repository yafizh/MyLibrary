package com.bptp.mylibrary.ui.home

import android.Manifest
import android.content.Context
import android.content.DialogInterface
import android.content.pm.PackageManager
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.bptp.mylibrary.databinding.FragmentHomeBinding
import com.bptp.mylibrary.ui.data.source.BooksData
import com.bptp.mylibrary.ui.utils.adapter.CardViewAdapter
import com.bptp.mylibrary.ui.detail.DetailActivity
import com.bptp.mylibrary.ui.data.model.Hero
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.mancj.materialsearchbar.MaterialSearchBar
import github.com.vikramezhil.dks.speech.Dks
import github.com.vikramezhil.dks.speech.DksListener


class HomeFragment : Fragment(), MaterialSearchBar.OnSearchActionListener {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: CardViewAdapter
    private lateinit var dks: Dks

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.searchBar.setOnSearchActionListener(this)
        showData()

        dks = Dks(requireActivity().application, childFragmentManager, object: DksListener {
            override fun onDksLiveSpeechResult(liveSpeechResult: String) {
                Log.d("DKS", "Speech result - $liveSpeechResult")
            }

            override fun onDksFinalSpeechResult(speechResult: String) {
                Log.d("DKS", "Final speech result - $speechResult")
                binding.searchBar.text = speechResult
                MaterialAlertDialogBuilder(requireContext())
                    .setMessage(speechResult)
                    .setPositiveButton("BENAR", DialogInterface.OnClickListener { dialog, which ->  })
                    .setNegativeButton("ULANGI", DialogInterface.OnClickListener { dialog, which ->
                        startVoiceRecording()
                    }).show()
                stopVoiceRecording()
            }

            override fun onDksLiveSpeechFrequency(frequency: Float) {
                Log.d("DKS", "onDksLiveSpeechFrequency: $frequency")
            }

            override fun onDksLanguagesAvailable(defaultLanguage: String?, supportedLanguages: ArrayList<String>?) {
                if (supportedLanguages != null && supportedLanguages.contains("id-ID")) {
                    // Setting the speech recognition language to english india if found
                    dks.currentSpeechLanguage = "id-ID"
                }

            }

            override fun onDksSpeechError(errMsg: String) {
                Log.d("DKS", "errMsg - $errMsg")
            }
        })
    }

    private fun showData() {

        binding.rvHero.layoutManager = LinearLayoutManager(context)
        adapter = CardViewAdapter { item, position ->
            DetailActivity.startActivity(context, item)
        }
        binding.rvHero.adapter = adapter

        adapter.setItems(BooksData.listData)
    }

    override fun onSearchStateChanged(enabled: Boolean) {
    }

    override fun onSearchConfirmed(text: CharSequence?) {
        adapter.setItems(BooksData.listData.filter {
            it.bookName.uppercase().contains(text.toString().uppercase())
            ||
            it.bookAuthor.uppercase().contains(text.toString().uppercase())
        })
        val inputMethodManager = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view?.windowToken, 0)
    }

    override fun onButtonClicked(buttonCode: Int) {
        when (buttonCode) {
            MaterialSearchBar.BUTTON_SPEECH ->{
                binding.searchBar.openSearch()
                when {
                    ContextCompat.checkSelfPermission(
                        requireContext(),
                        Manifest.permission.RECORD_AUDIO
                    ) == PackageManager.PERMISSION_GRANTED -> {
                        // You can use the API that requires the p1ermission.
                        startVoiceRecording()
                    }
                    else -> {
                        // You can directly ask for the permission.
                        // The registered ActivityResultCallback gets the result of this request.
                        requestPermissionLauncher.launch(
                            Manifest.permission.RECORD_AUDIO)
                    }
                }
            }
            MaterialSearchBar.BUTTON_BACK -> {
                Log.d("HABIS", "onButtonClicked: Button Back")
            }
            MaterialSearchBar.BUTTON_NAVIGATION -> {
                Log.d("HABIS", "onButtonClicked: Button Navigation")
            }
        }
    }

    private fun startVoiceRecording() {
        dks.startSpeechRecognition()
    }
    private fun stopVoiceRecording() {
        val handler = Handler(Looper.getMainLooper())
        handler.postDelayed({
            // do something after 1000ms
            dks.closeSpeechOperations()
        }, 500)
    }

    private val requestPermissionLauncher =
        registerForActivityResult(
            ActivityResultContracts.RequestPermission()
        ) { isGranted: Boolean ->
            if (isGranted) {
                // Permission is granted. Continue the action or workflow in your
                // app.
                startVoiceRecording()
            } else {
                // Explain to the user that the feature is unavailable because the
                // features requires a permission that the user has denied. At the
                // same time, respect the user's decision. Don't link to system
                // settings in an effort to convince the user to change their
                // decision.
                MaterialAlertDialogBuilder(requireContext())
                    .setTitle("Izin Mikrofon")
                    .setMessage("Kami membutuhkan izin mikrofon Anda untuk melakukan pencarian")
                    .show()
            }
        }
}

