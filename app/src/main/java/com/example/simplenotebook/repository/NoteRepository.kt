package com.example.simplenotebook.repository

import androidx.lifecycle.LiveData
import com.example.simplenotebook.database.NoteDao
import com.example.simplenotebook.model.Note

class NoteRepository(private val noteDao: NoteDao) {
    val allNotes: LiveData<List<Note>> = noteDao.getAllNotes()

    suspend fun insert(note: Note) {
        noteDao.insertNote(note)
    }
}