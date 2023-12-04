package com.example.pulltorefresh

import android.graphics.drawable.Drawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.example.pulltorefresh.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.swipeRefresh.setOnRefreshListener {
            reload()
        }
    }

    private fun reload() {
        Handler(Looper.getMainLooper()).postDelayed({
            binding.textView.text = "done"
            binding.imageView.setImageResource(R.drawable.ic_launcher_foreground)
            Toast.makeText(this, "reloadin", Toast.LENGTH_SHORT).show()
            binding.swipeRefresh.isRefreshing = false
        },3000)
    }
}