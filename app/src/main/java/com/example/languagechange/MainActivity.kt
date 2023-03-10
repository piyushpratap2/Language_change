package com.example.languagechange

import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.languagechange.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btn1.setOnClickListener {
            setLocale(this,"hi")

            startActivity(Intent(this,MainActivity2::class.java))
        }
        binding.btn2.setOnClickListener {
            setLocale(this,"en")
            /*finish()
            startActivity(intent)*/
            startActivity(Intent(this,MainActivity2::class.java))
        }
    }

    private fun  UpdateResources(context: Context,language: String):Context{
        val locale = Locale(language)
        Locale.setDefault(locale)
        val configuration: Configuration = context.resources.configuration
        configuration.setLocale(locale)
        configuration.setLayoutDirection(locale)
        return context.createConfigurationContext(configuration)
    }

    fun setLocale(mcontext: Context, language:String): Context{
        return UpdateResources(mcontext,language)
    }

}