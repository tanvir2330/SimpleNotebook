package com.example.simplenotebook.view

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.simplenotebook.R
import com.example.simplenotebook.repository.NoteRepository
import com.example.simplenotebook.view.adapter.NoteAdapter
import com.example.simplenotebook.viewmodel.NoteViewModel
import com.example.simplenotebook.viewmodel.NoteViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var noteAdapter: NoteAdapter
    private val noteViewModel: NoteViewModel by viewModels {
        NoteViewModelFactory((application as MainActivity).NoteRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        val addNoteButton = findViewById<Button>(R.id.button_add_note)

        noteAdapter = NoteAdapter(emptyList())
        recyclerView.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = noteAdapter
        }

        noteViewModel.allNotes.observe(this) { notes ->
            noteAdapter.updateNotes(notes)
        }

        addNoteButton.setOnClickListener {
            val intent = Intent(this, additemActivity::class.java)
            startActivity(intent)
        }
    }
}