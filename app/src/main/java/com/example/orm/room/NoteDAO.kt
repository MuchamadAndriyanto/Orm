package com.example.orm.room

import androidx.room.Dao
import androidx.room.Insert

@Dao
interface NoteDAO {

    @Insert
    fun insertData(noteData: NoteData)

}