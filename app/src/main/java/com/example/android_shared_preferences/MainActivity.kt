package com.example.android_shared_preferences

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.android_shared_preferences.databinding.ActivityMainBinding

const val PREF_NAME = "my_shared_prefs"
const val KEY_USER_NAME = "key_user_name"
const val KEY_USER_AGE = "key_user_age"
const val KEY_NIGHT_MODE = "key_night_mode"

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnWrite.setOnClickListener {
            writeOnSharedPreference()
            Toast.makeText(this, "ok", Toast.LENGTH_SHORT).show()
        }

        binding.btnRead.setOnClickListener {
            readOnSharedPreference()
        }
    }

    private fun writeOnSharedPreference() {
        val sp = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)

//        val editor = sp.edit()
//        editor.putString(KEY_USER_NAME, "Tarcisio")
//        editor.putBoolean(KEY_NIGHT_MODE, true)
//        editor.apply() // assincrona
//        editor.commit() // sincrona

        sp.edit()
            .putString(KEY_USER_NAME, binding.edtName.text.toString())
            .putString(KEY_USER_AGE, binding.edtAge.text.toString())
            .putBoolean(KEY_NIGHT_MODE, true)
            .apply()

    }

    private fun readOnSharedPreference() {
        val sp = getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE)
        val userName = sp.getString(KEY_USER_NAME, "")
        val userAge = sp.getString(KEY_USER_AGE, "")
        val nightMode = sp.getBoolean(KEY_NIGHT_MODE, false)

        binding.tvResult.text = "O seu nome é $userName e sua idade é $userAge"
    }
}