package com.example.simplenotebook.view

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.simplenotebook.R

class additemActivity : AppCompatActivity() {

    private val noteViewModel: NoteViewModel by viewModels {
        NoteViewModelFactory((application as NoteApp).repository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_note)

        val titleInput = findViewById<EditText>(R.id.input_title)
        val contentInput = findViewById<EditText>(R.id.input_content)
        val saveButton = findViewById<Button>(R.id.button_save)

        saveButton.setOnClickListener {
            val title = titleInput.text.toString()
            val content = contentInput.text.toString()
            if (title.isNotBlank() && content.isNotBlank()) {
                val note = Note(title = title, content = content)
                noteViewModel.insert(note)
                finish()
            }
        }
    }
}
