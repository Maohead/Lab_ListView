package com.example.lab_listview

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val listView : ListView = findViewById(R.id.lvMain)

        val arrayAdapter : ArrayAdapter<*>
        val names = arrayOf("Misha", "Petya", "Grisha", "Grisha", "Grisha", "Grisha")
        arrayAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, names)
        listView.adapter = arrayAdapter

        listView.setOnItemClickListener { parent, view, position, id ->
            val selectedItem = names[position]
            Toast.makeText(this, "Вы нажали на элемент ListView: $selectedItem", Toast.LENGTH_SHORT).show()
        }
    }
}