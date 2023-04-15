package com.example.orm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.orm.databinding.ActivityAddNoteBinding
import com.example.orm.room.NoteData
import com.example.orm.room.NoteDataBase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class AddNoteActivity : AppCompatActivity() {
    lateinit var binding : ActivityAddNoteBinding
    var noteDB : NoteDataBase? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddNoteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        noteDB = NoteDataBase.getInstance(this)

        binding.btnSaveNote.setOnClickListener {
            addData()
        }
    }
    fun addData(){
        GlobalScope.async {
            var title = binding.noteTitle.text.toString()
            var content = binding.noteContent.text.toString()
            var tgl = binding.dateNote.text.toString()

            noteDB?.noteDao()?.insertData(NoteData(0,title,content,tgl))
        }
        finish()

    }
}