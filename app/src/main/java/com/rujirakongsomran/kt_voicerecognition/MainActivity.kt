package com.rujirakongsomran.kt_voicerecognition

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.speech.RecognizerIntent
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    companion object {
        const val REQUEST_CODE_VOICE_RECOGNITION = 1001
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callVoiceRecognition()
    }

    private fun callVoiceRecognition() {
        val intent = Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH)
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, "th-TH")
        startActivityForResult(intent, REQUEST_CODE_VOICE_RECOGNITION)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        // Result will return here
        if (requestCode == REQUEST_CODE_VOICE_RECOGNITION && resultCode == Activity.RESULT_OK) {
            val resultList = data?.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS)
            // Do something with resultList
            val toast = Toast.makeText(applicationContext, resultList?.get(0), Toast.LENGTH_LONG)
            toast.show()
        }
    }

}