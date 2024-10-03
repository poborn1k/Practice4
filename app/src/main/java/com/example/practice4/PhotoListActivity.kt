package com.example.practice4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.practice4.databinding.ActivityPhotoListBinding
import java.io.BufferedReader
import java.io.InputStreamReader

class PhotoListActivity : AppCompatActivity() {
    lateinit var binding: ActivityPhotoListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotoListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val times = mutableListOf<String>()
        var file = MainActivity.file

        BufferedReader(InputStreamReader(file.inputStream())).use { reader ->
            reader.forEachLine { line ->
                times.add(line)
            }
        }


        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = TimeAdapter(times)
    }
}